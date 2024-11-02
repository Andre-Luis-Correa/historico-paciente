package com.historicopaciente.historicopaciente.paciente;

import com.historicopaciente.historicopaciente.consultamedica.ConsultaMedica;
import com.historicopaciente.historicopaciente.consultamedica.ConsultaMedicaDTO;
import com.historicopaciente.historicopaciente.consultamedica.ConsultaMedicaService;
import com.historicopaciente.historicopaciente.contato.email.EmailDTO;
import com.historicopaciente.historicopaciente.contato.email.EmailPaciente;
import com.historicopaciente.historicopaciente.contato.email.EmailService;
import com.historicopaciente.historicopaciente.contato.telefone.TelefoneDTO;
import com.historicopaciente.historicopaciente.contato.telefone.TelefonePaciente;
import com.historicopaciente.historicopaciente.contato.telefone.TelefoneService;
import com.historicopaciente.historicopaciente.endereco.EnderecoService;
import com.historicopaciente.historicopaciente.exameMedico.ExameMedico;
import com.historicopaciente.historicopaciente.exameMedico.ExameMedicoDTO;
import com.historicopaciente.historicopaciente.exameMedico.ExameMedicoService;
import com.historicopaciente.historicopaciente.report.JasperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final EnderecoService enderecoService;
    private final JasperService jasperService;
    private final TelefoneService telefoneService;
    private final EmailService emailService;
    private final ConsultaMedicaService consultaMedicaService;
    private final ExameMedicoService exameMedicoService;

    public void gerarRelatorioHistoricoPaciente() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número do paciente: ");
        String numeroPaciente = scanner.nextLine();

        Paciente paciente;
        if (verificarSeExistePaciente(numeroPaciente)) {
            paciente = buscarPacientePorNumeroPaciente(numeroPaciente);
        } else {
            System.out.println("Não foi possível encontrar o paciente!");
            return;
        }

        Map<String, Object> params = generateReportParams(paciente);

        List<TelefonePaciente> telefonePacienteList = telefoneService.buscarTelefonesPaciente(paciente);
        List<TelefoneDTO> telefoneDTOList = telefoneService.gerarTelefoneDTOList(telefonePacienteList);

        List<EmailPaciente> emailPacienteList = emailService.buscarEmailsPaciente(paciente);
        List<EmailDTO> emailDTOList = emailService.gerarEmailDTOList(emailPacienteList);

        List<ConsultaMedica> consultaMedicaList = consultaMedicaService.buscarConsultasMedicasPaciente(paciente);
        List<ConsultaMedicaDTO> consultaMedicaDTOList = consultaMedicaService.gerarConsultaMedicaDTOList(consultaMedicaList);

        List<ExameMedico> exameMedicoList = exameMedicoService.buscarExamesMedicosPaciente(paciente);
        List<ExameMedicoDTO> exameMedicoDTOListList = exameMedicoService.gerarExameMedicoDTOList(exameMedicoList);

        Map<String, Object> collections = new HashMap<>();
        collections.put("1", telefoneDTOList);
        collections.put("2", emailDTOList);
        collections.put("3", consultaMedicaDTOList);
        collections.put("4", exameMedicoDTOListList);

        byte[] file = jasperService.reportGenerate("reports/patient_report.jrxml", params, collections);

        if (file != null) {
            try (OutputStream out = new FileOutputStream("patient_report.pdf")) {
                out.write(file);
                System.out.println("Extrato gerado e salvo em 'patient_report.pdf'.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Erro ao gerar o extrato.");
        }
    }




    private Map<String, Object> generateReportParams(Paciente paciente) {
        Map<String, Object> params = new HashMap<>();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String enderecoCompleto = enderecoService.gerarEnderecoCompleto(paciente.getEndereco(), paciente.getComplementoEndereco(), paciente.getNumeroEndereco());

        params.put("PATIENT_NAME", paciente.getNome());
        params.put("PATIENT_NUMBER", paciente.getNumero());
        params.put("PATIENT_BIRTH_DATE", dateFormatter.format(paciente.getDataNascimento()));
        params.put("PATIENT_SEX", paciente.getSexo().getNome());
        params.put("PATIENT_CIVIL_STATUS", paciente.getEstadoCivil().getNome());
        params.put("PATIENT_DOCUMENT", paciente.getNumeroDocumentoIdentidade());
        params.put("PATIENT_ADDRESS", enderecoCompleto);
        params.put("LOGO1", "reports/logo.png");

        return params;
    }


    private Paciente buscarPacientePorNumeroPaciente(String numeroPaciente) {
        return pacienteRepository.findByNumero(numeroPaciente);
    }

    private boolean verificarSeExistePaciente(String numeroPaciente) {
        return pacienteRepository.existsByNumero(numeroPaciente);
    }


}

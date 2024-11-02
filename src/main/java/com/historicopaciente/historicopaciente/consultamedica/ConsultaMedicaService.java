package com.historicopaciente.historicopaciente.consultamedica;

import com.historicopaciente.historicopaciente.contato.email.EmailService;
import com.historicopaciente.historicopaciente.diagnosticocid.DiagnosticoCID;
import com.historicopaciente.historicopaciente.medico.Medico;
import com.historicopaciente.historicopaciente.paciente.Paciente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaMedicaService {

    private final ConsultaMedicaRepository consultaMedicaRepository;
    private final EmailService emailService;

    public List<ConsultaMedica> buscarConsultasMedicasPaciente(Paciente paciente) {
        return consultaMedicaRepository.findAllByPaciente(paciente);
    }

    public List<ConsultaMedicaDTO> gerarConsultaMedicaDTOList(List<ConsultaMedica> consultaMedicaList) {
        List<ConsultaMedicaDTO> consultaMedicaDTOList = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (ConsultaMedica consultaMedica : consultaMedicaList) {
            String medicalConsultationNumber = consultaMedica.getNumero();
            String medicalConsultationDate = consultaMedica.getDataRealizacaoConsulta().format(dateFormatter);

            Medico medico = consultaMedica.getMedico();
            String medicoEmail = emailService.buscarEmailMedico(medico);
            String doctorInformations = medico.getNome() + ", CRM: " + medico.getCrm() + ", Email: " + medicoEmail;

            DiagnosticoCID diagnosticoCID = (consultaMedica.getDiagnosticoCID() != null) ? consultaMedica.getDiagnosticoCID() : null;

            String diagnosticInformations = "Diagnóstico não foi pôde ser definido.";
            if(diagnosticoCID != null) {
                diagnosticInformations = diagnosticoCID.getCodigo() + " - " + diagnosticoCID.getDescricao();
            }

            ConsultaMedicaDTO consultaMedicaDTO = new ConsultaMedicaDTO(
                    medicalConsultationNumber,
                    medicalConsultationDate,
                    doctorInformations,
                    diagnosticInformations
            );
            consultaMedicaDTOList.add(consultaMedicaDTO);
        }

        return consultaMedicaDTOList;
    }
}

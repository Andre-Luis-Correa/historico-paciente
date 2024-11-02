package com.historicopaciente.historicopaciente.contato.email;

import com.historicopaciente.historicopaciente.medico.Medico;
import com.historicopaciente.historicopaciente.paciente.Paciente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailPacienteRepository emailPacienteRepository;
    private final EmailMedicoRepository emailMedicoRepository;

    public List<EmailPaciente> buscarEmailsPaciente(Paciente paciente) {
        return emailPacienteRepository.findAllByPaciente(paciente);
    }

    public List<EmailDTO> gerarEmailDTOList(List<EmailPaciente> emailPacienteList) {
        List<EmailDTO> emailDTOList = new ArrayList<>();

        for (EmailPaciente emailPaciente : emailPacienteList) {
            EmailDTO emailDTO = new EmailDTO(emailPaciente.getEmail());
            emailDTOList.add(emailDTO);
        }

        return emailDTOList;
    }

    public String buscarEmailMedico(Medico medico) {
        return emailMedicoRepository.findAllByMedico(medico).get(0).getEmail();
    }


//    public void mostrarEmailCliente(Cliente cliente) {
//        List<Email> emailList = emailRepository.findAllByCliente(cliente);
//
//        System.out.println("E-mails:");
//        if (emailList.isEmpty()) {
//            System.out.println("   Nenhum e-mail cadastrado.");
//        } else {
//            for (Email email : emailList) {
//                System.out.println("   " + email.getEmail());
//            }
//        }
//    }
//
//    public List<Email> findAll(Cliente cliente) {
//        return emailRepository.findAllByCliente(cliente);
//    }
}

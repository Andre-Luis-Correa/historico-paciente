package com.historicopaciente.historicopaciente.contato.email;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailPacienteRepository emailPacienteRepository;

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
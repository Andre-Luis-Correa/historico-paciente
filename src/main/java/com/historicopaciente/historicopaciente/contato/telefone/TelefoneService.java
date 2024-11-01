package com.historicopaciente.historicopaciente.contato.telefone;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;

//    public void mostrarTelefonesCliente(Cliente cliente) {
//
//        List<Telefone> telefoneList = telefoneRepository.findAllByCliente(cliente);
//
//        System.out.println("Telefones:");
//        if (telefoneList.isEmpty()) {
//            System.out.println("   Nenhum telefone cadastrado.");
//        } else {
//            for (Telefone telefone : telefoneList) {
//                System.out.println("   +" + telefone.getNumeroDDI().getNumeroDDI() + " (" + telefone.getNumeroDDD().getNumeroDDD() + ") " + telefone.getNumeroTelefone());
//            }
//        }
//    }
//
//    public List<Telefone> findAll(Cliente cliente) {
//        return telefoneRepository.findAllByCliente(cliente);
//    }
}

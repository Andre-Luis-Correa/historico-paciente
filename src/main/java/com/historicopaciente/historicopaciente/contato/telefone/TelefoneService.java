package com.historicopaciente.historicopaciente.contato.telefone;

import com.historicopaciente.historicopaciente.contato.email.EmailDTO;
import com.historicopaciente.historicopaciente.contato.email.EmailPaciente;
import com.historicopaciente.historicopaciente.paciente.Paciente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TelefoneService {

    private final TelefonePacienteRepository telefonePacienteRepository;

    public List<TelefonePaciente> buscarTelefonesPaciente(Paciente paciente) {
        return telefonePacienteRepository.findAllByPaciente(paciente);
    }

    public List<TelefoneDTO> gerarTelefoneDTOList(List<TelefonePaciente> telefonePacienteList) {
        List<TelefoneDTO> telefoneDTOList = new ArrayList<>();

        for (TelefonePaciente telefonePaciente : telefonePacienteList) {
            String phone = telefonePaciente.getNumeroDDI().getNumeroDDI() + " (" +
                    telefonePaciente.getNumeroDDD().getNumeroDDD() + ") " +
                    telefonePaciente.getNumeroTelefone();

            TelefoneDTO telefoneDTO = new TelefoneDTO(phone);
            telefoneDTOList.add(telefoneDTO);
        }

        return telefoneDTOList;
    }

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

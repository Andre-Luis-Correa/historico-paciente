package com.historicopaciente.historicopaciente.contato.telefone;

import com.historicopaciente.historicopaciente.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelefonePacienteRepository extends JpaRepository<TelefonePaciente, String> {

    List<TelefonePaciente> findAllByPaciente(Paciente paciente);
}
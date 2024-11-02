package com.historicopaciente.historicopaciente.contato.email;

import com.historicopaciente.historicopaciente.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailPacienteRepository extends JpaRepository<EmailPaciente, String> {

    List<EmailPaciente> findAllByPaciente(Paciente paciente);
}
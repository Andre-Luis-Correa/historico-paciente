package com.historicopaciente.historicopaciente.contato.email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailPacienteRepository extends JpaRepository<EmailPaciente, String> {

}
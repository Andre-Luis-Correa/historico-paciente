package com.historicopaciente.historicopaciente.contato.email;

import com.historicopaciente.historicopaciente.medico.Medico;
import com.historicopaciente.historicopaciente.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailMedicoRepository extends JpaRepository<EmailMedico, String> {

    @Query("SELECT e FROM EmailMedico e WHERE e.medico = :medico")
    List<EmailMedico> findAllByMedico(Medico medico);
}
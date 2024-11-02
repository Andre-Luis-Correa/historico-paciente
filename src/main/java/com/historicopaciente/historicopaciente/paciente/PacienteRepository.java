package com.historicopaciente.historicopaciente.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {
    boolean existsByNumero(String numeroPaciente);

    Paciente findByNumero(String numeroPaciente);
}

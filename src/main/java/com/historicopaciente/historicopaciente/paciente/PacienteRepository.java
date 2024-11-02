package com.historicopaciente.historicopaciente.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {
    boolean existsByNumeroPaciente();

    Paciente findByNumeroPaciente(String numeroPaciente);
}

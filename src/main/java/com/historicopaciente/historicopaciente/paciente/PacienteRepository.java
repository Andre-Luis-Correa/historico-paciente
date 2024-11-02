package com.historicopaciente.historicopaciente.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Paciente p WHERE p.numero = :numeroPaciente")
    boolean existsByNumero(@Param("numeroPaciente") String numeroPaciente);

    @Query("SELECT p FROM Paciente p WHERE p.numero = :numeroPaciente")
    Paciente findByNumero(@Param("numeroPaciente") String numeroPaciente);
}

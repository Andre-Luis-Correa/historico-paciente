package com.historicopaciente.historicopaciente.consultamedica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaMedicaRepository extends JpaRepository<ConsultaMedica, String> {
}

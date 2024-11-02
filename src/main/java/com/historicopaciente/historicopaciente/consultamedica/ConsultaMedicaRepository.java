package com.historicopaciente.historicopaciente.consultamedica;

import com.historicopaciente.historicopaciente.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaMedicaRepository extends JpaRepository<ConsultaMedica, String> {
    List<ConsultaMedica> findAllByPaciente(Paciente paciente);
}

package com.historicopaciente.historicopaciente.exameMedico;

import com.historicopaciente.historicopaciente.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExameMedicoRepository extends JpaRepository<ExameMedico, String> {
    List<ExameMedico> findAllByPaciente(Paciente paciente);
}

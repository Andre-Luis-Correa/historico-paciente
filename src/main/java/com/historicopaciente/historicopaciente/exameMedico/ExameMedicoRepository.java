package com.historicopaciente.historicopaciente.exameMedico;

import com.historicopaciente.historicopaciente.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExameMedicoRepository extends JpaRepository<ExameMedico, String> {
    @Query("SELECT e FROM ExameMedico e WHERE e.paciente = :paciente")
    List<ExameMedico> findAllByPaciente(Paciente paciente);
}

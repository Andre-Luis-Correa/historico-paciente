package com.historicopaciente.historicopaciente.exameMedico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameMedicoRepository extends JpaRepository<ExameMedico, String> {
}

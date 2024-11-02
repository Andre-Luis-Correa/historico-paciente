package com.historicopaciente.historicopaciente.exameMedico;

import com.historicopaciente.historicopaciente.paciente.Paciente;
import com.historicopaciente.historicopaciente.tipoexamemedico.TipoExameMedico;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExameMedicoService {
    
    private final ExameMedicoRepository exameMedicoRepository;

    public List<ExameMedico> buscarExamesMedicosPaciente(Paciente paciente) {
        return exameMedicoRepository.findAllByPaciente(paciente);
    }

    public List<ExameMedicoDTO> gerarExameMedicoDTOList(List<ExameMedico> exameMedicoList) {
        List<ExameMedicoDTO> exameMedicoDTOList = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (ExameMedico exameMedico : exameMedicoList) {
            String examNumber = exameMedico.getNumero();
            String examDate = exameMedico.getDataRealizacao().format(dateFormatter);

            TipoExameMedico tipoExameMedico = exameMedico.getTipoExameMedico();
            String examTypeInformation = tipoExameMedico.getCodigo() + " - " + tipoExameMedico.getNome();

            String examResult = exameMedico.getResultadoGeralExameMedico().getResultadoGeral();

            String examObservations = exameMedico.getObservacao();

            ExameMedicoDTO exameMedicoDTO = new ExameMedicoDTO(
                    examNumber,
                    examDate,
                    examTypeInformation,
                    examResult,
                    examObservations
            );
            exameMedicoDTOList.add(exameMedicoDTO);
        }

        return exameMedicoDTOList;
    }
}

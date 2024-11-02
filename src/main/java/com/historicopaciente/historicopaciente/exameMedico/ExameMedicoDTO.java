package com.historicopaciente.historicopaciente.exameMedico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExameMedicoDTO {
    private String examNumber;
    private String examDate;
    private String examTypeInformation;
    private String examResult;
    private String examObservations;
}

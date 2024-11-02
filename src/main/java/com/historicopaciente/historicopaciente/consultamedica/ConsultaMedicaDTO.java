package com.historicopaciente.historicopaciente.consultamedica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ConsultaMedicaDTO {

    private String medicalConsultationNumber;
    private String medicalConsultationDate;
    private String doctorInformations;
    private String diagnosticInformations;

}

package com.historicopaciente.historicopaciente.consultamedica;

import com.historicopaciente.historicopaciente.diagnosticocid.DiagnosticoCID;
import com.historicopaciente.historicopaciente.medico.Medico;
import com.historicopaciente.historicopaciente.paciente.Paciente;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Getter
@Setter
@Table(name = "consulta_medica")
public class ConsultaMedica {

    @Id
    @Column(name = "numero_consulta_medica")
    private String numero;

    @Column(name = "data_realizacao_consulta_medica")
    private LocalDate dataRealizacaoConsulta;

    @ManyToOne
    @JoinColumn(name = "crm_medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "codigo_diagnostico_cid")
    private DiagnosticoCID diagnosticoCID;

    @ManyToOne
    @JoinColumn(name = "numero_paciente")
    private Paciente paciente;
}

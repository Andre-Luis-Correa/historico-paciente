package com.historicopaciente.historicopaciente.exameMedico;

import com.historicopaciente.historicopaciente.resultadogeralexamemedico.ResultadoGeralExameMedico;
import com.historicopaciente.historicopaciente.paciente.Paciente;
import com.historicopaciente.historicopaciente.tipoexamemedico.TipoExameMedico;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Getter
@Setter
@Table(name = "exame_medico")
public class ExameMedico {

    @Id
    @Column(name = "numero_exame_medico")
    private String numero;

    @Column(name = "data_realizacao_exame_medico")
    private LocalDate dataRealizacao;

    @ManyToOne
    @JoinColumn(name = "codigo_tipo_exame")
    private TipoExameMedico tipoExameMedico;

    @ManyToOne
    @JoinColumn(name = "id_resultado_geral_exame")
    private ResultadoGeralExameMedico resultadoGeralExameMedico;

    @Column(name = "observacao_exame_medico")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "numero_paciente")
    private Paciente paciente;
}

package com.historicopaciente.historicopaciente.exame;

import com.historicopaciente.historicopaciente.ResultadoGeralExame;
import com.historicopaciente.historicopaciente.paciente.Paciente;
import com.historicopaciente.historicopaciente.tipoexame.TipoExame;
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
    private TipoExame tipoExame;

    @ManyToOne
    @JoinColumn(name = "id_resultado_geral_exame")
    private ResultadoGeralExame resultadoGeralExame;

    @Column(name = "observacao_exame_medico")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "numero_paciente")
    private Paciente paciente;
}

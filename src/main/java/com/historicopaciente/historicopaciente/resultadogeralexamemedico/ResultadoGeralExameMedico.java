package com.historicopaciente.historicopaciente.resultadogeralexamemedico;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "resultado_geral_exame_medico")
public class ResultadoGeralExameMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultado_geral_exame_medico")
    private Long id;

    @Column(name = "resultado_geral_exame_medico")
    private String resultadoGeral;


}

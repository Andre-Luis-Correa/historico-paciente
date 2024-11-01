package com.historicopaciente.historicopaciente;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "resultado_geral_exame")
public class ResultadoGeralExame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultado_geral_exame")
    private Long id;

    @Column(name = "resultado_geral_exame")
    private String resultadoGeral;


}

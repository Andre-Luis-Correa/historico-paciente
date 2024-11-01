package com.historicopaciente.historicopaciente.tipoexame;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "tipoExame")
public class TipoExame {

    @Id
    @Column(name = "codigo_tipo_exame")
    private String codigo;

    @Column(name = "nome_tipo_exame")
    private String nome;
}

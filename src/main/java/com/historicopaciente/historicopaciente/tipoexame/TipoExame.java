package com.historicopaciente.historicopaciente.tipoexame;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "tipo_exame_medico")
public class TipoExame {

    @Id
    @Column(name = "codigo_tipo_exame_medico")
    private String codigo;

    @Column(name = "nome_tipo_exame_medico")
    private String nome;
}

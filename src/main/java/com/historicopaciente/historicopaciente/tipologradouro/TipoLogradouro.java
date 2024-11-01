package com.historicopaciente.historicopaciente.tipologradouro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "tipo_logradouro")
public class TipoLogradouro {

    @Id
    @Column(name = "sigla_tipo_logradouro")
    private String sigla;

    @Column(name = "nome_tipo_logradouro")
    private String nome;
}

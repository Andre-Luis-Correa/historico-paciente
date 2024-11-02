package com.historicopaciente.historicopaciente.unidadefederativa;

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
@Table(name = "unidade_federativa")
public class UnidadeFederativa {

    @Id
    @Column(name = "sigla_uf")
    private String sigla;

    @Column(name = "nome_uf")
    private String nome;
}

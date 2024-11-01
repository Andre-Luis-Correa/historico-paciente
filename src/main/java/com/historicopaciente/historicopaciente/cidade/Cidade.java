package com.historicopaciente.historicopaciente.cidade;

import com.historicopaciente.historicopaciente.unidadefederativa.UnidadeFederativa;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cidade")
    private Long id;

    @Column(name = "nome_cidade")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_unidade_federativa")
    private UnidadeFederativa unidadeFederativa;

}

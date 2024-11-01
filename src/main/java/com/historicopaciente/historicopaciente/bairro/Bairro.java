package com.historicopaciente.historicopaciente.bairro;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "bairro")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bairro")
    private Long id;

    @Column(name = "nome_bairro")
    private String nome;
}

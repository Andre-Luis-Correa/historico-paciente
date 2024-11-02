package com.historicopaciente.historicopaciente.logradouro;

import com.historicopaciente.historicopaciente.tipologradouro.TipoLogradouro;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "logradouro")
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_logradouro")
    private Long id;

    @Column(name = "nome_logradouro")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "sigla_tipo_logradouro")
    private TipoLogradouro tipoLogradouro;
}

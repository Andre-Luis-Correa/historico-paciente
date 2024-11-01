package com.historicopaciente.historicopaciente.endereco;

import com.historicopaciente.historicopaciente.bairro.Bairro;
import com.historicopaciente.historicopaciente.cidade.Cidade;
import com.historicopaciente.historicopaciente.logradouro.Logradouro;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;

    @Column(name = "cep")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "id_bairro")
    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "id_logradouro")
    private Logradouro logradouro;
}

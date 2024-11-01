package com.historicopaciente.historicopaciente.medico;

import com.historicopaciente.historicopaciente.endereco.Endereco;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "medico")
public class Medico {

    @Id
    @Column(name = "crm_medico")
    private String crm;

    @Column(name = "nome_medico")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Column(name = "complemento_endereco_medico")
    private String complementoEndereco;

    @Column(name = "numero_endereco_medico")
    private String numeroendereco;
}

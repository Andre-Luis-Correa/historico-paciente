package com.historicopaciente.historicopaciente.paciente;

import com.historicopaciente.historicopaciente.endereco.Endereco;
import com.historicopaciente.historicopaciente.estadocivil.EstadoCivil;
import com.historicopaciente.historicopaciente.sexo.Sexo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Getter
@Setter
@Table(name = "paciente")
public class Paciente {

    @Id
    @Column(name = "numero_paciente")
    private String numero;

    @Column(name = "nome_paciente")
    private String nome;

    @Column(name = "data_nascimento_paciente")
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "id_sexo")
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name = "id_estado_civil")
    private EstadoCivil estadoCivil;

    @Column(name = "numero_documento_identidade_paciente")
    private String numeroDocumentoIdentidade;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Column(name = "complemento_endereco_paciente")
    private String complementoEndereco;

    @Column(name = "numero_endereco_paciente")
    private String numeroEndereco;
}

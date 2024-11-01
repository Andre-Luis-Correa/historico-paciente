package com.historicopaciente.historicopaciente.contato.email;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "email_paciente")
public class EmailPaciente {

    @Id
    @Column(name = "email_paciente")
    private String email;

}

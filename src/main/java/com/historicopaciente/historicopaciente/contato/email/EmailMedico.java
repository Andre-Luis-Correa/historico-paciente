package com.historicopaciente.historicopaciente.contato.email;

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
@Table(name = "email_medico")
public class EmailMedico {

    @Id
    @Column(name = "email_medico")
    private String email;
}

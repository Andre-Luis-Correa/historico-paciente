package com.historicopaciente.historicopaciente.contato.email;

import com.historicopaciente.historicopaciente.medico.Medico;
import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "crm_medico")
    private Medico medico;
}

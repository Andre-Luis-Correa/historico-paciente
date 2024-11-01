package com.historicopaciente.historicopaciente.contato.email;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class Email {

    @Id
    private String email;

}

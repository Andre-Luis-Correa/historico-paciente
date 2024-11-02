package com.historicopaciente.historicopaciente.contato.ddi;

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
@Table(name = "ddi")
public class DDI {

    @Id
    @Column(name = "numero_ddi")
    private Long numeroDDI;
}

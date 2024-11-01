package com.historicopaciente.historicopaciente.contato.telefone.ddi;

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
@Table(name = "DDI")
public class DDI {

    @Id
    @Column(name = "numero_DDD")
    private Long numeroDDI;
}

package com.historicopaciente.historicopaciente.contato.ddd;

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
@Table(name = "ddd")
public class DDD {

    @Id
    @Column(name = "numero_ddd")
    private Long numeroDDD;
}

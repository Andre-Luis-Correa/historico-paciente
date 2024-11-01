package com.historicopaciente.historicopaciente.contato.telefone;

import com.historicopaciente.historicopaciente.contato.telefone.ddd.DDD;
import com.historicopaciente.historicopaciente.contato.telefone.ddi.DDI;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "telefone")
public class Telefone {

    @Id
    @Column(name = "numero_telefone")
    private String numeroTelefone;

    @ManyToOne
    @JoinColumn(name = "numero_DDD")
    private DDD numeroDDD;

    @ManyToOne
    @JoinColumn(name = "numero_DDI")
    private DDI numeroDDI;

}

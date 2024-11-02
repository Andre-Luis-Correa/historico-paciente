package com.historicopaciente.historicopaciente.contato.telefone;

import com.historicopaciente.historicopaciente.contato.ddd.DDD;
import com.historicopaciente.historicopaciente.contato.ddi.DDI;
import com.historicopaciente.historicopaciente.medico.Medico;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "telefone_medico")
public class TelefoneMedico {

    @Id
    @Column(name = "numero_telefone_medico")
    private String numeroTelefone;

    @ManyToOne
    @JoinColumn(name = "numero_ddd")
    private DDD numeroDDD;

    @ManyToOne
    @JoinColumn(name = "numero_ddi")
    private DDI numeroDDI;

    @ManyToOne
    @JoinColumn(name = "crm_medico")
    private Medico medico;
}

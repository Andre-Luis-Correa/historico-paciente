package com.historicopaciente.historicopaciente.diagnosticocid;

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
@Table(name = "diagnostico_cid")
public class DiagnosticoCID {

    @Id
    @Column(name = "codigo_diagnostico_cid")
    private String codigo;

    @Column(name = "descricao_diagnostico_cid")
    private String descricao;
}

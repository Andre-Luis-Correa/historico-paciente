package com.historicopaciente.historicopaciente.contato.telefone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonePacienteRepository extends JpaRepository<TelefonePaciente, String> {

}
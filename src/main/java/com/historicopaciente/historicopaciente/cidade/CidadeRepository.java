package com.historicopaciente.historicopaciente.cidade;

import com.historicopaciente.historicopaciente.unidadefederativa.UnidadeFederativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("SELECT c FROM Cidade c WHERE c.unidadeFederativa = :unidadeFederativa")
    List<Cidade> findAllByUnidadeFederativa(@Param("unidadeFederativa") UnidadeFederativa unidadeFederativa);

    @Query("SELECT c FROM Cidade c WHERE c.nome = :nomeCidade")
    Cidade findByNomeCidade(@Param("nomeCidade") String nomeCidade);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Cidade c WHERE c.nomeCidade = :nomeCidade")
    boolean existsByNomeCidade(@Param("nomeCidade") String nomeCidade);
}
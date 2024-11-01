package com.historicopaciente.historicopaciente.endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Endereco e WHERE e.cep = :cep")
    boolean existsByCep(@Param("cep") String cep);

    @Query("SELECT e FROM Endereco e WHERE e.cep = :cep")
    Endereco findByCep(@Param("cep") String cep);

    @Query("SELECT e FROM Endereco e WHERE e.cidade.id = :cidadeId")
    List<Endereco> findAllByCidadeId(@Param("cidadeId") Long cidadeId);

    @Query("SELECT e FROM Endereco e WHERE e.bairro.id = :bairroId")
    List<Endereco> findAllByBairroId(@Param("bairroId") Long bairroId);

    @Query("SELECT e FROM Endereco e WHERE e.logradouro.id = :logradouroId")
    List<Endereco> findAllByLogradouroId(@Param("logradouroId") Long logradouroId);
}
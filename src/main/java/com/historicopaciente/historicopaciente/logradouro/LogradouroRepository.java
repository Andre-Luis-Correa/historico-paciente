package com.historicopaciente.historicopaciente.logradouro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {

    @Query("SELECT CASE WHEN COUNT(l) > 0 THEN true ELSE false END FROM Logradouro l WHERE l.nome = :nomeLogradouro")
    boolean existsByNomeLogradouro(@Param("nomeLogradouro") String nomeLogradouro);

    @Query("SELECT l FROM Logradouro l WHERE l.nome = :nomeLogradouro")
    Logradouro findByNomeLogradouro(@Param("nomeLogradouro") String nomeLogradouro);
}
package com.historicopaciente.historicopaciente.unidadefederativa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeFederativaRepository extends JpaRepository<UnidadeFederativa, String> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UnidadeFederativa u WHERE u.sigla = :siglaUF")
    boolean existsBySiglaUF(@Param("siglaUF") String siglaUF);

    @Query("SELECT u FROM UnidadeFederativa u WHERE u.sigla = :siglaUF")
    UnidadeFederativa findBySiglaUF(@Param("siglaUF") String siglaUF);
}
package com.historicopaciente.historicopaciente.tipologradouro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoLogradouroRepository extends JpaRepository<TipoLogradouro, String> {

    @Query("SELECT CASE WHEN COUNT(tl) > 0 THEN true ELSE false END FROM TipoLogradouro tl WHERE tl.sigla = :siglaTipoLogradouro")
    boolean existsBySiglaTipoLogradouro(@Param("siglaTipoLogradouro") String siglaTipoLogradouro);

    @Query("SELECT tl FROM TipoLogradouro tl WHERE tl.sigla = :siglaTipoLogradouro")
    TipoLogradouro findBySiglaTipoLogradouro(@Param("siglaTipoLogradouro") String siglaTipoLogradouro);
}

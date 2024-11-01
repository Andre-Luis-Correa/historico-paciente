package com.historicopaciente.historicopaciente.bairro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Bairro b WHERE b.id = :id")
    boolean existsById(@Param("id") @NonNull Long id);
}
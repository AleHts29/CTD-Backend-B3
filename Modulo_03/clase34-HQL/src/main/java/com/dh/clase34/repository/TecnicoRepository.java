package com.dh.clase34.repository;

import com.dh.clase34.entities.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico,Long> {
    @Query("select t from Tecnico t where t.nombre=?1")
    Optional<Tecnico> buscarTecnicoPorNombre(String nombre);
}

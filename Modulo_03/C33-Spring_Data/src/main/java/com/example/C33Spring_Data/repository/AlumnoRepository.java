package com.example.C33Spring_Data.repository;

import com.example.C33Spring_Data.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    @Query("SELECT a FROM Alumno WHERE a.nombre = ?1")
    Optional<Alumno> buscarAlumno(String nombre);

}

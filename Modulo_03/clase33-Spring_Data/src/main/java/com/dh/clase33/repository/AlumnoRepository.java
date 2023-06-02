package com.dh.clase33.repository;

import com.dh.clase33.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
}

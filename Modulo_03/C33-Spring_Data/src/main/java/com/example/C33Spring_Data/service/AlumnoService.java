package com.example.C33Spring_Data.service;

import com.example.C33Spring_Data.modelo.Alumno;
import com.example.C33Spring_Data.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlumnoService {
    private AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> buscarTodos(){
        return alumnoRepository.findAll();
    }

    public Alumno buscarPorNombre(String nombre){
        return alumnoRepository.buscarAlumno(nombre).get();
    }
}

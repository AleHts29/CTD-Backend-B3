package com.dh.clase33.service;

import com.dh.clase33.entities.Profesor;
import com.dh.clase33.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {
    private final ProfesorRepository profesorRepository;
    @Autowired
    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }
    public List<Profesor> obtenerProfesores(){
        return profesorRepository.findAll();
    }
}

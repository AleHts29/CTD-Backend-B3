package com.example.clase22.controller;

import com.example.clase22.modelo.Paciente;
import com.example.clase22.servicio.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // se usa cuando se tienen vistas
@RestController // se usa cuando no se tienen vistas
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    // con @RequestBody me permite recibir parametros mediante el body
    public Paciente registrarPaciente(@RequestBody Paciente paciente){

        return pacienteService.guardar(paciente);
    }

    @GetMapping
    public List<Paciente> buscarAllPacientes (){

        return pacienteService.buscarTodos();
    }
}

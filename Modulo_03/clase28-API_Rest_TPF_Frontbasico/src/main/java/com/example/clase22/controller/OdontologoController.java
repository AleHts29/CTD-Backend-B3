package com.example.clase22.controller;

import com.example.clase22.modelo.Odontologo;
import com.example.clase22.servicio.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public List<Odontologo> buscarAllOdontologos(){
        return odontologoService.buscarTodosOdontologos();
    }
    @PostMapping
    public Odontologo registrarNuevoOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardarOdontologo(odontologo);
    }
    @GetMapping("/{id}")
    public Odontologo buscarOdontologo(@PathVariable Integer id){
        return odontologoService.buscarOdontologoXId(id);
    }
}

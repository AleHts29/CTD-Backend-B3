package com.example.clase22.controller;

import com.example.clase22.modelo.Odontologo;
import com.example.clase22.modelo.Paciente;
import com.example.clase22.servicio.OdontologoService;
import com.example.clase22.servicio.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/index")
public class InicioController {
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    @Autowired
    public InicioController(PacienteService pacienteService, OdontologoService odontologoService) {
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public String mostrarDatosDePrueba (
            Model model, @RequestParam("email") String email,
            @RequestParam("id") Integer id){
        Paciente paciente=pacienteService.buscarXEmail(email);
        Odontologo odontologo=odontologoService.buscarOdontologoXId(id);
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        model.addAttribute("matricula",odontologo.getMatricula());
        return "index";
    }
}

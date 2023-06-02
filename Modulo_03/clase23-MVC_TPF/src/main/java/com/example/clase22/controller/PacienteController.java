package com.example.clase22.controller;

import com.example.clase22.modelo.Paciente;
import com.example.clase22.servicio.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }


    @GetMapping("/index")
    // se busca como http://localhost:8080/index?email=reb@gmail.com
    public String traerPaciente(Model model, @RequestParam("email") String email){
        Paciente paciente=pacienteService.buscarXEmail(email);
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        return "index";
    }

}

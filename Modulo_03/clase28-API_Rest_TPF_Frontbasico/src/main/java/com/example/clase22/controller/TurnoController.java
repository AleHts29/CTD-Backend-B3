package com.example.clase22.controller;

import com.example.clase22.modelo.Turno;
import com.example.clase22.servicio.OdontologoService;
import com.example.clase22.servicio.PacienteService;
import com.example.clase22.servicio.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final TurnoService turnoService;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> respuesta;
        //cuando esta mal
        if (odontologoService.buscarOdontologoXId(turno.getOdontologo().getId())==null
        ||pacienteService.buscar(turno.getPaciente().getId())==null){
            respuesta=ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            //cuando esta ok
            //registrar el turno porque ambos existen
            respuesta=ResponseEntity.ok(turnoService.guardar(turno));
        }
        return respuesta;
    }

    @GetMapping()
    public ResponseEntity<List<Turno>> buscarAllTurnos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }
}

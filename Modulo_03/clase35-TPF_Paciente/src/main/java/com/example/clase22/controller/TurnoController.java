package com.example.clase22.controller;

import com.example.clase22.entities.Turno;
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
    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Integer id){
        Turno turnoBuscado=turnoService.buscar(id);
        if (turnoBuscado!=null){
            //entra porque existe el turno con el id consultado
            return ResponseEntity.ok(turnoBuscado);
        }
        else{
            //entra porque no existe un id en el listado de turnos
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Integer id){
        if (turnoService.buscar(id)!=null){
            //borrar con seguridad porque existe
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Se eliminó el turno con id="+id);
        }
        else{
            //no existe turno con ese id
            return ResponseEntity.notFound().build();
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo");
        }
    }
    @PutMapping
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> respuesta;
        // Pedido - actualizar el turno id=1 con el paciente id=500 y odontologo id=1
        if (turnoService.buscar(turno.getId())!=null){
            if (odontologoService.buscarOdontologoXId(turno.getOdontologo().getId())!=null
                    &&pacienteService.buscar(turno.getPaciente().getId())!=null){
                respuesta=ResponseEntity.ok(turnoService.actualizarTurno(turno));
            }
            else{
                respuesta=ResponseEntity.badRequest().build();
            }
        }
        else{
            respuesta=ResponseEntity.badRequest().build();
        }
        return respuesta;
    }

}

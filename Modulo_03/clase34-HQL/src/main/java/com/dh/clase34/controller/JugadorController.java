package com.dh.clase34.controller;

import com.dh.clase34.entities.Jugador;
import com.dh.clase34.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {
    private final JugadorService jugadorService;
    @Autowired
    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }
    @GetMapping
    public ResponseEntity<List<Jugador>> buscarJugadores(){
        return ResponseEntity.ok(jugadorService.obtenerJugadores());
    }
    @PostMapping
    public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador jugador){
        return ResponseEntity.ok(jugadorService.guardarJugador(jugador));
    }
    @GetMapping("/{nombre}")
    public ResponseEntity<Jugador> buscarJugadorXNombre(@PathVariable String nombre){
        Optional<Jugador> jugadorBuscado=jugadorService.obtenerJugadorPorNombre(nombre);
        if (jugadorBuscado.isPresent()){
            return ResponseEntity.ok(jugadorBuscado.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }


}

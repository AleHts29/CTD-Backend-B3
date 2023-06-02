package com.dh.clase34.service;

import com.dh.clase34.entities.Jugador;
import com.dh.clase34.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class JugadorService {
    private final JugadorRepository jugadorRepository;
    @Autowired
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }
    public Jugador guardarJugador(Jugador jugador){
        return jugadorRepository.save(jugador);
    }
    public List<Jugador> obtenerJugadores(){
        return jugadorRepository.findAll();
    }
    public Optional<Jugador> obtenerJugadorPorNombre(String nombre){
        return jugadorRepository.buscarJugadorPorNombre(nombre);
    }
}

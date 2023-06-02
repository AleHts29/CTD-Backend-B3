package com.dh.clase34.repository;

import com.dh.clase34.entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JugadorRepository extends JpaRepository<Jugador,Long> {
    // para crear un nuevo jugador, usamos el método save
    // para obtener todos los jugadores, usamos findAll del repository
    //para obtener un jugador de acuerdo a un nombre
    @Query("select j from Jugador j where j.nombre=?1")
    Optional<Jugador> buscarJugadorPorNombre(String nombreJugador);
}

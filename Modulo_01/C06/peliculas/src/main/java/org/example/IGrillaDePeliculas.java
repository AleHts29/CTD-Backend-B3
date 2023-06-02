package org.example;

public interface IGrillaDePeliculas {
   Pelicula getPelicula( String nombrePelicula) throws PeliculaNoHabilitadaException;
}

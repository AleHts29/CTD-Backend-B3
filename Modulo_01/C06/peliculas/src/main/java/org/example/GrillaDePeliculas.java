package org.example;

public class GrillaDePeliculas implements IGrillaDePeliculas{
    @Override
    public Pelicula getPelicula(String nombrePelicula) throws PeliculaNoHabilitadaException {
        Pelicula pelicula = null;

        switch (nombrePelicula){
            case "Peli1":
                pelicula = new Pelicula("Peli1", "Argentina","https://peliculas.com/peli1");
                break;
            case "Peli2":
                pelicula = new Pelicula("Peli12", "Brasil","https://peliculas.com/peli2");
                break;
            case "Peli3":
                pelicula = new Pelicula("Peli3", "Colombia","https://peliculas.com/peli3");
                break;
            default:
                System.out.println("Peli no valida :/");
                return null;
        }

        return pelicula;
    }
}

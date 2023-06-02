package org.example;

public class GrillaDePeliculasProxy implements IGrillaDePeliculas{

    private GrillaDePeliculas grilla;
    private IP dirIP;

    public GrillaDePeliculasProxy(IP dir){
        grilla = new GrillaDePeliculas();
        dirIP = dir;
    }



    @Override
    public Pelicula getPelicula(String nombrePelicula) throws PeliculaNoHabilitadaException {
        // El pais de la pelicula debe ser igual al pais de la dirección
        // Buscamos la pelicula
        Pelicula resPeliculaBuscada = grilla.getPelicula(nombrePelicula);

        String origenPelicula = resPeliculaBuscada.getPais();
        String origenDireccionIP = dirIP.getPais();
        if(!origenDireccionIP.equals(origenPelicula)){
            throw new PeliculaNoHabilitadaException( nombrePelicula+" no disponible para "+origenDireccionIP);

        }

        return resPeliculaBuscada;
    }

    public GrillaDePeliculas getGrilla() {
        return grilla;
    }

    public IP getDirIP() {
        return dirIP;
    }

    public void setGrilla(GrillaDePeliculas grilla) {
        this.grilla = grilla;
    }

    public void setDirIP(IP dirIP) {
        this.dirIP = dirIP;
    }
}

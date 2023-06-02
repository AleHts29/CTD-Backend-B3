package org.example;

public class Main {
    public static void main(String[] args) {

        IP direccionIP = new IP(150,98,52,44);
        GrillaDePeliculasProxy proxy = new GrillaDePeliculasProxy(direccionIP);
        String peliculaBuscada = "Peli3";

        //Mostramos el link
        //Manejamos la exception
        try{
            System.out.println(peliculaBuscada+ " ver en: "+proxy.getPelicula(peliculaBuscada).getLink());
        }catch (PeliculaNoHabilitadaException exception){
            exception.printStackTrace();
        }


    }
}
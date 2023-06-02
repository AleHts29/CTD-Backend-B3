package org.example;

import java.time.LocalDate;

public class RegistroVacunaProxy implements Registro{
    private RegistroVacuna centroDeVacunacion;

    public RegistroVacunaProxy() {
        this.centroDeVacunacion = new RegistroVacuna();
    }

    public RegistroVacuna getCentroDeVacunacion() {
        return centroDeVacunacion;
    }

    public void setCentroDeVacunacion(RegistroVacuna centroDeVacunacion) {
        this.centroDeVacunacion = centroDeVacunacion;
    }

    @Override
    public String vacunar(Persona persona) {
        if(persona.getFechaAsignada().isAfter(LocalDate.now())){
            return centroDeVacunacion.vacunar(persona);
        }else {
            return "No se encontro turno asignado";
        }
    }
}

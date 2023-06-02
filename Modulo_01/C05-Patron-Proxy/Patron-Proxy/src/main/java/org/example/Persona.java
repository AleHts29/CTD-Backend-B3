package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaAsignada;
    private String nombreVacuna;

    public Persona(String nombre, String apellido, String dni, LocalDate fechaAsignada, String nombreVacuna) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaAsignada = fechaAsignada;
        this.nombreVacuna = nombreVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaAsignada() {
        return fechaAsignada;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaAsignada(LocalDate fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }
}

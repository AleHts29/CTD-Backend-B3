package org.example;

public class RegistroVacuna implements Registro{
    @Override
    public String vacunar(Persona persona) {
        System.out.println("Se gasto una vacuna");
        return ("Se ha registrado el DNI "+persona.getDni());
    }
}

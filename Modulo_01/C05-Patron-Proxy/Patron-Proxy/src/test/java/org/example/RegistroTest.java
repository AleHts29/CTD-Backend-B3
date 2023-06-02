package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {
    @Test
    public void vacunaPersonaOkTest(){

        Persona persona= new Persona("Ale", "Huertas", "9595", LocalDate.of(2022, 9, 29), "Moderna");

        Registro registro = new RegistroVacunaProxy();
        String respuestaEsperada = "Se ha registrado el DNI 9595";
        String respuestaActual = registro.vacunar(persona);
        assertEquals(respuestaEsperada, respuestaActual);
    }

}
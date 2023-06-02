package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcesaMailTest {
    @Test
    public void debeResponderComercial(){
        Mail correo = new Mail("ale@gmail.com", "comercial@colmena.com", "Devolucion");

        ProcesaMail colmena = new ProcesaMail(correo);
        String resultadoEsperado = "Enviado a comercial";
        String resultadoActual = colmena.getComprobador().comprobar(colmena.getCorreo());
        assertEquals(resultadoEsperado, resultadoActual);
    }

}
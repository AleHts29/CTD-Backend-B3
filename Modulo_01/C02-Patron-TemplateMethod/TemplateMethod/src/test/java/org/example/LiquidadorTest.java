package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidadorTest {
    @Test
    public void emitirReciboParaEmpleadoEfectivo(){
        Liquidador liquidador = new LiquidadorEmpleadoEfectivo();
        Empleado empleado = new EmpleadoEfectivo("Juan", "Martinez", "000212121333", 400,  40, 60);

        String respuestaEsperada = "La liquidación generada es un documento escrito. Saldo a liquidar: 420.0";
        String respuestaActual = liquidador.liquidarSueldo(empleado);
        assertEquals(respuestaEsperada, respuestaActual);

    }

}
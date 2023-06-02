package mesas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmadorDeMenuTest {
    @Test
    public void prepararMenuClasicoTest(){
        ArmadorDeMenu armador = new ArmadorMenuClasico();
        String respuestaEsperada = "Iniciando el armado del Menu - Paso 1: Agregar comida. Paso 2: Cocinar Comida. - " +
                "El precio del menu es: 100.0";
        Menu menu = new Menu(100);
        String respActual = armador.preparar(menu);
        assertEquals(respuestaEsperada, respActual);
    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeDescuentoTest {

    @Test
    public void descuento20Test(){
        //--> dado
        FacadeDescuento facadeDescuento = new FacadeDescuento();
        Tarjeta tarjeta = new Tarjeta("232343432002", "Star Bank");
        Producto producto = new Producto("Jugo", "Bebida" );
        int cantidad = 3;
        int descuentoEsperado = 20;

        //--> cuando
        int descuentoActual = facadeDescuento.descuento(tarjeta, producto, cantidad);

        //--> entonces
        assertEquals(descuentoEsperado, descuentoActual);

    }
}
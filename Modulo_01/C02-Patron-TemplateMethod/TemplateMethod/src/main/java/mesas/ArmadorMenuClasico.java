package mesas;

public class ArmadorMenuClasico extends ArmadorDeMenu{
    @Override
    protected String armar(Menu menu) {
        return "Paso 1: Agregar comida. Paso 2: Cocinar Comida. - ";
    }

    @Override
    protected double calcularPrecio(Menu menu) {
        return menu.getPrecioBase();
    }
}

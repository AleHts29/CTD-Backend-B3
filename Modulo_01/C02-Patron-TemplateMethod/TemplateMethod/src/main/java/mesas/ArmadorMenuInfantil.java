package mesas;

public class ArmadorMenuInfantil extends ArmadorDeMenu{
    @Override
    protected String armar(Menu menu) {
        return "Paso 1: Agregar comida. Paso 2: Cocinar Comida. Paso 3: Agregar Juguete";
    }

    @Override
    protected double calcularPrecio(Menu menu) {
        double resp = 0;
        if(menu instanceof MenuInfantil){
            resp = menu.getPrecioBase()+(3*((MenuInfantil)menu).getCantidadDeJuguetes());
        }

        return resp;
    }
}

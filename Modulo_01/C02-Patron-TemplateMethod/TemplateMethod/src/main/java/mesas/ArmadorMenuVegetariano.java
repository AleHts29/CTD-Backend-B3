package mesas;

public class ArmadorMenuVegetariano extends ArmadorDeMenu {
    @Override
    protected String armar(Menu menu) {
        return "Paso 1: Agregar comida. Paso 2: Cocinar Comida. Paso 3: Agregar Salsas";
    }

    @Override
    protected double calcularPrecio(Menu menu) {
        double resp = 0;
        if(menu instanceof MenuVegetariano){
            double recargos = (menu.getPrecioBase()*0.01)+(2*((MenuVegetariano)menu).getCantidadDeSalsas());
            resp = menu.getPrecioBase()+recargos;
        }

        return resp;
    }
}

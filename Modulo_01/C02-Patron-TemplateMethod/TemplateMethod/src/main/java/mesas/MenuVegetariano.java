package mesas;

public class MenuVegetariano extends  Menu{
    private int cantidadDeSalsas;
    public MenuVegetariano(double precioBase) {
        super(precioBase);
    }

    public int getCantidadDeSalsas() {
        return cantidadDeSalsas;
    }

    public void setCantidadDeSalsas(int cantidadDeSalsas) {
        this.cantidadDeSalsas = cantidadDeSalsas;
    }
}

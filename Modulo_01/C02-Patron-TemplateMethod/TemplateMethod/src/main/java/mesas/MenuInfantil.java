package mesas;

public class MenuInfantil extends Menu{
    private int cantidadDeJuguetes;

    public MenuInfantil(double precioBase) {
        super(precioBase);
    }

    public int getCantidadDeJuguetes() {
        return cantidadDeJuguetes;
    }

    public void setCantidadDeJuguetes(int cantidadDeJuguetes) {
        this.cantidadDeJuguetes = cantidadDeJuguetes;
    }
}

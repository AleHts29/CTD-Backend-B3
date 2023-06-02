package org.example;

public class EmpleadoEfectivo extends Empleado{
    private double sueldoBase;
    private double descuentos;
    private double premios;

    public EmpleadoEfectivo(String nombre, String apellido, String numeroDeCuenta, double sueldoBase, double descuentos, double premios) {
        super(nombre, apellido, numeroDeCuenta);
        this.sueldoBase = sueldoBase;
        this.descuentos = descuentos;
        this.premios = premios;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public double getPremios() {
        return premios;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public void setPremios(double premios) {
        this.premios = premios;
    }
}

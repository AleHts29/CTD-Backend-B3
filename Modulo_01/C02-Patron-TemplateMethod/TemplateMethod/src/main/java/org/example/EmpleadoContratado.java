package org.example;

public class EmpleadoContratado extends Empleado{
    private int cantidadDeHoras;
    private double valorHora;

    public EmpleadoContratado(String nombre, String apellido, String numeroDeCuenta, int cantidadDeHoras, double valorHora) {
        super(nombre, apellido, numeroDeCuenta);
        this.cantidadDeHoras = cantidadDeHoras;
        this.valorHora = valorHora;
    }

    public int getCantidadDeHoras() {
        return cantidadDeHoras;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setCantidadDeHoras(int cantidadDeHoras) {
        this.cantidadDeHoras = cantidadDeHoras;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}

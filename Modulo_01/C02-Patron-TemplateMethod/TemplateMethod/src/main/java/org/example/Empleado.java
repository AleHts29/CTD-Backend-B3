package org.example;

public class Empleado {
    private String nombre;
    private String apellido;
    private String numeroDeCuenta;

    public Empleado(String nombre, String apellido, String numeroDeCuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeCuenta = numeroDeCuenta;
    }



    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }
}

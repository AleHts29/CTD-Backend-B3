package org.example;

public class LiquidadorEmpleadoContratado extends Liquidador{
    @Override
    protected double calcularSueldo(Empleado empleado) {
        double respuesta = 0;

        // Hacemos un casteo efectivo
        if(empleado instanceof EmpleadoContratado){
            EmpleadoContratado emp = (EmpleadoContratado)empleado;
            respuesta = emp.getCantidadDeHoras()*emp.getValorHora();
        }
        return  respuesta;
    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidación generada es un dopcumento escrito.";
    }
}

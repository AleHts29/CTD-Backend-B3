package org.example;

public class LiquidadorEmpleadoEfectivo extends Liquidador{

    @Override
    protected double calcularSueldo(Empleado empleado) {
        double respuesta = 0;

        // Hacemos un casteo efectivo
        if(empleado instanceof EmpleadoEfectivo){
            EmpleadoEfectivo emp = (EmpleadoEfectivo)empleado;
            respuesta = emp.getSueldoBase()+emp.getPremios()-emp.getDescuentos();
        }


        return  respuesta;

    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidación generada es un documento escrito.";
    }
}

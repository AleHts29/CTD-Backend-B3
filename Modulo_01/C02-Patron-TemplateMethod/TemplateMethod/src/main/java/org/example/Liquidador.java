package org.example;

public abstract class Liquidador {
    public String liquidarSueldo(Empleado empleado){
        String respuesta = "La liquidacion no pudo ser calculada";
        double sueldo = calcularSueldo(empleado);

        if(sueldo > 0){
            String recibo = emitirRecibo(empleado);

            System.out.println(depositarSueldo(empleado));

            // respuesta final.
            respuesta = recibo+" Saldo a liquidar: " + sueldo;
        }
        return  respuesta;
    }

    protected abstract double calcularSueldo(Empleado empleado);
    protected abstract String emitirRecibo(Empleado empleado);
    private String depositarSueldo(Empleado empleado){
        return "Orden de deposito en la cuenta N. " + empleado.getNumeroDeCuenta();
    }
}

package composicion;

import herencia.Cuenta;

public class EstrategiaCajaAhorro implements IEstrategiaExtraccion{


    @Override
    public boolean extraer(Cuenta cuenta, double monto) {
        boolean result = false;
        if(cuenta.getSaldo() >= monto){
            cuenta.setSaldo(cuenta.getSaldo()-monto);
            result = true;
        }

        return result;
    }
}

package composicion;
import herencia.Cuenta;

public class EstratejiaCuentaCorriente implements IEstrategiaExtraccion{


    @Override
    public boolean extraer(Cuenta cuenta, double monto) {
        cuenta.setSaldo(cuenta.getSaldo()-monto);
        return true;
    }
}

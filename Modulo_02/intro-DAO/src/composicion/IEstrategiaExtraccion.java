package composicion;

import herencia.Cuenta;

public interface IEstrategiaExtraccion {
    public boolean extraer(Cuenta cuenta, double monto);
}

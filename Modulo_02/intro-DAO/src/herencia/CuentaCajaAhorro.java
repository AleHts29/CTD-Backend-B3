package herencia;

public class CuentaCajaAhorro extends Cuenta {
    @Override
    public boolean extraer(double monto) {
        boolean result = false;
        if(getSaldo() >= monto){
            setSaldo(getSaldo()-monto);
            result = true;
        }
        return result;
    }
}

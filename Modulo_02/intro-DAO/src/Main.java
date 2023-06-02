import composicion.EstrategiaCajaAhorro;
import composicion.EstratejiaCuentaCorriente;
import herencia.Cuenta;
import herencia.CuentaCajaAhorro;
import herencia.CuentaCorriente;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {

        //vinculacion dinamica dependiendo de la clase que se instancie
        Cuenta cuenta = new CuentaCajaAhorro();
        cuenta.setSaldo(1000);
        //aqui se produce el Polimorfismo
        cuenta.extraer(1200);

        //retorna el saldo de la cuenta ya que no se pudo extraer el monto
        out.println(cuenta.getSaldo());



        Cuenta cuentaC = new CuentaCorriente();
        cuentaC.setSaldo(cuenta.getSaldo());
        cuenta = cuentaC;
        cuenta.extraer(1200);

        //retorna el saldo al descubierto
        System.out.println(cuenta.getSaldo());


        //=> Usando Composicion
        Cuenta cuenta3 = new Cuenta();
        cuenta3.setSaldo(2000);
        cuenta3.setNumero(023);
        cuenta3.setEstratejia(new EstrategiaCajaAhorro());

        cuenta3.extraer(2500);

        cuenta3.setEstratejia(new EstratejiaCuentaCorriente());
        cuenta3.extraer(2500);

        System.out.println("Usando composicion: "+cuenta3.getSaldo());
    }
}
package herencia;

import composicion.IEstrategiaExtraccion;

public  class Cuenta {
    private int numero;
    private double saldo;
    private IEstrategiaExtraccion estratejia;

    public void setEstratejia(IEstrategiaExtraccion estratejia) {
        this.estratejia = estratejia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // si usamos solo herrencia, el metodo extraer y la clase deben ser abstract
    //abstract public boolean extraer (double monto);


    //Se esta usando composicion
     public boolean extraer (double monto){
        return estratejia.extraer(this, monto);
     }
}

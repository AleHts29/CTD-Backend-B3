import org.apache.log4j.Logger;

public class Calculadora {
    private static final Logger logger = Logger.getLogger((Calculadora.class));
    private int num1;
    private int num2;

    public Calculadora(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double dividir(){
        logger.info("Empezamos la division");
        double resultado;
        try{
            resultado = num1 / num2;
        }catch (Exception e){
            logger.error("Ocurrio un error", e);
            return 0;
        }
        logger.debug("Operacion finalizada");
        return resultado;
    }
}


import java.util.logging.Logger;

public class Test {
    private static final Logger logger = Logger.getLogger(String.valueOf(Test.class));

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora(6,2);
        calculadora.dividir();
    }
}

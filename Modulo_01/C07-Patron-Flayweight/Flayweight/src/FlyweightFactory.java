import java.util.HashMap;

public class FlyweightFactory {

    private static final HashMap<String, Circulo> circuloMap = new HashMap<>();

    public static Circulo obtenerCiculo(String color){
        Circulo circulo = circuloMap.get(color);
        if(circulo == null){
            circulo = new Circulo(color);
            circuloMap.put(color, circulo);
            System.out.println("Se creo un circulo de color "+color);
        }
        return circulo;
    }
}

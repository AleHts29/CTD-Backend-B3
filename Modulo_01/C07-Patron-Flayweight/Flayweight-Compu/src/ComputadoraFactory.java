import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
    private Map<String, Computadora> computadorasCreadas = new HashMap<>();
    public Computadora getComputadora (int ram, int disco){
        //crear una clave para mi mapa
        String clave = "clave:"+ram+":"+disco;

        //Obtener la computadora
        //Si la clave ya existe, devolvemos el objeto creado con anterioridad, de lo contrario lo creamos y lo agregamos a la coleccion
        if(!computadorasCreadas.containsKey(clave)){
            computadorasCreadas.put(clave, new Computadora(ram, disco));
            return computadorasCreadas.get(clave);
        }

        return computadorasCreadas.get(clave);
    }
}

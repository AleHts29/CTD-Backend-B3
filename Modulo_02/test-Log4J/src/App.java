import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    private List<Integer> listaEnteros;
    public App(){
        listaEnteros = new ArrayList<>();
    }

    public void agregarEntero(Integer numero){
        listaEnteros.add(numero);

        if(listaEnteros.size()>5){
            //usamos el logger
            logger.info("La lista tienen mas de 5 elementos - total: "+listaEnteros.size());
        }
    }
}

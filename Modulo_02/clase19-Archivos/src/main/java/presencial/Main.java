package presencial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class  Main {
    public static void main(String[] args) {
        // preparar nuestra colección de perros
        List<Perro> canes= new ArrayList<>();
        canes.add(new Perro("Carmela",1));
        canes.add(new Perro("BaBU",8));
        canes.add(new Perro("Olivia",9));
        canes.add(new Perro("Max",4));
        canes.add(new Perro("Zonfranc",2));
        canes.add(new Perro("Indi",3));
        canes.add(new Perro("Milo",3));
        // guardar la colección en un archivo
        try{
            FileOutputStream fos= new FileOutputStream("OutputFile.txt");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(canes);
            oos.close();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        // vamos a recuperar la colección del archivo a una nueva colección
        List<Perro> canesRecuperados=null;
        try{
            FileInputStream fis= new FileInputStream("OutputFile.txt");
            ObjectInputStream ois= new ObjectInputStream(fis);
            canesRecuperados=(ArrayList)ois.readObject();
            ois.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //mostrando la información recuperada
        for (Perro perro:canesRecuperados) {
            System.out.println(perro.toString());
        }
    }
}

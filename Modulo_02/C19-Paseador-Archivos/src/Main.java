import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Perro p1 = new Perro("Homero", "Waimaraner", 2, "dir 1");
        Perro p2 = new Perro("toby", "coker", 4, "dir 2");
        Perro p3 = new Perro("fido", "dogo", 3, "dir 3");
        Perro p4 = new Perro("Dante", "Maltes", 2, "dir 4");

        ArrayList <Perro> lunes = new ArrayList<Perro>();
        ArrayList <Perro> martes = new ArrayList<Perro>();
        ArrayList <Perro> miercoles = new ArrayList<Perro>();
        ArrayList <Perro> jueves = new ArrayList<Perro>();
        ArrayList <Perro> viernes = new ArrayList<Perro>();

        //p1
        lunes.add(p1);
        miercoles.add(p1);
        viernes.add(p1);

        //p2
        lunes.add(p2);
        miercoles.add(p2);
        jueves.add(p2);

        //p3
        martes.add(p3);
        miercoles.add(p3);
        viernes.add(p3);

        //p4
        lunes.add(p4);
        miercoles.add(p4);
        jueves.add(p4);
        viernes.add(p4);


        try{
            //se crea archivo de salida
            FileOutputStream fi = new FileOutputStream("perros.dat");

            //se da formata objeto
            ObjectOutputStream archivo = new ObjectOutputStream(fi);

            //se guarda la informacion del array en formato de objetos literales.
            archivo.writeObject(lunes);
            archivo.writeObject(martes);
            archivo.writeObject(miercoles);
            archivo.writeObject(jueves);
            archivo.writeObject(viernes);
            archivo.close();

            //leo el archivo
            FileInputStream fiInt = new FileInputStream("perros.dat");
            ObjectInputStream archivoInt = new ObjectInputStream(fiInt);

            ArrayList<Perro> dia;


            for(int i=0; i<5; i++){
                System.out.println("Dia: "+i+1);
                System.out.println("==========");

                //se hace casteo y se imprime la data
                dia = (ArrayList<Perro>) archivoInt.readObject();
                for (Perro p: dia ) {
                    System.out.println(p);
                }
            }

            archivoInt.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
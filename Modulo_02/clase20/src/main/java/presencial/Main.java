package presencial;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        Empresa empresa= new Empresa("20-8474158-9","Java S.A");
        empresa.agregarEmpleado(new Empleado("Juan","Rodriguez",
                1154,56000d));
        empresa.mostrarEmpleados();
        try {
            FileOutputStream fos= new FileOutputStream("Empleados.txt");
            BufferedOutputStream bos= new BufferedOutputStream(fos);
            for (Empleado empleado:empresa.getEmpleados()) {
                //guardar cada empleado con su formato correspondiente tipo csv
                String linea=empleado.getNombre()+";"+
                        empleado.getApellido()+";"+
                        empleado.getLegajo()+";"+
                        empleado.getSueldo()+"\n";
                bos.write(linea.getBytes());
            }
            bos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

package presencial;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String cuit;
    private String razonSocial;
    private List<Empleado> empleados;

    public Empresa(String cuit, String razonSocial) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        empleados=new ArrayList<>();
    }
    public void mostrarEmpleados(){
        for (Empleado empleado:empleados) {
            System.out.println(empleado.toString());
        }
    }

    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}

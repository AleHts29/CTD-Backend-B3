package mesas;

public abstract class ArmadorDeMenu {
    public String preparar(Menu menu){
        String respuesta = "Iniciando el armado del Menu - ";
        respuesta = respuesta+armar(menu);
        respuesta = respuesta + "El precio del menu es: " + calcularPrecio(menu);
        return respuesta;
    }

    protected abstract String armar(Menu menu);
    protected abstract double calcularPrecio(Menu menu);

}

public class Circulo {
    private String color;
    private double radio;
    private String tamanio;


    public Circulo(String color) {
        this.color = color;
    }



    //Metodos
    public void dibujar(){
        System.out.println("Dibujamos objeto color: "+ color);
    }


    // Setter and Getters
    public String getColor() {
        return color;
    }

    public double getRadio() {
        return radio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
}

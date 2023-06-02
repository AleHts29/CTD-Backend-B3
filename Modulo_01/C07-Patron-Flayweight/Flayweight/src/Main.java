public class Main {
    private static final String colores[] = {"Rojo", "Azul", "Verde", "Negro"};



    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Circulo circulo = FlyweightFactory.obtenerCiculo(radomColor());
            circulo.setRadio(i+5);
            circulo.setTamanio("size: "+ i*2);
            circulo.dibujar();

        }

    }

    //Metodo radomColor
    private static String radomColor(){
        return colores[(int)(Math.random()*colores.length)];
    }

}
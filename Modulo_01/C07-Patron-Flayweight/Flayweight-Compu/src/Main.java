public class Main {
    public static void main(String[] args) {

        ComputadoraFactory computadoraFactory = new ComputadoraFactory();

        Computadora compu1 = computadoraFactory.getComputadora(32, 512);
        Computadora compu2 = computadoraFactory.getComputadora(32, 512);
        Computadora compu3 = computadoraFactory.getComputadora(8, 256);
        Computadora compu4 = computadoraFactory.getComputadora(32, 1024);
        Computadora compu5 = computadoraFactory.getComputadora(16, 512);
        Computadora compu6 = computadoraFactory.getComputadora(8, 256);

        System.out.println(compu1);
        System.out.println(compu2);
        System.out.println(compu3);
        System.out.println(compu4);
        System.out.println(compu5);
        System.out.println(compu6);

        System.out.println("Compus: "+Computadora.getContador());

    }
}
package org.example;

public class IP {
    private int num1;
    private int num2;
    private int num3;
    private int num4;

    public IP(int num1, int num2, int num3, int num4) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
    }

    // Metodos
    public String getPais(){
        String respuesta = "desconocido";
        if(num1 > 0 && num1 <= 49){
            respuesta = "Argentina";
            return respuesta;
        }
        if( num1 <= 99){
            respuesta = "Brasil";
            return respuesta;
        }
        if( num1 <= 150){
            respuesta = "Colombia";
            return respuesta;
        }
        return respuesta;
    }


    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public void setNum4(int num4) {
        this.num4 = num4;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getNum3() {
        return num3;
    }

    public int getNum4() {
        return num4;
    }
}

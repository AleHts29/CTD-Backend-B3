package org.example;

public class CompruebaMail {
    private Manejador inicial;

    public CompruebaMail(){
        //vamos a crear la cadena correspondiente
        inicial = new ManejadorGerencial();
        Manejador tecnico = new ManejadorTecnico();
        Manejador comercial = new ManejadorComercial();
        Manejador spam = new ManejadorSpam();

        //armar la cadena
        inicial.setSiguiguienteManejador(tecnico);
        tecnico.setSiguiguienteManejador(comercial);
        comercial.setSiguiguienteManejador(spam);

    }

    public String comprobar(Mail mail){
        return inicial.comprobarMail(mail);
    }
}

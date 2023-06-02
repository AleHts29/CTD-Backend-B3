package org.example;

public class ManejadorComercial extends Manejador{
    @Override
    public String comprobarMail(Mail mail) {
        if(mail.getDestino().equals("comercial@colmena.com") || mail.getTema().equals("Comercial")){
            return "Enviado a comercial";
        }
        else{
            return getSiguiguienteManejador().comprobarMail(mail);
        }
    }
}

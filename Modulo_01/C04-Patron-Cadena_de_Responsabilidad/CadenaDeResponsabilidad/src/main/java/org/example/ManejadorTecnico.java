package org.example;

public class ManejadorTecnico extends Manejador{
    @Override
    public String comprobarMail(Mail mail) {
        if(mail.getDestino().equals("tecnica@colmena.com") || mail.getTema().equals("Tecnico")){
            return "Enviado a tecnica";
        }
        else{
            return getSiguiguienteManejador().comprobarMail(mail);
        }
    }
}

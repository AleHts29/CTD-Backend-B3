package org.example;

public abstract class Manejador {
    // es un atributo
    private Manejador siguiguienteManejador;

    public abstract String comprobarMail(Mail mail);

    public Manejador getSiguiguienteManejador() {
        return siguiguienteManejador;
    }

    public void setSiguiguienteManejador(Manejador siguiguienteManejador) {
        this.siguiguienteManejador = siguiguienteManejador;
    }
}

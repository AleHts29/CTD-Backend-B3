package com.example.C33Spring_Data.modelo;

import javax.persistence.*;

@Entity
@Table
public class Alumno {
    @Id
    @SequenceGenerator(name = "alumno_sequence", sequenceName = "alumno_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    private Long id;
    private String nombre;
    private int edad;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "escuela_id")
    private Escuela escuela;

    public Alumno() {
    }

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

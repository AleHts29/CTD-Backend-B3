package com.example.clase22.dao;

import com.example.clase22.entities.Turno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TurnoDAOLista implements IDao<Turno>{
    @Override
    public Turno guardar(Turno turno) {
        return null;
    }

    @Override
    public Turno buscar(Integer id) {
        return null;
    }

    @Override
    public Turno buscarXCriterio(String criterio) {
        return null;
    }

    @Override
    public List<Turno> buscarTodos() {
        return null;
    }

    @Override
    public Turno actualizar(Turno turno) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }
    /*
    private List<Turno> turnos;

    public TurnoDAOLista(){
        turnos=new ArrayList<>();
    }

    @Override
    public Turno guardar(Turno turno) {
        turnos.add(turno);
        return turno;
    }

    @Override
    public Turno buscar(Integer id) {
        Turno turnoBuscado=null;
        for (Turno turno:turnos) {
            if (turno.getId()==id){
                turnoBuscado=turno;
                return turnoBuscado;
            }
        }
        return turnoBuscado;
    }

    @Override
    public Turno buscarXCriterio(String criterio) {
        return null;
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnos;
    }

    @Override
    public Turno actualizar(Turno turno) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

     */
}

package com.example.entrenador.service;

import com.example.entrenador.dao.EntrenadorDAOH2;
import com.example.entrenador.dao.IDao;
import com.example.entrenador.dominio.Entrenador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServiceImpl implements IEntrenadorService{
    private IDao<Entrenador> entrenadorIDao;

    public EntrenadorServiceImpl(){
        entrenadorIDao=new EntrenadorDAOH2();
    }

    @Override
    public List<Entrenador> listarEntrenadores() {
        return entrenadorIDao.listarTodos();
    }
}

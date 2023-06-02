package com.example.clase22.servicio;

import com.example.clase22.dao.IDao;
import com.example.clase22.dao.OdontologoDAOH2;
import com.example.clase22.modelo.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    @Autowired
    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo buscarOdontologoXId(Integer id){
        return odontologoIDao.buscar(id);
    }
    public List<Odontologo> buscarTodosOdontologos(){
        return odontologoIDao.buscarTodos();
    }
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }
}

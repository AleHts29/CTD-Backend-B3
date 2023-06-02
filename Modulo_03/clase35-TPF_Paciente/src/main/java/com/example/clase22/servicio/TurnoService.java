package com.example.clase22.servicio;

import com.example.clase22.dao.IDao;
import com.example.clase22.entities.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TurnoService {
    private IDao<Turno> turnoIDao;
    @Autowired
    public TurnoService(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
    }

    public Turno guardar(Turno turno){
        return turnoIDao.guardar(turno);
    }
    public Turno buscar(Integer id){
        return turnoIDao.buscar(id);
    }
    public List<Turno> buscarTodos(){
        return turnoIDao.buscarTodos();
    }
    public Turno actualizarTurno(Turno turno){
        return turnoIDao.actualizar(turno);
    }
    public void eliminarTurno(Integer id){
        turnoIDao.eliminar(id);
    }
}

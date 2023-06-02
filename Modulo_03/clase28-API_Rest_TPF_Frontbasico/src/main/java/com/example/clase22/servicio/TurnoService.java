package com.example.clase22.servicio;

import com.example.clase22.dao.IDao;
import com.example.clase22.dao.PacienteDAOH2;
import com.example.clase22.dao.TurnoDAOLista;
import com.example.clase22.modelo.Paciente;
import com.example.clase22.modelo.Turno;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TurnoService {
    private IDao<Turno> turnoIDao;

    public TurnoService() {
        this.turnoIDao = new TurnoDAOLista();
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
}

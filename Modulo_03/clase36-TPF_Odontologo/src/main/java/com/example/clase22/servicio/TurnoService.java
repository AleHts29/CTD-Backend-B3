package com.example.clase22.servicio;

import com.example.clase22.dao.IDao;
import com.example.clase22.entities.Turno;
import com.example.clase22.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    private final TurnoRepository turnoRepository;
    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno guardar(Turno turno){
        return turnoRepository.save(turno);
    }
    public Optional<Turno> buscar(Long id){
        return turnoRepository.findById(id);
    }
    public List<Turno> buscarTodos(){
        return turnoRepository.findAll();
    }
    public Turno actualizarTurno(Turno turno){
        return turnoRepository.save(turno);
    }
    public void eliminarTurno(Long id){
        turnoRepository.deleteById(id);
    }
}

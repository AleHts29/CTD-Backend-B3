package com.dh.clase31.service;

import com.dh.clase31.entities.Movimiento;
import com.dh.clase31.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {
    private final MovimientoRepository movimientoRepository;
    @Autowired
    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }
    public List<Movimiento> listarMovimientos(){

        return movimientoRepository.findAll();
    }
    public Movimiento guardarMovimiento(Movimiento movimiento){

        return movimientoRepository.save(movimiento);
    }

}

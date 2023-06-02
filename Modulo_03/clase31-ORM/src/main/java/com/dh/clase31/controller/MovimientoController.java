package com.dh.clase31.controller;

import com.dh.clase31.entities.Movimiento;
import com.dh.clase31.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    private final MovimientoService movimientoService;
    @Autowired
    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }
    @GetMapping
    public ResponseEntity<List<Movimiento>> consultarMovimientos(){
        return ResponseEntity.ok(movimientoService.listarMovimientos());
    }
}

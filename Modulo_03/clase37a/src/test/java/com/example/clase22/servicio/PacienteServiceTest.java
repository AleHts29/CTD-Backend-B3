package com.example.clase22.servicio;

import com.example.clase22.entities.Paciente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;
    @Test
    void buscar() {
        Integer idPacienteBuscado=1;
        //buscar paciente
        //Paciente pacienteBuscado=pacienteService.buscar(idPacienteBuscado);
        //assertNotNull(pacienteBuscado);
    }
}
package presencial.servicio;

import org.junit.jupiter.api.Test;
import presencial.bd.BD;
import presencial.dao.PacienteDAOH2;
import presencial.modelo.Domicilio;
import presencial.modelo.Paciente;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {
    private PacienteService pacienteService= new PacienteService(new PacienteDAOH2());
    @Test
    public void cargarPacienteTest() throws Exception {
        BD.crearTablas();
        Domicilio domicilio= new Domicilio("Calle A",845,
                "Salta Capital","Salta");
        Paciente paciente= new Paciente("Rodolfo",584571,
                LocalDate.of(2022,8,17),domicilio);
        pacienteService.guardar(paciente);
        assertTrue(paciente.getId()==1);
    }
}
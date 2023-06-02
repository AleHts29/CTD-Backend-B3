package presencial.dao;

import presencial.bd.BD;
import presencial.modelo.Paciente;

import java.sql.*;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente>{
    private static final String SQL_GUARDAR=
            "INSERT INTO PACIENTES (APELLIDO, NOMBRE,  DNI, FECHA, DOMICILIO_ID) " +
                    "VALUES (?,?,?,?,?)";
    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection=null;
        try{
            DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
            domicilioDAOH2.guardar(paciente.getDomicilio());

            connection= BD.getConnection();
            PreparedStatement ps= connection.prepareStatement(SQL_GUARDAR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,paciente.getApellido());
            ps.setString(2,paciente.getNombre());
            ps.setInt(3,paciente.getDni());
            ps.setDate(4, Date.valueOf(paciente.getFecha()));
            ps.setInt(5,paciente.getDomicilio().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                paciente.setId(rs.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) {
        return null;
    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }
}

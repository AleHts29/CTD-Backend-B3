package com.example.clase22.dao;

import com.example.clase22.bd.BD;
import com.example.clase22.modelo.Domicilio;
import com.example.clase22.modelo.Paciente;

import java.sql.*;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente>{
    private static final String SQL_GUARDAR=
            "INSERT INTO PACIENTES (APELLIDO, NOMBRE,  DNI, FECHA, DOMICILIO_ID, EMAIL) " +
                    "VALUES (?,?,?,?,?,?)";
    private static final String SQL_BUSCAR_X_EMAIL=
            "SELECT * FROM PACIENTES WHERE EMAIL=?";
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
            ps.setString(6,paciente.getEmail());
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
    public Paciente buscarXCriterio(String criterio) {
        Connection connection=null;
        Paciente paciente=null;
        Domicilio domicilio;
        try{
            DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement(SQL_BUSCAR_X_EMAIL);
            ps.setString(1,criterio);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                domicilio=domicilioDAOH2.buscar(rs.getInt(6));
                paciente= new Paciente(rs.getInt(1),
                        rs.getString(2),rs.getString(3),
                        rs.getInt(4),rs.getDate(5).toLocalDate(),
                        domicilio,rs.getString(7));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }
}

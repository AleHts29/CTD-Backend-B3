package com.example.clase22.dao;

import com.example.clase22.bd.BD;
import com.example.clase22.modelo.Domicilio;
import com.example.clase22.modelo.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente>{
    private static final String SQL_GUARDAR=
            "INSERT INTO PACIENTES (APELLIDO, NOMBRE, EMAIL, DNI, FECHA, DOMICILIO_ID) " +
                    "VALUES (?,?,?,?,?,?)";
    private static final String SQL_BUSCAR_X_EMAIL=
            "SELECT * FROM PACIENTES WHERE EMAIL=?";
    private static final String SQL_BUSCAR_X_ID=
            "SELECT * FROM PACIENTES WHERE ID=?";

    private static final String SQL_BUSCAR_ALL=
            "SELECT * FROM PACIENTES";
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
            ps.setString(3,paciente.getEmail());
            ps.setInt(4,paciente.getDni());
            ps.setDate(5, Date.valueOf(paciente.getFecha()));
            ps.setInt(6,paciente.getDomicilio().getId());
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
        Connection connection=null;
        Paciente paciente=null;
        Domicilio domicilio;
        try{
            DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement(SQL_BUSCAR_X_ID);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                domicilio=domicilioDAOH2.buscar(rs.getInt(7));
                paciente= new Paciente(rs.getInt(1),
                        rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getInt(5),rs.getDate(6).toLocalDate(),
                        domicilio);

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
                domicilio=domicilioDAOH2.buscar(rs.getInt(7));
                paciente= new Paciente(rs.getInt(1),
                        rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getInt(5),rs.getDate(6).toLocalDate(),
                        domicilio);

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
        Connection connection=null;
        List<Paciente> pacientes=new ArrayList<>();
        Domicilio domicilio;
        try{
            DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement(SQL_BUSCAR_ALL);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                domicilio=domicilioDAOH2.buscar(rs.getInt(7));
                pacientes.add(new Paciente(rs.getInt(1),
                        rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getInt(5),rs.getDate(6).toLocalDate(),
                        domicilio)
                            );

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

        //para el test
        //1- asegurar el tamaño de la lista: Si tiene tres elementos que la lista pacientes.size()==3
        //2- dado que existen pacientes: si o si la pacientes.size()>0
        //3- dado que existen pacientes la lista si o si tiene que ser no nula
        return pacientes;
    }
}

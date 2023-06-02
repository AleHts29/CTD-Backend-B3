package com.example.clase22.dao;


import com.example.clase22.bd.BD;
import com.example.clase22.entities.Domicilio;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
@Repository
public class DomicilioDAOH2 implements IDao<Domicilio> {
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        return null;
    }

    @Override
    public Domicilio buscar(Integer id) {
        return null;
    }

    @Override
    public Domicilio buscarXCriterio(String criterio) {
        return null;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return null;
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }
    /*
    private static final String SQL_GUARDAR=
            "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) " +
                    "VALUES (?,?,?,?)";
    private static final String SQL_BUSCAR=
            "SELECT * FROM DOMICILIOS WHERE ID=?";
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection = null;
        try {
            connection = BD.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_GUARDAR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                domicilio.setId(rs.getInt(1));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            //se ejecuta siempre
            try{
                connection.close();
            }
            catch (SQLException sqle){
                sqle.printStackTrace();
            }
        }
        return domicilio;

    }
    @Override
    public Domicilio buscar(Integer id) {
        Connection connection=null;
        Domicilio domicilio=null;
        try{
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement(SQL_BUSCAR);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                domicilio= new Domicilio(
                        rs.getInt(1),
                        rs.getString("calle"),
                        rs.getInt("numero"),
                        rs.getString("localidad"),
                        rs.getString("provincia")
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
            catch (SQLException sql){
                sql.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public Domicilio buscarXCriterio(String criterio) {
        return null;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return null;
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

     */
}

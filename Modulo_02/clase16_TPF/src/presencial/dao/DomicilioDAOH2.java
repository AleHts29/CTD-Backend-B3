package presencial.dao;

import presencial.bd.BD;
import presencial.modelo.Domicilio;

import java.sql.*;
import java.util.List;

public class DomicilioDAOH2 implements IDao<Domicilio> {
    private static final String SQL_GUARDAR=
            "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) " +
                    "VALUES (?,?,?,?)";
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
        return null;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return null;
    }
}

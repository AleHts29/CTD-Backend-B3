package DAOs;

import modelo.Estudiante;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudiantesDAO_H2 implements IDao<Estudiante> {

    private static final Logger logger = Logger.getLogger(EstudiantesDAO_H2.class);

    private static final String SQL_CREATE_TABLE = """
            DROP TABLE IF EXISTS ESTUDIANTES;
            CREATE TABLE ESTUDIANTES (ID BIGINT PRIMARY KEY,
            NOMBRE VARCHAR(255) NOT NULL,
            APELLIDO VARCHAR(255) NOT NULL)
            """;
    private static final String SQL_INSERT = """
            INSERT INTO ESTUDIANTES (ID, NOMBRE, APELLIDO) VALUES(?, ?, ?)
            """;
    private static final String SQL_DELETE = """
            DELETE FROM ESTUDIANTES WHERE ID=?
            """;
    private static final String SQL_FIND = """
            SELECT * FROM ESTUDIANTES WHERE ID=?
            """;
    private static final String SQL_SELECT = """
            SELECT * FROM ESTUDIANTES
            """;

    //Conexion con H2
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/DAO-LiveCoding_C14A";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "sa";

    private static Connection getConnection() throws Exception{
        Class.forName(DB_JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USER,DB_PASSWORD);

    }


    @Override
    public Estudiante guardar(Estudiante estudiante) {
        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            //inserts
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setLong(1, estudiante.getId());
            psInsert.setString(2, estudiante.getNombre());
            psInsert.setString(3, estudiante.getApellido());
            psInsert.executeUpdate();


            //Mostrar datos de la db
            ResultSet rs = statement.executeQuery(SQL_SELECT);
            while (rs.next()){
                System.out.println("ID:"+rs.getLong(1)+" Nombre:" +rs.getString(2)+" Apellido:"+rs.getString(3));
            }
            psInsert.close();

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return estudiante;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;

        try{
            connection = getConnection();
            //Statement statement = connection.createStatement();
            //statement.execute(SQL_CREATE_TABLE);

            //inserts
            PreparedStatement psInsert = connection.prepareStatement(SQL_DELETE);
            psInsert.setLong(1, id);

            psInsert.executeUpdate();

            psInsert.close();

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Estudiante buscar(Long id) {
        Connection connection = null;
        Estudiante estudiante = null;

        try{
            connection = getConnection();

            //inserts
            PreparedStatement psInsert = connection.prepareStatement(SQL_FIND);
            psInsert.setLong(1, id);

            ResultSet rs = psInsert.executeQuery();

            //Mostrar datos de la db
            while (rs.next()){
                System.out.println("ID:"+rs.getLong(1)+" Nombre:" +rs.getString(2)+" Apellido:"+rs.getString(3));

                estudiante = new Estudiante();
                estudiante.setId(rs.getLong("id"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
            }
            psInsert.close();

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    return estudiante;
    }


    @Override
    public List buscarTodos() {
        Connection connection = null;
        List<Estudiante> estudiantes = new ArrayList();

        try{
            connection = getConnection();

            //inserts
            PreparedStatement psInsert = connection.prepareStatement(SQL_SELECT);
//            psInsert.setLong(1, id);

            ResultSet rs = psInsert.executeQuery();

            //Mostrar datos de la db
            while (rs.next()){
//                System.out.println("ID:"+rs.getLong(1)+" Nombre:" +rs.getString(2)+" Apellido:"+rs.getString(3));

                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getLong("id"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));

                estudiantes.add(estudiante);
            }
            psInsert.close();

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return estudiantes;
    }


}

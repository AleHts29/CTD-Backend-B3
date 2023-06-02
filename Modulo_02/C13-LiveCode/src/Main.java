import org.apache.log4j.Logger;
//
import java.security.PublicKey;
import java.sql.*;

public class Main {


        private static final String SQL_CREATE_TABLE = """
            DROP TABLE IF EXISTS USUARIOS;
            CREATE TABLE USUARIOS (ID INT PRIMARY KEY,
            NOMBRE VARCHAR(100) NOT NULL,
            EMAIL VARCHAR(100) NOT NULL,
            SUELDO NUMERIC(15, 2) NOT NULL)
            """;

    private static final String SQL_INSERT = """
            INSERT INTO USUARIOS (ID, NOMBRE, EMAIL, SUELDO) VALUES(?, ?, ?, ?)
            """;
    private static final String SQL_UPDATE = "UPDATE USUARIOS SET SUELDO=? WHERE EMAIL=?";

    private static final String SQL_SELECT = """
            SELECT * FROM USUARIOS
            """;

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception{
        Usuario usuario = new Usuario("Pedro", "pedro@gmail.com", 2500d);
        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            //inserts
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1, 1);
            psInsert.setString(2, usuario.getNombre());
            psInsert.setString(3, usuario.getEmail());
            psInsert.setDouble(4, usuario.getSueldo());
            psInsert.execute();

            //Update
            connection.setAutoCommit(false);
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setDouble(1, usuario.subirSueldo(4000d));
            psUpdate.setString(2, usuario.getEmail());
            psUpdate.execute();

            //simulamos un error
            //int a = 4 / 0;

            connection.commit();
            connection.setAutoCommit(true);



            //Mostrar datos de la db
            ResultSet rs = statement.executeQuery(SQL_SELECT);
            while (rs.next()){
                System.out.println("ID:"+rs.getInt(1)+" Nombre:" +rs.getString(2)+" Email:"+rs.getString(3)+" Sueldo: "+ rs.getDouble(4));
            }


        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            connection.rollback();
        }finally {
            connection.close();
        }

        //Mostrar datos de la db despues del rollback
//        Connection connection1 = getConnection();
//        Statement statement = connection1.createStatement();
//        ResultSet rs = statement.executeQuery(SQL_SELECT);
//        while (rs.next()){
//            System.out.println("ID:"+rs.getInt(1)+" Nombre:" +rs.getString(2)+" Email:"+rs.getString(3)+" Sueldo: "+ rs.getDouble(4));
//        }


    }

    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase13-liveCoding", "sa","sa");

    }
}

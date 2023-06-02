import org.apache.log4j.Logger;

import java.sql.*;

public class Main {

    private static final String SQL_CREATE_TABLE = """
            DROP TABLE IF EXISTS USUARIOS;
            CREATE TABLE USUARIOS (ID INT PRIMARY KEY,
            PRIMER_NOMBRE VARCHAR(100) NOT NULL,
            APELLIDO VARCHAR(100) NOT NULL,
            EDAD INT NOT NULL)
            """;

    private static final String SQL_INSERT1 = """
            INSERT INTO USUARIOS (ID, PRIMER_NOMBRE, APELLIDO, EDAD) VALUES(1, 'Rodo', 'Basbi', 29)
            """;

    private static final String SQL_INSERT2 = """
            INSERT INTO USUARIOS (ID, PRIMER_NOMBRE, APELLIDO, EDAD) VALUES(2, 'Juan', 'Acevedo', 49)
            """;

    private static final String SQL_INSERT3 = """
            INSERT INTO USUARIOS (ID, PRIMER_NOMBRE, APELLIDO, EDAD) VALUES(3, 'Ivan', 'Ortega', 35)
            """;

    private static final String SQL_DELETE = """
            DELETE FROM USUARIOS WHERE ID=3    
            """;

    private static final String SQL_SELECT = """
            SELECT * FROM USUARIOS
            """;

    // ejemplo de exepcion - la tabla DIGITAL NO Existe
    private static final String SQL_SELECT2 = """
            SELECT * FROM DIGITAL
            """;

    private static final Logger logger = Logger.getLogger(Main.class);



    public static void main(String[] args)  {
        Connection connection = null;
        try{
            connection = getConnection();
            Statement statement = connection.createStatement();

            //crear tabla
            statement.execute(SQL_CREATE_TABLE);

            //insert
            statement.execute(SQL_INSERT1);
            statement.execute(SQL_INSERT2);
            statement.execute(SQL_INSERT3);

            //Delete
            statement.execute(SQL_DELETE);
            logger.warn("Se elimino al usuario con id=3");

            //Mostrar datos de la db
            ResultSet rs = statement.executeQuery(SQL_SELECT);
            while (rs.next()){
                System.out.println("ID:"+rs.getInt(1)+" Nombre:" +rs.getString(2)+" Apellido:"+rs.getString(3)+" Edad: "+ rs.getInt(4));
            }

            // ej - exception
           // rs = statement.executeQuery(SQL_SELECT2);

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }

    }


// https://www.notion.so/JDBC-2fd2c14b5aee45f5ae0b9f5c891baf45?pvs=4
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase12", "sa","sa");
        //Statement statement = connection.createStatement();
    }
}
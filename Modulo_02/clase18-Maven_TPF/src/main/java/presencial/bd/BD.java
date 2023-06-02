package presencial.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private static final String DRIVER="org.h2.Driver";
    private static final String URL="jdbc:h2:~/clase18";
    private static final String USER="sa";
    private static final String PASS="sa";
    private static final String SQL_CREATE_TABLE_DOMICILIOS=
            "DROP TABLE IF EXISTS DOMICILIOS;" +
                    "CREATE TABLE DOMICILIOS (" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY," +
                    " CALLE VARCHAR(100) NOT NULL," +
                    " NUMERO INT NOT NULL," +
                    " LOCALIDAD VARCHAR(100) NOT NULL," +
                    " PROVINCIA VARCHAR(100) NOT NULL)";
    private static final String SQL_CREATE_TABLE_PACIENTES=
            "DROP TABLE IF EXISTS PACIENTES;" +
                    "CREATE TABLE PACIENTES (" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY," +
                    " APELLIDO VARCHAR(100) NOT NULL," +
                    " NOMBRE VARCHAR(100) NOT NULL," +
                    " DNI INT NOT NULL," +
                    " FECHA DATE NOT NULL," +
                    " DOMICILIO_ID INT NOT NULL)";
    public static Connection getConnection() throws Exception {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER,PASS);
    }
    public static void crearTablas() throws Exception{
        Connection connection=getConnection();
        Statement statement=connection.createStatement();
        statement.execute(SQL_CREATE_TABLE_DOMICILIOS);
        statement.execute(SQL_CREATE_TABLE_PACIENTES);
        //colocar una ejecución que cree domicilios y pacientes de inicio
    }

}

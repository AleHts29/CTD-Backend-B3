package presencial.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private static final String DRIVER="org.h2.Driver";
    private static final String URL="jdbc:h2:~/clase15";
    private static final String USER="sa";
    private static final String PASS="sa";

    private static final String SQL_CREATE_TABLE=
            "DROP TABLE IF EXISTS MEDICAMENTOS;" +
                    "CREATE TABLE MEDICAMENTOS (ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "NOMBRE VARCHAR(100)," +
                    "LABORATORIO VARCHAR(100)," +
                    "CANTIDAD INT," +
                    "PRECIO NUMERIC(10,2))";
    public static void crearBD() throws Exception {
        Connection connection=getConnection();
        Statement statement=connection.createStatement();
        statement.execute(SQL_CREATE_TABLE);
    }
    public static Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USER,PASS);
    }
}

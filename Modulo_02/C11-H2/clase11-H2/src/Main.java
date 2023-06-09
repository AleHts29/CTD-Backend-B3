import org.h2.Driver;

import java.sql.*;

public class Main {

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES ( ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, TIPO VARCHAR(100) NOT NULL)";

    private static final String SQL_INSERT_1 = "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES(1, 'Homero', 'Perro')";
    private static final String SQL_INSERT_2 = "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES(2, 'Lolo', 'Gato')";
    private static final String SQL_INSERT_3 = "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES(3, 'Oriana', 'Gato')";
    private static final String SQL_INSERT_4 = "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES(4, 'Dante', 'Perro')";

    private static final String SQL_SELECT = "SELECT * FROM ANIMALES";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:~/clase11", "sa","sa");
        Statement statement = connection.createStatement();

        statement.execute(SQL_CREATE_TABLE);
        statement.execute(SQL_INSERT_1);
        statement.execute(SQL_INSERT_2);
        statement.execute(SQL_INSERT_3);
        statement.execute(SQL_INSERT_4);

        ResultSet rs = statement.executeQuery(SQL_SELECT);
        while (rs.next()){
            System.out.println(rs.getInt(1)+"-"+rs.getString(2)+"-"+rs.getString(3));
        }

    }
}
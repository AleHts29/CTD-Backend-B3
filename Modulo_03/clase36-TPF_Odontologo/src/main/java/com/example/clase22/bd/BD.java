package com.example.clase22.bd;

import java.sql.*;

public class BD {
    private static final String DRIVER="org.h2.Driver";
    private static final String URL="jdbc:h2:~/clase22";
    private static final String URL_CREATE=URL+";INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String USER="sa";
    private static final String PASS="sa";

    public static Connection getConnection() throws Exception {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER,PASS);
    }
    public static void crearTablas() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL_CREATE, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }



        /*
        Connection connection=getConnection();
        Statement statement=connection.createStatement();
        statement.execute(SQL_CREATE_TABLE_DOMICILIOS);
        statement.execute(SQL_CREATE_TABLE_PACIENTES);
        statement.execute(SQL_PACIENTE1);
        //colocar una ejecución que cree domicilios y pacientes de inicio

         */
/*
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
                    " DOMICILIO_ID INT NOT NULL," +
                    " EMAIL VARCHAR(100) NOT NULL)";
    private static final String SQL_PACIENTE1=
            "INSERT INTO DOMICILIOS (CALLE,NUMERO,LOCALIDAD,PROVINCIA)" +
                    " VALUES ('Calle 1',484,'Salta Capital', 'Salta');" +
                    "INSERT INTO PACIENTES (APELLIDO, NOMBRE, DNI," +
                    "FECHA, DOMICILIO_ID, EMAIL) VALUES ('Baspineiro'," +
                    "'Rodolfo',584,'2022-08-25',1,'reb@gmail.com')";
*/
}


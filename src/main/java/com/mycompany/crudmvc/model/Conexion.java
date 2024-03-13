package com.mycompany.crudmvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private final String base = "tienda";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;

    public Connection getConexion() {
        try {
            //Class.forName("com.mysql.jdbc.Driver"); Quedo obsoleto cargar el driver manualmente, ya no hace falta porque lo realiza el SPI (Service Provider Interface)
            con = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return con;
    }
}

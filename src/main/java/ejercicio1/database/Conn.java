package ejercicio1.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

    private String url;
    private String pwd;
    private String user;
    private Connection dbConn;

    public Conn(String conn, String user, String pwd) {
        this.url = conn;
        this.user = user;
        this.pwd = pwd;

    }

    Connection open() {
        try {
            this.dbConn = DriverManager.getConnection(url, user, pwd);
            return this.dbConn;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


   /* private void setupBaseDeDatos() throws SQLException {
        this.url = "jdbc:derby://localhost:1527/participantes";
        this.user = "app";
        this.pwd = "app";

    }*/
}






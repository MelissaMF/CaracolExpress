
package sql;

import java.sql.*;

public class Conexion {
     public static Connection getConexion() {

        Connection connection = null;
        try {
            String bbdd_mysql = "bd_encomiendas";
            String user_mysql = "root";
            String pass_mysql = "";
            String driverClassName = "com.mysql.jdbc.Driver";
            String driverUrl="jdbc:mysql://localhost:3307/" + bbdd_mysql;
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(driverUrl, user_mysql,pass_mysql);
            System.out.println("Conexión exitosa");         
        }catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}

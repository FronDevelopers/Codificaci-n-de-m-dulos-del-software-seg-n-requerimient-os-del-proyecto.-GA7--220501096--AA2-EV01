
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class conexionSQL {
    
  //public static void main(String[]args){
  //}   
    private static final String URL = "jdbc:mysql://localhost:3306/tienda";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "root";
    
    public static Connection getConnection() throws ClassNotFoundException{
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(conexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
    } 
}


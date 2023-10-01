/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo49.AccesoADatos;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conexion {
    
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="universidadgrupo49";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    
    private static Connection connection;
    
    private Conexion(){}
    
    public static Connection getConexion(){
        if(connection == null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
                
//                JOptionPane.showMessageDialog(null, "Conexion Exitosa"); // (es solo para probar)
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar el driver."+ex.getMessage());
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexión"+ex.getMessage());
            }
            
            }
        return connection;
    }
}

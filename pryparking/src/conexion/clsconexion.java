
package conexion;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class clsconexion {
    Connection conectar = null;
    java.sql.Statement st = null;

 public clsconexion(){
        try 
            {
                String rutafile = "C:\\Users\\luchi\\OneDrive\\Documentos\\Deber_Fundamentos\\pryparking\\parqueadero.accdb";
                String Url = "jdbc:ucanaccess://" + rutafile;
                conectar = DriverManager.getConnection(Url);
                st = conectar.createStatement();
            } catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null, "CONEXION FALLIDA " + e);  
                }
    }
    
    public Connection getConnection(){
        return conectar;
    }
    
    public void Desconexion(){
        try 
            {
                conectar.close();            
                System.exit(0);
            } catch (SQLException ex) 
                {
                    Logger.getLogger(clsconexion.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    
}

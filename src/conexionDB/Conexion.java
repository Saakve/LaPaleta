package conexionDB;

import java.sql.*;

/**
 *
 * @author Saakve
 */
public class Conexion {
    public Connection connection;
    
    private String usuario = "root";
    private String password = "";
    private String servidor = "localhost";
    private String puerto = "3306";
    private String database = "lapaletadb";
    private String url = "jdbc:mysql://" + servidor + ":" + puerto + "/" + database;
    
    public Conexion(){
        try{
            connection = DriverManager.getConnection(url, usuario, password);
            
            if(connection != null){
                System.out.println("CONEXION EXITOSA");
            }
            
        } catch (SQLException e){
            System.out.println("ERROR" + e);
        }
    }
}

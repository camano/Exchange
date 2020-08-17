/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jonathan
 */
public class Conexion {
    private static String Username = "root";
    private static String Password = "";
    private static String Host = "localhost";
    private static String Post = "3306";
    private static String Database = "exchange";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/exchange";
    private static Connection conn;
   
   public Conexion(){
       conn=null;
       try {
           Class.forName(driver);
           conn=DriverManager.getConnection(url,Username,Password);
           if (conn!=null) {
               System.out.println("conexion establecida");
           }
       } catch (ClassNotFoundException | SQLException e) {
           System.out.println("error"+e);
       }
   }
   
   public Connection getConnection(){
       return conn;
   }
   
   public void desconectar(){
       conn=null;
       
   }
}

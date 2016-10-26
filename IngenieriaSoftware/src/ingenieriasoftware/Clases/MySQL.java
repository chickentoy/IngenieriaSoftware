/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoftware.Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Chicken
 */
public class MySQL {
    Connection con=null;
    String user="root";
    String pass="";
    String tipoconector="com.mysql.jdbc.Driver";
    static int contador;
    public static boolean agenda=false;

    
    public Connection conexion (String BaseDatos,String ip){
         try{
             //cargar driver
             Class.forName(tipoconector);
             con=DriverManager.getConnection("jdbc:mysql://"+ip+"/"+BaseDatos,user,pass);
             System.out.println("conexion establecida");
         }
         catch (ClassNotFoundException | SQLException e){
             System.out.println(e);
             JOptionPane.showMessageDialog(null, "Falta Conector MySQL");
         }
         return con;
    }
    
}

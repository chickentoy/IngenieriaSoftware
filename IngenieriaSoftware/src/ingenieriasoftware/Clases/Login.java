/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoftware.Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static ingenieriasoftware.JFramePrincipal.tcuenta;
/**
 *
 * @author Chicken
 */
public class Login {
    Connection cn;
    Connection con;
    MySQL m=new MySQL();
    Statement st=null;
    ResultSet rs=null;
    String aux="";
    String sql;
    boolean acceso=false;
    
    
    
    
    public boolean Usuario(String usuario,String clave){
        sql="SELECT * FROM usuarios WHERE usuario='"+usuario+"' AND clave=sha1('"+clave+"')";
        try {
            cn=m.conexion("proyecto","127.0.0.1");
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){
                acceso=true;
            }
            if (acceso==true){
                sql="SELECT U_TCUENTA FROM usuarios WHERE usuario='"+usuario+"' AND clave=sha1('"+clave+"')";
                st = cn.createStatement();
                rs = st.executeQuery(sql);
                if(rs.next()){
                 tcuenta=rs.getString(1);
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"Error al obtener el tipo de usuario");
                }
            }
            
            
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {

                cn.close();

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        return acceso;
        
    }
}
    
    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author EstebanRM
 */
public class Consultas {
    private PreparedStatement sentencia=null;
    private ResultSet resultado=null;
    private Conexion con;
    
    public Consultas(Conexion con) {
        this.con = con;
    }
    
    public ResultSet ConsultarClientes(){

        try{
            this.sentencia=con.getConexion().prepareStatement("select * from clientes");
            this.resultado=this.sentencia.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return this.resultado;
    }
    public void InsertarClientes(String codigo,String apellido, String nombre, String telefono, String email){
        try{
            this.sentencia=this.con.getConexion().prepareStatement("insert into hr.regions(REGION_ID,REGION_NAME) values(?,?)");
            this.sentencia.setString(1, codigo);
            this.sentencia.setString(2, apellido);
            this.sentencia.setString(3, nombre);
            this.sentencia.setString(4, telefono);
            this.sentencia.setString(5, email);
            this.sentencia.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
}

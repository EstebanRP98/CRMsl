/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC-MATIC
 */
public class Conexion {
    private String username;
    private String password;
    private String url;
    private Connection conexion=null;

    public Conexion(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public void Conectar(){ 
        try{
            this.setConexion(DriverManager.getConnection(this.getUrl(), this.getUsername(), this.getPassword()));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void cerrarConexion(){
        try{
            if(this.getConexion()!=null && !this.getConexion().isClosed()){
                this.getConexion().close();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}

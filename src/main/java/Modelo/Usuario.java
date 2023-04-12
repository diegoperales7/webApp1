/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Diego
 */
public class Usuario {
    private int id;
	public int getId()
	{
		return this.id;
	}
	public void setId(int value)
	{
		this.id = value;
	}   

    private String nombre;
	public String getNombre()
	{
		return this.nombre;
	}
	public void setNombre(String value)
	{
		this.nombre= value;
	}

    private String apellido;
	public String getApellido()
	{
		return this.apellido;
	}
	public void setApellido(String value)
	{
		this.apellido = value;
	}

    private String correo;
	public String getCorreo()
	{
		return this.correo;
	}
	public void setCorreo(String value)
	{
		this.correo = value;
	}

    private String usr;
	public String getUsr()
	{
		return this.usr;
	}
	public void setUsr(String value)
	{
		this.usr = value;
	}

    private String pwd;
	public String getPwd()
	{
		return this.pwd;
	}
	public void setPwd(String value)
	{
		this.pwd = value;
	}
        
        public Usuario(){
            
        }
        public Usuario( String nombre,String apellido,String correo, String usr, String pwd){
            
            this.nombre=nombre;
            this.apellido=apellido;
            this.correo=correo;
            this.usr=usr;
            this.pwd=pwd;
        }
        
        
    public String queryTestLogin (String usr, String pwd)
    {
        String result="Bienvenido";
        Connection c = null;
        try {   
            PreparedStatement statement;
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // create a database connection
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");
            
            String query = "select count(*) from usuarios where usr=? and pwd=?";
            
            statement = c.prepareStatement(query);
            statement.setString(1, usr);
            statement.setString(2, pwd);   
            
            ResultSet r = statement.executeQuery();
            
            if (r.next())
            {
                if (r.getInt(1) == 0){
                    result = "Usuario y/o contraseña incorrectas";
                }else{
                    result="Bienvenido";
                }               
            }
            
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            try {
                if (c != null) 
                    c.close();                
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
        
        return result;                        
    }
    
    public String queryTestInsert(String nombre,String apellidos,String correo,String usuario,String password){
        String result=" ";
        //System.out.println(user.getCorreo());
        Connection c = null;
        try {   
            PreparedStatement statement;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // create a database connection
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");
            
            String query = "INSERT INTO USUARIOS (nombre,apellidos,correo,usr,pwd) VALUES (?, ?,?,?,?)";
            
            statement = c.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2,apellidos);
            statement.setString(3, correo);
            statement.setString(4, usuario);
            statement.setString(5, password);     
                        
            int r = statement.executeUpdate();   // numero de filas modificadas  
            if (r>0){
                result="Exito";
            }else{
                result="noRegistro";
                //if si hay usuarios repetidos o correos repetidos 
            }                      
            
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            try {
                if (c != null) 
                    c.close();                
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
        return result;       
    }
    
    public int queryTestBuscarUsr(String usr)
    {
        int result=0;
        Connection c = null;
        try {   
            PreparedStatement statement;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // create a database connection
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");    
            String query = "select count(*) from usuarios where usr=?";
            
            statement = c.prepareStatement(query);
            statement.setString(1, usr);   
            ResultSet r = statement.executeQuery();     
            if (r.next())
            {
                if (r.getInt(1) == 0){
                    result = 0;
                }else{
                    result=1;
                }               
            }
            
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            try {
                if (c != null) 
                    c.close();                
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
        
        return result;                        
    }
    
    
    public int queryTestBuscarCorreo(String correo)
    {
        int result=0;
        Connection c = null;
        try {   
            PreparedStatement statement;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // create a database connection
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");    
            String query = "select count(*) from usuarios where correo=?";
            
            statement = c.prepareStatement(query);
            statement.setString(1, correo);   
            ResultSet r = statement.executeQuery();     
            if (r.next())
            {
                if (r.getInt(1) == 0){
                    result = 0;
                }else{
                    result=1;
                }               
            }
            
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            try {
                if (c != null) 
                    c.close();                
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
        
        return result;                        
    }
    

}

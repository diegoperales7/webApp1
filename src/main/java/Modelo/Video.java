/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class Video {
    
    private int id;
    private String titulo;
    private String autor;
    private Date fecha;
    private Time duracion;
    private int reproducciones;
    private String descripcion;
    private String formato;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    

    public Video() {
    }

    public Video(String titulo, String autor, Time duracion, String descripcion, String formato, String url) {
        this.titulo = titulo;
        this.autor = autor;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.formato = formato;
        this.url = url;
    }
    
    public Video(String titulo, String autor, Date fecha,Time duracion, int reproducciones, String descripcion, String formato, String url) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha=fecha;
        this.duracion = duracion;
        this.reproducciones = reproducciones;
        this.descripcion = descripcion;
        this.formato = formato;
        this.url = url;
    }
    
    
    public String queryTestInsert(String titulo,String autor,Time duracion,String descripcion,String formato,String url){
        String result=" ";
        //System.out.println(user.getCorreo());
        Connection c = null;
        try {   
            PreparedStatement statement;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // create a database connection
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");
            
            String query = "INSERT INTO VIDEOS (titulo,autor,duracion,descripcion,formato,url) VALUES (?, ?,?,?,?,?)";
            
            statement = c.prepareStatement(query);
            statement.setString(1, titulo);
            statement.setString(2,autor);
            statement.setTime(3, duracion);
            statement.setString(4, descripcion);
            statement.setString(5, formato);     
            statement.setString(6, url);     
                        
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
    
    public int queryTestBuscarTituloAutor(String titulo,String autor){
        int result=0;
        
        Connection c = null;
        try {   
            PreparedStatement statement;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // create a database connection
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");    
            String query = "select count(*) from videos where titulo=? and autor=?";
            
            statement = c.prepareStatement(query);
            statement.setString(1, titulo);   
            statement.setString(2, autor);   
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
    
    public int queryTestBuscarURL(String url){
        int result=0;
        
        Connection c = null;
        try {   
            PreparedStatement statement;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // create a database connection
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");    
            String query = "select count(*) from videos where url=?";
            
            statement = c.prepareStatement(query);
            statement.setString(1, url);     
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
    
    public List<Video> listarVideos() throws SQLException {
 
            List<Video> listarVideos = new ArrayList<>();

            Connection c = null;
            
            try{
                PreparedStatement statement;
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                // create a database connection
                c = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");    
                String query = "SELECT * FROM videos";

                statement = c.prepareStatement(query);
		ResultSet resulSet = statement.executeQuery();
                while (resulSet.next()) {
                    //int id_video = resulSet.getInt("id_video");
                    String titulo2 = resulSet.getString("titulo");
                    String autor2 = resulSet.getString("autor");                    
                    Date fecha2 = resulSet.getDate("fecha");
                    //DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
                    Time duracion2 = resulSet.getTime("duracion");      
                    int reproducciones2 = resulSet.getInt("reproducciones");
                    String descripcion2 = resulSet.getString("descripcion");
                    String formato2 = resulSet.getString("formato");
                    String url2 = resulSet.getString("url");

                    Video video = new Video(titulo2,autor2,fecha2,duracion2,reproducciones2,descripcion2,formato2,url2);
                    listarVideos.add(video);
                }
                
            }catch(Exception e){
                System.out.println(e.getStackTrace());
            }finally{
               try {
                    if (c != null) 
                        c.close();                
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                } 
            }
           
            return listarVideos;
    }
    
    
}

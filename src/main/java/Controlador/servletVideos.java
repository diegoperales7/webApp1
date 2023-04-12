/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Video;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego
 */
@WebServlet(name = "servletVideos", urlPatterns = {"/servletVideos"})
public class servletVideos extends servletAuth {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletVideos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletVideos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //Logger.getLogger(servletUsuarios.class.getName()).log(Level.SEVERE, "acaaaaa");
        boolean res=validate(request,response);
        if(res==false){
            request.setAttribute("resLogin", "Debe iniciar Sesión");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            try {
                mostrarLista(request,response);
                RequestDispatcher rd = request.getRequestDispatcher("listaVid.jsp");
                rd.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(servletVideos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean res=validate(request,response);
        if(res==false){
            request.setAttribute("resLogin", "Debe iniciar Sesión");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            String action=request.getParameter("action");
        //validate(request,response);
            if(action.equals("Registrar")){
                try {
                    registrar(request,response);
                } catch (SQLException ex) {
                    Logger.getLogger(servletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }         
            }
            if(action.equals("Acceder")){
                try {
                    mostrarLista(request,response);
                } catch (SQLException ex) {
                    Logger.getLogger(servletVideos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }     
        
    }
    
    
    private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String titulo=request.getParameter("titulo");
        String autor=request.getParameter("autor");
        String duracion=request.getParameter("duracion");
        String descripcion=request.getParameter("descripcion");
        String formato=request.getParameter("formato");
        String url=request.getParameter("url");
        
        int busquedaTituloAutor = new Video().queryTestBuscarTituloAutor(titulo,autor);
        if(busquedaTituloAutor==1){
            request.setAttribute("resRegistro","El video ya esta registrado!");
            request.getRequestDispatcher("registroVid.jsp").forward(request, response);
            return;
        }
        
        int busquedaURL = new Video().queryTestBuscarURL(url);

        if(busquedaURL==1){
            request.setAttribute("resRegistro","Ya existe un registro con esa URL!");
            request.getRequestDispatcher("registroVid.jsp").forward(request, response);
            return;
        }else{
            Time dur=Time.valueOf(duracion);
            String result = new Video().queryTestInsert(titulo,autor,dur,descripcion,formato,url);
            if(result=="Exito"){
                mostrarLista(request,response);
                RequestDispatcher rd = request.getRequestDispatcher("listaVid.jsp");
                rd.forward(request, response);
            }
        }  
    }
    
    
    private void mostrarLista(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException , ServletException{                            
        try{
            RequestDispatcher dispatcher = request.getRequestDispatcher("listaVideo.jsp");
                
		List<Video> listaVideos= new Video().listarVideos();
		request.setAttribute("lista", listaVideos);
		dispatcher.forward(request, response);
            
        }catch(Exception ex){
            System.out.println(ex);
        }     
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

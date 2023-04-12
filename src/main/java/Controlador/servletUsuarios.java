package Controlador;

import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego
 */
@WebServlet(name = "servletUsuarios", urlPatterns = {"/servletUsuarios"})
public class servletUsuarios extends HttpServlet {

    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*try (PrintWriter out = response.getWriter()) {    
                out.println("<html><body>Method not supported</body></html>");
        }*/
        
       
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
        String action=request.getParameter("action");
        if(action.equals("Acceder")){   
            autenticar(request,response);          
        }
        if(action.equals("Registrar")){
            try {
                registrar(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(servletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(action.equals("Logout")){
            try {
                logout(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(servletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
    private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String password1=request.getParameter("password");
        String password2=request.getParameter("repetPassword");
        int res=0;
        if(!password1.equals(password2)){
            request.setAttribute("resRegistro","Las contraseñas no coinciden!");
            request.getRequestDispatcher("registroUsu.jsp").forward(request, response);
            return;//
        }else{
            String usr=request.getParameter("usuario");
            String correo=request.getParameter("correo");
            int busquedaUsr = new Usuario().queryTestBuscarUsr(usr);
            int busquedaCorreo = new Usuario().queryTestBuscarCorreo(correo);
            
            if(busquedaUsr==1){
                request.setAttribute("resRegistro","El usuario ya existe!");
                request.getRequestDispatcher("registroUsu.jsp").forward(request, response);
                return;
            }
            if(busquedaCorreo==1){
                request.setAttribute("resRegistro","Ya existe un registro con ese correo!");
                request.getRequestDispatcher("registroUsu.jsp").forward(request, response);
                return;
            }else{
                String nombre=request.getParameter("nombre");
                String apellidos=request.getParameter("apellidos");
                
                String result = new Usuario().queryTestInsert(nombre,apellidos,correo,usr,getMD5(password1));
                
                if(result=="Exito"){
                    
                    request.setAttribute("resRegistro","Usuario registrado Exitosamente, Inicie sesión");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
            
        }
    
    }
    
    private void autenticar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        //String res="";
        try (PrintWriter out = response.getWriter()) {
            
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            
            String result = new Usuario().queryTestLogin( usuario, getMD5(password));  
            HttpSession sesion = request.getSession();
            if(result=="Bienvenido"){
                request.setAttribute("action","mostrarLista");
                sesion.setAttribute("usr", usuario);
                request.setAttribute("resUsuario",usuario);
                //response.sendRedirect(request.getContextPath()+"/listaVideo.jsp");
                request.getRequestDispatcher("servletVideos").forward(request, response);
            }else{
                
                request.setAttribute("resLogin", result);
                request.getRequestDispatcher("login.jsp").forward(request, response);                
            }          
        }
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
        HttpSession sesion = request.getSession();
            sesion.invalidate();
            response.sendRedirect("login.jsp");
    }
    
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
            }
        catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
        }
    }

}

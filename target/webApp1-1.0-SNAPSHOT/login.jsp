<%-- 
    Document   : login
    Created on : 28-feb-2023, 19:35:08
    Author     : Diego
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link rel="stylesheet" href="css/login.css">
        <title>Login Usuarios</title>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-4"></div>
                <div class="col-4">
                    
                        <form class="formLogin" action="servletUsuarios" method="post">
                            <h1 class="frmLogh1">Inicio de Sesión</h1>
                             <c:if test="${resLogin!='Bienvenido'}">
                                      <p class="error"><c:out value="${resLogin}"/></p>
                                  </c:if>
                                <c:if test="${resRegistro!='Bienvenido'}">
                                    <p class="Exito"><c:out value="${resRegistro}"/></p>
                                </c:if>
                            <div class="row g-2 align-items-center">
                               
                                <label class="frmLoglabel">Usuario:</label>
                                <input type="text" name="usuario" required autocomplete="off"/>
                                <label class="frmLoglabel">Contraseña: </label>
                                <input type="password" name="password" required autocomplete="off"/>
                                <input type="submit" value="Acceder" name="action" class="btn btnAcceso"/>   
                                <p>No tienes una cuenta? <a href="registroUsu.jsp">Registrate Aqui!</a></p>
                            </div>
                        </form>
                    
                    
                </div>
                
                
                <div class="col-4"></div>
                
            </div>
            
        </div>
        
         
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
    
    
</html>

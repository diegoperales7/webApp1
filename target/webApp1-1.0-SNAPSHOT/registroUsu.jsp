<%-- 
    Document   : registroUsu
    Created on : 02-mar-2023, 11:13:18
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/registroUsu.css"/>
        <title>Registro de Usuario</title>
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <div class="col-4"></div>
                <div class="col-4 align-self-center">
            
                    <form class="frmRegUsu" action="servletUsuarios" method="post">
                        <h1>Registrar Usuario</h1>
                        <div class="row g-2 align-items-center">
                            <label>Nombre:</label>
                            <input type="text" name="nombre" required autocomplete="off"></>
                            <label>Apellidos:</label>
                            <input type="text" name="apellidos" required autocomplete="off"></>
                            <label>Correo Elctronico:</label>
                            <input type="email" name="correo" required autocomplete="off"></>
                            <label>Nombre de usuario:</label>
                            <input type="text" name="usuario" required autocomplete="off"></>
                            <label>Contraseña:</label>
                            <input type="password" name="password" required autocomplete="off"></>
                            <label>Repetir Contraseña:</label>
                            <input type="password" name="repetPassword" required autocomplete="off"></>
                            <p class="error">${resRegistro}</p>
                            <input type="submit" class="btn frmRegUsuBtn" value="Registrar" name="action"/>
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

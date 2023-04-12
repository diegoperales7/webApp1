<%-- 
    Document   : registroVid
    Created on : 14-mar-2023, 20:10:56
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/registroVid.css"/>
        <title>Registro de videos</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-4"></div>
                <div class="col-4 align-self-center">
            
                    <form class="frmRegVid" action="servletVideos" method="post">
                        <h1>Registrar Videos</h1>
                        <div class="row g-2 align-items-center">
                            
                            <label>Titulo:</label>
                            
                            <input type="text" name="titulo" required autocomplete="off"></>
                            <label>Autor:</label>
                            <input type="text" name="autor" required autocomplete="off"></>
                            <label>Duración:</label>
                            <input type="time" name="duracion" required autocomplete="off" value="00:00:00" max="24:59:59" min="00:00:01" step="1"></>
                            
                            <label>Formato:</label>
                            <select type="text" name="formato" required >
                                <option value="MPEG-4" selected>MPEG-4</option>
                                <option value="MOV">MOV</option>
                                <option value="WMV">WMV</option>
                                <option value="AVI">AVI</option>
                                
                            </select>
                            <label>URL:</label>
                            <input type="url" name="url" required autocomplete="off"></>
                            <label>Descripción:</label>
                            <textarea type="text" name="descripcion" autocomplete="off"></textarea>
                            <p class="error">${resRegistro}</p>
                            <input type="submit" class="btn frmRegVidBtn" value="Registrar" name="action"/>
                            
                        </div>
                            <div class="row g-2 align-items-center">
                                
                        <a href="servletVideos" class="btn btn-danger">Regresar</a>
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

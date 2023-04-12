<%-- 
    Document   : listaVideo
    Created on : 28-feb-2023, 20:26:36
    Author     : Diego
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<%@page import="Modelo.Video"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/listaVid.css"/>
        <title>Lista de videos</title>
    </head>
    <body>
        
        <nav class="navbar navbar-expand-lg navbar-light bg-light color">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
              <a class="navbar-brand texCol" href="#">Lista de Videos</a>
              <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                  <li class="nav-item">
                  <a class="nav-link disabled texCol" href="#">Bienvenido ${usr}</a>
                </li>
                <li class="nav-item active">
                  <a class="nav-link texCol" href="registroVid.jsp">Agregar Videos</a>
                </li>
                <li>                  
                </li>
                <li class="nav-item">
                  <form class="mr-sm-2" action="servletUsuarios" method="post">      
                      <input type="submit" value="Logout" name="action" class="btn btn-danger"/>
                    </form>
                </li>                               
              </ul>
                    
            </div>
                
                 <form class="form-inline inputInline">
                    <input class="inputBuscar " type="search" placeholder="Buscar" aria-label="Search">
                    <button class="btn btn-outline-warning inputInline" type="submit">Buscar</button>
                </form>
           
          </nav>
                <br>
        <div class="container">
            <div class="row">
               
                <div class="col">                   
                    <table class="table">
                        <thead class="thead-dark">
                             <tr>
                                <th >#</th>
                                <th >TITULO</th>
                                <th >AUTOR</th>
                                <th >FECHA</th>
                                <th>DURACIÓN</th>
                                <th>REPRODUCCIONES</th>
                                <th>DESCRIPCIÓN</th>
                                <th>FORMATO</th>
                                <th>URL</th>
                            </tr>
                        </thead>
                        <tbody>   
                              
                                <c:forEach var="video" items="${lista}">
                                    <%! int cont = 1; %>
                                    <tr>
                                    
                                        <th><%=cont++ %></th>
                                        <td>${video.titulo}</td>
                                        <td>${video.autor}</td>
                                        <td>${video.fecha}</td>
                                        <td>${video.duracion}</td>
                                        <td>${video.reproducciones}</td>
                                        <td>${video.descripcion}</td>
                                        <td>${video.formato}</td>
                                        <td><a href="${video.url}">${video.url}</a></td>

                                    </tr>
                                </c:forEach>   
                                     <% cont = 1; %>
                        </tbody>
                       
                        
                    </table>
                </div>
                
            </div>
        </div>
        
        
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        
    </body>
</html>

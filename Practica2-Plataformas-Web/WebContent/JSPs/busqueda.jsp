<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Mi agenda</title>
    
    <link rel="shortcut icon" href="/Practica2-Plataformas-Web/JSPs/imagenes/emaill.png" type="image/x-icon">
    <link rel="stylesheet" href="/Practica2-Plataformas-Web/JSPs/css/estilos-agenda.css">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Google Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/css/mdb.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

  <c:set var = "personas" value = "${requestScope['personas']}" />
<!-- Button trigger modal -->

 <header>
        <nav>
       
            <a href="MiAgenda">Mi cuenta</a>
            <a href="MiAgenda?logout=true">Salir</a>
          
        </nav>
        <section class="textos-header">
     <div class="ui container">
            <c:choose>
                <c:when test="${personas.size() > 0}">
                 
                    <table style="color: white; margin-top: 100px"  class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Contactos</th>
                                <th scope="col">Correo</th>
                                <th scope="col">Numero de telefono</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="i" value = "${0}"/>
                            <c:forEach var="persona" items="${personas}">
                                <c:set var="i" value = "${i+1}"/>
                                <tr style="margin-top: 100px; height: 50px" data-toggle="modal" data-target="#exampleModal${i}" data-whatever="@mdo">
                                    <td>
                                        <div class="ui middle aligned selection list">
                                            <div class="item">
                                                <img style="height: 100px; width: 100px" class="ui avatar image" src="JSPs/imagenes/perfil.jpg">
                                                <div class="content">
                                                    <div class="header">${fn:toUpperCase(persona.nombre)} ${fn:toUpperCase(persona.apellido)}</div>
                                                </div>
                                            </div>

                                    </td>
                                    <td>${persona.correo}</td>
                                    <td>${persona.telefonos[0].numero}</td>
                                </tr>

                            <div style="height: 600px; width: 350px; margin-left: 600px; margin-top: 120px" class="modal fade" id="exampleModal${i}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" style="background-color: #BDBFCB; role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h3 style="position: absolute;" class="modal-title" id="exampleModalLabel">${fn:toUpperCase(persona.nombre)} ${fn:toUpperCase(persona.apellido)}
                                                                                         
                                            </h3>
                                            
                                            <h2 style="color: black; margin-top: 100px">${persona.correo}
                                            <a href="mailto:${persona.correo}" class="ui small primary labeled icon button mail-user">
                                                    <i class="envelope icon"></i> Enviar correo
                                                </a>
                                            </h2>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <h3 style="color: black;">Detalles de contacto</h3>
                                            <c:forEach var="telefono" items="${persona.telefonos}">
                                                <p style="margin-left: 70px; height: 2px"><i class="phone icon"></i> <a href="tel:${telefono.numero}">${telefono.numero}</a>  &#9679; ${telefono.tipo} &#9679; ${telefono.operadora}</p>

                                            </c:forEach>
                                        </div>
                                        <div class="modal-footer">
                                            <button style="background-color: blue; color: white;" type="button" class="modal-body" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>
                        </tbody>
                    </table>
                </c:when>    
                <c:otherwise>
                    <h1>No hay contactos para esta busqueda</h1>
                </c:otherwise>
            </c:choose>
        </div>
    
       
      

            
        </section>
       
    </header>
  
    <footer>
        <div class="contenedor-footer">
            <div class="content-foo">
                <h4>Phone</h4>
                <p>0999287912</p>
            </div>
            <div class="content-foo">
                <h4>Email</h4>
                <p>dduchimazad@est.ups.edu.ec</p>
            </div>
            <div class="content-foo">
                <h4>Location</h4>
                <p>Gualaceo-Ecuador</p>
            </div>
        </div>
        <h2 class="titulo-final">&copy; Diego Ramon | Duchimaza Duchimaza</h2>
    </footer>
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/js/mdb.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
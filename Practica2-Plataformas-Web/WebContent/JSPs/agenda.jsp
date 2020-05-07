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
    <link rel="shortcut icon" href="imagenes/emaill.png" type="image/x-icon">
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

  <c:set var = "persona" value = "${requestScope['persona']}" />
<!-- Button trigger modal -->

 <header>
  
        <nav>
        <form action="busqueda">
            <a style="color: white;">${fn:toUpperCase(persona.nombre)} ${fn:toUpperCase(persona.apellido)}</a>
     		  <input type="text" name="usuario" placeholder="cedula" id="buscar">
             <input type="submit" value="Buscar">
                                            
            <a href="MiAgenda?logout=true">Cerrar sesion</a>
             </form>
        </nav>
      
        <section class="textos-header">
   
        <div>
          <c:choose>
                <c:when test="${persona.telefonos.size() > 0}">
                      <p>MIS DATOS</p>
                    <table class="table" style="color: white">
  						<thead>
  						  <tr>
  						  	<th scope="col">#</th>
     						 <th scope="col">Numero</th>
   						     <th scope="col">Operadora</th>
     						 <th scope="col">Tipo</th>
     						 <th scope="col">Operaciones</th>
   						 </tr>
  					</thead>
  				<tbody>
    				 <c:set var="i" value = "${0}"/>

                            <c:forEach var="telefono" items="${persona.telefonos}">
                                <c:set var="i" value = "${i+1}"/>
                                <tr>
                                    <td>${i}</td> 
                                    <td>${telefono.numero}</td>
                                    <td>${telefono.tipo}</td>
                                    <td>${telefono.operadora}</td>
                                    <td>

                                        <div class="modal fade" id="confirm-delete${i}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5>Eliminar numero.</h5>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>El numero ${telefono.numero} se eliminara de tu agenda.</p>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                        <a href="EditarTelefono?eliminar=true&telefonoID=${telefono.id}" class="btn btn-danger btn-ok">Eliminar</a>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                        </div>

                                        <div  class="edit" data-toggle="modal" data-target="#confirm-delete${i}" >
                                             <a>Eliminar</a>
                                        </div>
                                        <div  class="edit" data-toggle="modal" data-target="#exampleModalCenter${i}">
                                            <a>Editar</a>
                                        </div>
                                    </td>
                                </tr>
                                <!-- Modal -->
                          
                             <div class="modal fade" id="exampleModalCenter${i}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalCenterTitle">Numero: ${telefono.numero}</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <form action="EditarTelefono" method="POST">
                                            <input type="hidden" name="idtel" value="${telefono.id}" >
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label for="numero">Numero</label>
                                                    <input type="text" class="form-control" id="numero" name="numero" value="${telefono.numero}" required="" >
                                                </div>
                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <label for="tipo">Tipo</label>
                                                        <input type="text" class="form-control" id="tipo" name="tipo" required="" placeholder="Movil" value="${telefono.tipo}">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label for="operadora">Operadora</label>
                                                        <input type="text" class="form-control" id="operadora" name="operadora" required="" placeholder="Movistar" value="${telefono.operadora}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                <button type="submit" class="btn btn-primary">Guardar</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
 						 </tbody>
 						  <tfoot class="full-width">
                            <tr>
                                <th></th>
                                <th colspan="4">

                                    <button type="button" class="ui right floated small primary labeled icon button" data-toggle="modal" data-target="#exampleModallCenter">
                                        <i class="phone icon"></i> Agregar telefono
                                    </button>
                                </th>
                            </tr>
                        </tfoot>
				</table>
				  </c:when>    
                <c:otherwise>
                    <h1>No hay contactos</h1>
                    <button type="button" class="ui left floated small primary labeled icon button" data-toggle="modal" data-target="#exampleModallCenter">
                        <i class="phone icon"></i> Agregar telefono
                    </button>
                </c:otherwise>
            </c:choose>
        </div>
      
  <div class="modal fade" id="exampleModallCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                           
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <form action="AgregarTelefono" method="POST">
                                            <input type="hidden" name="idtel" value="${telefono.id}" >
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label for="numero">Numero</label>
                                                    <input type="text" class="form-control" id="numero" name="numero" value="" required="" >
                                                </div>
                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <label for="tipo">Tipo</label>
                                                        <input type="text" class="form-control" id="tipo" name="tipo" required=""  value="">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label for="operadora">Operadora</label>
                                                        <input type="text" class="form-control" id="operadora" name="operadora" required="" value="">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                <button type="submit" class="btn btn-primary">Guardar</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
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
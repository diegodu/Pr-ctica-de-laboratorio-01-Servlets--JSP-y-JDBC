<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
 <link rel="shortcut icon" href="imagenes/email.png" type="image/x-icon">
<link rel="stylesheet" href="css/estilos.css">
<title>Sistema de correos</title>
</head>
<body>
<header>
        <nav>
            <a href="#">Mi cuenta</a>
            <a href="#">Mi Agenda</a>
            <a href="#">Registrar telefono</a>
            <a href="#">Buscar persona</a>
             <input type="text" name="buscar" id="buscar">
            <a href="#">Salir</a>
        </nav>
        <section class="textos-header">
            <h1>AGENDA TELEFONICA</h1>
            <h2>Tus contactos aqui</h2>
        </section>
        <div class="wave" style="height: 150px; overflow: hidden;" >
            <svg viewBox="0 0 500 150" preserveAspectRatio="none" 
            style="height: 100%; width: 100%;">
            <path d="M0.00,49.99 C150.00,150.00 349.20,-49.99 500.00,49.99 L500.00,150.00 L0.00,150.00 Z" 
            style="stroke: none; fill: rgb(250, 251, 252);"></path></svg></div>
</header>
<main>
<section class="agenda">
<div class="cabecera">
<h1>Mi agenda</h1>
 <input type="text" name="buscar" id="bus">
 <input type="submit" value="Buscar" name="buscar" id="buscarMiTelefono">

</div>
<div class=lista>
 <table width="100%" class="ui called table blue" style="text-align: center;">
                <tr>
                    <td>
                        <table class="data" id="mia" width="100%" style="background-color: rgb(178, 206, 248);">
                            <thead>
                                <tr>
                                    <th width="20%" style="font-size: 25px;" style="height: 50px;"
                                        style="background-color: rgb(144, 188, 255);">POSTER</th>
                                    <th width="20%" style="font-size: 25px;" style="height: 50px;"
                                        style="background-color: rgb(144, 188, 255);"> TITULO</th>
                                    <th width="20%" style="font-size: 25px;" style="height: 50px;"
                                        style="background-color: rgb(144, 188, 255);">AÑO</th>
                                    <th width="20%" style="font-size: 25px;" style="height: 50px;"
                                        style="background-color: rgb(144, 188, 255);">TIPO</th>
                                    <th width="20%" style="font-size: 25px;" style="height: 50px;"
                                        style="background-color: rgb(144, 188, 255);">INFORMACION</th>
                                </tr>
                            </thead>
                            <tbody style="font-size: 30px;" id="informacion">
                            </tbody>
                        </table>
                    </td>
                </tr>
                <tr>
                <tr>
                    <div id="detalles">
                    </div>
                </tr>
                </tr>
            </table>

</div>
</section>
</main>


</body>
</html>
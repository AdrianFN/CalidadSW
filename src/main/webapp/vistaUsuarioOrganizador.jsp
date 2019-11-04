<%-- 
    Document   : vistaOrganizador
    Created on : 13/10/2019, 09:43:09 AM
    Author     : Adrián
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estiloUsuarioOrganizador.css">
    </head>
    <body>
        <div id="contenedor1">
            <form id = "formularioCrearEvento" action="vistaCrearEvento.jsp">
                <h1 align="center">Organizador</h1>
                <div class="contenedor">
                    <label for="crearEvento">Crear evento: </label>
                    <button type="submit" class="button"> Ir </button>
                </div>
            </form>
            
            <form id = "formularioTerminarEvento" action="vistaTerminarEvento.jsp">
                <div class="contenedor">
                    <label for="terminarEvento">Terminar evento: </label>
                   
                    <button type="submit" class="button"> Ir </button>
                </div>
            </form>
            
            <form id = "formularioHistorialEvento" action="vistaHistorialDeEventos.jsp">
                <div class="contenedor">
                    <label for="historialEvento">Historial evento: </label>
                    
                    <button type="submit" class="button"> Ir </button>
                </div>
            </form>
            
        </div>
        
    </body>
</html>

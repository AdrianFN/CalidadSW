<%-- 
    Document   : vistaCrearEvento
    Created on : 28/10/2019, 06:26:12 PM
    Author     : Adrián
--%>

<%@page import="dao.factory.DAOFactory"%>
<%@page import="dao.component.IUsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creación de evento</title>
        <link href="css/estiloCrearEvento.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form class="formularioCrearEvento" action="ServletCrearEvento" method="post">
            <h1>Sistema Gestor de Eventos</h1>
            
            <div class="contenedor">
                
                <div class="input-contenedor">
                    <label for="DNIusuario">DNI usuario</label><br>
                    <%
                        if(request.getAttribute("mensaje") == null){
                            out.print("Esperando autenticación...");
                        }
                        else{
                            out.print(request.getAttribute("mensaje"));
                        }
                    %><br>
                    <input type="text" name="txtDNI" id="idDNI" placeholder="DNI"/>
                    <button type="submit" name="btnValidar" class="btnVerificar">Verificar</button>
                </div>
               
                <div class="input-contenedor">
                    <label for="NombreEvento">Nombre de evento</label><br><br>
                    <input type="text" name="txtNombreEvento" placeholder="nombre"/>
                </div>
                
                <div class="input-contenedor">
                    <label for="DescripcionEvento">Descripcion</label><br><br>
                    <textarea type="txt" name="txtDescripcionEvento" placeholder="descripcion"></textarea>
                </div>
                
                <input type="submit" name="btnSiguienteDetalleEvento" value="Siguiente" class="button">
                
            </div>
        </form>
    </body>
</html>

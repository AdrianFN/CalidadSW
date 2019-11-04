<%-- 
    Document   : vistaDetalleEvento2
    Created on : 28/10/2019, 06:24:31 PM
    Author     : Adrián
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="formularioRegistroUsuario" action="Servlet">
        <h1>Sistema Gestor de Eventos</h1>
            <div class="contenedor">
                <div class="input-contenedor">
                    
                    <label for="fecha">Colocar Fecha </label>
                    <input type="text" name="fecha" placeholder="Ej. 2018-08-01"/>
                   
                </div>
                <div class="input-contenedor">
                    <label for="ListarExpositores"> Elegir salon y horario disponible: </label>
                </div>
                <div class="input-contenedor">                  
                    <jsp:useBean id="cn" class="dao.impl.ExpositorDAOImpl" scope="page"></jsp:useBean>
                        <select>
                            <option> Tipo de salon </option>
                        <%
                            cn.listarExpositor();
                        %>
                        </select>
                        
                        <select>
                            <option> Salon dispo </option>
                        <%
                            cn.listarExpositor();
                        %>
                        </select>
                        
                        <select>
                            <option> Horario dispo </option>
                        <%
                            cn.listarExpositor();
                        %>
                        </select>
                    
                </div>
                <div class="input-contenedor">
                    <label for="ExpositoresElegidos"> Lista de expositores elegidos </label>
                    <select>
                            <option> Expositores </option>
                        <%
                            cn.listarExpositor();
                        %>
                        </select>
                </div>
                        
                        
               
                <div class="input-contenedor">
                         <input type="submit" name="VerLista" value="Registrar" class="button">
                </div>
                <div class="input-contenedor">
                         <input type="submit" name="Continuar" value="Crear Evento" class="button">
                </div>
                       
            </div>
        
        </form>
    </body>
    </body>
</html>

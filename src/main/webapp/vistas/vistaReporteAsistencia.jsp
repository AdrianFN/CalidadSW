<%-- 
    Document   : vistaReporteAsistencia
    Created on : 28/10/2019, 05:39:13 PM
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
                
                <h4>Salones Asignados </h4>
                <div class="input-contenedor">                  
                    <jsp:useBean id="cn" class="dao.impl.ExpositorDAOImpl" scope="page"></jsp:useBean>
                        <select>
                            <option>Salon, horario, dia, expositor </option>
                        <%
                            cn.listarExpositor();
                        %>
                        </select>
                                                             
                </div>
                <div class="input-contenedor">
                    <input type="radio" name="asistecia" value="Asistio"/>Asistio
                    <input type="radio" name="asistecia" value="NoAsistio"/>No Asistio
                </div>
                        
                        
               
                <div class="input-contenedor">
                         <input type="submit" name="VerLista" value="Habilitar Salon" class="button">
                </div>
                <div class="input-contenedor">
                         <input type="submit" name="Continuar" value="Terminar Evento" class="button">
                </div>
                       
            </div>
        
        </form>
    </body>
</html>

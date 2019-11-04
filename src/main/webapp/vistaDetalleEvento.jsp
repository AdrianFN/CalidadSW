<%-- 
    Document   : vistaDetalleEvento
    Created on : 28/10/2019, 06:17:16 PM
    Author     : Adrián
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle Evento 1</title>
        <link href="css/estiloDetalleEvento.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form class="formularioDetalleEvento" action="Servlet">
            <h1>Sistema Gestor de Eventos</h1>

            <div class="contenedor">

                <div class="input-contenedor">
                    <label for="ListarExpositores">Expositores registrados</label>


                    </select>
                    <input type="submit" name="agregarLista" value="Agregar" class="button">
                </div>

                <div class="input-contenedor">
                    <label for="RegistrarExpositor">Registrar expositores</label><br><br>
                    <label for="DNI">DNI</label>
                    <input type="text" name="txtDNI" placeholder="DNI"/><br><br>
                    <label for="Nombre">Nombre</label>
                    <input type="text" name="Nombre" placeholder="Nombre de expositor"/>
                    <br><br>
                    <input type="submit" name="agregarRegistrarLista" value="Agregar a lista" class="button">
                </div>


                <div class="input-contenedor">
                    <label for="ListarExpositores">Expositores registrados</label>

                    <select>
                        <option hidden selected disabled>Expositores...</option>
                        <c:forEach items="${expositores}" var="item">
                            <option value="${item.getIdExpositor()}">
                                ${item.getExpositorNombre()}
                            </option>
                        </c:forEach>

                    </select>  


                </div>

                <div class="input-contenedor">
                    <input type="submit" name="VerLista" value="ver" class="button">
                </div>

                <div class="input-contenedor">
                    <input type="submit" name="Continuar" value="continuar" class="button">
                </div>

            </div>
        </form>
    </body>
</html>

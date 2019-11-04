<%-- 
    Document   : index
    Created on : 13/10/2019, 04:03:06 AM
    Author     : Adrián
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Ingreso</title>
        <link href="css/estiloIndex.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="contenedor1">
            <h1>Sistema Gestor de Eventos</h1>
            <form id = "formulario1" action="ServletUsuario" method="post">
                <img src="imagen/user.png" alt=""/>
                <input type="text" name="txtUser" placeholder="Nombre de usuario"/>
                <hr> <!--¿Una línea?-->
                <img src="imagen/user.png" alt=""/>
                <input type="password" name="txtPass" placeholder="Contraseña"/>
                <hr>
                <input type="submit" name="btnInicioSesion" value="Iniciar sesión"/>
            </form>
        </div>

        <div id="contenedor2">

            
            <form id = "formulario2" action="vistaRegistroUsuario.jsp">
                <input type="submit" name="btnRegistro" value="Registrarse"/>
            </form>

            <div id="referencias">
                <a>Sistema Gestor de eventos</a>
                <a href="">Términos de uso</a>
                <a href="">Políticas de privacidad</a>
            </div>
        </div>
    </body>
</html>


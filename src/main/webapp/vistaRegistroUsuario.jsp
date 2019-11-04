<%-- 
    Document   : vistaRegistroUsuario
    Created on : 13/10/2019, 09:44:31 AM
    Author     : Adrián
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estiloRegistroUsuario.css">
    </head>
    <body>
        <form class="formularioRegistroUsuario" action="ServletRegistroUsuario" method="post">
            <h1>Sistema Gestor de Eventos</h1>
            <div class="contenedor">
                <div class="input-contenedor">
                    <img src="imagen/dni.png" alt=""/>
                    <input type="text" name="txtDNI" placeholder="DNI"/>
                </div>
                <div class="input-contenedor">
                    <img src="imagen/password.png" alt=""/>
                    <input type="password" name="txtPassword" placeholder="Contraseña"/>
                </div>
                <div class="input-contenedor">
                    <img src="imagen/user.png" alt=""/>
                    <input type="text" name="txtNombre" placeholder="Nombres"/>
                </div>
                <div class="input-contenedor">
                    <img src="imagen/user.png" alt=""/>
                    <input type="text" name="txtApellido" placeholder="Apellidos"/>
                </div>
                <div class="input-contenedor">
                    <img src="imagen/phone.png" alt=""/>
                    <input type="text" name="txtTelefono" placeholder="Celular"/>
                </div>
                
                <input type="submit" name="btnRegistrarse" value="Registrarse" class="button">
                <p>Al registrarte, aceptas nuestras condiciones de uso y políticas de privacidad.</p>
                <p>¿Ya tienes cuenta?<a class="link" href="../">Iniciar sesión</a></p>
            </div>
        </form>
    </body>
</html>

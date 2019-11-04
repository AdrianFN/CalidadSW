<%-- 
    Document   : index
    Created on : 13/10/2019, 04:03:06 AM
    Author     : Adrián
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Ingreso</title>
        <link href="css/estiloIndex.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <br>
        <br>
        <br>

        <div class="container">
            <div class="row">

                <div class="card border-dark mx-auto">
                    <div class="card-body">
                        <h1>Sistema Gestor de Eventos</h1>
                        <hr>
                        <br>
                        <form id="formulario1" action="ServletUsuario" method="post">

                            <div class="form-group">
                                <label>Usuario</label>
                                <input class="form-control" type="text" name="txtUser" placeholder="Nombre de usuario"/>
                            </div>

                            <div class="form-group">
                                <label>Contraseña</label>
                                <input class="form-control" type="password" name="txtPass" placeholder="Contraseña"/>
                            </div>

                            <input class="btn btn-primary" type="submit" name="btnInicioSesion" value="Iniciar sesión"/>
                        </form>
                    </div>
                </div>
            </div>


            <br>
            <div class="row">
                <div class="card mx-auto">
                    <div class="card-body">
                        <!--<form id = "formulario2" action="vistaRegistroUsuario.jsp">
                            <input class="btn btn-primary" type="submit" name="btnRegistro" value="Registrarse"/>
                            
                        </form>-->
                        <button class="btn btn-link"><a href="vistaRegistroUsuario.jsp">Registrarse</a></button>
                    </div>
                </div>

            </div>
        </div>

        <!--<div id="contenedor1">
            <h1>Sistema Gestor de Eventos</h1>
            <form id = "formulario1" action="ServletUsuario" method="post">
                <img src="imagen/user.png" alt=""/>
                <input type="text" name="txtUser" placeholder="Nombre de usuario"/>
                <hr> 
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
        </div>-->
    </body>
</html>


<%-- 
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        <div id = "wrapper">
            <header>
                <div id = navi>
                    <header>
                        <h1>SPJ</h1>
                        <a href="index.jsp" class="pNav">Inicio</a>
                        <a href="login.jsp" class="pNav">login</a>
                </div>
            </header>
                    <section>
                        <div id = "contents">
                            <article>
                            <h1>Login</h1>
                            <form class="formLogin"  method="GET" action="loginServlet">
                                <table>
                                    <tr>
                                        <td class="etiqueta">
                                            <label for="usuario">Usuario:&nbsp;</label>
                                        </td>
                                        <td class="campo">
                                            <input type="text" size="30"
                                                   id="usuario" name="usuario" autocomplete="off" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="etiqueta">
                                            <label for="password">Clave:&nbsp;</label>
                                        </td>
                                        <td class="campo">
                                            <input type="password" size="30"
                                                   id="password" name="clave" autocomplete="off" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="controles" colspan="2">
                                            <button>Ingresar</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                            </article>
                        </div>
                    </section>  
        </div>
                
    </body>
</html>

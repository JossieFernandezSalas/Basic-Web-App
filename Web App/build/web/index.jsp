<%-- 
    Document   : index
    Created on : 7 may. 2021, 13:48:18
    Author     : jossi
--%>

<%@page import="java.util.List"%>
<%@page import="aplicacion.modelo.Sorteo"%>
<%@page import="aplicacion.modelo.Modelo"%>
<%@page import="java.io.InputStream"%>
<%@page import="aplicacion.modelo.ListaSorteo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/tablaSorteos.css" rel="stylesheet" type="text/css"/>
        <title>Sorteos</title>
    </head>
    <body>
        <div class="wrapper">
            <div >
            <div id = navi>
            <header>
                    <h1>SPJ</h1>
                        <a href="index.jsp" class="pNav">Inicio</a>
                        <a href="login.jsp" class="pNav">login</a>
            </div>
            </div>
            </header>
                <div id = "padre">
                    <h2>Proximos Sorteos</h2>
                
            <div id="contents">
                <%
                    Modelo modelo = new Modelo();
                    InputStream datos = getServletContext().getResourceAsStream("/WEB-INF/data/info-spj.xml");
                    try {
                        modelo = modelo.cargar(datos);
                    } catch (Exception ex) {
                        out.println(String.format("<p class=\"error\">(Excepción: '%s')</p>",
                                ex.getMessage()));
                    }
                    
                       ListaSorteo proximos = new ListaSorteo();
                       for(Sorteo s : modelo.getSorteos()){
                           if(s.getEstado() == 1)
                               proximos.agregar(s);
                       }
                       out.println(proximos.getTabla());
                %>
                </div>
                
                 <div>
                    <h2>Sorteos Anteriores</h2>
                
            <div id="contents">
                <%
                      ListaSorteo anteriores = new ListaSorteo();
                       for(Sorteo s : modelo.getSorteos()){
                           if(s.getEstado() == 3)
                               anteriores.agregar(s);
                       }
                       out.println(anteriores.getTabla());
                %>
                </div>
            </div>
        </div>
    </body>
</html>

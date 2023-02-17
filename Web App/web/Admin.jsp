<%--
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="aplicacion.modelo.Sorteo"%>
<%@page import="aplicacion.modelo.Modelo"%>
<%@page import="aplicacion.modelo.ListaSorteo"%>
<%@page import="java.io.InputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/tablaSorteos.css" rel="stylesheet" type="text/css"/>
        <title>Admin</title>
    </head>
    <body>
        <div id = "wrapper">
        <div id = "padre">
            <div id = navi>
                <header>
                    <h1>SPJ</h1>
                    <a href="index.jsp" class="pNav">Inicio</a>
                    <a href="Logout.jsp" class="pNav">logout</a>
            </div>
            <div>
                <h1>Sorteos Vencidos</h1>
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
                        
                        HttpSession sesion = request.getSession(true);
                        ListaSorteo vencidos = (ListaSorteo) session.getAttribute("vencidos");
                        /*for (Sorteo s : modelo.getSorteos()) {
                            if (s.getEstado() == 2 || s.getEstado() == 3) {
                                vencidos.agregar(s);
                            }
                        }*/
                        out.println(vencidos.getTablaAdmin());
                %>
                <div class = "datos">
                     <h3>Edicion</h3>
                                 <form class="Admin"  method="POST" action="AdminServlet">
                                <table>
                                    <tr>
                                        <td class="etiqueta">
                                            <label for="usuario">Sorteo&nbsp;</label>
                                        </td>
                                        <td class="campo">
                                            <select id="sorteo" name="sorteo">
                                                <%              
                                                    for (Sorteo s : modelo.getSorteos()) {
                                                            if (s.getEstado() == 2 || s.getEstado() == 3) {
                                                                vencidos.agregar(s);
                                                            }
                                                    }
                                                    for (Sorteo s : vencidos.getListaSorteos()) {
                                                            int i = 1;
                                                            out.println("<option value =" + new SimpleDateFormat("yyyy-MM-dd").format(s.getFecha()) + 
                                                                    " >" + new SimpleDateFormat("yyyy-MM-dd").format(s.getFecha()) + "</option>");
                                                            i++;
                                                        }
                                                    
                                                %>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="etiqueta">
                                            <label for="numero">Numero&nbsp;</label>
                                        </td>
                                        <td class="campo">
                                            <input type="number" name="numero"
                                                   size="99" placeholder="00"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="controles" colspan="2">
                                            <button>Editar</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                </div>
                </div>
                </div>
            </div>
                </div>
            </div>
    </body>
</html>

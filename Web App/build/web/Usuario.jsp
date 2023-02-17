<%-- 
    Document   : Usuario
    Created on : 7 may. 2021, 19:27:38
    Author     : jossi
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="aplicacion.modelo.ListaApuestaJugador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="aplicacion.modelo.ApuestaJugador"%>
<%@page import="aplicacion.modelo.ListaSorteo"%>
<%@page import="aplicacion.modelo.ListaApuesta"%>
<%@page import="aplicacion.modelo.Apuesta"%>
<%@page import="aplicacion.modelo.Sorteo"%>
<%@page import="java.io.InputStream"%>
<%@page import="aplicacion.modelo.Modelo"%>
<%@page import="aplicacion.modelo.Modelo"%>
<%@page import="aplicacion.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/tablaApuestas.css" rel="stylesheet" type="text/css"/>
        <title>Apuestas</title>
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
                    <h2>Mis Apuestas</h2>
                    <%
                             Usuario usuario = (Usuario) request.getSession(true).getAttribute("usuario");
                            
                             Modelo modelo = new Modelo();
                            InputStream datos = getServletContext().getResourceAsStream("/WEB-INF/data/info-spj.xml");
                            try {
                                modelo = modelo.cargar(datos);
                            } catch (Exception ex) {
                                out.println(String.format("<p class=\"error\">(Excepción: '%s')</p>",
                                        ex.getMessage()));
                            }
                          
                            ListaApuesta apuestas = new ListaApuesta();
                            
                           for(Apuesta a: modelo.getApuestas()){
                                if(usuario.getCedula().equals(a.getCedula())){
                                    apuestas.agregar(a);
                                }
                            }
                           
                            ListaSorteo sorteos = new ListaSorteo();
                            for(int i = 0; i < apuestas.getListaApuestas().size(); i++){
                                for(int j = 0; j < modelo.getSorteos().size(); j++)
                                if(apuestas.getListaApuestas().get(i).getNumeroSorteo() == (int) modelo.getSorteos().get(j).getNumeroSorteo())
                                    sorteos.agregar(modelo.getSorteos().get(j));
                            }
                            
                            ListaApuestaJugador misApuestas = new ListaApuestaJugador();
                            ApuestaJugador jugador = (ApuestaJugador) request.getSession(true).getAttribute("jugador");

                                if (jugador != null) {
                                        
                                        misApuestas.agregar(jugador);
                                        
                                        for (Sorteo s : sorteos.getListaSorteos()) {
                                            ApuestaJugador aj = new ApuestaJugador(s, new Apuesta());
                                            misApuestas.agregar(aj);
                                        }

                                        for (int i = 1; i < apuestas.getListaApuestas().size(); i++) {
                                            misApuestas.getApuestasJugador().get(i).setApuesta(apuestas.getListaApuestas().get(i));
                                        }
                                        
                                    } else {
                                        for (Sorteo s : sorteos.getListaSorteos()) {
                                            ApuestaJugador aj = new ApuestaJugador(s, new Apuesta());
                                            misApuestas.agregar(aj);
                                        }

                                        for (int i = 0; i < apuestas.getListaApuestas().size(); i++) {
                                            misApuestas.getApuestasJugador().get(i).setApuesta(apuestas.getListaApuestas().get(i));
                                        }
                                    }
                                                       
                            out.println(misApuestas.getTabla());
                        %>
                </div>
                <div class = "datos">
                    <h3>Apostar</h3>
                                 <form class="formLogin"  method="GET" action="apuestaServlet">
                                <table>
                                    <tr>
                                        <td class="etiqueta">
                                            <label for="usuario">Sorteo&nbsp;</label>
                                        </td>
                                        <td class="campo">
                                            <select id="sorteo" name="sorteo">
                                                <% 
                                                                      ListaSorteo proximos = new ListaSorteo();
                                                                          for (Sorteo s : modelo.getSorteos()) {
                                                                              if (s.getEstado() == 1) {
                                                                                  proximos.agregar(s);
                                                                              }
                                                                          }
                                                                        for(Sorteo s: proximos.getListaSorteos()){
                                                                            int i = 1;
                                                                          out.println("<option value =" + new SimpleDateFormat("yyyy-MM-dd").format(s.getFecha())  +" >" + new SimpleDateFormat("yyyy-MM-dd").format(s.getFecha()) + "</option>");
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
                                        <td class="etiqueta">
                                            <label for="monto">Monto&nbsp;</label>
                                        </td>
                                        <td class="etiqueta">
                                            <input type="number" name="monto"
                                                   min="100" max="20000"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="controles" colspan="2">
                                            <button>Aprobar</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                </div>
            </div>
            
        </div>
    </body>
</html>

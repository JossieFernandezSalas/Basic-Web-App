/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package aplicacion.servlets;

import aplicacion.modelo.ListaSorteo;
import aplicacion.modelo.Modelo;
import aplicacion.modelo.Sorteo;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jossi
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       int ganador = Integer.valueOf(request.getParameter("numero"));
       String fecha = request.getParameter("sorteo");
       
        Modelo modelo = new Modelo();
        InputStream datos = getServletContext().getResourceAsStream("/WEB-INF/data/info-spj.xml");
        try {
            modelo = modelo.cargar(datos);
        } catch (Exception ex) {
            out.println(String.format("<p class=\"error\">(Excepción: '%s')</p>",
                    ex.getMessage()));
        }
                
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        
        ListaSorteo vencidos = new ListaSorteo();
        for (Sorteo s : modelo.getSorteos()) {
            if (s.getEstado() == 2 || s.getEstado() == 3) {
                vencidos.agregar(s);
            }
        }
        
        for(Sorteo sor : vencidos.getListaSorteos()){
            String f = date.format(sor.getFecha());
            if( f.equals(fecha)){
                sor.setNumeroGanador(ganador);
            }
        }
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("vencidos", vencidos);
        response.sendRedirect("Admin.jsp");
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

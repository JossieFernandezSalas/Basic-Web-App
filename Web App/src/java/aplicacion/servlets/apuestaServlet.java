/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package aplicacion.servlets;

import aplicacion.modelo.Apuesta;
import aplicacion.modelo.ApuestaJugador;
import aplicacion.modelo.Sorteo;
import java.io.IOException;
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

@WebServlet(name = "apuestaServlet", urlPatterns = {"/apuestaServlet"})
public class apuestaServlet extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
           String fecha = request.getParameter("sorteo");
           long monto = Integer.valueOf(request.getParameter("monto"));
           long numero = Integer.valueOf(request.getParameter("numero"));
           
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = date.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(apuestaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Sorteo sorteo = new Sorteo(1234 , date1, "Sorteo ordinario", 90, 0, 1);
        Apuesta apuesta = new Apuesta("123456789", numero, 98, monto, 0);
        
        ApuestaJugador jugador = new ApuestaJugador(sorteo, apuesta);
         HttpSession sesion = request.getSession(true);
        sesion.setAttribute("jugador", jugador);
        response.sendRedirect("Usuario.jsp");
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

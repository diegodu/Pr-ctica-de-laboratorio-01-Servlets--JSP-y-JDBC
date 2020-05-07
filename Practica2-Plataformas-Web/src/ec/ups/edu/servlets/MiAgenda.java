package ec.ups.edu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.PersonaDAO;
import ec.ups.edu.modelo.Persona;

/**
 * Servlet implementation class MiAgenda
 */
@WebServlet("/MiAgenda")
public class MiAgenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sesion = request.getParameter("logout");
        if (sesion != null) {
            if (sesion.equals("true")) {
                //System.out.println("Sesion cerrada de id " + request.getSession().getAttribute("sesionID"));
                request.getSession().invalidate();
                response.sendRedirect("/Practica2-Plataformas-Web/JSPs/login.html");

            }
        } else {
            PersonaDAO PersonaDao = DAOFactory.getFactory().getPersonaDAO();
            Persona persona= PersonaDao.findById(String.valueOf(request.getSession().getAttribute("personaID")));

            request.setAttribute("persona", persona);
           System.out.println("personaaaa"+persona);
            getServletContext().getRequestDispatcher("/JSPs/agenda.jsp").forward(request, response);
        
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/views/jsp/my-agenda.jsp");
            //dispatcher.forward(request, response);


            //System.out.println("Nombre: "+user.getNombre() + " Apellido: "+user.getApellido());
        }
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
        //processRequest(request, response);
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

package ec.ups.edu.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.PersonaDAO;
import ec.ups.edu.modelo.Persona;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Practica2-Plataformas-Web/JSPs/login.html");
        dispatcher.forward(request, response);
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
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        
        PersonaDAO personaDao = DAOFactory.getFactory().getPersonaDAO();
        Persona persona = personaDao.findPersona(correo, contrasena);
  
        if (persona != null ) {
            System.out.println("usuario encontrado");
            HttpSession session = request.getSession(true);
            System.out.println("Sesion iniciada con id " + request.getSession().getId());
            session.setAttribute("sesionID", String.valueOf(session.getId()));
            session.setAttribute("personaID", persona.getCedula());
           
        
            response.sendRedirect("/Practica2-Plataformas-Web/MiAgenda");
            
        }else{
            response.sendRedirect("/Practica2-Plataformas-Web/JSPs/login.html");
        }     
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

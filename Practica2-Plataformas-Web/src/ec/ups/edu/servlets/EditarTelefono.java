package ec.ups.edu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.TelefonoDAO;
import ec.ups.edu.modelo.Persona;
import ec.ups.edu.modelo.Telefono;

/**
 * Servlet implementation class EditarTelefono
 */
@WebServlet("/EditarTelefono")
public class EditarTelefono extends HttpServlet {


	private static final long serialVersionUID = 1L;

	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sesion = request.getParameter("eliminar");
        String id = request.getParameter("telefonoID");
        if (sesion != null && id != null) {
            if (sesion.equals("true")) {  
                TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
                Telefono telefono= telefonoDao.findById(Integer.parseInt(id));
                telefonoDao.delete(telefono);
                System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                //System.out.println("telefono a eliminar.. " + id );
                response.sendRedirect("/Practica2-Plataformas-Web/MiAgenda");
            }
        } else {}
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
        String numero = request.getParameter("numero");
        String tipo = request.getParameter("tipo");
        String operadora = request.getParameter("operadora");
        String idTelefono = request.getParameter("idtel");

        TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
        Telefono telefono = telefonoDao.findById(Integer.parseInt(idTelefono));
        Persona persona = DAOFactory.getFactory().getPersonaDAO().findById(String.valueOf(request.getSession().getAttribute("personaID")));
        telefono.setPersona(persona);
        telefono.setNumero(numero);
        telefono.setTipo(tipo);
        telefono.setOperadora(operadora);
        System.out.println("holaaa"+telefono);
        
        telefonoDao.update(telefono);

        response.sendRedirect("/Practica2-Plataformas-Web/MiAgenda");
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

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
 * Servlet implementation class AgregarTelefono
 */
@WebServlet("/AgregarTelefono")
public class AgregarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarTelefono() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String numero = request.getParameter("numero");
		String tipo = request.getParameter("tipo");
		String operadora = request.getParameter("operadora");
		
		TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		Telefono telefono = new Telefono(numero, operadora, tipo);
		Persona persona = DAOFactory.getFactory().getPersonaDAO().findById(String.valueOf(request.getSession().getAttribute("personaID")));
		telefono.setPersona(persona);
		telefonoDao.create(telefono);
		
		response.sendRedirect("/Practica2-Plataformas-Web/MiAgenda");
	}

}

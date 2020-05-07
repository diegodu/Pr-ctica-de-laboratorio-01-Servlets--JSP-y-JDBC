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
 * Servlet implementation class Registro
 */
@WebServlet(name = "Registro", urlPatterns = {"/registro"})
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
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
		doGet(request, response);
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String cedula = request.getParameter("cedula");
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(cedula);
		System.out.println(correo);
		System.out.println(contrasena);
		DAOFactory.getFactory().createTables();
		
		PersonaDAO personaDao = DAOFactory.getFactory().getPersonaDAO();
        Persona persona = new Persona(cedula, nombre, apellido, correo, contrasena);
        if (personaDao.create(persona)) {
            response.sendRedirect("/Practica2-Plataformas-Web/JSPs/login.html");
            System.out.println("Usuario Creado");
            //System.out.println("nombre: "+nombre+" apellido: "+apellido+" cedula: "+cedula+" correo: "+correo);
        }else{
            System.out.println("Usuario No Creado");
            response.sendRedirect("registro");
        }
		
		
	}
	

}

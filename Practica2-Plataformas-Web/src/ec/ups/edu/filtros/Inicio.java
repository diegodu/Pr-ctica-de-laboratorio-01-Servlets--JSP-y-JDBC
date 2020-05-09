package ec.ups.edu.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.PersonaDAO;
import ec.ups.edu.dao.TelefonoDAO;

import javax.servlet.DispatcherType;

/**
 * Servlet Filter implementation class Inicio
 */
@WebFilter(filterName = "Inicio", urlPatterns = {"/Practica2-Plataformas-Web"}, dispatcherTypes = {DispatcherType.REQUEST})
public class Inicio implements Filter {
	 private static final boolean debug = true;

	    // The filter configuration object we are associated with.  If
	    // this value is null, this filter instance is not currently
	    // configured. 
	    private FilterConfig filterConfig = null;
	    
	    public Inicio() {
	    }    
	    
	    /**
	     *
	     * @param request The servlet request we are processing
	     * @param response The servlet response we are creating
	     * @param chain The filter chain we are processing
	     *
	     * @exception IOException if an input/output error occurs
	     * @exception ServletException if a servlet error occurs
	     */
	    public void doFilter(ServletRequest request, ServletResponse response,
	            FilterChain chain)
	            throws IOException, ServletException {
	        PersonaDAO personaDao = DAOFactory.getFactory().getPersonaDAO();
	        personaDao.createTable();
	        TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
	        telefonoDao.createTable();
	        System.err.println("Filtro en homefilter");
	        //chain.doFilter(request, response);
	        HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;
	        //res.sendRedirect("/Practica-de-laboratorio-01");
	        
	        //req.setAttribute("userId", req.getSession().getAttribute("userID"));
	        //RequestDispatcher dispatcher = req.getRequestDispatcher("/index.js");
	        //dispatcher.forward(req, res);
	        //RequestDispatcher despachador= request.getRequestDispatcher("/scopes.jsp");
	        //despachador.forward(request, response);
	        
	    
	        
	    }
}

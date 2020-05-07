package ec.ups.edu.dao;

import ec.ups.edu.mysql.jdbc.JDBCPersonaDAO;
import ec.ups.edu.mysql.jdbc.JDBCTelefonoDAO;

public class JDBCDAOFactory extends DAOFactory {

	@Override
	public void createTables() {
		this.getPersonaDAO().createTable();
		this.getTelefonoDAO().createTable();

	}

	@Override
	public PersonaDAO getPersonaDAO() {
		return new JDBCPersonaDAO();
	}

	@Override
	public TelefonoDAO getTelefonoDAO() {
		return new JDBCTelefonoDAO();
	}

	
}

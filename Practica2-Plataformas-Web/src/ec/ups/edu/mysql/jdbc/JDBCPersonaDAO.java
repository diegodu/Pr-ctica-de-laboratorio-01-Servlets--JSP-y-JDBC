package ec.ups.edu.mysql.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.PersonaDAO;
import ec.ups.edu.modelo.Persona;
import ec.ups.edu.modelo.Telefono;


public class JDBCPersonaDAO extends JDBCGenericDAO<Persona, String> implements PersonaDAO {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		 conexionUno.update("CREATE TABLE IF NOT EXISTS usuario ("
	                + "	usu_cedula VARCHAR(10) NOT NULL,"
	                + "	usu_nombre VARCHAR(50),"
	                + "	usu_apellido VARCHAR(50),"
	                + "	usu_correo VARCHAR(100),"
	                + "	usu_pass VARCHAR(255),"
	                + "	usu_activo INT,"
	                + "	PRIMARY KEY (usu_cedula)"
	                + ");");
		
	}

	@Override
	public boolean create(Persona persona) {
		// TODO Auto-generated method stub
		 return conexionUno.update("INSERT INTO usuario VALUES ('" + persona.getCedula() + "', '" + persona.getNombre() + "', '" + persona.getApellido() + "', '" + persona.getCorreo() + "', '" + persona.getContrasena() + ");");
	}

	@Override
	public Persona read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Persona persona) {
		return conexionUno.update("UPDATE usuario SET "
                + "	usu_nombre = '" + persona.getNombre() + "',"
                + "	usu_apellido = '" + persona.getApellido() + "',"
                + "	usu_pass  = '" + persona.getContrasena() + "'"
                + "	WHERE usu_cedula = '" + persona.getCedula() + "';");
	}

	@Override
	public boolean delete(Persona persona) {
		// TODO Auto-generated method stub
		return conexionUno.update("UPDATE usuario SET "
                + "	WHERE usu_cedula = '" + persona.getCedula() + "';");
	}

	@Override
	public List<Persona> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona findById(String cedula) {
		 Persona persona = null;
	        ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE usu_cedula = '" + cedula + "';");
	        try {
	            if (rs != null && rs.next()) {
	                persona = new Persona(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getNString("usu_apellido"), rs.getNString("usu_correo"), rs.getNString("usu_pass"));
	                List<Telefono> telefonos = DAOFactory.getFactory().getTelefonoDAO().findByPersonaId(persona.getCedula());
	                persona.setTelefonos(telefonos);
	            }
	        } catch (SQLException e) {
	            System.out.println(">>>WARNING (JDBCUserDAO:findById): " + e.getMessage());
	        }
	        return persona;
	}

	@Override
	public Persona findPersona(String correo, String contrasena) {
		// TODO Auto-generated method stub
		 Persona persona = null;
	        ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE usu_correo = '"+correo+"' AND usu_pass = '"+contrasena+"';");
	        try {
	            if (rs != null && rs.next()) {
	                persona = new Persona(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getNString("usu_apellido"), rs.getNString("usu_correo"), rs.getNString("usu_pass"));
	                List<Telefono> telefonos = DAOFactory.getFactory().getTelefonoDAO().findByPersonaId(persona.getCedula());
	                persona.setTelefonos(telefonos);
	            }
	        } catch (SQLException e) {
	            System.out.println(">>>WARNING (JDBCUserDAO:findUser): " + e.getMessage());
	        }
	        return persona; 
	}

	

	
	

}

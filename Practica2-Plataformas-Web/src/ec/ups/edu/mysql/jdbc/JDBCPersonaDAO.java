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
	        conexionUno.update("CREATE TABLE IF NOT EXISTS usuario ("
	                + "	usu_cedula VARCHAR(10) NOT NULL,"
	                + "	usu_nombre VARCHAR(50),"
	                + "	usu_apellido VARCHAR(50),"
	                + "	usu_correo VARCHAR(100),"
	                + "	usu_pass VARCHAR(255),"
	                + "	PRIMARY KEY (usu_cedula)"
	                + ");");
	    }

	    @Override
	    public boolean create(Persona persona) {
	        return conexionUno.update("INSERT INTO usuario VALUES ('" + persona.getNombre() + "', '" + persona.getApellido()+ "', '" + persona.getCedula() + "', '" + persona.getCorreo() + "', '" + persona.getContrasena() + "');");
	    }

	    @Override
	    public Persona findById(String cedula) {
	        Persona persona = null;
	        ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE usu_cedula = '" + cedula + "';");
	        try {
	            if (rs != null && rs.next()) {
	                persona = new Persona(rs.getString("usu_nombre"), rs.getString("usu_apellido"),rs.getString("usu_cedula"), rs.getNString("usu_correo"), rs.getNString("usu_pass"));
	                List<Telefono> telefonos = DAOFactory.getFactory().getTelefonoDAO().findByPersonaId(persona.getCedula());
	                persona.setTelefonos(telefonos);
	             
	                //System.out.println("Usuario buscado...."+user.getNombre());
	               
	            }
	        } catch (SQLException e) {
	            System.out.println(">>>WARNING (JDBCUserDAO:findById): " + e.getMessage());
	        }
	        return persona;
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
	        return conexionUno.update("UPDATE usuario SET "
	             
	                + "	WHERE usu_cedula = '" + persona.getCedula() + "';");
	    }

	    @Override
	    public List<Persona> find() {
	        List<Persona> personas = new ArrayList<>();

	        ResultSet rs = conexionUno.query("SELECT * FROM usuario;");
	        try {
	            while (rs.next()) {
	                Persona persona = new Persona( rs.getString("usu_nombre"), rs.getNString("usu_apellido"),rs.getString("usu_cedula"), rs.getNString("usu_correo"), rs.getNString("usu_pass"));
	                List<Telefono> telefonos = DAOFactory.getFactory().getTelefonoDAO().findByPersonaId(persona.getCedula());
	                persona.setTelefonos(telefonos);
	                personas.add(persona);
	            }
	        } catch (SQLException e) {
	            System.out.println(">>>WARNING (JDBCUserDAO:find): " + e.getMessage());
	        }
	        return personas;
	    }

	    @Override
	    public Persona findPersona(String correo, String contrasena) {
	        //System.out.println("Usuario: "+correo+" Pass: "+pass);
	        Persona persona = null;
	        ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE usu_correo = '" + correo + "' AND usu_pass = '" + contrasena + "';");
	        try {
	            if (rs != null && rs.next()) {
	                persona = new Persona( rs.getString("usu_nombre"), rs.getNString("usu_apellido"),rs.getString("usu_cedula"), rs.getNString("usu_correo"), rs.getNString("usu_pass"));
	                List<Telefono> telefonos = DAOFactory.getFactory().getTelefonoDAO().findByPersonaId(persona.getCedula());
	                persona.setTelefonos(telefonos);
	               
	               
	            }
	        } catch (SQLException e) {
	            System.out.println(">>>WARNING (JDBCUserDAO:findUser): " + e.getMessage());
	        }
	        return persona;
	    }
	    

	    @Override
	    public List<Persona> findByIdOrMail(String context) {
	        List<Persona> personas = new ArrayList<>();
	        if (context.equals("all")) {
	            ResultSet rs = conexionUno.query("SELECT * FROM usuario;");
	            try {
	                if (rs != null && rs.next()) {
	                    Persona persona = new Persona( rs.getString("usu_nombre"), rs.getString("usu_apellido"),rs.getString("usu_cedula"), rs.getString("usu_correo"), rs.getString("usu_pass"));
	                    List<Telefono> telefonos = DAOFactory.getFactory().getTelefonoDAO().findByPersonaId(persona.getCedula());
	                    persona.setTelefonos(telefonos);
	                    personas.add(persona);
	                }
	            } catch (SQLException e) {
	                System.out.println(">>>WARNING (JDBCUserDAO:findByIdOrMail): " + e.getMessage());
	            }
	            System.out.println("Todos los usuarios....."+personas.toString());
	        } else {
	            ResultSet rs = conexionUno.query("SELECT * FROM usuario "
	                    + "WHERE usu_cedula = '" + context + "' OR usu_correo = '" + context + "';");
	            try {
	                if (rs != null && rs.next()) {
	                	Persona persona= new Persona( rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_cedula"),rs.getString("usu_correo"), rs.getString("usu_pass"));
	                    List<Telefono> telefonos = DAOFactory.getFactory().getTelefonoDAO().findByPersonaId(persona.getCedula());
	                    persona.setTelefonos(telefonos);
	                    personas.add(persona);
	                }
	            } catch (SQLException e) {
	                System.out.println(">>>WARNING (JDBCUserDAO:findByIdOrMail): " + e.getMessage());
	            }
	        }

	        return personas;
	    }


	
	

}

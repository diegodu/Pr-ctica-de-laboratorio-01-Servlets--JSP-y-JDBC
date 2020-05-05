package ec.ups.edu.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.PersonaDAO;
import ec.ups.edu.dao.TelefonoDAO;
import ec.ups.edu.modelo.Telefono;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDAO {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		conexionDos.update("CREATE TABLE IF NOT EXISTS telefono ("
                + "	tel_id INT NOT NULL AUTO_INCREMENT,"
                + "	tel_numero VARCHAR(20),"
                + "	tel_tipo  VARCHAR(50),"
                + "	tel_operadora VARCHAR(50),"
                + "	usu_cedula VARCHAR(10) NOT NULL,"
                + "	PRIMARY KEY (tel_id),"
                + "	FOREIGN KEY (usu_cedula) REFERENCES usuario(usu_cedula)"
                + ");");
		
		
	}


	@Override
	public boolean create(Telefono telefono) {
		// TODO Auto-generated method stub
		  return conexionDos.update("INSERT INTO telefono (tel_numero, tel_tipo, tel_operadora, usu_cedula) "
	                + "VALUES ('" + telefono.getNumero() + "', '" + telefono.getTipo() + "', '" + telefono.getOperadora() + "', '" + telefono.getPersona().getCedula() + "');");
		
		
	}
	   @Override
	    public Telefono findById(Integer id) {
	        Telefono telefono = null;
	        ResultSet rs = conexionUno.query("Select * FROM telefono WHERE tel_id = " + id + ";");
	        try {
	            if (rs != null && rs.next()) {
	                telefono = new Telefono(rs.getInt("tel_id"), rs.getString("tel_tipo"), rs.getString("tel_operadora"), rs.getString("tel_numero"));
	                telefono.setPersona(DAOFactory.getFactory().getPersonaDAO().findById(rs.getString("usu_cedula")));
	            }
	        } catch (SQLException e) {
	            System.out.println(">>>WARNING (JDBCPhoneDAO:read): " + e.getMessage());
	        }
	        return telefono;
	    }

	@Override
	public Telefono read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Telefono telefono) {
		// TODO Auto-generated method stub
		 return conexionDos.update("UPDATE telefono SET "
	                + "	tel_numero = '" + telefono.getNumero() + "',"
	                + "	tel_tipo = '" + telefono.getTipo() + "',"
	                + "	tel_operadora = '" + telefono.getOperadora() + "'"
	                + "WHERE tel_id = '" + telefono.getId() + "' AND usu_cedula = '" + telefono.getPersona().getCedula() + "';");
		
	}

	@Override
	public boolean delete(Telefono telefono) {
		// TODO Auto-generated method stub
		return conexionDos.update("DELETE FROM telefono WHERE tel_id = '" + telefono.getId() + "' AND usu_cedula = '" + telefono.getPersona().getCedula() + "';");
		
	}

	@Override
	public List<Telefono> find() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}





	@Override
	public List<Telefono> findByPersonaId(String cedula) {
		// TODO Auto-generated method stub
		 List<Telefono> telefonos = new ArrayList<>();
	        ResultSet rs = conexionDos.query("SELECT * FROM telefono WHERE usu_cedula = '" + cedula + "';");
	        try {
	            while (rs.next()) {
	                Telefono telefono = new Telefono(rs.getInt("tel_id"), rs.getString("tel_tipo"), rs.getString("tel_operadora"), rs.getString("tel_numero"));
	                telefono.setPersona(DAOFactory.getFactory().getPersonaDAO().findById(rs.getString("usu_cedula")));
	                telefonos.add(telefono);
	            }
	        } catch (SQLException e) {
	            System.out.println(">>>WARNING (JDBCPhoneDAO:findByShoppingBasketId): " + e.getMessage());
	        }
	        return telefonos;
	
	}

	
}

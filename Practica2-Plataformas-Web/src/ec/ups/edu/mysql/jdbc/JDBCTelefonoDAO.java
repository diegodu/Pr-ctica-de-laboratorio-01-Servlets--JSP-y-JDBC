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
		conexionDos.update("CREATE TABLE IF NOT EXISTS telefono (" + "	tel_id INT NOT NULL AUTO_INCREMENT,"
				+ "	tel_numero VARCHAR(20)," + "	tel_tipo  VARCHAR(50)," + "	tel_operadora VARCHAR(50),"
				+ "	usu_cedula VARCHAR(10) NOT NULL," + "	PRIMARY KEY (tel_id),"
				+ "	FOREIGN KEY (usu_cedula) REFERENCES usuario(usu_cedula)" + ");");
	}

	@Override
	public boolean create(Telefono telefono) {

		return conexionDos.update("INSERT INTO telefono (tel_numero, tel_tipo, tel_operadora, usu_cedula) "
				+ "VALUES ('" + telefono.getNumero() + "', '" + telefono.getTipo() + "', '" + telefono.getOperadora()
				+ "', '" + telefono.getPersona().getCedula() + "');");
	}

	@Override
	public Telefono findById(Integer id) {

		Telefono telefono = null;
		ResultSet rs = conexionUno.query("Select * FROM telefono WHERE tel_id = " + id + ";");
		try {
			if (rs != null && rs.next()) {
				telefono = new Telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"),
						rs.getString("tel_operadora"));
				telefono.setId(rs.getInt("tel_id"));

				telefono.setPersona(DAOFactory.getFactory().getPersonaDAO().findById(rs.getString("usu_cedula")));

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPhoneDAO:read): " + e.getMessage());
		}
		return telefono;
	}


	
	@Override
	public boolean update(Telefono phone) {
		return conexionDos.update("UPDATE telefono SET " + "	tel_numero = '" + phone.getNumero() + "',"
				+ "	tel_tipo = '" + phone.getTipo() + "'," + "	tel_operadora = '" + phone.getOperadora() + "'"
				+ "WHERE tel_id = '" + phone.getId() + "' AND usu_cedula = '" + phone.getPersona().getCedula() + "';");
	}

	@Override
	public boolean delete(Telefono phone) {
		return conexionDos.update("DELETE FROM telefono WHERE tel_id = '" + phone.getId() + "' AND usu_cedula = '"
				+ phone.getPersona().getCedula() + "';");
	}

	@Override
	public List<Telefono> find() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public List<Telefono> findByPersonaId(String cedula) {
		List<Telefono> telefonos = new ArrayList<>();
		ResultSet rs = conexionDos.query("SELECT * FROM telefono WHERE usu_cedula = '" + cedula + "';");
		try {
			while (rs.next()) {
				Telefono telefono = new Telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"),
						rs.getString("tel_operadora"));
				telefono.setId(rs.getInt("tel_id"));
				// phone.setUser(DAOFactory.getDAOFactory().getUserDAO().findById(cedula));
				// System.out.println("Telegono usuario: "+cedula);
				telefonos.add(telefono);
				System.out.println("2222" + telefonos);

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPhoneDAO:findByShoppingBasketId): " + e.getMessage());
		}
		return telefonos;
	}

	@Override
	public List<Telefono> findByTelefono(String cedula, String numero) {
		
		
		List<Telefono> telefonos = new ArrayList<>();
		ResultSet rs = conexionDos.query("SELECT * FROM telefono WHERE tel_numero = '" + numero + "';");
		try {
			while (rs.next()) {
				Telefono telefono = new Telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"),
						rs.getString("tel_operadora"));
				telefono.setId(rs.getInt("tel_id"));
				 telefono.setPersona(DAOFactory.getFactory().getPersonaDAO().findById(cedula));
				// System.out.println("Telegono usuario: "+cedula);
				telefonos.add(telefono);
				System.out.println("2222" + telefonos);

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPhoneDAO:findByShoppingBasketId): " + e.getMessage());
		}
		return telefonos;
		
	}

}

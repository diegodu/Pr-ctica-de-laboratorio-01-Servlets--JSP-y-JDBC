package ec.ups.edu.dao;



import ec.ups.edu.modelo.Persona;

public interface PersonaDAO extends GenericDAO<Persona, String> {

	public abstract Persona findPersona(String correo, String contrasena);

}

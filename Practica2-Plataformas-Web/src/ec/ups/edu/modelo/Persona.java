package ec.ups.edu.modelo;

import java.util.Arrays;
import java.util.List;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String cedula;
	private String correo;
	private String contrasena;
	private List<Telefono> telefonos;
	
	public Persona() {
		
	}


	public Persona(String nombre, String apellido, String cedula, String correo, String contrasena
			) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.correo = correo;
		this.contrasena = contrasena;
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public List<Telefono> getTelefonos() {
		return telefonos;
	}


	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", correo=" + correo
				+ ", contrasena=" + contrasena + ", telefonos=" + telefonos + "]";
	}


	

}

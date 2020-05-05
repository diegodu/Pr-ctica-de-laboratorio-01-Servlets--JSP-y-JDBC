package ec.ups.edu.modelo;

public class Telefono {
	
	private int id;
	private String numero;
	private String operadora;
	private String tipo;
	private Persona persona;
	
	public Telefono() {
		
	}

	public Telefono(int id, String numero, String operadora, String tipo) {
		super();
		this.id = id;
		this.numero = numero;
		this.operadora = operadora;
		this.tipo = tipo;
	
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Telefono [id=" + id + ", numero=" + numero + ", operadora=" + operadora + ", tipo=" + tipo
				+ ", persona=" + persona + "]";
	}
	
	

}


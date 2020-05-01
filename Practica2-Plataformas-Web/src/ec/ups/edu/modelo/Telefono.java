package ec.ups.edu.modelo;

public class Telefono {
	
	private String numero;
	private String operadora;
	
	public Telefono() {
		
	}
	public Telefono(String numero, String operadora) {
		super();
		this.numero = numero;
		this.operadora = operadora;
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

	@Override
	public String toString() {
		return "Telefono [numero=" + numero + ", operadora=" + operadora + "]";
	}
	
	

}


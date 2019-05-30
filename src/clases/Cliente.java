package clases;

import java.time.LocalDate;

public class Cliente extends Persona {
	private boolean esVip;

	public boolean isEsVip() {
		return esVip;
	}

	public void setEsVip(boolean esVip) {
		this.esVip = esVip;
	}

	private static final long serialVersionUID = -8584991777121025797L;

	/**
	 * Crea un objeto de la clase cliente
	 * 
	 * @param dni             DNI del cliente
	 * @param nombre          nombre del cliente
	 * @param apellidos       Apellidos del cliente
	 * @param domicilio       Domicilio del cliente
	 * @param fechaNacimiento Fecha de nacimiento del cliente
	 * @param esVip			  Parametro booleano que indica si el cliente es vip o no
	 */
	public Cliente(String dni, String nombre, String apellidos, String domicilio, LocalDate fechaNacimiento,
			boolean esVip) {
		super(dni, nombre, apellidos, domicilio, fechaNacimiento);
		this.esVip = esVip;
	}

	@Override
	public String toString() {
		return "Cliente: " + dni + " " + nombre + " " + apellidos + " " + domicilio + " " + fechaNacimiento
				+ " es vip: " + esVip;
	}

	@Override
	public int compareTo(Persona arg0) {
		return this.getDni().compareTo(arg0.getDni());
	}
}

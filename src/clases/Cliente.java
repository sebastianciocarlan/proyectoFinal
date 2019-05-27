package clases;

import java.time.LocalDate;

public class Cliente extends Persona {
	private boolean esVip;
	private static final long serialVersionUID = -8584991777121025797L;
	public Cliente(String dni, String nombre, String apellidos, String domicilio, LocalDate fechaNacimiento,boolean esVip) {
		super(dni, nombre, apellidos, domicilio, fechaNacimiento);
		this.esVip = esVip;
	}

	@Override
	public String toString() {
		return "Cliente: "+dni+" "+nombre+" "+apellidos+" "+domicilio+" "+fechaNacimiento+" es vip: "+esVip;
	}
	@Override
	public int compareTo(Persona arg0) {
		return this.getDni().compareTo(arg0.getDni());
	}
}

package clases;

import java.time.LocalDate;

public class Trabajador extends Persona {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6524085263806859209L;
	private LocalDate fechaInicioContrato;
	public void setFechaInicioContrato(LocalDate fechaInicioContrato) {
		this.fechaInicioContrato = fechaInicioContrato;
	}
	private String puesto;

	public Trabajador(String dni, String nombre, String apellidos, String domicilio, LocalDate fechaNacimiento, LocalDate fechaInicioContrato,
			String puesto) {
		super(dni, nombre, apellidos, domicilio, fechaNacimiento);
		this.fechaInicioContrato = fechaInicioContrato;
		this.puesto = puesto;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public LocalDate getFechaInicioContrato() {
		return fechaInicioContrato;
	}
	@Override
	public String toString() {
		return "Trabajador"+" "+dni+" "+nombre+" "+apellidos+" "+domicilio+" "+fechaNacimiento+" "+puesto;
	}
	@Override
	public int compareTo(Persona arg0) {
		// TODO Auto-generated method stub
		return this.getDni().compareTo(arg0.getDni());
	}

}

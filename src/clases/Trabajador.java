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

	/**
	 * Crea un objeto de tipo trabajador
	 * 
	 * @param dni                 Dni del trabajador
	 * @param nombre              Nombre del trabajador
	 * @param apellidos           Apellidos del trabajador
	 * @param domicilio           Domicilio del trabajador
	 * @param fechaNacimiento     Fecha de nacimiento del trabajador (LOCALDATE)
	 * @param fechaInicioContrato Fecha de inicio de contrato
	 * @param puesto              Puesto de inicio del trabajador
	 */
	public Trabajador(String dni, String nombre, String apellidos, String domicilio, LocalDate fechaNacimiento,
			LocalDate fechaInicioContrato, String puesto) {
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
	/**
	 * Devuelve el trrabajador con todos sus datos
	 */
	@Override
	public String toString() {
		return "Trabajador" + " " + dni + " " + nombre + " " + apellidos + " " + domicilio + " " + fechaNacimiento + " "
				+ puesto;
	}

	@Override
	public int compareTo(Persona arg0) {
		// TODO Auto-generated method stub
		return this.getDni().compareTo(arg0.getDni());
	}

}

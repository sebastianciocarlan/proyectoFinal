package clases;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Persona implements Serializable, Comparable<Persona> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8723637178463957828L;

	protected String dni;
	protected String nombre;
	protected String apellidos;
	protected String domicilio;
	protected LocalDate fechaNacimiento;
	
	public Persona(String dni, String nombre, String apellidos,String domicilio,LocalDate fechaNacimiento){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos= apellidos;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}

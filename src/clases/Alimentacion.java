package clases;

import java.time.LocalDate;

public class Alimentacion extends Producto {

	private static final long serialVersionUID = 2202538231459337679L;
	private String alergenos;
	private String ingredientes;
	private LocalDate fechaCaducidad;

	/**
	 * Crea un objeto de un producto de tipo alimentacion
	 * 
	 * @param precio         Precio en double del producto (Euros)
	 * @param marca          Marca del producto
	 * @param nombreProducto Nombre del producto
	 * @param codigoBarras   Codigo de barras del producto
	 * @param alergenos		 Alergenos del producto
	 * @param ingredientes	 Ingredientes del producto
	 * @param fechaCaducidad Fecha de caducidad del producto
	 */
	public Alimentacion(double precio, String marca, String nombreProducto, String codigoBarras, String alergenos,
			String ingredientes, LocalDate fechaCaducidad) {
		super(precio, marca, nombreProducto, codigoBarras);
		this.alergenos = alergenos;
		this.fechaCaducidad = fechaCaducidad;
		this.ingredientes = ingredientes;
		this.fechaCaducidad = fechaCaducidad;
	}

	@Override
	/**
	 * Devuelve los valores de un producto de alimentacion. (Todos)
	 */
	public String toString() {
		return "Alimentacion " + alergenos + " " + ingredientes + " " + fechaCaducidad + " " + codigoBarras + ' '
				+ marca + ' ' + nombreProducto + ' ' + precio;
	}

	@Override
	public int compareTo(Producto arg0) {
		return this.getCodigoBarras().compareTo(arg0.getCodigoBarras());

	}

	public String getAlergenos() {
		return alergenos;
	}

	public void setAlergenos(String alergenos) {
		this.alergenos = alergenos;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

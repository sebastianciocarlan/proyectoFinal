package clases;

import java.io.Serializable;

public abstract class Producto implements Serializable,Comparable<Producto>  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4674994708762564702L;
	protected double precio;
	protected String marca;
	protected String nombreProducto;
	protected String codigoBarras;
	public Producto(double precio, String marca, String nombreProducto, String codigoBarras) {
		this.precio = precio;
		this.marca = marca;
		this.nombreProducto = nombreProducto;
		this.codigoBarras = codigoBarras;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	@Override
	public String toString() {
		return codigoBarras+' '+marca+' '+nombreProducto +' '+precio;
	}
}

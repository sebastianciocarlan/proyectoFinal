package clases;

public class Drogueria extends Producto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8571438713764636964L;
	private String tipo;
	private boolean esImportado;

	public Drogueria(double precio, String marca, String nombreProducto, String codigoBarras, String tipo,
			boolean esImportado) {
		super(precio, marca, nombreProducto, codigoBarras);
		this.tipo = tipo;
		this.esImportado = esImportado;
	}

	@Override
	public String toString() {
		return "Drogueria " + tipo + " EsImportado: " + esImportado + " " + codigoBarras + ' ' + marca + ' '
				+ nombreProducto + ' ' + precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isEsImportado() {
		return esImportado;
	}

	public void setEsImportado(boolean esImportado) {
		this.esImportado = esImportado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int compareTo(Producto arg0) {
		// TODO Auto-generated method stub
		return this.getCodigoBarras().compareTo(arg0.getCodigoBarras());
	}

}

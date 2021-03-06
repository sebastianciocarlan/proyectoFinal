package clases;

public class Factura implements Comparable<Factura> {

	private String dniDependiente;
	private String idFactura;
	private String dniCliente;

	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	/**
	 * Crea un objeto de tipo factura
	 * 
	 * @param idFactura   Id Alfanumerico de la factura
	 * @param dependiente DNI del dependiente
	 * @param cliente     Dni del cliente
	 */
	public Factura(String idFactura, String dependiente, String cliente) {
		this.dniDependiente = dependiente;
		this.idFactura = idFactura;
		this.dniCliente = cliente;
	}
	/**
	 * Devuelve una factura con todos sus datos
	 */
	@Override
	public String toString() {
		return "Id factura: " + idFactura + " Dependiente: " + dniDependiente + " Cliente: " + dniCliente;

	}

	@Override
	public int compareTo(Factura o) {
		// TODO Auto-generated method stub
		return this.idFactura.compareTo(o.getIdFactura());
	}

	public String getDependiente() {
		return dniDependiente;
	}

	public void setDependiente(String dependiente) {
		this.dniDependiente = dependiente;
	}

	public String getCliente() {
		return dniCliente;
	}

	public void setCliente(String cliente) {
		this.dniCliente = cliente;
	}

}

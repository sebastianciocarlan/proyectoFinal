package clases;



public class Factura implements Comparable<Factura>{
	
	private String dependiente;
	private String idFactura;
	private String cliente;

	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public Factura(String idFactura, String dependiente, String cliente) {
		this.dependiente =  dependiente;
		this.idFactura=idFactura;
		this.cliente =  cliente;
	}


	

	
	@Override
	public String toString() {
		return "Id factura: "+idFactura+" Dependiente: "+dependiente+" Cliente: "+cliente;
		
	}
	@Override
	public int compareTo(Factura o) {
		// TODO Auto-generated method stub
		return this.idFactura.compareTo(o.getIdFactura());
	}

	public String getDependiente() {
		return dependiente;
	}

	public void setDependiente(String dependiente) {
		this.dependiente = dependiente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}



}

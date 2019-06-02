package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;

import java.sql.Date;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Sebastian
 *
 */
public class Gestor {
	private Connection conexionBD;
	final private String servidor = "jdbc:mysql://localhost:3306/";
	final private String bbdd = "mercadona?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	final private String user = "root";
	final private String password = "";
	private ArrayList<Persona> personas;
	private ArrayList<Producto> productos;
	private ArrayList<Factura> facturas;

	/**
	 * Constructor de la clase gestor (Que controla todo el programa)
	 */
	public Gestor() {
		personas = new ArrayList<Persona>();
		productos = new ArrayList<Producto>();
		facturas = new ArrayList<Factura>();
	}

	
	/**
	 * A�ade un trabajador a la lista de personas, especificando una fecha de inicio
	 * de contrato
	 * 
	 * @param dni                 Dni intorducido en formato XXXXXXXXXL o NIE en
	 *                            formato LXXXXXXXXL
	 * @param nombre              Nombre de pila
	 * @param apellidos           Apellidos
	 * @param domicilio           Domicilio completo ( Calle / Avenida incluido)
	 * @param fechaNacimiento     Fecha de nacimiento en formato LocalDate
	 * @param fechaInicioContrato Fecha de inicio contrato en formato LocalDate
	 * @param puesto              Puesto del trabajador
	 */
	public void addTrabajador(String dni, String nombre, String apellidos, String domicilio, LocalDate fechaNacimiento,
			LocalDate fechaInicioContrato, String puesto) {
		personas.add(new Trabajador(dni, nombre, apellidos, domicilio, fechaNacimiento, fechaInicioContrato, puesto));
		Collections.sort(personas);
	}

	/**
	 * Anyade un cliente a la lista de personas
	 * 
	 * @param dni             Dni intorducido en formato XXXXXXXXXL o NIE en formato
	 *                        LXXXXXXXXL
	 * @param nombre          Nombre de pila
	 * @param apellidos       Apellidos
	 * @param domicilio       Domicilio completo ( Calle / Avenida incluido)
	 * @param fechaNacimiento Fecha de nacimiento en formato LocalDate
	 * @param esVip           Boolean que almacena si es vip
	 */

	public void addCliente(String dni, String nombre, String apellidos, String domicilio, LocalDate fechaNacimiento,
			boolean esVip) {
		personas.add(new Cliente(dni, nombre, apellidos, domicilio, fechaNacimiento, esVip));
		Collections.sort(personas);
	}

	/**
	 * A�ade un producto de tipo alimentacion
	 * 
	 * @param precio         Precio del producto
	 * @param marca          Marca del producto
	 * @param nombreProducto Nombre del producto
	 * @param codigoBarras   Codigo de barras alfanumerico del producto
	 * @param alergenos      Alergenos del producto alimentario
	 * @param ingredientes   Ingredientes principales del producto
	 * @param fechaCaducidad Fecha de caducidad del producto indicado en LocalDate
	 */
	public void addAlimentacion(double precio, String marca, String nombreProducto, String codigoBarras,
			String alergenos, String ingredientes, LocalDate fechaCaducidad) {
		productos.add(
				new Alimentacion(precio, marca, nombreProducto, codigoBarras, alergenos, ingredientes, fechaCaducidad));
		Collections.sort(productos);
	}

	/**
	 * A�ade un producto de tipo drogueria
	 * 
	 * @param precio         Precio del producto
	 * @param marca          Marca del producto
	 * @param nombreProducto Nombre del producto
	 * @param codigoBarras   Codigo de barras alfanumerico del producto
	 * @param tipo           Tipo del producto (Champu,gel,colonia...)
	 * @param esImportado    True si es importado, false si no.
	 */
	public void addDrogueria(double precio, String marca, String nombreProducto, String codigoBarras, String tipo,
			boolean esImportado) {
		productos.add(new Drogueria(precio, marca, nombreProducto, codigoBarras, tipo, esImportado));
		Collections.sort(productos);
	}

	/**
	 * Crea una factura y la añade al ArrayList
	 * 
	 * @param dniCliente     Dni del cliente
	 * @param dniDependiente Dni del dependiente
	 * @param idFactura      Id alfanumerico de la factura
	 */
	public void addFactura(String dniCliente, String dniDependiente, String idFactura) {

		facturas.add(new Factura(idFactura, dniDependiente, dniCliente));
		Collections.sort(facturas);

	}

	/**
	 * Modifica una factura
	 * 
	 * @param dniCliente    Dni del cliente a modificar
	 * @param dniTrabajador Dni del trabajador a modificar
	 * @param idFactura     idFactura de la factura
	 */
	public void modFactura(String dniCliente, String dniTrabajador, String idFactura) {
		for (Factura fact : facturas) {
			if (fact.getIdFactura().equals(idFactura)) {
				fact.setCliente(dniCliente);
				fact.setDependiente(dniTrabajador);

			}
		}
	}

	/**
	 * Modifica un cliente indicando un dni
	 * 
	 * @param dni             de la persona a buscar
	 * @param nombre          modificado
	 * @param apellidos       modificados
	 * @param domicilio       modificado
	 * @param fechaNacimiento modificada
	 * @param esVip           modificado
	 */
	public void modCliente(String dni, String nombre, String apellidos, String domicilio, LocalDate fechaNacimiento,
			Boolean esVip) {
		for (Persona cliente : personas) {
			if (cliente.getDni().equals(dni)) {
				cliente.setNombre(nombre);
				cliente.setApellidos(apellidos);
				cliente.setDomicilio(domicilio);
				cliente.setFechaNacimiento(fechaNacimiento);
				((Cliente) cliente).setEsVip(esVip);
			}
		}
	}

	/**
	 * Modifica un trabajador indicando un dni
	 * 
	 * @param dni                 Dni por el cual se busca
	 * @param nombre              Nombre del trabajador modificado
	 * @param apellidos           Apellidos del trabajador modificado
	 * @param domicilio           Domicilio modificado del trabajador
	 * @param fechaNacimiento     Fecha nacimiento en LocalDate modificado
	 * @param puesto              Puesto modificado
	 * @param fechaInicioContrato Fecha de inicio de contrato
	 */
	public void modTrabajador(String dni, String nombre, String apellidos, String domicilio, LocalDate fechaNacimiento,
			LocalDate fechaInicioContrato, String puesto) {
		for (Persona trabajador : personas) {
			if (trabajador.getDni().equals(dni)) {
				trabajador.setNombre(nombre);
				trabajador.setApellidos(apellidos);
				trabajador.setDomicilio(domicilio);
				trabajador.setFechaNacimiento(fechaNacimiento);
				((Trabajador) trabajador).setPuesto(puesto);
				((Trabajador) trabajador).setFechaInicioContrato(fechaInicioContrato);
			}
		}
	}

	/**
	 * Modifica un producto de alimentacion
	 * 
	 * @param codigoBarras   codigo barras por el cual se busca
	 * @param marca          Marca modificad
	 * @param nombreProducto Nombre producto modificado
	 * @param precio         Precio double modificado
	 * @param alergenos      Alergenos modificados
	 * @param fechaCaducidad Fecha caducidad modificada
	 * @param ingredientes   Ingredientes modificados
	 */
	public void modAlimentacion(String codigoBarras, String marca, String nombreProducto, double precio,
			String alergenos, LocalDate fechaCaducidad, String ingredientes) {
		for (Producto alimentacion : productos) {
			if ((alimentacion instanceof Alimentacion) && (alimentacion.getCodigoBarras().equals(codigoBarras))) {
				alimentacion.setMarca(marca);
				alimentacion.setNombreProducto(nombreProducto);
				alimentacion.setPrecio(precio);
				((Alimentacion) alimentacion).setAlergenos(alergenos);
				((Alimentacion) alimentacion).setFechaCaducidad(fechaCaducidad);
				((Alimentacion) alimentacion).setIngredientes(ingredientes);
			}
		}
	}

	/**
	 * modifica un producto de drogueria
	 * 
	 * @param codigoBarras   codigo barras por el cual se busca
	 * @param marca          Marca modificad
	 * @param nombreProducto Nombre producto modificado
	 * @param precio         Precio double modificado
	 * @param esImportado    Boolean esImportado modificado
	 * @param tipo           Tipo de producto de drogueria modificado
	 */
	public void modDrogueria(String codigoBarras, String marca, String nombreProducto, double precio,
			boolean esImportado, String tipo) {
		for (Producto drogueria : productos) {
			if ((drogueria instanceof Alimentacion) && (drogueria.getCodigoBarras().equals(codigoBarras))) {
				drogueria.setMarca(marca);
				drogueria.setNombreProducto(nombreProducto);
				drogueria.setPrecio(precio);
				((Drogueria) drogueria).setEsImportado(esImportado);
				((Drogueria) drogueria).setTipo(tipo);
			}
		}
	}

	/**
	 * Busca una persona en el arraylist y la devuelve
	 * 
	 * @param dni Dni de la persona a buscar
	 * @return devuelve una persona (Objeto)
	 */
	public Persona buscarPersona(String dni) {
		for (Persona persona : personas) {
			if (persona.getDni().equals(dni)) {
				return (persona);
			}

		}
		return null;
	}

	/**
	 * Busca un producto en el arraylist y la devuelve
	 * 
	 * @param codigoBarras Codigo de barras del producto a buscar
	 * @return devuelve un producto (Objeto)
	 */
	public Producto buscarProducto(String codigoBarras) {
		for (Producto producto : productos) {
			if (producto.getCodigoBarras().equals(codigoBarras)) {
				return (producto);
			}

		}
		return null;
	}

	/**
	 * Borra una persona de la lista de personas
	 * 
	 * @param dni Dni de la persona a eliminar
	 */
	public void delPersona(String dni) {
		personas.remove(buscarPersona(dni));
		Collections.sort(personas);
	}

	/**
	 * Borra un producto por su codigo de barras
	 * 
	 * @param codBarras CodBarras del producto a eliminar
	 */
	public void delProducto(String codBarras) {
		productos.remove(buscarProducto(codBarras));
		Collections.sort(productos);
	}

	/**
	 * Borra una factura
	 * 
	 * @param idFactura idFactura a eliminar
	 */
	public void delFactura(String idFactura) {
		for (Factura factura : facturas) {
			if (factura.getIdFactura().equals(idFactura)) {
				facturas.remove(factura);
			}
		}

	}

	/**
	 * Conecta una base de datos
	 */
	public void conectarBaseDatos() {
		try {
			conexionBD = DriverManager.getConnection(servidor + bbdd, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Descarga la base de datos
	 */
	public void cargarBaseDatos() {
		String sentencia = "SELECT dni,nombre,apellidos,domicilio,fechaNacimiento,esVip FROM clientes";
		PreparedStatement sentenciaStat;
		try {
			sentenciaStat = conexionBD.prepareStatement(sentencia);
			ResultSet resultado = sentenciaStat.executeQuery();
			while (resultado.next()) {
				addCliente(resultado.getString(1), resultado.getString(2), resultado.getString(3),
						resultado.getString(4), resultado.getDate(5).toLocalDate(), resultado.getBoolean(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sentencia = "SELECT dni,nombre,apellidos,domicilio,fechaNacimiento,fechaInicioContrato,puesto FROM trabajadores";
		try {
			sentenciaStat = conexionBD.prepareStatement(sentencia);
			ResultSet resultado = sentenciaStat.executeQuery();
			while (resultado.next()) {
				addTrabajador(resultado.getString(1), resultado.getString(2), resultado.getString(3),
						resultado.getString(4), resultado.getDate(5).toLocalDate(), resultado.getDate(6).toLocalDate(),
						resultado.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Comprueba si el login introducido es correcto
	 * 
	 * @param usuario    Usuario dentro de la base de datos para el login
	 * @param contrasena Contrasena del usuario dentro de la base de datos
	 * @return devuelve true si el usuario y la contrasena se encuentran en la base
	 *         de datos
	 */
	public boolean comprobarLogin(String usuario, String contrasena) {
		String sentencia = "SELECT user, password from login";
		try {
			PreparedStatement sentenciaStat = conexionBD.prepareStatement(sentencia);
			ResultSet resultado = sentenciaStat.executeQuery();
			while (resultado.next()) {
				if (resultado.getString(1).equals(usuario) && resultado.getString(2).equals(contrasena)) {
					return true;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Devuelve si ya hay un cliente con el dni en la base de datos
	 * 
	 * @param dni Dni del cliente a buscar
	 * @return Devuelve boolean en funcion si lo encuentra en la base de datos o no
	 */
	public boolean comprobarDniCliente(String dni) {
		String sentencia = "SELECT dni from clientes";
		try {
			PreparedStatement sentenciaStat = conexionBD.prepareStatement(sentencia);
			ResultSet resultado = sentenciaStat.executeQuery();
			while (resultado.next()) {
				if (resultado.getString(1).equals(dni)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Deveuelve si ya hay un trabajador con el dni indicado en la base de datos
	 * 
	 * @param dni Dni del trabajador a buscar
	 * @return Devuelve boolean en funcion si lo encuentra en la base de datos o no
	 */
	public boolean comprobarDniTrabajador(String dni) {
		String sentencia = "SELECT dni from trabajadores";
		try {
			PreparedStatement sentenciaStat = conexionBD.prepareStatement(sentencia);
			ResultSet resultado = sentenciaStat.executeQuery();
			while (resultado.next()) {
				if (resultado.getString(1).equals(dni)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Sube las listas a la base de datos
	 */
	public void guardarBaseDatos() {

		try {
			for (Persona cliente : personas) {
				if (cliente instanceof Cliente && !(comprobarDniCliente(cliente.getDni()))) {
					String sentenciaSQL = "INSERT INTO clientes(dni,nombre,apellidos,domicilio,fechaNacimiento) VALUES (?,?,?,?)";
					PreparedStatement sentencia = conexionBD.prepareStatement(sentenciaSQL);
					sentencia.setString(1, cliente.getDni());
					sentencia.setString(2, cliente.getNombre());
					sentencia.setString(3, cliente.getApellidos());
					sentencia.setString(4, cliente.getDomicilio());
					sentencia.setDate(5, Date.valueOf((cliente.getFechaNacimiento())));
					sentencia.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			for (Persona trabajador : personas) {
				if (trabajador instanceof Trabajador && !(comprobarDniTrabajador(trabajador.getDni()))) {
					String sentenciaSQL = "INSERT INTO clientes(dni,nombre,apellidos,domicilio,fechaNacimiento,fechaInicioContrato,puesto) VALUES (?,?,?,?,?,?)";
					PreparedStatement sentencia = conexionBD.prepareStatement(sentenciaSQL);
					sentencia.setString(1, trabajador.getDni());
					sentencia.setString(2, trabajador.getNombre());
					sentencia.setString(3, trabajador.getApellidos());
					sentencia.setString(4, trabajador.getDomicilio());
					sentencia.setDate(5, Date.valueOf((trabajador.getFechaNacimiento())));
					sentencia.setDate(6, Date.valueOf((((Trabajador) trabajador).getFechaInicioContrato())));
					sentencia.setString(7, ((Trabajador) trabajador).getPuesto());
					sentencia.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Apaga la conexion con la base de datos
	 */
	public void desconectarBBDD() {
		try {
			conexionBD.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Almacena en un archivo los datos de los arraylist
	 * 
	 * @param archivo que es devuelto con los datos introducidos
	 */
	public void guardarFichero(File archivo) {
		try {
			ObjectOutputStream ser = new ObjectOutputStream(new FileOutputStream(archivo));
			ser.writeObject(personas);
			ser.writeObject(productos);
			ser.writeObject(facturas);
			ser.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga un archivo y lo introduce en los arraylist
	 * 
	 * @param archivo El archivo que introduces para que cargue en los arraylist
	 */
	@SuppressWarnings("unchecked")
	public void cargarFichero(File archivo) {
		try {
			ObjectInputStream ser = new ObjectInputStream(new FileInputStream(archivo));
			personas = (ArrayList<Persona>) ser.readObject();
			productos = (ArrayList<Producto>) ser.readObject();
			facturas = (ArrayList<Factura>) ser.readObject();
			ser.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

}

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
	 * 
	 * Devuelve trabjadores
	 * 
	 * @return Un string que contiene todos los trabajadores.
	 */
	public String devuelveTrabajadores() {
		String aux = "";
		for (Persona trabajador : personas) {
			if (trabajador instanceof Trabajador) {
				aux = aux + "\n" + trabajador.toString();
			}
		}
		return aux;
	}

	/**
	 * Devuelve productos
	 * 
	 * @return Un string que contiene todos los trabajadores
	 */
	public String devuelveProductos() {
		String aux = "";
		for (Producto producto : productos) {
			aux = aux + "\n" + producto.toString();
		}
		return aux;
	}

	/**
	 * Devuelve clientes
	 * 
	 * @return Un string que contiene todos los trabajadores
	 */
	public String devuelveClientes() {
		String aux = "";
		for (Persona cliente : personas) {
			if (cliente instanceof Cliente) {
				aux = aux + "\n" + cliente.toString();
			}
		}
		return aux;
	}

	public Gestor() {
		personas = new ArrayList<Persona>();
		productos = new ArrayList<Producto>();
		facturas = new ArrayList<Factura>();
	}

	/**
	 * Añade un trabajador a la lista de personas, especificando una fecha de
	 * inicio de contrato
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param domicilio
	 * @param fechaNacimiento
	 * @param fechaInicioContrato
	 * @param puesto
	 */
	public void addTrabajador(String dni, String nombre, String apellidos, String domicilio, LocalDate fechaNacimiento,
			LocalDate fechaInicioContrato, String puesto) {
		personas.add(new Trabajador(dni, nombre, apellidos, domicilio, fechaNacimiento, fechaInicioContrato, puesto));
		Collections.sort(personas);
	}

	/**
	 * Anyade un cliente a la lista de personas
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param domicilio
	 * @param fechaNacimiento
	 */

	public void addCliente(String dni, String nombre, String apellidos, String domicilio, LocalDate fechaNacimiento,
			boolean esVip) {
		personas.add(new Cliente(dni, nombre, apellidos, domicilio, fechaNacimiento, esVip));
		Collections.sort(personas);
	}

	/**
	 * Borra una persona de la lista de personas
	 * 
	 * @param dni
	 */
	public void delPersona(String dni) {
		Persona aux = null;
		for (Persona per : personas) {
			if (per.getDni().equals(dni)) {
				aux = per;
			}

		}
		personas.remove(aux);
		Collections.sort(personas);
	}

	public String buscarPersona(String dni) {
		for (Persona persona : personas) {
			if (persona.getDni().equals(dni)) {
				return (persona.toString());
			}

		}
		return ("NO SE HA ENCONTRADO");
	}

	public String buscarProducto(String codigoBarras) {
		for (Producto producto : productos) {
			if (producto.getCodigoBarras().equals(codigoBarras)) {
				return (producto.toString());
			}

		}
		return ("NO SE HA ENCONTRADO");
	}

	/**
	 * Modifica un cliente indicando un dni
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param domicilio
	 * @param fechaNacimiento
	 */

	public void modCliente(String dni, String nombre, String apellidos, String domicilio, LocalDate fechaNacimiento) {
		for (Persona cliente : personas) {
			if (cliente.getDni().equals(dni)) {
				cliente.setNombre(nombre);
				cliente.setApellidos(apellidos);
				cliente.setDomicilio(domicilio);
				cliente.setFechaNacimiento(fechaNacimiento);
			}
		}
	}

	/**
	 * Modifica un trabajador indicando un dni
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param domicilio
	 * @param fechaNacimiento
	 * @param puesto
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
	 * modifica un producto de alimentacion
	 * 
	 * @param codigoBarras
	 * @param marca
	 * @param nombreProducto
	 * @param precio
	 * @param alergenos
	 * @param fechaCaducidad
	 * @param ingredientes
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
	 * @param codigoBarras
	 * @param marca
	 * @param nombreProducto
	 * @param precio
	 * @param esImportado
	 * @param tipo
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
	 * Añade un producto de tipo alimentacion
	 * 
	 * @param precio
	 * @param marca
	 * @param nombreProducto
	 * @param codigoBarras
	 * @param alergenos
	 * @param ingredientes
	 * @param fechaCaducidad
	 */
	public void addAlimentacion(double precio, String marca, String nombreProducto, String codigoBarras,
			String alergenos, String ingredientes, LocalDate fechaCaducidad) {
		productos.add(
				new Alimentacion(precio, marca, nombreProducto, codigoBarras, alergenos, ingredientes, fechaCaducidad));
		Collections.sort(productos);
	}

	/**
	 * Añade un producto de tipo drogueria
	 * 
	 * @param precio
	 * @param marca
	 * @param nombreProducto
	 * @param codigoBarras
	 * @param tipo
	 * @param esImportado
	 */
	public void addDrogueria(double precio, String marca, String nombreProducto, String codigoBarras, String tipo,
			boolean esImportado) {
		productos.add(new Drogueria(precio, marca, nombreProducto, codigoBarras, tipo, esImportado));
		Collections.sort(productos);
	}

	/**
	 * Borra un producto por su codigo de barras
	 * 
	 * @param codBarras
	 */
	public void delProducto(String codBarras) {
		for (Producto product : productos) {
			if (product.getCodigoBarras().equals(codBarras)) {
				productos.remove(product);
				Collections.sort(productos);
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Comprueba si el login introducido es correcto
	 * 
	 * @param usuario
	 * @param contraseña
	 * @return
	 */
	public boolean comprobarLogin(String usuario, String contraseña) {
		String sentencia = "SELECT user, password from login";
		try {
			PreparedStatement sentenciaStat = conexionBD.prepareStatement(sentencia);
			ResultSet resultado = sentenciaStat.executeQuery();
			while (resultado.next()) {
				if (resultado.getString(1).equals(usuario) && resultado.getString(2).equals(contraseña)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Devuelve si ya hay un cliente con el dni en la base de datos
	 * 
	 * @param dni
	 * @return
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Deveuelve si ya hay un trabajador con el dni indicado en la base de datos
	 * 
	 * @param dni
	 * @return
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * apaga la conexion con la base de datos
	 */
	public void desconectarBBDD() {
		try {
			conexionBD.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void guardarFichero(File archivo) {
		try {
			ObjectOutputStream ser = new ObjectOutputStream(new FileOutputStream(archivo));
			ser.writeObject(personas);
			ser.writeObject(productos);
			ser.writeObject(facturas);
			ser.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void cargarFichero(File archivo) {
		try {
			ObjectInputStream ser = new ObjectInputStream(new FileInputStream(archivo));
			personas = (ArrayList<Persona>) ser.readObject();
			productos = (ArrayList<Producto>) ser.readObject();
			facturas = (ArrayList<Factura>) ser.readObject();
			ser.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * muestra facturas de un cliente
	 * 
	 * @param dniCliente
	 * @return
	 */
	public String mostrarFacturasCliente(String dniCliente) {
		String aux = "";
		for (Factura factura : facturas) {
			if (factura.getCliente().equals(dniCliente)) {
				aux = aux + factura.toString();
			}
		}
		return aux;
	}

	/**
	 * crea una factura
	 * 
	 * @param dniCliente
	 * @param dniDependiente
	 * @param idFactura
	 */
	public void crearFactura(String dniCliente, String dniDependiente, String idFactura) {
		facturas.add(new Factura(idFactura, dniDependiente, dniCliente));
		Collections.sort(facturas);

	}

	/**
	 * borra una factura
	 * 
	 * @param idFactura
	 */
	public void delFactura(String idFactura) {
		for (Factura factura : facturas) {
			if (factura.getIdFactura().equals(idFactura)) {
				facturas.remove(factura);
			}
		}

	}

	/**
	 * muestra todas las facturas
	 * 
	 * @return
	 */
	public String mostrarFacturas() {
		String aux = "";
		for (Factura factura : facturas) {
			aux = aux + "\n" + factura.toString();
		}
		return aux;
	}

	/**
	 * modifica una factura
	 * 
	 * @param cliente
	 * @param trabajador
	 * @param factura
	 */
	public void modFactura(String cliente, String trabajador, String factura) {
		for (Factura fact : facturas) {
			if (fact.getIdFactura().equals(factura)) {
				fact.setCliente(cliente);
				fact.setDependiente(trabajador);

			}
		}
	}
}

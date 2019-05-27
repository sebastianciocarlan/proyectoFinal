package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Gestor;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 2654200120836949397L;
	private JPanel contentPane;
	private JMenuItem mntmEnviarDatos;
	private JMenuItem mntmRecibirDatos;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnArchivo = new JMenu("Archivo");
	private JMenuItem mntmCargar = new JMenuItem("Cargar ");
	private JMenuItem mntmGuardarFichero = new JMenuItem("Guardar ");
	private JMenu mnBaseDeDatos = new JMenu("Base de datos");
	private JButton btnAltaTrabajador = new JButton("Alta Trabajador");
	private JButton btnAltaCliente = new JButton("Alta Cliente");
	private JButton btnBorrarProducto = new JButton("Borrar Producto");
	private JButton btnBorrarPersona = new JButton("Borrar Persona");
	private JButton btnAadirProductoDrogueria = new JButton("A\u00F1adir Producto Drogueria");
	private JButton btnAadirProductoAlimentacion = new JButton("A\u00F1adir Producto Alimentacion");
	private JButton btnMostrarProductos = new JButton("Mostrar productos");
	private JButton btnModificarTrabajador = new JButton("Modificar Trabajador");
	private JButton btnModificarCliente = new JButton("Modificar Cliente");
	private JButton btnAddFactura = new JButton("A\u00F1adir factura a cliente");
	private JSeparator separator_1 = new JSeparator();
	private JSeparator separator = new JSeparator();
	private JButton btnEliminarFactura = new JButton("Eliminar Factura");
	private JButton btnMostrarClientes = new JButton("Mostrar clientes");
	private final JButton btnListarFacturas = new JButton("Listar facturas usuario");
	private final JButton btnListarProductosFacturas = new JButton("Listar facturas ");
	private final JButton btnMostrarTrabajadores = new JButton("Mostrar trabajadores");
	private final JButton btnModificarFactura = new JButton("Modificar factura");
	private final JButton btnModAlimentacion = new JButton("Modificar alimentacion");
	private final JButton btnModDrogueria = new JButton("Modificar drogueria");
	private final JButton btnBuscarPersona = new JButton("Buscar Persona");
	private final JButton btnBuscarProducto = new JButton("Buscar Producto");
	private JMenuItem mntmCerrarBaseDatos = new JMenuItem("Cerrar base datos");

	public VentanaPrincipal(Gestor gestor) {
		inicializarGraficos();
		handlers(gestor);
	}

	public void handlers(Gestor gestor) {
		btnModificarTrabajador.setBackground(Color.WHITE);
		btnModificarTrabajador.setForeground(Color.BLACK);
		btnModificarTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ModTrabajador dialog = new ModTrabajador(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		mntmGuardarFichero.setBackground(Color.WHITE);
		mntmGuardarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser selector = new JFileChooser();

				int opcion = selector.showSaveDialog(null);
				if (opcion == JFileChooser.APPROVE_OPTION) { // Ha pulsado “Aceptar”
					File fichero = selector.getSelectedFile();
					gestor.guardarFichero(fichero);
				}
			}
		});
		mntmCargar.setBackground(Color.WHITE);
		mntmCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser selector = new JFileChooser();

				int opcion = selector.showOpenDialog(null);
				if (opcion == JFileChooser.APPROVE_OPTION) { // Ha pulsado “Aceptar”
					File fichero = selector.getSelectedFile();
					gestor.cargarFichero(fichero);
				}

			}
		});
		btnEliminarFactura.setBackground(Color.WHITE);
		btnEliminarFactura.setForeground(Color.BLACK);
		btnEliminarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BorrarFactura dialog = new BorrarFactura(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnMostrarClientes.setBackground(Color.WHITE);
		btnMostrarClientes.setForeground(Color.BLACK);
		btnMostrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MostrarClientes dialog = new MostrarClientes(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnAadirProductoDrogueria.setBackground(Color.WHITE);
		btnAadirProductoDrogueria.setForeground(Color.BLACK);
		btnAadirProductoDrogueria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AltaDrogueria dialog = new AltaDrogueria(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}

		});
		btnAltaTrabajador.setBackground(Color.WHITE);
		btnAltaTrabajador.setForeground(Color.BLACK);
		btnAltaTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AltaTrabajador dialog = new AltaTrabajador(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		mntmEnviarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestor.guardarBaseDatos();
			}
		});
		mntmRecibirDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor.cargarBaseDatos();
			}
		});
		btnBorrarPersona.setBackground(Color.WHITE);
		btnBorrarPersona.setForeground(Color.BLACK);
		btnBorrarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BorrarPersona frame = new BorrarPersona(gestor);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAltaCliente.setBackground(Color.WHITE);
		btnAltaCliente.setForeground(Color.BLACK);
		btnAltaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AltaCliente frame = new AltaCliente(gestor);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAadirProductoAlimentacion.setBackground(Color.WHITE);
		btnAadirProductoAlimentacion.setForeground(Color.BLACK);
		btnAadirProductoAlimentacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AltaAlimentacion dialog = new AltaAlimentacion(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnMostrarProductos.setBackground(Color.WHITE);
		btnMostrarProductos.setForeground(Color.BLACK);
		btnMostrarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MostrarProductos dialog = new MostrarProductos(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnListarFacturas.setBackground(Color.WHITE);
		btnListarFacturas.setForeground(Color.BLACK);
		btnListarFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ListarFacturas dialog = new ListarFacturas(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnBorrarProducto.setBackground(Color.WHITE);
		btnBorrarProducto.setForeground(Color.BLACK);
		btnBorrarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BorrarProducto dialog = new BorrarProducto(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnModificarCliente.setBackground(Color.WHITE);
		btnModificarCliente.setForeground(Color.BLACK);
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ModCliente dialog = new ModCliente(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnMostrarTrabajadores.setBackground(Color.WHITE);
		btnMostrarTrabajadores.setForeground(Color.BLACK);
		btnMostrarTrabajadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MostrarTrabajador dialog = new MostrarTrabajador(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnModAlimentacion.setBackground(Color.WHITE);
		btnModAlimentacion.setForeground(Color.BLACK);
		btnModAlimentacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ModAlimentacion dialog = new ModAlimentacion(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnModDrogueria.setBackground(Color.WHITE);
		btnModDrogueria.setForeground(Color.BLACK);
		btnModDrogueria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ModDrogueria dialog = new ModDrogueria(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BuscarProducto dialog = new BuscarProducto(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnBuscarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BuscarPersona dialog = new BuscarPersona(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}	
			}
		});
		btnAddFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CrearFactura dialog = new CrearFactura(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}	
			}
		});
		mntmCerrarBaseDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			gestor.desconectarBBDD();
			}
		});
		btnListarProductosFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ListarFacturasUsuario dialog = new ListarFacturasUsuario(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnModificarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ModFactura dialog = new ModFactura(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
	}

	public void inicializarGraficos() {
		setTitle("Marcadone");
		setBackground(new Color(152, 251, 152));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 690);
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		mnArchivo.setBackground(Color.WHITE);
		menuBar.add(mnArchivo);

		mnArchivo.add(mntmGuardarFichero);

		mnArchivo.add(mntmCargar);
		mnBaseDeDatos.setBackground(Color.WHITE);
		menuBar.add(mnBaseDeDatos);
		mntmEnviarDatos = new JMenuItem("Enviar datos");
		mntmEnviarDatos.setBackground(Color.WHITE);

		mnBaseDeDatos.add(mntmEnviarDatos);
		mntmRecibirDatos = new JMenuItem("Recibir datos");
		mntmRecibirDatos.setBackground(Color.WHITE);

		mnBaseDeDatos.add(mntmRecibirDatos);
		


		mntmCerrarBaseDatos.setBackground(Color.WHITE);
		mnBaseDeDatos.add(mntmCerrarBaseDatos);
		contentPane = new JPanel();
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAltaTrabajador.setBounds(10, 95, 428, 23);
		contentPane.add(btnAltaTrabajador);

		btnAltaCliente.setBounds(10, 61, 428, 23);
		contentPane.add(btnAltaCliente);

		btnBorrarPersona.setBounds(10, 27, 210, 23);
		contentPane.add(btnBorrarPersona);
		
		btnBorrarProducto.setBounds(10, 285, 210, 23);
		contentPane.add(btnBorrarProducto);

		btnAadirProductoDrogueria.setBounds(10, 421, 428, 23);
		contentPane.add(btnAadirProductoDrogueria);

		btnAadirProductoAlimentacion.setBounds(10, 387, 428, 23);
		contentPane.add(btnAadirProductoAlimentacion);
		separator.setBounds(10, 272, 428, 2);
		contentPane.add(separator);

		btnModificarTrabajador.setBounds(10, 129, 428, 23);
		contentPane.add(btnModificarTrabajador);

		btnModificarCliente.setBounds(10, 163, 428, 23);
		contentPane.add(btnModificarCliente);

		btnAddFactura.setBackground(Color.WHITE);
		btnAddFactura.setForeground(Color.BLACK);
		btnAddFactura.setBounds(8, 606, 430, 23);
		contentPane.add(btnAddFactura);
		separator_1.setBounds(10, 455, 428, 2);
		contentPane.add(separator_1);

		btnEliminarFactura.setBounds(10, 570, 428, 23);
		contentPane.add(btnEliminarFactura);

		btnMostrarClientes.setBounds(10, 197, 428, 23);
		contentPane.add(btnMostrarClientes);

		btnMostrarProductos.setBounds(10, 319, 428, 23);
		contentPane.add(btnMostrarProductos);

		btnListarFacturas.setBounds(10, 536, 428, 23);
		
		contentPane.add(btnListarFacturas);

		btnListarProductosFacturas.setBackground(Color.WHITE);
		btnListarProductosFacturas.setForeground(Color.BLACK);
		btnListarProductosFacturas.setBounds(10, 502, 428, 23);
		
		contentPane.add(btnListarProductosFacturas);

		btnMostrarTrabajadores.setBounds(10, 231, 428, 23);
		
		contentPane.add(btnMostrarTrabajadores);

		btnModificarFactura.setBackground(Color.WHITE);
		btnModificarFactura.setForeground(Color.BLACK);
		btnModificarFactura.setBounds(10, 468, 428, 23);
		
		contentPane.add(btnModificarFactura);

		btnModAlimentacion.setBounds(10, 353, 210, 23);
		
		contentPane.add(btnModAlimentacion);

		btnModDrogueria.setBounds(228, 353, 210, 23);
		
		contentPane.add(btnModDrogueria);

		btnBuscarPersona.setBackground(Color.WHITE);
		btnBuscarPersona.setBounds(230, 27, 208, 23);
		
		contentPane.add(btnBuscarPersona);

		btnBuscarProducto.setBackground(Color.WHITE);
		btnBuscarProducto.setBounds(230, 285, 208, 23);
		
		contentPane.add(btnBuscarProducto);
	}
}

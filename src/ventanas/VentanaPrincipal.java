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
	private JButton btnAltaTrabajador = new JButton("Alta trabajador");
	private JButton btnAltaCliente = new JButton("Alta cliente");
	private JButton btnBorrarProducto = new JButton("Borrar producto");
	private JButton btnBorrarPersona = new JButton("Borrar persona");
	private JButton btnAadirProductoDrogueria = new JButton("A\u00F1adir producto drogueria");
	private JButton btnAadirProductoAlimentacion = new JButton("A\u00F1adir producto alimentacion");
	private JButton btnMostrarProductos = new JButton("Mostrar productos");
	private JButton btnModificarTrabajador = new JButton("Modificar trabajador");
	private JButton btnModificarCliente = new JButton("Modificar cliente");
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
	private final JButton btnBuscarPersona = new JButton("Buscar persona");
	private final JButton btnBuscarProducto = new JButton("Buscar producto");
	private JMenuItem mntmCerrarBaseDatos = new JMenuItem("Cerrar base datos");
	private JButton btnMostrarPersonas;
	private JButton btnMostrarDrogueria;
	private JButton btnMostrarAlimentacion;
	/**
	 * Crea la ventana principal.
	 * 
	 * @param gestor El gestor del programa
	 */
	public VentanaPrincipal(Gestor gestor) {
		inicializarGraficos();
		handlers(gestor);
	}

	private void handlers(Gestor gestor) {
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
				if (opcion == JFileChooser.APPROVE_OPTION) { // Ha pulsado �Aceptar�
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
				if (opcion == JFileChooser.APPROVE_OPTION) { // Ha pulsado �Aceptar�
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
					ListarClientes dialog = new ListarClientes(gestor);
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
					ListarProductos dialog = new ListarProductos(gestor);
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
					ListarFacturasCliente dialog = new ListarFacturasCliente(gestor);
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
					ListarTrabajador dialog = new ListarTrabajador(gestor);
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
					AltaFactura dialog = new AltaFactura(gestor);
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
					ListarFacturas dialog = new ListarFacturas(gestor);
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
		btnMostrarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ListarPersonas dialog = new ListarPersonas(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnMostrarAlimentacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ListarAlimentacion dialog = new ListarAlimentacion(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnMostrarDrogueria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ListarDrogueria dialog = new ListarDrogueria(gestor);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
	}

	private void inicializarGraficos() {
		setTitle("Mercadona pero mal");
		setBackground(new Color(152, 251, 152));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 818);
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
		
		btnBorrarProducto.setBounds(10, 489, 210, 23);
		contentPane.add(btnBorrarProducto);

		btnAadirProductoDrogueria.setBounds(10, 453, 428, 23);
		contentPane.add(btnAadirProductoDrogueria);

		btnAadirProductoAlimentacion.setBounds(10, 419, 428, 23);
		contentPane.add(btnAadirProductoAlimentacion);
		separator.setBounds(10, 304, 428, 2);
		contentPane.add(separator);

		btnModificarTrabajador.setBounds(10, 129, 428, 23);
		contentPane.add(btnModificarTrabajador);

		btnModificarCliente.setBounds(10, 163, 428, 23);
		contentPane.add(btnModificarCliente);

		btnAddFactura.setBackground(Color.WHITE);
		btnAddFactura.setForeground(Color.BLACK);
		btnAddFactura.setBounds(8, 606, 430, 23);
		contentPane.add(btnAddFactura);
		separator_1.setBounds(10, 557, 428, 2);
		contentPane.add(separator_1);

		btnEliminarFactura.setBounds(10, 570, 428, 23);
		contentPane.add(btnEliminarFactura);

		btnMostrarClientes.setBounds(10, 197, 428, 23);
		contentPane.add(btnMostrarClientes);

		btnMostrarProductos.setBounds(10, 351, 428, 23);
		contentPane.add(btnMostrarProductos);

		btnListarFacturas.setBounds(10, 708, 428, 23);
		
		contentPane.add(btnListarFacturas);

		btnListarProductosFacturas.setBackground(Color.WHITE);
		btnListarProductosFacturas.setForeground(Color.BLACK);
		btnListarProductosFacturas.setBounds(10, 674, 428, 23);
		
		contentPane.add(btnListarProductosFacturas);

		btnMostrarTrabajadores.setBounds(10, 231, 428, 23);
		
		contentPane.add(btnMostrarTrabajadores);

		btnModificarFactura.setBackground(Color.WHITE);
		btnModificarFactura.setForeground(Color.BLACK);
		btnModificarFactura.setBounds(10, 640, 428, 23);
		
		contentPane.add(btnModificarFactura);

		btnModAlimentacion.setBounds(10, 523, 210, 23);
		
		contentPane.add(btnModAlimentacion);

		btnModDrogueria.setBounds(230, 523, 210, 23);
		
		contentPane.add(btnModDrogueria);

		btnBuscarPersona.setBackground(Color.WHITE);
		btnBuscarPersona.setBounds(230, 27, 208, 23);
		
		contentPane.add(btnBuscarPersona);

		btnBuscarProducto.setBackground(Color.WHITE);
		btnBuscarProducto.setBounds(230, 489, 208, 23);
		
		contentPane.add(btnBuscarProducto);
		
		btnMostrarAlimentacion = new JButton("Mostrar alimentacion");

		btnMostrarAlimentacion.setForeground(Color.BLACK);
		btnMostrarAlimentacion.setBackground(Color.WHITE);
		btnMostrarAlimentacion.setBounds(10, 317, 428, 23);
		contentPane.add(btnMostrarAlimentacion);
		
		btnMostrarDrogueria = new JButton("Mostrar drogueria");

		btnMostrarDrogueria.setForeground(Color.BLACK);
		btnMostrarDrogueria.setBackground(Color.WHITE);
		btnMostrarDrogueria.setBounds(10, 385, 428, 23);
		contentPane.add(btnMostrarDrogueria);
		
		btnMostrarPersonas = new JButton("Mostrar personas");

		btnMostrarPersonas.setForeground(Color.BLACK);
		btnMostrarPersonas.setBackground(Color.WHITE);
		btnMostrarPersonas.setBounds(10, 265, 428, 23);
		contentPane.add(btnMostrarPersonas);
	}
}

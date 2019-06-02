package ventanas;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Factura;
import clases.Gestor;

import javax.swing.JScrollPane;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;

public class ListarFacturasCliente extends JDialog {

	private static final long serialVersionUID = 5612853395117871603L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblDniCliente = new JLabel("Dni cliente:");
	private final JTextField textDni = new JTextField();
	private final JButton btnBuscar = new JButton("Buscar");
	private final JTextArea textArea = new JTextArea();

	/**
	 * Crea una ventana de ListarFacturasCliente
	 * 
	 * @param gestor El gestor principal
	 */
	public ListarFacturasCliente(Gestor gestor) {
		setTitle("Listar facturas cliente");
		textDni.setBounds(10, 36, 133, 20);
		textDni.setColumns(10);
		inicializarGraficos();
		handlers(gestor);

	}

	private void handlers(Gestor gestor) {
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Factura facturas : gestor.getFacturas()) {
					if (facturas.getCliente().equals(textDni.getText())) {
						textArea.append(facturas.toString() + "\n");
					}
				}
			}
		});

	}

	private void inicializarGraficos() {
		setResizable(false);
		setBounds(100, 100, 608, 662);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane.setBounds(0, 82, 602, 552);
		contentPanel.add(scrollPane);
		{
			textArea.setEditable(false);
			scrollPane.setViewportView(textArea);
		}
		lblDniCliente.setBounds(10, 11, 133, 14);

		contentPanel.add(lblDniCliente);

		contentPanel.add(textDni);

		btnBuscar.setBounds(503, 35, 89, 23);

		contentPanel.add(btnBuscar);
	}

}

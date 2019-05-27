package ventanas;

import java.awt.BorderLayout;


import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Gestor;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarFacturas extends JDialog {


	private static final long serialVersionUID = 5612853395117871603L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private final JTextPane textPane = new JTextPane();
	private final JLabel lblDniCliente = new JLabel("Dni cliente:");
	private final JTextField textDni = new JTextField();
	private final JButton btnBuscar = new JButton("Buscar");


	public ListarFacturas(Gestor gestor) {
		textDni.setBounds(10, 36, 133, 20);
		textDni.setColumns(10);
		inicializarGraficos();
		handlers(gestor);
		
	}
	public void handlers(Gestor gestor) {
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTextPaneText(gestor.mostrarFacturasCliente(textDni.getText()));
			}
		});

	}
	public void inicializarGraficos() {
		setResizable(false);
		setBounds(100, 100, 608, 662);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane.setBounds(10, 82, 582, 540);
		contentPanel.add(scrollPane);
		{
			textPane.setEditable(false);
			scrollPane.setViewportView(textPane);
		}
		lblDniCliente.setBounds(10, 11, 133, 14);
		
		contentPanel.add(lblDniCliente);
		
		contentPanel.add(textDni);

		btnBuscar.setBounds(503, 35, 89, 23);
		
		contentPanel.add(btnBuscar);
	}
	public String getTextPaneText() {
		return textPane.getText();
	}
	public void setTextPaneText(String text) {
		textPane.setText(text);
	}
}

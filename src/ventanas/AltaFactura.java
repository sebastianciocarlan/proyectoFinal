package ventanas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Gestor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearFactura extends JDialog {


	private static final long serialVersionUID = -2174195994690665496L;
	private final JPanel contentPanel = new JPanel();
	private final JLabel lblDniCliente = new JLabel("Dni Cliente: ");
	private final JTextField textCliente = new JTextField();
	private final JLabel lblDniTrabajador = new JLabel("Dni Trabajador: ");
	private final JTextField textTrabajador = new JTextField();
	private final JTextField textFactura = new JTextField();
	private final JLabel lblIdFactura = new JLabel("ID Factura:");
	private final JButton btnCrearFactura = new JButton("Crear factura");


	public CrearFactura(Gestor gestor) {
		inicializarGraficos();
		handlers(gestor);
		
	}
	public void handlers(Gestor gestor) {
		btnCrearFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor.addFactura(textCliente.getText(), textTrabajador.getText(), textFactura.getText());
				dispose();
			}
		});
	}
	public void inicializarGraficos() {
		setTitle("Crear Factura");
		setResizable(false);
		textFactura.setBounds(190, 36, 170, 20);
		textFactura.setColumns(10);
		textTrabajador.setBounds(10, 92, 170, 20);
		textTrabajador.setColumns(10);
		textCliente.setBounds(10, 36, 170, 20);
		textCliente.setColumns(10);
		setBounds(100, 100, 380, 168);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblDniCliente.setBounds(10, 11, 170, 14);
			contentPanel.add(lblDniCliente);
		}
		{
			contentPanel.add(textCliente);
		}
		{
			lblDniTrabajador.setBounds(10, 67, 170, 14);
			contentPanel.add(lblDniTrabajador);
		}
		{
			contentPanel.add(textTrabajador);
		}
		{
			contentPanel.add(textFactura);
		}
		{
			lblIdFactura.setBounds(190, 11, 138, 14);
			contentPanel.add(lblIdFactura);
		}
		{

			btnCrearFactura.setBounds(190, 91, 170, 23);
			contentPanel.add(btnCrearFactura);
		}
	}

}

package ventanas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Gestor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarProducto extends JDialog {


	private static final long serialVersionUID = -4788192926395229984L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textCodBarras;
	private JLabel lblcodBarras = new JLabel("Codigo Barras:");
	private JButton btnBuscar = new JButton("Buscar");
	private JTextArea textArea = new JTextArea();
	/**
	 * Crea el JDialog.
	 * 
	 * @param gestor El gestor del programa
	 */
	public BuscarProducto(Gestor gestor) {
		setTitle("Buscar producto");
		inicializarGraficos();
		handlers(gestor);
	}
	private void handlers(Gestor gestor) {
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(gestor.buscarProducto(textCodBarras.getText()).toString());
			}
		});
	}
	private void inicializarGraficos() {
		setResizable(false);
		setBounds(100, 100, 450, 157);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{

			lblcodBarras.setBounds(10, 11, 206, 14);
			contentPanel.add(lblcodBarras);
		}
		{
			textCodBarras = new JTextField();
			textCodBarras.setBounds(10, 36, 206, 20);
			contentPanel.add(textCodBarras);
			textCodBarras.setColumns(10);
		}
		{


			btnBuscar.setBounds(226, 35, 208, 23);
			contentPanel.add(btnBuscar);
		}
		{

			textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
			textArea.setEditable(false);
			textArea.setBounds(10, 67, 424, 41);
			contentPanel.add(textArea);
		}
	}

}

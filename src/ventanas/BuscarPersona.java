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

public class BuscarPersona extends JDialog {
	private static final long serialVersionUID = -7612751346300852325L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textDni;
	private JLabel lblDNI = new JLabel("DNI:");
	private JButton btnBuscar = new JButton("Buscar");
	private JTextArea textArea = new JTextArea();
	/**
	 * Crea el JDialog.
	 * 
	 * @param gestor El gestor del programa
	 */
	public BuscarPersona(Gestor gestor) {
		setTitle("Buscar persona");
		inicializarGraficos();
		handlers(gestor);
	}
	private void handlers(Gestor gestor) {
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(gestor.buscarPersona(textDni.getText()).toString());
			}
		});
	}
	private void inicializarGraficos() {
		setResizable(false);
		setBounds(100, 100, 450, 152);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{

			lblDNI.setBounds(10, 11, 206, 14);
			contentPanel.add(lblDNI);
		}
		{
			textDni = new JTextField();
			textDni.setBounds(10, 36, 206, 20);
			contentPanel.add(textDni);
			textDni.setColumns(10);
		}
		{


			btnBuscar.setBounds(226, 35, 208, 23);
			contentPanel.add(btnBuscar);
		}
		{

			textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
			textArea.setEditable(false);
			textArea.setBounds(10, 67, 424, 37);
			contentPanel.add(textArea);
		}
	}

}

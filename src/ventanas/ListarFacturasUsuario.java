package ventanas;

import java.awt.BorderLayout;


import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Gestor;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ListarFacturasUsuario extends JDialog {


	private static final long serialVersionUID = 5612853395117871603L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private final JTextPane textPane = new JTextPane();


	public ListarFacturasUsuario(Gestor gestor) {
		inicializarGraficos();
		setTextPaneText(gestor.mostrarFacturas());
	}

	public void inicializarGraficos() {
		setResizable(false);
		setBounds(100, 100, 608, 662);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane.setBounds(10, 11, 582, 611);
		contentPanel.add(scrollPane);
		{
			textPane.setEditable(false);
			scrollPane.setViewportView(textPane);
		}
	}
	public String getTextPaneText() {
		return textPane.getText();
	}
	public void setTextPaneText(String text) {
		textPane.setText(text);
	}
}

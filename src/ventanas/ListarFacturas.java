package ventanas;

import java.awt.BorderLayout;


import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Gestor;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Color;

public class ListarFacturas extends JDialog {


	private static final long serialVersionUID = 5612853395117871603L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private final JTextPane textPane = new JTextPane();


	public ListarFacturas(Gestor gestor) {
		setTitle("Listar facturas");
		inicializarGraficos();
		setTextPaneText(gestor.listarFacturas());
	}

	public void inicializarGraficos() {
		setResizable(false);
		setBounds(100, 100, 608, 662);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane.setBounds(0, 0, 602, 634);
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

package ventanas;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Gestor;

import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JScrollPane;

public class MostrarProductos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 778431214976114131L;
	private final JPanel contentPanel = new JPanel();
	private JTextPane textPane = new JTextPane();
	private JScrollPane scrollPane = new JScrollPane();

	public MostrarProductos(Gestor gestor) {
		setResizable(false);
		inicializarGraficos();
		setTextPaneText(gestor.devuelveProductos());
		
	}
	public void inicializarGraficos() {
		setBounds(100, 100, 805, 775);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		

		scrollPane.setBounds(10, 11, 769, 681);
		contentPanel.add(scrollPane);
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
	}
	public String getTextPaneText() {
		return textPane.getText();
	}
	public void setTextPaneText(String text) {
		textPane.setText(text);
	}
}
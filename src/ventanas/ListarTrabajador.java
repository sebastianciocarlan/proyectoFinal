package ventanas;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Gestor;

import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JScrollPane;

public class ListarTrabajador extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5434411989151953658L;
	private final JPanel contentPanel = new JPanel();
	private JTextPane textPane = new JTextPane();
	private JScrollPane scrollPane = new JScrollPane();

	public ListarTrabajador(Gestor gestor) {
		setTitle("Listar trabajadores");
		setResizable(false);
		inicializarGraficos();
		setTextPaneText(gestor.listarTrabajadores());
		
	}
	public void inicializarGraficos() {
		setBounds(100, 100, 805, 775);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		

		scrollPane.setBounds(0, 0, 799, 747);
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

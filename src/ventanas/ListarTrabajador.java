package ventanas;

import java.awt.BorderLayout;


import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Gestor;
import clases.Persona;
import clases.Trabajador;


import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListarTrabajador extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5434411989151953658L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private final JTextArea textArea = new JTextArea();
	/**
	 * Crea el JDialog.
	 * 
	 * @param gestor El gestor del programa
	 */
	public ListarTrabajador(Gestor gestor) {
		setTitle("Listar trabajadores");
		setResizable(false);
		inicializarGraficos();
		for (Persona persona : gestor.getPersonas()) {
			if (persona instanceof Trabajador) {
				textArea.append(persona.toString()+"\n");
			}
		}

	}

	private void inicializarGraficos() {
		setBounds(100, 100, 805, 775);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane.setBounds(0, 0, 799, 747);
		contentPanel.add(scrollPane);
		textArea.setEditable(false);

		scrollPane.setViewportView(textArea);
	}

}

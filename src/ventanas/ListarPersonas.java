package ventanas;

import java.awt.BorderLayout;



import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.Gestor;
import clases.Persona;


import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListarPersonas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 778431214976114131L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private final JTextArea textArea = new JTextArea();
	/**
	 * Crea el JDialog.
	 * 
	 * @param gestor El gestor del programa
	 */
	public ListarPersonas(Gestor gestor) {
		setTitle("Listar personas");
		setResizable(false);
		inicializarGraficos();
		for (Persona persona:gestor.getPersonas()) {
				textArea.append(persona.toString()+"\n");
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
		
		scrollPane.setViewportView(textArea);
	}

}

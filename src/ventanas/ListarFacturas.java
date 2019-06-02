package ventanas;

import java.awt.BorderLayout;



import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Factura;
import clases.Gestor;

import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTextArea;

public class ListarFacturas extends JDialog {


	private static final long serialVersionUID = 5612853395117871603L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private final JTextArea textArea = new JTextArea();

	/**
	 * Crea el JDialog.
	 * 
	 * @param gestor El gestor del programa
	 */
	public ListarFacturas(Gestor gestor) {
		setTitle("Listar facturas");
		inicializarGraficos();
		for(Factura facturas:gestor.getFacturas()) {
			textArea.append(facturas.toString()+"\n");
		}
	}

	private void inicializarGraficos() {
		setResizable(false);
		setBounds(100, 100, 608, 662);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane.setBounds(0, 0, 602, 634);
		contentPanel.add(scrollPane);
		textArea.setEditable(false);
		
		scrollPane.setViewportView(textArea);
	}

}

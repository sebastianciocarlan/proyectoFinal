package ventanas;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Gestor;
import clases.Producto;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListarProductos extends JDialog {

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
	public ListarProductos(Gestor gestor) {
		setTitle("Listar productos");
		setResizable(false);
		inicializarGraficos();
		for (Producto productos : gestor.getProductos()) {
			textArea.append(productos.toString() + "\n");
		}

	}
	
	private void inicializarGraficos() {
		setBounds(100, 100, 805, 775);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane.setBounds(0, 0, 799, 736);
		contentPanel.add(scrollPane);
		textArea.setEditable(false);

		scrollPane.setViewportView(textArea);
	}
}

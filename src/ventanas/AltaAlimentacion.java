package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import com.github.lgooddatepicker.components.DatePicker;

import clases.Gestor;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AltaAlimentacion extends JDialog {
	private static final long serialVersionUID = -8233413010934210986L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigoBarras;
	private JTextField textMarca;
	private JTextField textNombre;
	private JTextField textAlergenos;
	private JLabel lblCodigoBarras = new JLabel("Codigo barras:");
	private JLabel lblMarca = new JLabel("Marca:");
	private JLabel lblNombreProducto = new JLabel("Nombre producto:");
	private JSpinner spinnerPrecio = new JSpinner();
	private JLabel lblPrecio = new JLabel("Precio: ");
	private JLabel lblFechaCaducidad = new JLabel("Fecha caducidad:");
	private JLabel lblAlergenos = new JLabel("Alergenos: ");
	private DatePicker datePicker = new DatePicker();
	private JTextArea textIngredientes = new JTextArea();
	private JLabel lblIngredientes = new JLabel("Ingredientes:");
	private JButton okButton = new JButton("Alta");
	private JPanel buttonPane = new JPanel();

	public AltaAlimentacion(Gestor gestor) {
		setTitle("Alta alimentacion");
		inicializarGraficos();
		handlers(gestor);
	}
	public void handlers (Gestor gestor) {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor.addAlimentacion((int)spinnerPrecio.getValue(), textMarca.getText(), textNombre.getText(), textCodigoBarras.getText(), textAlergenos.getText(), textIngredientes.getText(), datePicker.getDate());
				dispose();
			}
		});
		
	}
	public void inicializarGraficos() {
		setResizable(false);
		setBounds(100, 100, 428, 418);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblCodigoBarras.setBounds(10, 11, 81, 14);
		contentPanel.add(lblCodigoBarras);

		textCodigoBarras = new JTextField();
		textCodigoBarras.setBounds(10, 36, 131, 20);
		contentPanel.add(textCodigoBarras);
		textCodigoBarras.setColumns(10);

		lblMarca.setBounds(10, 67, 46, 14);
		contentPanel.add(lblMarca);

		textMarca = new JTextField();
		textMarca.setBounds(10, 92, 131, 20);
		contentPanel.add(textMarca);
		textMarca.setColumns(10);

		lblNombreProducto.setBounds(10, 123, 131, 14);
		contentPanel.add(lblNombreProducto);

		textNombre = new JTextField();
		textNombre.setBounds(10, 148, 131, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);

		spinnerPrecio.setModel(new SpinnerNumberModel(0.0, null, 9999.0, 1.0));
		spinnerPrecio.setBounds(151, 36, 261, 20);
		contentPanel.add(spinnerPrecio);

		lblPrecio.setBounds(151, 11, 46, 14);
		contentPanel.add(lblPrecio);

		lblAlergenos.setBounds(151, 67, 81, 14);
		contentPanel.add(lblAlergenos);

		textAlergenos = new JTextField();
		textAlergenos.setBounds(151, 92, 261, 20);
		contentPanel.add(textAlergenos);
		textAlergenos.setColumns(10);

		lblFechaCaducidad.setBounds(151, 123, 129, 14);
		contentPanel.add(lblFechaCaducidad);

		datePicker.setBounds(151, 149, 261, 20);
		contentPanel.add(datePicker);
		contentPanel.add(lblPrecio);

		textIngredientes.setBounds(20, 212, 392, 133);
		contentPanel.add(textIngredientes);

		lblIngredientes.setBounds(20, 179, 142, 14);
		contentPanel.add(lblIngredientes);
		buttonPane.setBackground(Color.WHITE);

		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);


		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	}
}

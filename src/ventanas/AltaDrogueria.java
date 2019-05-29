package ventanas;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Gestor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AltaDrogueria extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1685164680499896124L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigoBarras;
	private JTextField textMarca;
	private JTextField textNombre;
	private JTextField textTipo;
	private JLabel lblCodigoBarras = new JLabel("Codigo barras:");
	private JLabel lblMarca = new JLabel("Marca:");
	private JLabel lblNombreProducto = new JLabel("Nombre producto:");
	private JSpinner spinnerPrecio = new JSpinner();
	private JLabel lblPrecio = new JLabel("Precio: ");
	private JCheckBox checkBoxEsImportado = new JCheckBox("Es Importado");
	private JLabel lblTipo = new JLabel("Tipo :");
	private JPanel buttonPane = new JPanel();
	private JButton okButton = new JButton("Alta");


		

	/**
	 * Create the dialog.
	 */
	public AltaDrogueria(Gestor gestor) {
		setTitle("Alta drogueria");
		inicializarGraficos();
		handlers(gestor);

	}
	public void handlers(Gestor gestor) {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor.addDrogueria((int)spinnerPrecio.getValue(), textMarca.getText(), textNombre.getText(), textCodigoBarras.getText(), textTipo.getText(), checkBoxEsImportado.isSelected());
				dispose();
			}
		});
	}
	public void inicializarGraficos() {
		setResizable(false);
		setBounds(100, 100, 296, 244);
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
		spinnerPrecio.setBounds(151, 36, 131, 20);
		contentPanel.add(spinnerPrecio);

		lblPrecio.setBounds(151, 11, 46, 14);
		contentPanel.add(lblPrecio);

		checkBoxEsImportado.setBounds(147, 145, 135, 23);
		contentPanel.add(checkBoxEsImportado);

		lblTipo.setBounds(151, 67, 131, 14);
		contentPanel.add(lblTipo);

		textTipo = new JTextField();
		textTipo.setBounds(151, 92, 131, 20);
		contentPanel.add(textTipo);
		textTipo.setColumns(10);
		{
			buttonPane.setBackground(Color.WHITE);

			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
	

				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}

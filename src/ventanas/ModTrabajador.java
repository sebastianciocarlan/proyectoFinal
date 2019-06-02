package ventanas;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.github.lgooddatepicker.components.DatePicker;

import clases.Gestor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ModTrabajador extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 493177491395106948L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDNI;
	private JTextField textDomicilio;
	private JTextField textPuesto;
	private JLabel lblNombre = new JLabel("Nombre: ");
	private JLabel lblApellidos = new JLabel("Apellidos: ");

	private JLabel lblDni = new JLabel("DNI:");
	private JLabel lblDomicilio = new JLabel("Domicilio:");
	private JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento: ");
	private DatePicker datePickerNacimiento = new DatePicker();
	private JLabel lblFechaDeInicio = new JLabel("Fecha de inicio de contrato:");
	private DatePicker datePickerContrato = new DatePicker();
	private JLabel lblPuesto = new JLabel("Puesto:");
	private JPanel buttonPane = new JPanel();
	private JButton okButton = new JButton("Modificar");
	/**
	 * Crea el JDialog.
	 * 
	 * @param gestor El gestor del programa
	 */
	public ModTrabajador(Gestor gestor) {
		inicializarGraficos();
		handlers(gestor);
	}
	private void handlers(Gestor gestor) {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor.modTrabajador(textDNI.getText(), textNombre.getText(), textApellidos.getText(), textDomicilio.getText(), datePickerNacimiento.getDate(), datePickerContrato.getDate(), textPuesto.getText());
				dispose();
			}
		});
		
	}
	private void inicializarGraficos() {
		setTitle("Modificar trabajador");
		setResizable(false);
		setBounds(100, 100, 347, 362);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblNombre.setBounds(10, 11, 91, 14);
		contentPanel.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(10, 36, 150, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);

		lblApellidos.setBounds(10, 67, 150, 14);
		contentPanel.add(lblApellidos);

		textApellidos = new JTextField();
		textApellidos.setBounds(10, 92, 150, 20);
		contentPanel.add(textApellidos);
		textApellidos.setColumns(10);

		lblDni.setBounds(172, 11, 46, 14);
		contentPanel.add(lblDni);

		textDNI = new JTextField();
		textDNI.setBounds(170, 36, 161, 20);
		contentPanel.add(textDNI);
		textDNI.setColumns(10);

		lblDomicilio.setBounds(170, 67, 66, 14);
		contentPanel.add(lblDomicilio);

		textDomicilio = new JTextField();
		textDomicilio.setBounds(170, 92, 161, 20);
		contentPanel.add(textDomicilio);
		textDomicilio.setColumns(10);

		lblFechaNacimiento.setBounds(10, 123, 310, 14);
		contentPanel.add(lblFechaNacimiento);

		datePickerNacimiento.setBounds(10, 148, 321, 20);
		contentPanel.add(datePickerNacimiento);
		
				lblFechaDeInicio.setBounds(10, 179, 310, 14);
				contentPanel.add(lblFechaDeInicio);

		datePickerContrato.setBounds(10, 204, 321, 20);
		contentPanel.add(datePickerContrato);

		lblPuesto.setBounds(10, 235, 46, 14);
		contentPanel.add(lblPuesto);

		textPuesto = new JTextField();
		textPuesto.setBounds(10, 260, 321, 20);
		contentPanel.add(textPuesto);
		textPuesto.setColumns(10);
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

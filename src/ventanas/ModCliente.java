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

public class ModCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7314993226761304957L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDNI;
	private JTextField textDomicilio;
	private JLabel lblNombre = new JLabel("Nombre: ");
	private JLabel lblDni = new JLabel("DNI:");
	private JLabel lblApellidos = new JLabel("Apellidos: ");
	private JLabel lblDomicilio = new JLabel("Domicilio:");
	private DatePicker datePicker = new DatePicker();
	private JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
	private JPanel buttonPane = new JPanel();
	private JButton okButton = new JButton("Modificar");
	public ModCliente(Gestor gestor) {
		inicializarGraficos();
		handlers(gestor);
	}
	public void handlers(Gestor gestor) {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor.modCliente(textDNI.getText(), textNombre.getText(), textApellidos.getText(), textDomicilio.getText(),datePicker.getDate() );
				dispose();
			}
		});

	}
	public void inicializarGraficos() {
		setTitle("Modificar Cliente");
		setResizable(false);
		setBounds(100, 100, 347, 252);
		getContentPane().setLayout(new BorderLayout());
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
		textDNI.setBounds(170, 36, 150, 20);
		contentPanel.add(textDNI);
		textDNI.setColumns(10);

		lblDomicilio.setBounds(170, 67, 66, 14);
		contentPanel.add(lblDomicilio);

		textDomicilio = new JTextField();
		textDomicilio.setBounds(170, 92, 150, 20);
		contentPanel.add(textDomicilio);
		textDomicilio.setColumns(10);

		datePicker.setBounds(10, 157, 310, 20);
		contentPanel.add(datePicker);

		lblFechaDeNacimiento.setBounds(10, 132, 208, 14);
		contentPanel.add(lblFechaDeNacimiento);
		{

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

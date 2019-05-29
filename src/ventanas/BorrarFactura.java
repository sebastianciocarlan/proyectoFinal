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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrarFactura extends JDialog {

	private static final long serialVersionUID = -4316814856716012135L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFactura;
	private JLabel lblIdFactura = new JLabel("Id Factura: ");
	private JPanel buttonPane = new JPanel();
	private JButton okButton = new JButton("Borrar");


	public BorrarFactura(Gestor gestor) {
		setTitle("Borrar Factura");
		inicializarGraficos();
		handlers(gestor);
	}
	public void handlers(Gestor gestor) {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor.delFactura( textFactura.getText());
				dispose();
			}
		});
		
	}
	public void inicializarGraficos() {
		setResizable(false);
		setBounds(100, 100, 288, 129);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblIdFactura.setBounds(10, 11, 262, 14);
		contentPanel.add(lblIdFactura);

		textFactura = new JTextField();
		textFactura.setBounds(10, 36, 262, 20);
		contentPanel.add(textFactura);
		textFactura.setColumns(10);
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

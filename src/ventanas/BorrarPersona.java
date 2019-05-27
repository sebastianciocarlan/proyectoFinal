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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrarPersona extends JDialog {


	private static final long serialVersionUID = 8779607875811016349L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textDni;
	private JLabel lblDniPersonaA = new JLabel("DNI persona a eliminar:");
	private JPanel buttonPane = new JPanel();
	private JButton okButton = new JButton("Borrar");


	public BorrarPersona(Gestor gestor) {
		inicializarGraficos();
		handler(gestor);
	}
	public void handler(Gestor gestor) {
		
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						gestor.delPersona(textDni.getText());
						dispose();
					}
				});

				
	}
	public void inicializarGraficos() {
		setTitle("Borrar persona");
		setResizable(false);
		setBounds(100, 100, 364, 101);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{

			lblDniPersonaA.setBounds(10, 11, 126, 14);
			contentPanel.add(lblDniPersonaA);
		}
		{
			textDni = new JTextField();
			textDni.setBounds(146, 8, 198, 20);
			contentPanel.add(textDni);
			textDni.setColumns(10);
		}
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

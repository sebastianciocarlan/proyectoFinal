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
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Login extends JDialog {
	private static final long serialVersionUID = 7132717529619046419L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textUser;
	private JPasswordField textPassword;
	private JPanel buttonPane = new JPanel();
	private JButton okButton = new JButton("OK");
	private JTextPane txtpnLoginError = new JTextPane();
	/**
	 * Create the dialog.
	 */
	public Login(Gestor gestor) {
		inicializarGraficos();
		handlers(gestor);
	}
	
	public void handlers(Gestor gestor) {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestor.conectarBaseDatos();

				if(gestor.comprobarLogin(textUser.getText(), String.valueOf(textPassword.getPassword()))) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								VentanaPrincipal frame = new VentanaPrincipal(gestor);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					dispose();
				}else{
					txtpnLoginError.setForeground(Color.RED);
				}
			}
		});
	}

	public void inicializarGraficos() {
		setResizable(false);
		setTitle("Login");
		setBounds(100, 100, 242, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(10, 11, 46, 14);
		contentPanel.add(lblUser);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 36, 87, 14);
		contentPanel.add(lblPassword);

		textUser = new JTextField();
		textUser.setText("darknnesilver");
		textUser.setBounds(89, 8, 127, 20);
		contentPanel.add(textUser);
		textUser.setColumns(10);

		textPassword = new JPasswordField();
		textPassword.setToolTipText("");
		textPassword.setBounds(89, 33, 127, 20);
		contentPanel.add(textPassword);
		

		txtpnLoginError.setEditable(false);
		txtpnLoginError.setForeground(Color.WHITE);
		txtpnLoginError.setText("LOGIN ERROR!");
		txtpnLoginError.setBounds(20, 58, 196, 20);
		contentPanel.add(txtpnLoginError);
		buttonPane.setBackground(Color.WHITE);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

	}
}

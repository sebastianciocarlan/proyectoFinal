package programa;

import javax.swing.JDialog;

import clases.Gestor;
import ventanas.Login;


public class ProgramaPrincipal {

	public static void main(String[] args) {
		Gestor gestor = new Gestor();
		try {
			Login dialog = new Login(gestor);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

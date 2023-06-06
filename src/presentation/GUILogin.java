package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUILogin extends JFrame {

	private JPanel contentPane;
	private JLabel lUser;
	private JLabel lPassword;
	private JTextField tUser;
	private JTextField tPassword;
	private JButton bLogin;

	/**
	 * Create the frame.
	 */
	public GUILogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLUser());
		contentPane.add(getLPassword());
		contentPane.add(getTUser());
		contentPane.add(getTPassword());
		contentPane.add(getBLogin());
		setVisible(true);
	}
	public JLabel getLUser() {
		if (lUser == null) {
			lUser = new JLabel("Usuario");
			lUser.setBounds(32, 46, 46, 14);
		}
		return lUser;
	}
	public JLabel getLPassword() {
		if (lPassword == null) {
			lPassword = new JLabel("Contraseña");
			lPassword.setBounds(32, 103, 65, 14);
		}
		return lPassword;
	}
	public JTextField getTUser() {
		if (tUser == null) {
			tUser = new JTextField();
			tUser.setBounds(94, 60, 86, 20);
			tUser.setColumns(10);
		}
		return tUser;
	}
	public JTextField getTPassword() {
		if (tPassword == null) {
			tPassword = new JTextField();
			tPassword.setBounds(94, 128, 86, 20);
			tPassword.setColumns(10);
		}
		return tPassword;
	}
	public JButton getBLogin() {
		if (bLogin == null) {
			bLogin = new JButton("Ingresar");
			bLogin.setBounds(157, 179, 89, 23);
		}
		return bLogin;
	}
}


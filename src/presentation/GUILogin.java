package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import java.awt.Color;

@SuppressWarnings("serial")
public class GUILogin extends JFrame {

	private JPanel contentPane;
	private JLabel lUser;
	private JLabel lPassword;
	private JTextField tUser;
	private JButton bLogin;
	private JPasswordField pfPassword;
	private JButton bExit;
	private JLabel li;
	/**
	 * Create the frame.
	 */
	public GUILogin() {
		setBackground(new Color(255, 255, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 407);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLUser());
		contentPane.add(getLPassword());
		contentPane.add(getTUser());
		contentPane.add(getBLogin());
		contentPane.add(getPfPassword());
		contentPane.add(getBExit());
		contentPane.add(getImagen());
		setVisible(true);
	}
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(-38, -62, 589, 436);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUILogin.class.getResource("/media/logo3.png")));
		getContentPane().add(li);
		}
		return li;
	}
	public JLabel getLUser() {
		if (lUser == null) {
			lUser = new JLabel("Usuario");
			lUser.setBackground(UIManager.getColor("Button.focus"));
			lUser.setFont(new Font("Tahoma", Font.BOLD, 11));
			lUser.setBounds(45, 233, 74, 23);
		}
		return lUser;
	}
	public JLabel getLPassword() {
		if (lPassword == null) {
			lPassword = new JLabel("Contraseña");
			lPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
			lPassword.setBackground(new Color(204, 255, 204));
			lPassword.setBounds(45, 283, 74, 23);
		}
		return lPassword;
	}
	public JTextField getTUser() {
		if (tUser == null) {
			tUser = new JTextField();
			tUser.setBackground(new Color(255, 255, 255));
			tUser.setBounds(33, 231, 96, 27);
			tUser.setColumns(10);
		}
		return tUser;
	}
	public JButton getBLogin() {
		if (bLogin == null) {
			bLogin = new JButton("Iniciar Sesión");
			bLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
			bLogin.setBackground(UIManager.getColor("Button.shadow"));
			bLogin.setBounds(191, 322, 124, 23);
		}
		return bLogin;
	}
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
		}
	public JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setBackground(new Color(255, 255, 255));
			pfPassword.setBounds(33, 280, 96, 28);
		}
		return pfPassword;
	}
	public JButton getBExit() {
		if (bExit == null) {
			bExit = new JButton("Salir");
			bExit.setFont(new Font("Tahoma", Font.BOLD, 11));
			bExit.setBackground(UIManager.getColor("Button.light"));
			bExit.setBounds(471, 11, 70, 23);
		}
		return bExit;
	}
}


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
	private JLabel lLogin;
	private JLabel li;
	/**
	 * Create the frame.
	 */
	public GUILogin() {
		setBackground(new Color(255, 255, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 398);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLUser());
		contentPane.add(getLPassword());
		contentPane.add(getTUser());
		contentPane.add(getBLogin());
		contentPane.add(getPfPassword());
		contentPane.add(getBExit());
		contentPane.add(getLLogin());
		contentPane.add(getImagen());
		setVisible(true);
	}
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(0, 0, 509, 359);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUILogin.class.getResource("/media/airline-.png")));
		getContentPane().add(li);
		}
		return li;
	}
	public JLabel getLUser() {
		if (lUser == null) {
			lUser = new JLabel("Usuario");
			lUser.setBackground(UIManager.getColor("Button.focus"));
			lUser.setFont(new Font("Tahoma", Font.BOLD, 11));
			lUser.setBounds(38, 86, 74, 23);
		}
		return lUser;
	}
	public JLabel getLPassword() {
		if (lPassword == null) {
			lPassword = new JLabel("Contraseña");
			lPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
			lPassword.setBackground(new Color(204, 255, 204));
			lPassword.setBounds(38, 143, 74, 23);
		}
		return lPassword;
	}
	public JTextField getTUser() {
		if (tUser == null) {
			tUser = new JTextField();
			tUser.setBackground(new Color(204, 255, 153));
			tUser.setBounds(31, 84, 96, 27);
			tUser.setColumns(10);
		}
		return tUser;
	}
	public JButton getBLogin() {
		if (bLogin == null) {
			bLogin = new JButton("Iniciar Sesión");
			bLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
			bLogin.setBackground(UIManager.getColor("Button.shadow"));
			bLogin.setBounds(31, 302, 124, 23);
		}
		return bLogin;
	}
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
		}
	public JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setBackground(new Color(204, 255, 153));
			pfPassword.setBounds(31, 140, 96, 28);
		}
		return pfPassword;
	}
	public JButton getBExit() {
		if (bExit == null) {
			bExit = new JButton("Salir");
			bExit.setFont(new Font("Tahoma", Font.BOLD, 11));
			bExit.setBackground(UIManager.getColor("Button.light"));
			bExit.setBounds(429, 11, 70, 23);
		}
		return bExit;
	}
	public JLabel getLLogin() {
		if (lLogin == null) {
			lLogin = new JLabel("LOGIN");
			lLogin.setForeground(new Color(248, 248, 255));
			lLogin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 27));
			lLogin.setBounds(31, 21, 124, 52);
		}
		return lLogin;
	}
}


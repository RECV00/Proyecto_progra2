package presentation;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GUIWelcome extends JFrame {

	private JPanel contentPane;
	private JButton bInicioSesion;
	private JLabel li;


	public GUIWelcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBInicioSesion());
		contentPane.add(getImagen());
		setVisible(true);
	}
	public JButton getBInicioSesion() {
		if (bInicioSesion == null) {
			bInicioSesion = new JButton("INICIO DE SESIÓN");
			bInicioSesion.setBounds(319, 360, 144, 23);
		}
		return bInicioSesion;
	}
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(0, -38, 874, 528);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIWelcome.class.getResource("/media/logo.png")));
		getContentPane().add(li);
		}
		return li;
	}
}

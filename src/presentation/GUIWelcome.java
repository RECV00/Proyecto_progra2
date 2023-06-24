package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class GUIWelcome extends JFrame {

	private JPanel contentPane;
	private JButton bInicioSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIWelcome frame = new GUIWelcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIWelcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBInicioSesion());
	}
	public JButton getBInicioSesion() {
		if (bInicioSesion == null) {
			bInicioSesion = new JButton("INICIO DE SESIÓN");
			bInicioSesion.setBounds(166, 229, 144, 23);
		}
		return bInicioSesion;
	}
}

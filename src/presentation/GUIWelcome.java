package presentation;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GUIWelcome extends JFrame {

	private JPanel contentPane;
	private JButton bInicioSesion;
	private JLabel li;
	private JMenuBar menuBar;
	private JMenu mnHelp;
	private JMenuItem mAboutSistem;


	public GUIWelcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 522);
		setJMenuBar(getMenuBar_1());
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
	public void executeHTML1(String url) {
	    String osName = System.getProperty("os.name");
	    try {
	        if (osName.startsWith("Windows")) {
	            ProcessBuilder processBuilder = new ProcessBuilder("rundll32", "url.dll,FileProtocolHandler", url);
	            processBuilder.start();
	        } else if (osName.startsWith("Mac OS X")) {
	            ProcessBuilder processBuilder = new ProcessBuilder("open", "-a", "safari", url);
	            processBuilder.start();
	            processBuilder = new ProcessBuilder("open", url + "/index.html.html");
	            processBuilder.start();
	            processBuilder = new ProcessBuilder("open", url);
	            processBuilder.start();
	        } else {
	            System.out.println("Please open a browser and go to " + url);
	        }
	    } catch (IOException ioe) {
	        System.out.println("Failed to start a browser to open the URL " + url);
	        ioe.printStackTrace();
	    }
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	public JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Ayuda");
			mnHelp.add(getMAboutSistem());
		}
		return mnHelp;
	}
	public JMenuItem getMAboutSistem() {
		if (mAboutSistem == null) {
			mAboutSistem = new JMenuItem("Acerca del Sistema");
		}
		return mAboutSistem;
	}
}

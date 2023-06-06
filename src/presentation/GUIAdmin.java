package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings({ "serial", "unused" })
public class GUIAdmin extends JFrame {
	private JMenuBar menuBar;
	private JMenu mFile;
	private JMenu mOperations;
	private JMenu mHelp;
	private JMenuItem miOpen;
	private JMenuItem miSave;
	private JMenuItem miExit;
	private JMenuItem miUsers;
	private JMenuItem miAboutSystem;
	private JPanel contentPane;
	private JMenuItem miBrand;
	
	private int resultAcces;
	private JMenuItem miModel;
	private JMenuItem miAirline;
	private JMenuItem miPlane;
	private JMenuItem miFlight;
	private JMenuItem miPassenger;
	private JMenuItem miTickert;
	private JMenuItem miImpresionT;
	private JMenuItem miHistorialT;
	private JMenuItem miVuelos;
	/**
	 * Create the frame.
	 */
	public GUIAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5 ,5, 5,5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		//setSize(getMaximumSize());
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMFile());
			menuBar.add(getMOperations());
			menuBar.add(getMHelp());
		}
		return menuBar;
	}
	public JMenu getMFile() {
		if (mFile == null) {
			mFile = new JMenu("Archivo");
			mFile.add(getMiOpen());
			mFile.add(getMiSave());
			mFile.add(getMiExit());
		}
		return mFile;
	}
	public JMenu getMOperations() {
		if (mOperations == null) {
			mOperations = new JMenu("Operaciones");
			mOperations.add(getMiUsers());
			mOperations.add(getMiBrand());
			mOperations.add(getMiModel());
			mOperations.add(getMiAirline());
			mOperations.add(getMiPlane());
			mOperations.add(getMiFlight());
			mOperations.add(getMiPassenger());
			mOperations.add(getMiTickert());
			mOperations.add(getMiImpresionT());
			mOperations.add(getMiHistorialT());
			mOperations.add(getMiVuelos());
		}
		return mOperations;
	}
	public JMenu getMHelp() {
		if (mHelp == null) {
			mHelp = new JMenu("Ayuda");
			mHelp.add(getMiAboutSystem());
		}
		return mHelp;
	}
	public JMenuItem getMiOpen() {
		if (miOpen == null) {
			miOpen = new JMenuItem("Abrir");
		}
		return miOpen;
	}
	public JMenuItem getMiSave() {
		if (miSave == null) {
			miSave = new JMenuItem("Guardar");
		}
		return miSave;
	}
	public JMenuItem getMiExit() {
		if (miExit == null) {
			miExit = new JMenuItem("Salir");
		}
		return miExit;
	}
	public JMenuItem getMiUsers() {
		if (miUsers == null) {
			miUsers = new JMenuItem("Gestión de Usuario");
		}
		return miUsers;
	}
	public JMenuItem getMiAboutSystem() {
		if (miAboutSystem == null) {
			miAboutSystem = new JMenuItem("Acerca del Sistema");
		}
		return miAboutSystem;
	}
	public JMenuItem getMiBrand() {
		if (miBrand == null) {
			miBrand = new JMenuItem("Gestión de Marcas");
		}
		return miBrand;
	}
	public JMenuItem getMiModel() {
		if (miModel == null) {
			miModel = new JMenuItem("Gestión de Modelos");
		}
		return miModel;
	}
	public JMenuItem getMiAirline() {
		if (miAirline == null) {
			miAirline = new JMenuItem("Gestión de Aerolínea");
		}
		return miAirline;
	}
	public JMenuItem getMiPlane() {
		if (miPlane == null) {
			miPlane = new JMenuItem("Gestión de Aviones");
		}
		return miPlane;
	}
	public JMenuItem getMiFlight() {
		if (miFlight == null) {
			miFlight = new JMenuItem("Gestión de Vuelos");
		}
		return miFlight;
	}
	public JMenuItem getMiPassenger() {
		if (miPassenger == null) {
			miPassenger = new JMenuItem("Gestión de Pasajero");
		}
		return miPassenger;
	}
	public JMenuItem getMiTickert() {
		if (miTickert == null) {
			miTickert = new JMenuItem("Gestión de Tiquetes");
		}
		return miTickert;
	}
	public JMenuItem getMiImpresionT() {
		if (miImpresionT == null) {
			miImpresionT = new JMenuItem("Impresión de Tiquete");
		}
		return miImpresionT;
	}
	public JMenuItem getMiHistorialT() {
		if (miHistorialT == null) {
			miHistorialT = new JMenuItem("Historial de Tiquetes");
		}
		return miHistorialT;
	}
	public JMenuItem getMiVuelos() {
		if (miVuelos == null) {
			miVuelos = new JMenuItem("Consultar Vuelos");
		}
		return miVuelos;
	}
}


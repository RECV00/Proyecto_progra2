package presentation;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;

@SuppressWarnings({ "serial", "unused" })
public class GUIColaborador extends JFrame {
	private JMenuBar menuBar;
	private JMenu mFile;
	private JMenu mOperations;
	private JMenu mHelp;
	private JMenuItem miOpen;
	private JMenuItem miSave;
	private JMenuItem miiExit;
	private JMenuItem miAboutSystem;
	private JPanel contentPane;
	private int resultAcces;
	private JMenu mnBrand;
	private JMenu mnModel;
	private JMenu mnAeroline;
	private JMenu mnPlane;
	private JMenu mnFlight;
	private JMenu mnPass;
	private JMenu mnTicket;
	private JMenuItem miRegisterBrand;
	private JMenuItem miConsultBrand;
	private JMenuItem miRegisterModel;
	private JMenuItem miConsultModel;
	private JMenuItem miRegisterAeroline;
	private JMenuItem miConsultAeroline;
	private JMenuItem miRegisterPlane;
	private JMenuItem miConsultPlane;
	private JMenuItem miRegisterFlight;
	private JMenuItem miConsultFlight;
	private JMenuItem miRegisterPass;
	private JMenuItem miConsultPass;
	private JMenuItem miRegisterTicket;
	private JMenuItem miConsultTicket;
	private JMenuItem mnImpresionT;
	private JMenuItem mnHistorialT;
	private JMenuItem mnVuelos;
	private JLabel li;
	/**
	 * Create the frame.
	 */
	public GUIColaborador() {
		setTitle("Privilegios del Colaborador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 519);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5 ,5, 5,5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getImagen());
		setVisible(true);
		//setSize(getMaximumSize());
	}
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(0, -38, 874, 528);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIColaborador.class.getResource("/media/logoC.png")));
		getContentPane().add(li);
		}
		return li;
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(Color.WHITE);
			menuBar.add(getMFile());
			menuBar.add(getMOperations());
			menuBar.add(getMHelp());
		}
		return menuBar;
	}
	public JMenu getMFile() {
		if (mFile == null) {
			mFile = new JMenu("Archivo");
			mFile.setFont(new Font("Franklin Gothic Book", Font.BOLD | Font.ITALIC, 14));
			mFile.setHorizontalAlignment(SwingConstants.CENTER);
			mFile.setBackground(UIManager.getColor("MenuBar.background"));
			mFile.add(getMiOpen());
			mFile.add(getMiSave());
			mFile.add(getMiiExit());
		}
		return mFile;
	}
	public JMenu getMOperations() {
		if (mOperations == null) {
			mOperations = new JMenu("Operaciones");
			mOperations.setFont(new Font("Franklin Gothic Book", Font.BOLD | Font.ITALIC, 14));
			mOperations.setBackground(UIManager.getColor("MenuItem.background"));
			mOperations.add(getMnBrand());
			mOperations.add(getMnModel());
			mOperations.add(getMnAeroline());
			mOperations.add(getMnPlane());
			mOperations.add(getMnFlight());
			mOperations.add(getMnPass());
			mOperations.add(getMnTicket());
			mOperations.add(getMnImpresionT());
			mOperations.add(getMnHistorialT());
			mOperations.add(getMnVuelos());
		}
		return mOperations;
	}
	public JMenu getMHelp() {
		if (mHelp == null) {
			mHelp = new JMenu("Ayuda");
			mHelp.setFont(new Font("Franklin Gothic Book", Font.BOLD | Font.ITALIC, 14));
			mHelp.setBackground(UIManager.getColor("MenuBar.background"));
			mHelp.add(getMiAboutSystem());
		}
		return mHelp;
	}
	public JMenuItem getMiOpen() {
		if (miOpen == null) {
			miOpen = new JMenuItem("Abrir");
			miOpen.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miOpen;
	}
	public JMenuItem getMiSave() {
		if (miSave == null) {
			miSave = new JMenuItem("Guardar");
			miSave.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miSave;
	}
	public JMenuItem getMiiExit() {
		if (miiExit == null) {
			miiExit = new JMenuItem("Salir");
			miiExit.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miiExit;
	}	
		public JMenuItem getMiAboutSystem() {
			if (miAboutSystem == null) {
				miAboutSystem = new JMenuItem("Acerca del Sistema");
				miAboutSystem.setFont(new Font("SansSerif", Font.PLAIN, 12));
			}
			return miAboutSystem;
		}
		
	public JMenu getMnBrand() {
		if (mnBrand == null) {
			mnBrand = new JMenu("Gestión de Marcas");
			mnBrand.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
			mnBrand.add(getMiRegisterBrand());
			mnBrand.add(getMiConsultBrand());
		}
		return mnBrand;
	}
	public JMenu getMnModel() {
		if (mnModel == null) {
			mnModel = new JMenu("Gestión de Modelos");
			mnModel.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
			mnModel.add(getMiRegisterModel());
			mnModel.add(getMiConsultModel());
		}
		return mnModel;
	}
	public JMenu getMnAeroline() {
		if (mnAeroline == null) {
			mnAeroline = new JMenu("Gestión de Aerolíneas");
			mnAeroline.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
			mnAeroline.add(getMiRegisterAeroline());
			mnAeroline.add(getMiConsultAeroline());
		}
		return mnAeroline;
	}
	public JMenu getMnPlane() {
		if (mnPlane == null) {
			mnPlane = new JMenu("Gestión de Aviones");
			mnPlane.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
			mnPlane.add(getMiRegisterPlane());
			mnPlane.add(getMiConsultPlane());
		}
		return mnPlane;
	}
	public JMenu getMnFlight() {
		if (mnFlight == null) {
			mnFlight = new JMenu("Gestión de Vuelos");
			mnFlight.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
			mnFlight.add(getMiRegisterFlight());
			mnFlight.add(getMiConsultFlight());
		}
		return mnFlight;
	}
	public JMenu getMnPass() {
		if (mnPass == null) {
			mnPass = new JMenu("Gestión de Pasajeros");
			mnPass.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
			mnPass.add(getMiRegisterPass());
			mnPass.add(getMiConsultPass());
		}
		return mnPass;
	}
	public JMenu getMnTicket() {
		if (mnTicket == null) {
			mnTicket = new JMenu("Gestión de Tiquetes");
			mnTicket.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
			mnTicket.add(getMiRegisterTicket());
			mnTicket.add(getMiConsultTicket());
		}
		return mnTicket;
	}
	public JMenuItem getMiRegisterBrand() {
		if (miRegisterBrand == null) {
			miRegisterBrand = new JMenuItem("Registrar");
			miRegisterBrand.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterBrand;
	}
	public JMenuItem getMiConsultBrand() {
		if (miConsultBrand == null) {
			miConsultBrand = new JMenuItem("Consultar");
			miConsultBrand.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultBrand;
	}
	
	public JMenuItem getMiRegisterModel() {
		if (miRegisterModel == null) {
			miRegisterModel = new JMenuItem("Registrar");
			miRegisterModel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterModel;
	}
	public JMenuItem getMiConsultModel() {
		if (miConsultModel == null) {
			miConsultModel = new JMenuItem("Consultar");
			miConsultModel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultModel;
	}
	public JMenuItem getMiRegisterAeroline() {
		if (miRegisterAeroline == null) {
			miRegisterAeroline = new JMenuItem("Registrar");
			miRegisterAeroline.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterAeroline;
	}
	public JMenuItem getMiConsultAeroline() {
		if (miConsultAeroline == null) {
			miConsultAeroline = new JMenuItem("Consultar");
			miConsultAeroline.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultAeroline;
	}
	public JMenuItem getMiRegisterPlane() {
		if (miRegisterPlane == null) {
			miRegisterPlane = new JMenuItem("Registrar");
			miRegisterPlane.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterPlane;
	}
	public JMenuItem getMiConsultPlane() {
		if (miConsultPlane == null) {
			miConsultPlane = new JMenuItem("Consultar");
			miConsultPlane.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultPlane;
	}
	public JMenuItem getMiRegisterFlight() {
		if (miRegisterFlight == null) {
			miRegisterFlight = new JMenuItem("Registrar");
			miRegisterFlight.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterFlight;
	}
	public JMenuItem getMiConsultFlight() {
		if (miConsultFlight == null) {
			miConsultFlight = new JMenuItem("Consultar");
			miConsultFlight.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultFlight;
	}
	public JMenuItem getMiRegisterPass() {
		if (miRegisterPass == null) {
			miRegisterPass = new JMenuItem("Registrar");
			miRegisterPass.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterPass;
	}
	public JMenuItem getMiConsultPass() {
		if (miConsultPass == null) {
			miConsultPass = new JMenuItem("Consultar");
			miConsultPass.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultPass;
	}
	public JMenuItem getMiRegisterTicket() {
		if (miRegisterTicket == null) {
			miRegisterTicket = new JMenuItem("Registrar");
			miRegisterTicket.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterTicket;
	}
	public JMenuItem getMiConsultTicket() {
		if (miConsultTicket == null) {
			miConsultTicket = new JMenuItem("Consultar");
			miConsultTicket.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultTicket;
	}
	public JMenuItem getMnImpresionT() {
		if (mnImpresionT == null) {
			mnImpresionT = new JMenuItem("Imprimir Tiquetes");
			mnImpresionT.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		}
		return mnImpresionT;
	}
	public JMenuItem getMnHistorialT() {
		if (mnHistorialT == null) {
			mnHistorialT = new JMenuItem("Historial de Tiquetes");
			mnHistorialT.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		}
		return mnHistorialT;
	}
	public JMenuItem getMnVuelos() {
		if (mnVuelos == null) {
			mnVuelos = new JMenuItem("Consultar Vuelos");
			mnVuelos.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		}
		return mnVuelos;
	}
}

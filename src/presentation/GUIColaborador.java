package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings({ "serial", "unused" })
public class GUIColaborador extends JFrame {
	private JMenuBar menuBar;
	private JMenu mFile;
	private JMenu mOperations;
	private JMenu mHelp;
	private JMenuItem miOpen;
	private JMenuItem miSave;
	private JMenuItem miExit;
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
	private JMenuItem mnConsultBrand;
	private JMenuItem miRegisterModel;
	private JMenuItem mnConsultModel;
	private JMenuItem miRegisterAeroline;
	private JMenuItem mnConsultAeroline;
	private JMenuItem miRegisterPlane;
	private JMenuItem mnConsultPlane;
	private JMenuItem miRegisterFlight;
	private JMenuItem mnConsultFlight;
	private JMenuItem miRegisterPass;
	private JMenuItem miConsultPass;
	private JMenuItem miRegisterTicket;
	private JMenuItem miConsultTicket;
	private JMenuItem mnImpresionT;
	private JMenuItem mnHistorialT;
	private JMenuItem mnVuelos;
	/**
	 * Create the frame.
	 */
	public GUIColaborador() {
		setTitle("Privilegios del Colaborador");
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
	public JMenuItem getMiAboutSystem() {
		if (miAboutSystem == null) {
			miAboutSystem = new JMenuItem("Acerca del Sistema");
		}
		return miAboutSystem;
	}
	public JMenu getMnBrand() {
		if (mnBrand == null) {
			mnBrand = new JMenu("Gestión de Marcas");
			mnBrand.add(getMiRegisterBrand());
			mnBrand.add(getMnConsultBrand());
		}
		return mnBrand;
	}
	public JMenu getMnModel() {
		if (mnModel == null) {
			mnModel = new JMenu("Gestión de Modelos");
			mnModel.add(getMiRegisterModel());
			mnModel.add(getMnConsultModel());
		}
		return mnModel;
	}
	public JMenu getMnAeroline() {
		if (mnAeroline == null) {
			mnAeroline = new JMenu("Gestión de Aerolíneas");
			mnAeroline.add(getMiRegisterAeroline());
			mnAeroline.add(getMnConsultAeroline());
		}
		return mnAeroline;
	}
	public JMenu getMnPlane() {
		if (mnPlane == null) {
			mnPlane = new JMenu("Gestión de Aviones");
			mnPlane.add(getMiRegisterPlane());
			mnPlane.add(getMnConsultPlane());
		}
		return mnPlane;
	}
	public JMenu getMnFlight() {
		if (mnFlight == null) {
			mnFlight = new JMenu("Gestión de Vuelos");
			mnFlight.add(getMiRegisterFlight());
			mnFlight.add(getMnConsultFlight());
		}
		return mnFlight;
	}
	public JMenu getMnPass() {
		if (mnPass == null) {
			mnPass = new JMenu("Gestión de Pasajeros");
			mnPass.add(getMiRegisterPass());
			mnPass.add(getMiConsultPass());
		}
		return mnPass;
	}
	public JMenu getMnTicket() {
		if (mnTicket == null) {
			mnTicket = new JMenu("Gestión de Tiquetes");
			mnTicket.add(getMiRegisterTicket());
			mnTicket.add(getMiConsultTicket());
		}
		return mnTicket;
	}
	public JMenuItem getMiRegisterBrand() {
		if (miRegisterBrand == null) {
			miRegisterBrand = new JMenuItem("Registrar");
		}
		return miRegisterBrand;
	}
	public JMenuItem getMnConsultBrand() {
		if (mnConsultBrand == null) {
			mnConsultBrand = new JMenuItem("Consultar");
		}
		return mnConsultBrand;
	}
	public JMenuItem getMiRegisterModel() {
		if (miRegisterModel == null) {
			miRegisterModel = new JMenuItem("Registrar");
		}
		return miRegisterModel;
	}
	public JMenuItem getMnConsultModel() {
		if (mnConsultModel == null) {
			mnConsultModel = new JMenuItem("Consultar");
		}
		return mnConsultModel;
	}
	public JMenuItem getMiRegisterAeroline() {
		if (miRegisterAeroline == null) {
			miRegisterAeroline = new JMenuItem("Registrar");
		}
		return miRegisterAeroline;
	}
	public JMenuItem getMnConsultAeroline() {
		if (mnConsultAeroline == null) {
			mnConsultAeroline = new JMenuItem("Consultar");
		}
		return mnConsultAeroline;
	}
	public JMenuItem getMiRegisterPlane() {
		if (miRegisterPlane == null) {
			miRegisterPlane = new JMenuItem("Registrar");
		}
		return miRegisterPlane;
	}
	public JMenuItem getMnConsultPlane() {
		if (mnConsultPlane == null) {
			mnConsultPlane = new JMenuItem("Consultar");
		}
		return mnConsultPlane;
	}
	public JMenuItem getMiRegisterFlight() {
		if (miRegisterFlight == null) {
			miRegisterFlight = new JMenuItem("Registrar");
		}
		return miRegisterFlight;
	}
	public JMenuItem getMnConsultFlight() {
		if (mnConsultFlight == null) {
			mnConsultFlight = new JMenuItem("Consultar");
		}
		return mnConsultFlight;
	}
	public JMenuItem getMiRegisterPass() {
		if (miRegisterPass == null) {
			miRegisterPass = new JMenuItem("Registrar");
		}
		return miRegisterPass;
	}
	public JMenuItem getMiConsultPass() {
		if (miConsultPass == null) {
			miConsultPass = new JMenuItem("Consultar");
		}
		return miConsultPass;
	}
	public JMenuItem getMiRegisterTicket() {
		if (miRegisterTicket == null) {
			miRegisterTicket = new JMenuItem("Registrar");
		}
		return miRegisterTicket;
	}
	public JMenuItem getMiConsultTicket() {
		if (miConsultTicket == null) {
			miConsultTicket = new JMenuItem("Consultar");
		}
		return miConsultTicket;
	}
	public JMenuItem getMnImpresionT() {
		if (mnImpresionT == null) {
			mnImpresionT = new JMenuItem("Imprimir Tiquetes");
		}
		return mnImpresionT;
	}
	public JMenuItem getMnHistorialT() {
		if (mnHistorialT == null) {
			mnHistorialT = new JMenuItem("Historial de Tiquetes");
		}
		return mnHistorialT;
	}
	public JMenuItem getMnVuelos() {
		if (mnVuelos == null) {
			mnVuelos = new JMenuItem("Consultar Vuelos");
		}
		return mnVuelos;
	}
}

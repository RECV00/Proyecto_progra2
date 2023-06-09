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
	private JMenuItem miAboutSystem;
	private JPanel contentPane;
	
	private int resultAcces;
	private JMenu mnUser;
	private JMenuItem miRegister;
	private JMenu mnBrand;
	private JMenu mnModel;
	private JMenu mnAeroline;
	private JMenu mnPlane;
	private JMenu mnFlight;
	private JMenu mnPass;
	private JMenu mnTicket;
	private JMenuItem miRemove;
	private JMenuItem miConsult;
	private JMenuItem miUpdate;
	private JMenuItem miRegisterBrand;
	private JMenuItem miRemoveBrand;
	private JMenuItem miConsultBrand;
	private JMenuItem miUpdateBrand;
	private JMenuItem miRegisterModel;
	private JMenuItem miRemoveModel;
	private JMenuItem miConsultModel;
	private JMenuItem miUpdateModel;
	private JMenuItem miRegisterAeroline;
	private JMenuItem miRemoveAeroline;
	private JMenuItem miConsultAeroline;
	private JMenuItem miUpdateAeroline;
	private JMenuItem miRegisterPlane;
	private JMenuItem miRemovePlane;
	private JMenuItem miConsultPlane;
	private JMenuItem miUpdatePlane;
	private JMenuItem miRegisterFlight;
	private JMenuItem miRemoveFlight;
	private JMenuItem miConsultFlight;
	private JMenuItem miUpdateFlight;
	private JMenuItem miRegisterPass;
	private JMenuItem miRemovePass;
	private JMenuItem miConsultPass;
	private JMenuItem miUpdatePass;
	private JMenuItem miRegisterTicket;
	private JMenuItem miRemoveTicket;
	private JMenuItem miConsultTicket;
	private JMenuItem miUpdateTicket;
	private JMenuItem mnImpresionT;
	private JMenuItem mnHistorialT;
	private JMenuItem mnVuelos;
	/**
	 * Create the frame.
	 */
	public GUIAdmin() {
		setTitle("Privilegios del Administrador");
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
			mOperations.add(getMnUser());
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
	public JMenu getMnUser() {
		if (mnUser == null) {
			mnUser = new JMenu("Gestión de Usuarios");
			mnUser.add(getMiRegister());
			mnUser.add(getMiRemove());
			mnUser.add(getMiConsult());
			mnUser.add(getMiUpdate());
		}
		return mnUser;
	}
	public JMenuItem getMiRegister() {
		if (miRegister == null) {
			miRegister = new JMenuItem("Registrar");
		}
		return miRegister;
	}
	public JMenu getMnBrand() {
		if (mnBrand == null) {
			mnBrand = new JMenu("Gestión de Marcas");
			mnBrand.add(getMiRegisterBrand());
			mnBrand.add(getMiRemoveBrand());
			mnBrand.add(getMiConsultBrand());
			mnBrand.add(getMiUpdateBrand());
		}
		return mnBrand;
	}
	public JMenu getMnModel() {
		if (mnModel == null) {
			mnModel = new JMenu("Gestión de Modelos");
			mnModel.add(getMiRegisterModel());
			mnModel.add(getMiRemoveModel());
			mnModel.add(getMiConsultModel());
			mnModel.add(getMiUpdateModel());
		}
		return mnModel;
	}
	public JMenu getMnAeroline() {
		if (mnAeroline == null) {
			mnAeroline = new JMenu("Gestión de Aerolíneas");
			mnAeroline.add(getMiRegisterAeroline());
			mnAeroline.add(getMiRemoveAeroline());
			mnAeroline.add(getMiConsultAeroline());
			mnAeroline.add(getMiUpdateAeroline());
		}
		return mnAeroline;
	}
	public JMenu getMnPlane() {
		if (mnPlane == null) {
			mnPlane = new JMenu("Gestión de Aviones");
			mnPlane.add(getMiRegisterPlane());
			mnPlane.add(getMiRemovePlane());
			mnPlane.add(getMiConsultPlane());
			mnPlane.add(getMiUpdatePlane());
		}
		return mnPlane;
	}
	public JMenu getMnFlight() {
		if (mnFlight == null) {
			mnFlight = new JMenu("Gestión de Vuelos");
			mnFlight.add(getMiRegisterFlight());
			mnFlight.add(getMiRemoveFlight());
			mnFlight.add(getMiConsultFlight());
			mnFlight.add(getMiUpdateFlight());
		}
		return mnFlight;
	}
	public JMenu getMnPass() {
		if (mnPass == null) {
			mnPass = new JMenu("Gestión de Pasajeros");
			mnPass.add(getMiRegisterPass());
			mnPass.add(getMiRemovePass());
			mnPass.add(getMiConsultPass());
			mnPass.add(getMiUpdatePass());
		}
		return mnPass;
	}
	public JMenu getMnTicket() {
		if (mnTicket == null) {
			mnTicket = new JMenu("Gestión de Tiquetes");
			mnTicket.add(getMiRegisterTicket());
			mnTicket.add(getMiRemoveTicket());
			mnTicket.add(getMiConsultTicket());
			mnTicket.add(getMiUpdateTicket());
		}
		return mnTicket;
	}
	public JMenuItem getMiRemove() {
		if (miRemove == null) {
			miRemove = new JMenuItem("Eliminar");
		}
		return miRemove;
	}
	public JMenuItem getMiConsult() {
		if (miConsult == null) {
			miConsult = new JMenuItem("Consultar");
		}
		return miConsult;
	}
	public JMenuItem getMiUpdate() {
		if (miUpdate == null) {
			miUpdate = new JMenuItem("Actualizar");
		}
		return miUpdate;
	}
	public JMenuItem getMiRegisterBrand() {
		if (miRegisterBrand == null) {
			miRegisterBrand = new JMenuItem("Registrar");
		}
		return miRegisterBrand;
	}
	public JMenuItem getMiRemoveBrand() {
		if (miRemoveBrand == null) {
			miRemoveBrand = new JMenuItem("Eliminar");
		}
		return miRemoveBrand;
	}
	public JMenuItem getMiConsultBrand() {
		if (miConsultBrand == null) {
			miConsultBrand = new JMenuItem("Consultar");
		}
		return miConsultBrand;
	}
	public JMenuItem getMiUpdateBrand() {
		if (miUpdateBrand == null) {
			miUpdateBrand = new JMenuItem("Actualizar");
		}
		return miUpdateBrand;
	}
	public JMenuItem getMiRegisterModel() {
		if (miRegisterModel == null) {
			miRegisterModel = new JMenuItem("Registrar");
		}
		return miRegisterModel;
	}
	public JMenuItem getMiRemoveModel() {
		if (miRemoveModel == null) {
			miRemoveModel = new JMenuItem("Eliminar");
		}
		return miRemoveModel;
	}
	public JMenuItem getMiConsultModel() {
		if (miConsultModel == null) {
			miConsultModel = new JMenuItem("Consultar");
		}
		return miConsultModel;
	}
	public JMenuItem getMiUpdateModel() {
		if (miUpdateModel == null) {
			miUpdateModel = new JMenuItem("Actualizar");
		}
		return miUpdateModel;
	}
	public JMenuItem getMiRegisterAeroline() {
		if (miRegisterAeroline == null) {
			miRegisterAeroline = new JMenuItem("Registrar");
		}
		return miRegisterAeroline;
	}
	public JMenuItem getMiRemoveAeroline() {
		if (miRemoveAeroline == null) {
			miRemoveAeroline = new JMenuItem("Eliminar");
		}
		return miRemoveAeroline;
	}
	public JMenuItem getMiConsultAeroline() {
		if (miConsultAeroline == null) {
			miConsultAeroline = new JMenuItem("Consultar");
		}
		return miConsultAeroline;
	}
	public JMenuItem getMiUpdateAeroline() {
		if (miUpdateAeroline == null) {
			miUpdateAeroline = new JMenuItem("Actualizar");
		}
		return miUpdateAeroline;
	}
	public JMenuItem getMiRegisterPlane() {
		if (miRegisterPlane == null) {
			miRegisterPlane = new JMenuItem("Registrar");
		}
		return miRegisterPlane;
	}
	public JMenuItem getMiRemovePlane() {
		if (miRemovePlane == null) {
			miRemovePlane = new JMenuItem("Eliminar");
		}
		return miRemovePlane;
	}
	public JMenuItem getMiConsultPlane() {
		if (miConsultPlane == null) {
			miConsultPlane = new JMenuItem("Consultar");
		}
		return miConsultPlane;
	}
	public JMenuItem getMiUpdatePlane() {
		if (miUpdatePlane == null) {
			miUpdatePlane = new JMenuItem("Actualizar");
		}
		return miUpdatePlane;
	}
	public JMenuItem getMiRegisterFlight() {
		if (miRegisterFlight == null) {
			miRegisterFlight = new JMenuItem("Registrar");
		}
		return miRegisterFlight;
	}
	public JMenuItem getMiRemoveFlight() {
		if (miRemoveFlight == null) {
			miRemoveFlight = new JMenuItem("Eliminar");
		}
		return miRemoveFlight;
	}
	public JMenuItem getMiConsultFlight() {
		if (miConsultFlight == null) {
			miConsultFlight = new JMenuItem("Consultar");
		}
		return miConsultFlight;
	}
	public JMenuItem getMiUpdateFlight() {
		if (miUpdateFlight == null) {
			miUpdateFlight = new JMenuItem("Actualizar");
		}
		return miUpdateFlight;
	}
	public JMenuItem getMiRegisterPass() {
		if (miRegisterPass == null) {
			miRegisterPass = new JMenuItem("Registrar");
		}
		return miRegisterPass;
	}
	public JMenuItem getMiRemovePass() {
		if (miRemovePass == null) {
			miRemovePass = new JMenuItem("Eliminar");
		}
		return miRemovePass;
	}
	public JMenuItem getMiConsultPass() {
		if (miConsultPass == null) {
			miConsultPass = new JMenuItem("Consultar");
		}
		return miConsultPass;
	}
	public JMenuItem getMiUpdatePass() {
		if (miUpdatePass == null) {
			miUpdatePass = new JMenuItem("Actualizar");
		}
		return miUpdatePass;
	}
	public JMenuItem getMiRegisterTicket() {
		if (miRegisterTicket == null) {
			miRegisterTicket = new JMenuItem("Registrar");
		}
		return miRegisterTicket;
	}
	public JMenuItem getMiRemoveTicket() {
		if (miRemoveTicket == null) {
			miRemoveTicket = new JMenuItem("Eliminar");
		}
		return miRemoveTicket;
	}
	public JMenuItem getMiConsultTicket() {
		if (miConsultTicket == null) {
			miConsultTicket = new JMenuItem("Consultar");
		}
		return miConsultTicket;
	}
	public JMenuItem getMiUpdateTicket() {
		if (miUpdateTicket == null) {
			miUpdateTicket = new JMenuItem("Actualizar");
		}
		return miUpdateTicket;
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


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
	private JMenuItem mnRemove;
	private JMenuItem mnConsult;
	private JMenuItem mnUpdate;
	private JMenuItem miRegisterBrand;
	private JMenuItem mnRemoveBrand;
	private JMenuItem mnConsultBrand;
	private JMenuItem mnUpdateBrand;
	private JMenuItem miRegisterModel;
	private JMenuItem mnRemoveModel;
	private JMenuItem mnConsultModel;
	private JMenuItem mnUpdateModel;
	private JMenuItem miRegisterAeroline;
	private JMenuItem mnRemoveAeroline;
	private JMenuItem mnConsultAeroline;
	private JMenuItem mnUpdateAeroline;
	private JMenuItem miRegisterPlane;
	private JMenuItem mnRemovePlane;
	private JMenuItem mnConsultPlane;
	private JMenuItem mnUpdatePlane;
	private JMenuItem miRegisterFlight;
	private JMenuItem mnRemoveFlight;
	private JMenuItem mnConsultFlight;
	private JMenuItem mnUpdateFlight;
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
			mnUser.add(getMnRemove());
			mnUser.add(getMnConsult());
			mnUser.add(getMnUpdate());
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
			mnBrand.add(getMnRemoveBrand());
			mnBrand.add(getMnConsultBrand());
			mnBrand.add(getMnUpdateBrand());
		}
		return mnBrand;
	}
	public JMenu getMnModel() {
		if (mnModel == null) {
			mnModel = new JMenu("Gestión de Modelos");
			mnModel.add(getMiRegisterModel());
			mnModel.add(getMnRemoveModel());
			mnModel.add(getMnConsultModel());
			mnModel.add(getMnUpdateModel());
		}
		return mnModel;
	}
	public JMenu getMnAeroline() {
		if (mnAeroline == null) {
			mnAeroline = new JMenu("Gestión de Aerolíneas");
			mnAeroline.add(getMiRegisterAeroline());
			mnAeroline.add(getMnRemoveAeroline());
			mnAeroline.add(getMnConsultAeroline());
			mnAeroline.add(getMnUpdateAeroline());
		}
		return mnAeroline;
	}
	public JMenu getMnPlane() {
		if (mnPlane == null) {
			mnPlane = new JMenu("Gestión de Aviones");
			mnPlane.add(getMiRegisterPlane());
			mnPlane.add(getMnRemovePlane());
			mnPlane.add(getMnConsultPlane());
			mnPlane.add(getMnUpdatePlane());
		}
		return mnPlane;
	}
	public JMenu getMnFlight() {
		if (mnFlight == null) {
			mnFlight = new JMenu("Gestión de Vuelos");
			mnFlight.add(getMiRegisterFlight());
			mnFlight.add(getMnRemoveFlight());
			mnFlight.add(getMnConsultFlight());
			mnFlight.add(getMnUpdateFlight());
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
	public JMenuItem getMnRemove() {
		if (mnRemove == null) {
			mnRemove = new JMenuItem("Eliminar");
		}
		return mnRemove;
	}
	public JMenuItem getMnConsult() {
		if (mnConsult == null) {
			mnConsult = new JMenuItem("Consultar");
		}
		return mnConsult;
	}
	public JMenuItem getMnUpdate() {
		if (mnUpdate == null) {
			mnUpdate = new JMenuItem("Actualizar");
		}
		return mnUpdate;
	}
	public JMenuItem getMiRegisterBrand() {
		if (miRegisterBrand == null) {
			miRegisterBrand = new JMenuItem("Registrar");
		}
		return miRegisterBrand;
	}
	public JMenuItem getMnRemoveBrand() {
		if (mnRemoveBrand == null) {
			mnRemoveBrand = new JMenuItem("Eliminar");
		}
		return mnRemoveBrand;
	}
	public JMenuItem getMnConsultBrand() {
		if (mnConsultBrand == null) {
			mnConsultBrand = new JMenuItem("Consultar");
		}
		return mnConsultBrand;
	}
	public JMenuItem getMnUpdateBrand() {
		if (mnUpdateBrand == null) {
			mnUpdateBrand = new JMenuItem("Actualizar");
		}
		return mnUpdateBrand;
	}
	public JMenuItem getMiRegisterModel() {
		if (miRegisterModel == null) {
			miRegisterModel = new JMenuItem("Registrar");
		}
		return miRegisterModel;
	}
	public JMenuItem getMnRemoveModel() {
		if (mnRemoveModel == null) {
			mnRemoveModel = new JMenuItem("Eliminar");
		}
		return mnRemoveModel;
	}
	public JMenuItem getMnConsultModel() {
		if (mnConsultModel == null) {
			mnConsultModel = new JMenuItem("Consultar");
		}
		return mnConsultModel;
	}
	public JMenuItem getMnUpdateModel() {
		if (mnUpdateModel == null) {
			mnUpdateModel = new JMenuItem("Actualizar");
		}
		return mnUpdateModel;
	}
	public JMenuItem getMiRegisterAeroline() {
		if (miRegisterAeroline == null) {
			miRegisterAeroline = new JMenuItem("Registrar");
		}
		return miRegisterAeroline;
	}
	public JMenuItem getMnRemoveAeroline() {
		if (mnRemoveAeroline == null) {
			mnRemoveAeroline = new JMenuItem("Eliminar");
		}
		return mnRemoveAeroline;
	}
	public JMenuItem getMnConsultAeroline() {
		if (mnConsultAeroline == null) {
			mnConsultAeroline = new JMenuItem("Consultar");
		}
		return mnConsultAeroline;
	}
	public JMenuItem getMnUpdateAeroline() {
		if (mnUpdateAeroline == null) {
			mnUpdateAeroline = new JMenuItem("Actualizar");
		}
		return mnUpdateAeroline;
	}
	public JMenuItem getMiRegisterPlane() {
		if (miRegisterPlane == null) {
			miRegisterPlane = new JMenuItem("Registrar");
		}
		return miRegisterPlane;
	}
	public JMenuItem getMnRemovePlane() {
		if (mnRemovePlane == null) {
			mnRemovePlane = new JMenuItem("Eliminar");
		}
		return mnRemovePlane;
	}
	public JMenuItem getMnConsultPlane() {
		if (mnConsultPlane == null) {
			mnConsultPlane = new JMenuItem("Consultar");
		}
		return mnConsultPlane;
	}
	public JMenuItem getMnUpdatePlane() {
		if (mnUpdatePlane == null) {
			mnUpdatePlane = new JMenuItem("Actualizar");
		}
		return mnUpdatePlane;
	}
	public JMenuItem getMiRegisterFlight() {
		if (miRegisterFlight == null) {
			miRegisterFlight = new JMenuItem("Registrar");
		}
		return miRegisterFlight;
	}
	public JMenuItem getMnRemoveFlight() {
		if (mnRemoveFlight == null) {
			mnRemoveFlight = new JMenuItem("Eliminar");
		}
		return mnRemoveFlight;
	}
	public JMenuItem getMnConsultFlight() {
		if (mnConsultFlight == null) {
			mnConsultFlight = new JMenuItem("Consultar");
		}
		return mnConsultFlight;
	}
	public JMenuItem getMnUpdateFlight() {
		if (mnUpdateFlight == null) {
			mnUpdateFlight = new JMenuItem("Actualizar");
		}
		return mnUpdateFlight;
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


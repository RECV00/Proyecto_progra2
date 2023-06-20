package presentation;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings({ "serial", "unused" })
public class GUIAdmin extends JFrame {
	private JMenuBar menuBar;
	private JMenu mFile;
	private JMenu mOperations;
	private JMenu mHelp;
	private JMenuItem miOpen;
	private JMenuItem miSave;
	private JMenuItem miiExit;
	private JMenuItem miAboutSystem;
	private JPanel contentPane;
	private JLabel li;
	
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
		setBounds(100, 100, 730, 501);
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
		li.setBounds(0, 0, 714, 482);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIAdmin.class.getResource("/media/4.png")));
		getContentPane().add(li);
		}
		return li;
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(new Color(255, 255, 255));
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
	public JMenu getMnUser() {
		if (mnUser == null) {
			mnUser = new JMenu("Gestión de Usuarios");
			mnUser.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
			mnUser.add(getMiRegister());
			mnUser.add(getMiRemove());
			mnUser.add(getMiConsult());
			mnUser.add(getMiUpdate());
		}
		return mnUser;
	}
		public JMenu getMnBrand() {
		if (mnBrand == null) {
			mnBrand = new JMenu("Gestión de Marcas");
			mnBrand.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
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
			mnModel.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
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
			mnAeroline.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
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
			mnPlane.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
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
			mnFlight.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
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
			mnPass.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
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
			mnTicket.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
			mnTicket.add(getMiRegisterTicket());
			mnTicket.add(getMiRemoveTicket());
			mnTicket.add(getMiConsultTicket());
			mnTicket.add(getMiUpdateTicket());
		}
		return mnTicket;
	}
	public JMenuItem getMiRegister() {
		if (miRegister == null) {
			miRegister = new JMenuItem("Registrar");
			miRegister.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegister;
	}

	public JMenuItem getMiRemove() {
		if (miRemove == null) {
			miRemove = new JMenuItem("Eliminar");
			miRemove.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRemove;
	}
	public JMenuItem getMiConsult() {
		if (miConsult == null) {
			miConsult = new JMenuItem("Consultar");
			miConsult.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsult;
	}
	public JMenuItem getMiUpdate() {
		if (miUpdate == null) {
			miUpdate = new JMenuItem("Actualizar");
			miUpdate.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miUpdate;
	}
	public JMenuItem getMiRegisterBrand() {
		if (miRegisterBrand == null) {
			miRegisterBrand = new JMenuItem("Registrar");
			miRegisterBrand.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterBrand;
	}
	public JMenuItem getMiRemoveBrand() {
		if (miRemoveBrand == null) {
			miRemoveBrand = new JMenuItem("Eliminar");
			miRemoveBrand.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRemoveBrand;
	}
	public JMenuItem getMiConsultBrand() {
		if (miConsultBrand == null) {
			miConsultBrand = new JMenuItem("Consultar");
			miConsultBrand.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultBrand;
	}
	public JMenuItem getMiUpdateBrand() {
		if (miUpdateBrand == null) {
			miUpdateBrand = new JMenuItem("Actualizar");
			miUpdateBrand.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miUpdateBrand;
	}
	public JMenuItem getMiRegisterModel() {
		if (miRegisterModel == null) {
			miRegisterModel = new JMenuItem("Registrar");
			miRegisterModel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterModel;
	}
	public JMenuItem getMiRemoveModel() {
		if (miRemoveModel == null) {
			miRemoveModel = new JMenuItem("Eliminar");
			miRemoveModel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRemoveModel;
	}
	public JMenuItem getMiConsultModel() {
		if (miConsultModel == null) {
			miConsultModel = new JMenuItem("Consultar");
			miConsultModel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultModel;
	}
	public JMenuItem getMiUpdateModel() {
		if (miUpdateModel == null) {
			miUpdateModel = new JMenuItem("Actualizar");
			miUpdateModel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miUpdateModel;
	}
	public JMenuItem getMiRegisterAeroline() {
		if (miRegisterAeroline == null) {
			miRegisterAeroline = new JMenuItem("Registrar");
			miRegisterAeroline.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterAeroline;
	}
	public JMenuItem getMiRemoveAeroline() {
		if (miRemoveAeroline == null) {
			miRemoveAeroline = new JMenuItem("Eliminar");
			miRemoveAeroline.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRemoveAeroline;
	}
	public JMenuItem getMiConsultAeroline() {
		if (miConsultAeroline == null) {
			miConsultAeroline = new JMenuItem("Consultar");
			miConsultAeroline.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultAeroline;
	}
	public JMenuItem getMiUpdateAeroline() {
		if (miUpdateAeroline == null) {
			miUpdateAeroline = new JMenuItem("Actualizar");
			miUpdateAeroline.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miUpdateAeroline;
	}
	public JMenuItem getMiRegisterPlane() {
		if (miRegisterPlane == null) {
			miRegisterPlane = new JMenuItem("Registrar");
			miRegisterPlane.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterPlane;
	}
	public JMenuItem getMiRemovePlane() {
		if (miRemovePlane == null) {
			miRemovePlane = new JMenuItem("Eliminar");
			miRemovePlane.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRemovePlane;
	}
	public JMenuItem getMiConsultPlane() {
		if (miConsultPlane == null) {
			miConsultPlane = new JMenuItem("Consultar");
			miConsultPlane.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultPlane;
	}
	public JMenuItem getMiUpdatePlane() {
		if (miUpdatePlane == null) {
			miUpdatePlane = new JMenuItem("Actualizar");
			miUpdatePlane.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miUpdatePlane;
	}
	public JMenuItem getMiRegisterFlight() {
		if (miRegisterFlight == null) {
			miRegisterFlight = new JMenuItem("Registrar");
			miRegisterFlight.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterFlight;
	}
	public JMenuItem getMiRemoveFlight() {
		if (miRemoveFlight == null) {
			miRemoveFlight = new JMenuItem("Eliminar");
			miRemoveFlight.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRemoveFlight;
	}
	public JMenuItem getMiConsultFlight() {
		if (miConsultFlight == null) {
			miConsultFlight = new JMenuItem("Consultar");
			miConsultFlight.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultFlight;
	}
	public JMenuItem getMiUpdateFlight() {
		if (miUpdateFlight == null) {
			miUpdateFlight = new JMenuItem("Actualizar");
			miUpdateFlight.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miUpdateFlight;
	}
	public JMenuItem getMiRegisterPass() {
		if (miRegisterPass == null) {
			miRegisterPass = new JMenuItem("Registrar");
			miRegisterPass.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterPass;
	}
	public JMenuItem getMiRemovePass() {
		if (miRemovePass == null) {
			miRemovePass = new JMenuItem("Eliminar");
			miRemovePass.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRemovePass;
	}
	public JMenuItem getMiConsultPass() {
		if (miConsultPass == null) {
			miConsultPass = new JMenuItem("Consultar");
			miConsultPass.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultPass;
	}
	public JMenuItem getMiUpdatePass() {
		if (miUpdatePass == null) {
			miUpdatePass = new JMenuItem("Actualizar");
			miUpdatePass.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miUpdatePass;
	}
	public JMenuItem getMiRegisterTicket() {
		if (miRegisterTicket == null) {
			miRegisterTicket = new JMenuItem("Registrar");
			miRegisterTicket.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRegisterTicket;
	}
	public JMenuItem getMiRemoveTicket() {
		if (miRemoveTicket == null) {
			miRemoveTicket = new JMenuItem("Eliminar");
			miRemoveTicket.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miRemoveTicket;
	}
	public JMenuItem getMiConsultTicket() {
		if (miConsultTicket == null) {
			miConsultTicket = new JMenuItem("Consultar");
			miConsultTicket.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miConsultTicket;
	}
	public JMenuItem getMiUpdateTicket() {
		if (miUpdateTicket == null) {
			miUpdateTicket = new JMenuItem("Actualizar");
			miUpdateTicket.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return miUpdateTicket;
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


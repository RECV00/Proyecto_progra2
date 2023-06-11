package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUIAdmin;

public class ControllerAdmin implements ActionListener{
	private GUIAdmin guiA;
	private FilesXML fXML;
	
	public ControllerAdmin() {
		// TODO Auto-generated constructor stub
		guiA= new GUIAdmin();
		fXML= new FilesXML();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		//opciones usuario
		guiA.getMiRegister().addActionListener(this);
		guiA.getMiConsult().addActionListener(this);
		guiA.getMiRemove().addActionListener(this);
		guiA.getMiUpdate().addActionListener(this);
		//opciones marcas
		guiA.getMiRegisterBrand().addActionListener(this);
		guiA.getMiConsultBrand().addActionListener(this);
		guiA.getMiRemoveBrand().addActionListener(this);
		guiA.getMiUpdateBrand().addActionListener(this);
		//opciones modelo
		guiA.getMiRegisterModel().addActionListener(this);
		guiA.getMiConsultModel().addActionListener(this);
		guiA.getMiRemoveModel().addActionListener(this);
		guiA.getMiUpdateModel().addActionListener(this);
		//aerolinea
		guiA.getMiRegisterAeroline().addActionListener(this);
		guiA.getMiConsultAeroline().addActionListener(this);
		guiA.getMiRemoveAeroline().addActionListener(this);
		guiA.getMiUpdateAeroline().addActionListener(this);
		//aviones
		guiA.getMiRegisterPlane().addActionListener(this);
		guiA.getMiConsultPlane().addActionListener(this);
		guiA.getMiRemovePlane().addActionListener(this);
		guiA.getMiUpdatePlane().addActionListener(this);
		//opciones vuelos
		guiA.getMiRegisterFlight().addActionListener(this);
		guiA.getMiConsultFlight().addActionListener(this);
		guiA.getMiRemoveFlight().addActionListener(this);
		guiA.getMiUpdateFlight().addActionListener(this);
		//opciones pasajero
		guiA.getMiRegisterPass().addActionListener(this);
		guiA.getMiConsultPass().addActionListener(this);
		guiA.getMiRemovePass().addActionListener(this);
		guiA.getMiUpdatePass().addActionListener(this);
		//opciones tiquetes
		guiA.getMiRegisterTicket().addActionListener(this);
		guiA.getMiConsultTicket().addActionListener(this);
		guiA.getMiRemoveTicket().addActionListener(this);
		guiA.getMiUpdateTicket().addActionListener(this);
		//impresion
		guiA.getMnImpresionT().addActionListener(this);
		guiA.getMnHistorialT().addActionListener(this);
		guiA.getMnVuelos().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//usuario
		if(e.getSource() == guiA.getMiRegister()) {
			new ControllerRegisterUser();
		}
		if(e.getSource() == guiA.getMiConsult()) {
			new ControllerConsultUser();
		}
		if(e.getSource() == guiA.getMiRemove()) {
			new ControllerDeleteUser();
		}
		if(e.getSource() == guiA.getMiUpdate()) {
			new ControllerUpdateUser();
		}
		//marca
		if(e.getSource() == guiA.getMiRegisterBrand()) {
			new ControllerRegisterBrand();
		}
		if(e.getSource() == guiA.getMiConsultBrand()) {
			new ControllerConsultBrand();
		}
		if(e.getSource() == guiA.getMiRemoveBrand()) {
			new ControllerDeleteBrand();
		}
		if(e.getSource() == guiA.getMiUpdateBrand()) {
			new ControllerUpdateBrand();
		}
		//modelo
		if(e.getSource() == guiA.getMiRegisterModel()) {
			new ControllerRegisterModel();
		}
		if(e.getSource() == guiA.getMiConsultModel()) {
			new ControllerConsultModel();
		}
		if(e.getSource() == guiA.getMiRemoveModel()) {
			new ControllerDeleteModel();
		}
		if(e.getSource() == guiA.getMiUpdateModel()) {
			new ControllerUpdateModel();
		}
		//aerolinea
		if(e.getSource() == guiA.getMiRegisterAeroline()) {
			new ControllerRegisterAirline();
		}
		if(e.getSource() == guiA.getMiConsultAeroline()) {
			new ControllerConsultAirline();
		}
		if(e.getSource() == guiA.getMiRemoveAeroline()) {
			new ControllerDeleteAirline();
		}
		if(e.getSource() == guiA.getMiUpdateAeroline()) {
			new ControllerUpdateAirline();
		}
		//vuelos
		if(e.getSource() == guiA.getMiRegisterFlight()) {
			new ControllerRegisterFlight();
		}
		if(e.getSource() == guiA.getMiConsultFlight()) {
			new ControllerConsultFlight();
		}
		if(e.getSource() == guiA.getMiRemoveFlight()) {
			new ControllerDeleteFlight();
		}
		if(e.getSource() == guiA.getMiUpdateFlight()) {
			new ControllerUpdateFlight();
		}
		//aviones
		if(e.getSource() == guiA.getMiRegisterPlane()) {
			new ControllerRegisterPlane();
		}
		if(e.getSource() == guiA.getMiConsultPlane()) {
			new ControllerConsultPlane();
		}
		if(e.getSource() == guiA.getMiRemovePlane()) {
			new ControllerDeletePlane();
		}
		if(e.getSource() == guiA.getMiUpdatePlane()) {
			new ControllerUpdatePlane();
		}
		//pasajeros
		if(e.getSource() == guiA.getMiRegisterPass()) {
			new ControllerRegisterPassenger();
		}
		if(e.getSource() == guiA.getMiConsultPass()) {
			new ControllerConsultPassenger();
		}
		if(e.getSource() == guiA.getMiRemovePass()) {
			new ControllerDeletePassenger();
		}
		if(e.getSource() == guiA.getMiUpdatePass()) {
			new ControllerUpdatePassenger();
		}
		//tiquetes
		if(e.getSource() == guiA.getMiRegisterTicket()) {
			new ControllerRegisterTicket();
		}
		if(e.getSource() == guiA.getMiConsultTicket()) {
			new ControllerConsultTicket();
		}
		if(e.getSource() == guiA.getMiRemoveTicket()) {
			new ControllerDeleteTicket();
		}
		if(e.getSource() == guiA.getMiUpdateTicket()) {
			new ControllerUpdateTicket();
		}
		//otras opciones
		if(e.getSource() == guiA.getMnImpresionT()) {
			new ControllerImpresionT();
		}
		if(e.getSource() == guiA.getMnHistorialT()) {
			new ControllerHistorialT();
		}
		if(e.getSource() == guiA.getMnVuelos()) {
			new ControllerVuelos();
		}
		else if(e.getSource()== guiA.getMiiExit()) {
			//System.exit(0);
			guiA.dispose();
			new ControllerLogin();
		}

	}

}

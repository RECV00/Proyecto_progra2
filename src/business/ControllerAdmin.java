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
			new ControllerRegisterBrand();
		}
		if(e.getSource() == guiA.getMiRemove()) {
			new ControllerRegisterModel();
		}
		if(e.getSource() == guiA.getMiUpdate()) {
			new ControllerRegisterAirline();
		}
		//marca
		if(e.getSource() == guiA.getMiRegisterBrand()) {
			new ControllerRegisterPlane();
		}
		if(e.getSource() == guiA.getMiConsultBrand()) {
			new ControllerRegisterFlight();
		}
		if(e.getSource() == guiA.getMiRemoveBrand()) {
			new ControllerRegisterPassenger();
		}
		if(e.getSource() == guiA.getMiUpdateBrand()) {
			new ControllerRegisterTicket();
		}
		//modelo
		if(e.getSource() == guiA.getMiRegisterModel()) {
			new ControllerImpresionT();
		}
		if(e.getSource() == guiA.getMiConsultModel()) {
			new ControllerRegisterVuelos();
		}
		if(e.getSource() == guiA.getMiRemoveModel()) {
			new ControllerRegisterVuelos();
		}
		if(e.getSource() == guiA.getMiUpdateModel()) {
			new ControllerRegisterVuelos();
		}
		//aerolinea
		if(e.getSource() == guiA.getMiRegisterAeroline()) {
			new ControllerImpresionT();
		}
		if(e.getSource() == guiA.getMiConsultAeroline()) {
			new ControllerRegisterVuelos();
		}
		if(e.getSource() == guiA.getMiRemoveAeroline()) {
			new ControllerRegisterVuelos();
		}
		if(e.getSource() == guiA.getMiUpdateAeroline()) {
			new ControllerRegisterVuelos();
		}
		//vuelos
		if(e.getSource() == guiA.getMiRegisterFlight()) {
			new ControllerImpresionT();
		}
		if(e.getSource() == guiA.getMiConsultFlight()) {
			new ControllerRegisterVuelos();
		}
		if(e.getSource() == guiA.getMiRemoveFlight()) {
			new ControllerRegisterVuelos();
		}
		if(e.getSource() == guiA.getMiUpdateFlight()) {
			new ControllerRegisterVuelos();
		}
		//aviones
		if(e.getSource() == guiA.getMiRegisterPlane()) {
			new ControllerImpresionT();
		}
		if(e.getSource() == guiA.getMiConsultPlane()) {
			new ControllerRegisterVuelos();
		}
		if(e.getSource() == guiA.getMiRemovePlane()) {
			new ControllerRegisterVuelos();
		}
		if(e.getSource() == guiA.getMiUpdatePlane()) {
			new ControllerRegisterVuelos();
		}
		//pasajeros
		if(e.getSource() == guiA.getMiRegisterPass()) {
			new ControllerImpresionT();
		}
		if(e.getSource() == guiA.getMiConsultPass()) {
			new ControllerRegisterVuelos();
		}
		if(e.getSource() == guiA.getMiRemovePass()) {
			new ControllerRegisterVuelos();
		}
		if(e.getSource() == guiA.getMiUpdatePass()) {
			new ControllerRegisterVuelos();
		}
		//tiquetes
		if(e.getSource() == guiA.getMiRegisterTicket()) {
			new ControllerImpresionT();
		}
		if(e.getSource() == guiA.getMiConsultTicket()) {
			new ControllerRegisterVuelos();
		}
		if(e.getSource() == guiA.getMiRemoveTicket()) {
			new ControllerRegisterVuelos();
		}
		if(e.getSource() == guiA.getMiUpdateTicket()) {
			new ControllerRegisterVuelos();
		}
		//otras opciones
		if(e.getSource() == guiA.getMnImpresionT()) {
			new ControllerImpresionT();
		}
		if(e.getSource() == guiA.getMnHistorialT()) {
			new ControllerRegisterVuelos();
		}
		if(e.getSource() == guiA.getMnVuelos()) {
			new ControllerRegisterVuelos();
		}
		
	}

}

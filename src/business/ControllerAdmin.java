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
		if(e.getSource() == guiA.getMiRegister()) {
			new ControllerUser();
		}
		if(e.getSource() == guiA.getMnBrand()) {
			new ControllerBrand();
		}
		if(e.getSource() == guiA.getMnModel()) {
			new ControllerModel();
		}
		if(e.getSource() == guiA.getMnAeroline()) {
			new ControllerAirline();
		}
		if(e.getSource() == guiA.getMnPlane()) {
			new ControllerPlane();
		}
		if(e.getSource() == guiA.getMnFlight()) {
			new ControllerFlight();
		}
		if(e.getSource() == guiA.getMnPass()) {
			new ControllerPassenger();
		}
		if(e.getSource() == guiA.getMnTicket()) {
			new ControllerTicket();
		}
		if(e.getSource() == guiA.getMnImpresionT()) {
			new ControllerImpresionT();
		}
		if(e.getSource() == guiA.getMnVuelos()) {
			new ControllerVuelos();
		}
		
		
	}

}

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
		guiA.getMnUser().addActionListener(this);
		guiA.getMnBrand().addActionListener(this);
		guiA.getMnModel().addActionListener(this);
		guiA.getMnAeroline().addActionListener(this);
		guiA.getMnPlane().addActionListener(this);
		guiA.getMnFlight().addActionListener(this);
		guiA.getMnPass().addActionListener(this);
		guiA.getMnTicket().addActionListener(this);
		guiA.getMnImpresionT().addActionListener(this);
		guiA.getMnVuelos().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiA.getMnUser()) {
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

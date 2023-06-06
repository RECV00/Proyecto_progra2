package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUIAdmin;

public class ControllerColaborador implements ActionListener{
	private GUIAdmin guiA;
	private FilesXML fXML;
	
	public ControllerColaborador() {
		// TODO Auto-generated constructor stub
		guiA= new GUIAdmin();
		fXML= new FilesXML();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiA.getMiUsers().addActionListener(this);
		guiA.getMiBrand().addActionListener(this);
		guiA.getMiModel().addActionListener(this);
		guiA.getMiAirline().addActionListener(this);
		guiA.getMiPlane().addActionListener(this);
		guiA.getMiFlight().addActionListener(this);
		guiA.getMiPassenger().addActionListener(this);
		guiA.getMiTickert().addActionListener(this);
		guiA.getMiImpresionT().addActionListener(this);
		guiA.getMiVuelos().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiA.getMiUsers()) {
			new ControllerUser;
		}
		if(e.getSource() == guiA.getMiBrand()) {
			new ControllerBrand;
		}
		if(e.getSource() == guiA.getMiModel()) {
			new ControllerModel;
		}
		if(e.getSource() == guiA.getMiAirline()) {
			new ControllerAirline;
		}
		if(e.getSource() == guiA.getMiPlane()) {
			new ControllerPlane;
		}
		if(e.getSource() == guiA.getMiFlight()) {
			new ControllerFlight;
		}
		if(e.getSource() == guiA.getMiPassenger()) {
			new ControllerPassenger;
		}
		if(e.getSource() == guiA.getMiTickert()) {
			new ControllerTicket;
		}
		if(e.getSource() == guiA.getMiImpresionT()) {
			new ControllerImpresionT;
		}
		if(e.getSource() == guiA.getMiVuelos()) {
			new ControllerVuelos;
		}
		
		
	}

}
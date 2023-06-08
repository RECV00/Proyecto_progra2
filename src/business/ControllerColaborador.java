package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUIAdmin;
import presentation.GUIColaborador;

public class ControllerColaborador implements ActionListener{
	private GUIColaborador guiC;
	private FilesXML fXML;
	
	public ControllerColaborador() {
		// TODO Auto-generated constructor stub
		guiC= new GUIColaborador();
		fXML= new FilesXML();
		
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiC.getMiUsers().addActionListener(this);
		guiC.getMiBrand().addActionListener(this);
		guiC.getMiModel().addActionListener(this);
		guiC.getMiAirline().addActionListener(this);
		guiC.getMiPlane().addActionListener(this);
		guiC.getMiFlight().addActionListener(this);
		guiC.getMiPassenger().addActionListener(this);
		guiC.getMiTickert().addActionListener(this);
		guiC.getMiImpresionT().addActionListener(this);
		guiC.getMiVuelos().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiC.getMiUsers()) {
			new ControllerUser();
		}
		if(e.getSource() == guiC.getMiBrand()) {
			new ControllerBrand();
		}
		if(e.getSource() == guiC.getMiModel()) {
			new ControllerModel();
		}
		if(e.getSource() == guiC.getMiAirline()) {
			new ControllerAirline();
		}
		if(e.getSource() == guiC.getMiPlane()) {
			new ControllerPlane();
		}
		if(e.getSource() == guiC.getMiFlight()) {
			new ControllerFlight();
		}
		if(e.getSource() == guiC.getMiPassenger()) {
			new ControllerPassenger();
		}
		if(e.getSource() == guiC.getMiTickert()) {
			new ControllerTicket();
		}
		if(e.getSource() == guiC.getMiImpresionT()) {
			new ControllerImpresionT();
		}
		if(e.getSource() == guiC.getMiVuelos()) {
			new ControllerVuelos();
		}
		
		
	}

}
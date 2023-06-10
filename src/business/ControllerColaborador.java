package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUIColaborador;

public class ControllerColaborador implements ActionListener{
	private GUIColaborador guiC;
	@SuppressWarnings("unused")
	private FilesXML fXML;
	
	public ControllerColaborador() {
		// TODO Auto-generated constructor stub
		guiC= new GUIColaborador();
		fXML= new FilesXML();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiC.getMnBrand().addActionListener(this);
		guiC.getMnModel().addActionListener(this);
		guiC.getMnAeroline().addActionListener(this);
		guiC.getMnPlane().addActionListener(this);
		guiC.getMnFlight().addActionListener(this);
		guiC.getMnPass().addActionListener(this);
		guiC.getMnTicket().addActionListener(this);
		guiC.getMnImpresionT().addActionListener(this);
		guiC.getMnVuelos().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiC.getMnBrand()) {
			new ControllerRegisterBrand();
		}
		if(e.getSource() == guiC.getMnModel()) {
			new ControllerRegisterModel();
		}
		if(e.getSource() == guiC.getMnAeroline()) {
			new ControllerRegisterAirline();
		}
		if(e.getSource() == guiC.getMnPlane()) {
			new ControllerRegisterPlane();
		}
		if(e.getSource() == guiC.getMnFlight()) {
			new ControllerRegisterFlight();
		}
		if(e.getSource() == guiC.getMnPass()) {
			new ControllerRegisterPassenger();
		}
		if(e.getSource() == guiC.getMnTicket()) {
			new ControllerRegisterTicket();
		}
		if(e.getSource() == guiC.getMnImpresionT()) {
			new ControllerImpresionT();
		}
		if(e.getSource() == guiC.getMnVuelos()) {
			new ControllerVuelos();
		}
		
		
	}

}

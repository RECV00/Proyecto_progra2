package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Plane;
import presentation.GUIRegisterPlane;


public class ControllerRegisterPlane implements ActionListener{

	private GUIRegisterPlane guiRPlane;
	private FilesXML fXML;
	private Plane plane;
	//ArrayListUser<User> arrayLUser;
	
	public ControllerRegisterPlane() {
	guiRPlane= new GUIRegisterPlane();
	fXML = new FilesXML();
	plane = new Plane();
	fXML.createXML("Plane", "Planes.xml");
	initializer();
	}

	private void initializer() {
		guiRPlane.getBExit().addActionListener(this);
		guiRPlane.getBRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	//	System.out.println(guiRA.getArrayListUser().size());
		//guiRA.print(guiRA.getTUser());//pdf
		
		if(e.getSource()== guiRPlane.getBRegister()) {
			
			plane = new Plane(guiRPlane.getTAvionRegisterPlane().getText(),
					guiRPlane.getTModelRegisterPlane().getText(),
					guiRPlane.getTAirplaneRegisterPalne().getText(),
					guiRPlane.getTYearRegisterPlane().getText());
			
			guiRPlane.cleanForm();
			fXML.writeXML("Planes.xml","Plane",
					plane.getDataName(),plane.getData());
			//guiRF.getArrayListFlight().add(flight);
			//guiRA.getDTMTAirline().addRow(air);
		}
		if(e.getSource()== guiRPlane.getBExit()) {
			//meter la pagina anterior
			guiRPlane.dispose();
			//System.exit(0);
		}
	}
}

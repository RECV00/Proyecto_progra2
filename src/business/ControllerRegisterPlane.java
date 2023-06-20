package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.Logic;
import domain.Plane;
import domain.User;
import presentation.GUIRegisterPlane;


public class ControllerRegisterPlane implements ActionListener{

	private GUIRegisterPlane guiRPlane;
	private FilesXML fXML;
	private Plane plane;
	private Logic lo;
	private ArrayList<Plane> arrayLUser;
	
	public ControllerRegisterPlane() {
	guiRPlane= new GUIRegisterPlane();
	fXML = new FilesXML();
	lo=new Logic();
	plane = new Plane();
	fXML.createXML("Planes", "Planes.xml");
	initializer();
	}

	private void initializer() {
		guiRPlane.getBExit().addActionListener(this);
		guiRPlane.getBRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== guiRPlane.getBRegister()) {
			
			plane = new Plane(guiRPlane.getTAvionRegisterPlane().getText(),
					guiRPlane.getTAirplaneRegisterPalne().getText(),
					guiRPlane.getTModelRegisterPlane().getText(),
					guiRPlane.getTYearRegisterPlane().getText());
			
			fXML.writeXML("Planes.xml","Plane",plane.getDataName(),plane.getData());
			
			arrayLUser = lo.readXMLArrayListPlane("Planes.xml","Plane",plane.getDataName());
			guiRPlane.cleanForm();
			
				guiRPlane.getDTMTPlane().addRow(new Object [] {plane.getPlate(),plane.getAirline(),plane.getModel(),plane.getYear()});
		
		}
		if(e.getSource()== guiRPlane.getBExit()) {
			//meter la pagina anterior
			guiRPlane.dispose();
			//System.exit(0);
		}
	}
}

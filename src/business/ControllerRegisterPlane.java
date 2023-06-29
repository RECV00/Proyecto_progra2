package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.LogicXML;
import domain.Airline;
import domain.Model;
import domain.Plane;
import domain.User;
import presentation.GUIRegisterPlane;


public class ControllerRegisterPlane implements ActionListener{

	private GUIRegisterPlane guiRPlane;
	private FilesXML fXML;
	private Plane plane;
	private LogicXML lo;
	ArrayList<Airline> arrayLA;
	ArrayList<Model> arrayLM;
	ArrayList<Plane> arrayLUser;
	
	public ControllerRegisterPlane() {
	fXML = new FilesXML();
	lo=new LogicXML();
	plane = new Plane();
	fXML.createXML("Planes", "Planes.xml");
	arrayLA=lo.getNAirline("Airlines.xml", "Airline");
	arrayLM=lo.getNModel("Models.xml", "Model");
	guiRPlane= new GUIRegisterPlane(arrayLA,arrayLM);
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
					guiRPlane.getComboBoxAirline().getSelectedItem().toString(),
					guiRPlane.getComboBoxModel().getSelectedItem().toString(),
					guiRPlane.getTYearRegisterPlane().getText());
			
			fXML.writeXML("Planes.xml","Plane",plane.getDataName(),plane.getData());
			
			arrayLUser = lo.readXMLArrayListPlane("Planes.xml","Plane",plane.getDataName());
			guiRPlane.cleanForm();
			
				guiRPlane.getDTMTPlane().addRow(new Object [] {plane.getPlate(),
				guiRPlane.getComboBoxAirline().getSelectedItem().toString(),
				guiRPlane.getComboBoxModel().getSelectedItem().toString(),plane.getYear()});
		
		}
		if(e.getSource()== guiRPlane.getBExit()) {
			//meter la pagina anterior
			guiRPlane.dispose();
			//System.exit(0);
		}
	}
}

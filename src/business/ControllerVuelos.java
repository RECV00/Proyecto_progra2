package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.Logic;
import domain.Flight;
import domain.Plane;
import presentation.GUIVuelos;

public class ControllerVuelos implements ActionListener{
	private GUIVuelos guiV;
	private FilesXML fXML;
	private Logic lo;
	ArrayList<Plane> arrayLP;
	ArrayList<Flight> arrayLF;
	
	public ControllerVuelos() {
		fXML = new FilesXML();
		lo= new Logic();
		//arrayLP=new ArrayList<Plane>();
		arrayLF = lo.getNameFlight("Flights.xml", "Flight");
		System.out.print(arrayLF);
		guiV = new GUIVuelos(arrayLF);
		initializer();
	}

	private void initializer() {
		guiV.getBConsultV().addActionListener(this);
		guiV.getBExit().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==guiV.getBConsultV()) {
			guiV.getDTMTFlight().setRowCount(0);
			guiV.setArrayListFlight(lo.searchXMLFlight("Flights.xml", "Flight", "numFlight", 
			guiV.getComboBoxFlight().getSelectedItem().toString()));
			guiV.setArrayListPlane(lo.getNamePlaneAirline("Planes.xml", "Plane",
			lo.searchXMLAvion("Flights.xml", "Flight", "numFlight",guiV.getComboBoxFlight().getSelectedItem().toString())));
			guiV.fillTable(guiV.getArrayListFlight(),guiV.getArrayListPlane());
			//System.out.print(lo.searchXMLAvion("Flights.xml", "Flight", "numFlight",guiV.getComboBoxFlight().getSelectedItem().toString()));
		}
		
	}

}

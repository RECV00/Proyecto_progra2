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
		arrayLF = lo.getNameFlight("Flights.xml", "Flight");
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
			
			String avion =lo.searchXMLAvion2("Flights.xml", "Flight", "numFlight",guiV.getComboBoxFlight().getSelectedItem().toString());
			String aeroline = lo.getNamePlaneAirline("Planes.xml", "Plane",avion);
			//System.out.print("+++++"+avion+"eeeee"+aeroline);
			//System.out.print("}}}}}"+lo.getNamePlaneAirline("Planes.xml", "Plane",avion));
			guiV.fillTable(guiV.getArrayListFlight(),aeroline);
			
		}
		if(e.getSource()==guiV.getBExit()) {
			guiV.dispose();
		}
		
	}

}

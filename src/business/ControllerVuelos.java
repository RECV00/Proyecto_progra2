package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.LogicXML;
import domain.Flight;
import domain.Plane;
import presentation.GUIVuelos;

public class ControllerVuelos implements ActionListener{
	
	private GUIVuelos guiV;
	private FilesXML fXML;
	private LogicXML lo;
	private Logic logic;
	ArrayList<Plane> arrayLP;
	ArrayList<Flight> arrayLF;
	
	public ControllerVuelos() {
		fXML = new FilesXML();
		lo= new LogicXML();
		logic=new Logic();
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
			String modelo= lo.getNameModelPlane("Planes.xml", "Plane",avion);
			//obtener cantidad de asientos 
			String asiento=lo.searchSeat("Flights.xml", "Flight", "numFlight",guiV.getComboBoxFlight().getSelectedItem().toString());
			int ejecutivo= Integer.parseInt(lo.getCantSeatExecutive("Models.xml", "Model", modelo));
			int turista = Integer.parseInt(lo.getCantSeatTourist("Models.xml", "Model", modelo));
			int economico= Integer.parseInt(lo.getCantSeatEconomic("Models.xml", "Model", modelo));
			int disponibleEJE=logic.getCantExecutiveSeatD(ejecutivo,asiento);
			int disponibleEco=logic.getCantEconomicSeatD(economico,asiento );
			int disponibleTour=logic.getCantTouristSeatD(turista,asiento );
			int vendidoEJE=logic.getCantExecutiveSeatV(economico, asiento);			
			//int montoAsi= Integer.parseInt(lo.getMontoFlight("Flights.xml","Flight",guiV.getComboBoxFlight().getSelectedItem().toString()));
			
			guiV.fillTable(guiV.getDTMTFlight(),guiV.getArrayListFlight(),aeroline,disponibleEJE,disponibleEco,disponibleTour,vendidoEJE);
			
		}
		if(e.getSource()==guiV.getBExit()) {
			guiV.dispose();
		}
		
	}

}


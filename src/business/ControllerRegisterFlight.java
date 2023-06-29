package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.LogicXML;
import domain.Flight;
import domain.Plane;
import presentation.GUIRegisterFlight;

public class ControllerRegisterFlight implements ActionListener{

	private GUIRegisterFlight guiRF;
	private FilesXML fXML;
	private Flight flight;
	private LogicXML lo;
	ArrayList<Plane> arrayLP;
	ArrayList<Flight> arrayLFlight;
	
	public ControllerRegisterFlight() {
	fXML = new FilesXML();
	lo= new LogicXML();
	flight = new Flight();
	fXML.createXML("Flights", "Flights.xml");
	arrayLP= lo.getNamePlane("Planes.xml", "Plane");
	guiRF= new GUIRegisterFlight(arrayLP);
	initializer();
	}

	private void initializer() {
		guiRF.getBExit().addActionListener(this);
		guiRF.getBRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if(e.getSource()== guiRF.getBRegister()) {
			//int indice=guiRF.getComboBoxAvion().getSelectedIndex();
			flight = new Flight(guiRF.getTNumFlight().getText(),
					guiRF.getTDepartureCity().getText(),
					guiRF.getTDepartureDateTime().getText(),
					guiRF.getTArrivalCity().getText(),
					guiRF.getTArrivalDateTime().getText(),
					guiRF.getComboBoxAvion1().getSelectedItem().toString(),
					guiRF.getComboBoxState().getSelectedItem().toString(),
					Integer.valueOf(guiRF.getTAmount().getText()));
			
			fXML.writeXML("Flights.xml","Flight",flight.getDataName(),flight.getData());
			arrayLFlight= lo.readXMLArrayListFlight("Flights.xml","Flight",flight.getDataName());
			guiRF.cleanForm();
			guiRF.getDTMTFlight().addRow(new Object [] {flight.getNumFlight(),
					flight.getDepartureCity(),
					flight.getDepartureDateTime(),
					flight.getArrivalCity(),
					flight.getArrivalDateTime(),
					guiRF.getComboBoxAvion1().getSelectedItem().toString(),
					guiRF.getComboBoxState().getSelectedItem().toString(),
					Integer.valueOf(flight.getAmount())});
			
		}
		if(e.getSource()== guiRF.getBExit()) {
			//meter la pagina anterior
			guiRF.dispose();
			//System.exit(0);
		}
	}
}

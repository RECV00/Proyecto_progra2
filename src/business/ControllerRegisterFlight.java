package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import domain.Flight;
import presentation.GUIRegisterFlight;

public class ControllerRegisterFlight implements ActionListener{

	private GUIRegisterFlight guiRF;
	private FilesXML fXML;
	private Flight flight;
	ArrayList<Flight> arrayLFlight;
	
	public ControllerRegisterFlight() {
	guiRF= new GUIRegisterFlight();
	fXML = new FilesXML();
	flight = new Flight();
	fXML.createXML("Flights", "Flights.xml");
	initializer();
	}

	private void initializer() {
		guiRF.getBExit().addActionListener(this);
		guiRF.getBRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if(e.getSource()== guiRF.getBRegister()) {
			
			flight = new Flight(guiRF.getTNumFlight().getText(),
					guiRF.getTDepartureCity().getText(),guiRF.getTDepartureDateTime().getText(),
					guiRF.getTArrivalCity().getText(),guiRF.getTArrivalDateTime().getText(),
					guiRF.getComboBoxAvion().getSelectedItem().toString(),
					guiRF.getComboBoxState().getSelectedItem().toString(),
					Integer.valueOf(flight.getAmount(guiRF.getComboBoxState().getSelectedItem().toString())));
			
			fXML.writeXML("Flights.xml","Flight",flight.getDataName(),flight.getData());
			arrayLFlight=flight.readXMLArrayList("Flights.xml","Flight",flight.getDataName());
			guiRF.cleanForm();
			guiRF.getDTMTFlight().addRow(new Object [] {flight.getNumFlight(),flight.getDepartureCity(),
					flight.getDepartureDateTime(),flight.getArrivalCity(),flight.getArrivalDateTime(),
					flight.getFlight(),flight.getAmount(guiRF.getComboBoxState().getSelectedItem().toString())});
			
		}
		if(e.getSource()== guiRF.getBExit()) {
			//meter la pagina anterior
			guiRF.dispose();
			//System.exit(0);
		}
	}
}

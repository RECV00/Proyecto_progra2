package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.Logic;
import domain.Flight;
import presentation.GUIUpdateFlight;


public class ControllerUpdateFlight implements ActionListener{

	private GUIUpdateFlight guiUF;
	private FilesXML fXML;
	private Logic lo;
	private Flight flight;
	
	public ControllerUpdateFlight() {
		guiUF= new GUIUpdateFlight();
		fXML= new FilesXML();
		lo= new Logic();
		flight = new Flight();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUF.getBUpdate().addActionListener(this);
		guiUF.getBExit().addActionListener(this);
		
		guiUF.getDTMTFlight().setRowCount(0);
		guiUF.setArrayListFlight(lo.getListFlight("Flights.xml","Flight"));
		guiUF.fillTable(guiUF.getArrayListFlight());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUF.getBUpdate()) {
			flight = new Flight(guiUF.getTNumFlight().getText(),
					guiUF.getTDepartureCity().getText(),guiUF.getTDepartureDateTime().getText(),
					guiUF.getTArrivalCity().getText(),guiUF.getTArrivalDateTime().getText(),
					guiUF.getTFlights().getText(),//cambiar a combobox avion
					guiUF.getComboBoxState().getSelectedItem().toString(),
					Integer.valueOf(flight.getAmount(guiUF.getComboBoxState().getSelectedItem().toString())));
			try {
				fXML.updateXML("Flights.xml","Flight",flight.getDataName(),flight.getData());
				
				guiUF.getDTMTFlight().setRowCount(0);
				guiUF.getDTMTFlight().addRow(new Object [] {flight.getNumFlight(),flight.getDepartureCity(),
					flight.getDepartureDateTime(),flight.getArrivalCity(),flight.getArrivalDateTime(),
					flight.getFlight(),flight.getAmount(guiUF.getComboBoxState().getSelectedItem().toString())});
				
				guiUF.setArrayListFlight(lo.getListFlight("Flights.xml","Flight"));
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== guiUF.getBExit()) {
			guiUF.dispose();
		}
	}
}

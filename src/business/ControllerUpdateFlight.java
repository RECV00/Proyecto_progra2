package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.LogicXML;
import domain.Flight;
import domain.Plane;
import presentation.GUIUpdateFlight;


public class ControllerUpdateFlight implements ActionListener{

	private GUIUpdateFlight guiUF;
	private FilesXML fXML;
	private LogicXML lo;
	private Flight flight;
	ArrayList<Plane> arrayLP;
	
	public ControllerUpdateFlight() {
		fXML= new FilesXML();
		lo= new LogicXML();
		flight = new Flight();
		arrayLP= lo.getNamePlane("Planes.xml", "Plane");
		guiUF= new GUIUpdateFlight(arrayLP);
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUF.getBUpdate().addActionListener(this);
		guiUF.getBExit().addActionListener(this);
		guiUF.getBSearch().addActionListener(this);
		//muestra la tabla llena con los datos de los vuelos
		guiUF.getDTMTFlight().setRowCount(0);
		guiUF.setArrayListFlight(lo.getListFlight("Flights.xml","Flight"));
		guiUF.fillTable(guiUF.getArrayListFlight());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUF.getBSearch()) {
			flight=lo.searchFlight("Flights.xml", "Flight", "numFlight", guiUF.getTNumFlight().getText());
			guiUF.getTDepartureCity().setText(flight.getDepartureCity());
			guiUF.getTDepartureDateTime().setText(flight.getDepartureDateTime());
			guiUF.getTArrivalCity().setText(flight.getArrivalCity());
			guiUF.getTArrivalDateTime().setText(flight.getArrivalDateTime());
			guiUF.getComboBoxAvion().setSelectedItem(flight.getFlight());
			guiUF.getComboBoxState().setSelectedItem(flight.getSeat());
			guiUF.getTAmount().setText(String.valueOf(flight.getAmount()));
		}
		if(e.getSource()==guiUF.getBUpdate()) {
			flight = new Flight(guiUF.getTNumFlight().getText(),
					guiUF.getTDepartureCity().getText(),
					guiUF.getTDepartureDateTime().getText(),
					guiUF.getTArrivalCity().getText(),
					guiUF.getTArrivalDateTime().getText(),
					guiUF.getComboBoxAvion().getSelectedItem().toString(),
					guiUF.getComboBoxState().getSelectedItem().toString(),
					Integer.valueOf(guiUF.getTAmount().getText()));
			try {
				fXML.updateXML("Flights.xml","Flight",flight.getDataName(),flight.getData());
				
				guiUF.getDTMTFlight().setRowCount(0);
				guiUF.getDTMTFlight().addRow(new Object [] {flight.getNumFlight(),
					flight.getDepartureCity(),
					flight.getDepartureDateTime(),
					flight.getArrivalCity(),
					flight.getArrivalDateTime(),
					guiUF.getComboBoxAvion().getSelectedItem().toString(),
					guiUF.getComboBoxState().getSelectedItem().toString(),
					Integer.valueOf(flight.getAmount())});
				
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

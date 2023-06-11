package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Flight;
import presentation.GUIRegisterFlight;

public class ControllerRegisterFlight implements ActionListener{

	private GUIRegisterFlight guiRF;
	private FilesXML fXML;
	private Flight flight;
	//ArrayListUser<User> arrayLUser;
	
	public ControllerRegisterFlight() {
	guiRF= new GUIRegisterFlight();
	fXML = new FilesXML();
	flight = new Flight();
	fXML.createXML("Flight", "Flights.xml");
	initializer();
	}

	private void initializer() {
		guiRF.getBExit().addActionListener(this);
		guiRF.getBRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	//	System.out.println(guiRA.getArrayListUser().size());
		//guiRA.print(guiRA.getTUser());//pdf
		
		if(e.getSource()== guiRF.getBRegister()) {
			
			flight = new Flight(guiRF.getTNumFlight().getText(),
					guiRF.getTDepartureCity().getText(),guiRF.getTDepartureDateTime().getText(),
					guiRF.getTArrivalCity().getText(),guiRF.getTArrivalDateTime().getText(),
					guiRF.getTFlight().getText(),Integer.valueOf(guiRF.getTAmount().getText()));
			
			guiRF.cleanForm();
			fXML.writeXML("Brands.xml","Brand",flight.getDataName(),flight.getData());
			//guiRU.getComboBoxState().getSelectedItem().toString());
			//guiRF.getArrayListFlight().add(flight);
			
			//guiRA.getDTMTAirline().addRow(air);
			
		}
		if(e.getSource()== guiRF.getBExit()) {
			//meter la pagina anterior
			guiRF.dispose();
			//System.exit(0);
		}
	}
}

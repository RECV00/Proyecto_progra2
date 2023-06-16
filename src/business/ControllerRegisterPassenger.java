package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Passenger;
import presentation.GUIRegisterPassenger;


public class ControllerRegisterPassenger implements ActionListener{

	private GUIRegisterPassenger guiRP;
	private FilesXML fXML;
	private Passenger passenger;
	//ArrayListUser<User> arrayLUser;
	
	public ControllerRegisterPassenger() {
	guiRP= new GUIRegisterPassenger();
	fXML = new FilesXML();
	passenger = new Passenger();
	fXML.createXML("Passenger", "Passengers.xml");
	initializer();
	}

	private void initializer() {
		guiRP.getBExit().addActionListener(this);
		guiRP.getBRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== guiRP.getBRegister()) {
			
			passenger = new Passenger(guiRP.getTPassportPassenger().getText(),
					guiRP.getTNamePassenger().getText(),
					guiRP.getTLastNamePassenger().getText(),
					guiRP.getTBirthdatePassenger().getText(),
					guiRP.getTGmailPassenger().getText(),
					Integer.valueOf(guiRP.getTPhonePassenger().getText()));
			
			guiRP.cleanForm();
			fXML.writeXML("Passengers.xml","Passenger",
					passenger.getDataName(),passenger.getData());
			//guiRF.getArrayListFlight().add(flight);
			//guiRA.getDTMTAirline().addRow(air);
		}
		if(e.getSource()== guiRP.getBExit()) {
			//meter la pagina anterior
			guiRP.dispose();
			//System.exit(0);
		}
	}
}

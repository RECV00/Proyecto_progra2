package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.Logic;
import domain.Passenger;
import presentation.GUIRegisterPassenger;


public class ControllerRegisterPassenger implements ActionListener{

	private GUIRegisterPassenger guiRP;
	private FilesXML fXML;
	private Passenger passenger;
	private Logic lo;
	@SuppressWarnings("unused")
	private ArrayList<Passenger> arrayLPassenger;
	
	public ControllerRegisterPassenger() {
	guiRP= new GUIRegisterPassenger();
	fXML = new FilesXML();
	lo= new Logic();
	passenger = new Passenger();
	fXML.createXML("Passengers", "Passengers.xml");
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
			
			fXML.writeXML("Passengers.xml", "Passenger", passenger.getDataName(),passenger.getData());
			arrayLPassenger = lo.readXMLArrayListPassenger("Passengers.xml", "Passenger", passenger.getData());
			guiRP.getDTMTPassenger().addRow(new Object[] {passenger.getPassport(),passenger.getName(),
			passenger.getLastName(),passenger.getBirthdate(),passenger.getGmail(),passenger.getPhone()});
			guiRP.cleanForm();
		}
		if(e.getSource()== guiRP.getBExit()) {
			//meter la pagina anterior
			guiRP.dispose();
			//System.exit(0);
		}
	}
}

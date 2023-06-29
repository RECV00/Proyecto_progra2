package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.LogicXML;
import domain.Passenger;
import presentation.GUIUpdatePassenger;


public class ControllerUpdatePassenger implements ActionListener{

	private GUIUpdatePassenger guiUP;
	private FilesXML fXML;
	private Passenger passenger;
	private LogicXML lo;
	
	public ControllerUpdatePassenger() {
		guiUP= new GUIUpdatePassenger();
		fXML= new FilesXML();
		lo= new LogicXML();
		passenger = new Passenger();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUP.getBUpdate().addActionListener(this);
		guiUP.getBExit().addActionListener(this);
		guiUP.getBSearch().addActionListener(this);
		//muestra la tabla llena 
		guiUP.getDTMTPassenger().setRowCount(0);
		guiUP.setArrayListPassenger(lo.getListPassenger("Passengers.xml","Passenger"));
		guiUP.fillTable(guiUP.getArrayListPassenger());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
if(e.getSource()==guiUP.getBSearch()) {
			
			passenger = lo.searchPassenger("Passengers.xml","Passenger","passport",guiUP.getTPassportPassenger().getText());
			guiUP.getTNamePassenger().setText(passenger.getName());
			guiUP.getTLastNamePassenger().setText(passenger.getLastName());
			guiUP.getTBirthdatePassenger().setText(passenger.getBirthdate());
			guiUP.getTGmailPassenger().setText(passenger.getGmail());
			guiUP.getTPhonePassenger().setText(String.valueOf(passenger.getPhone()));
		}
		if(e.getSource()==guiUP.getBUpdate()) {
			passenger = new Passenger(guiUP.getTPassportPassenger().getText(),
					guiUP.getTNamePassenger().getText(),
					guiUP.getTLastNamePassenger().getText(),
					guiUP.getTBirthdatePassenger().getText(),
					guiUP.getTGmailPassenger().getText(),
					Integer.valueOf(guiUP.getTPhonePassenger().getText()));
			try {
				fXML.updateXML("Passengers.xml","Passenger",passenger.getDataName(),passenger.getData());
				guiUP.getDTMTPassenger().setRowCount(0);
				guiUP.getDTMTPassenger().addRow(new Object[] {passenger.getPassport(),passenger.getName(),
				passenger.getLastName(),passenger.getBirthdate(),passenger.getGmail(),passenger.getPhone()});
				
				guiUP.setArrayListPassenger(lo.getListPassenger("Passengers.xml","Passenger"));

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== guiUP.getBExit()) {
			guiUP.dispose();
		}
	}
}

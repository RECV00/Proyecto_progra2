package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Passenger;
import presentation.GUIDeletePassenger;


public class ControllerDeletePassenger implements ActionListener{

	private GUIDeletePassenger guiDP;
	private FilesXML fXML;
	private Passenger passenger;
	
	public ControllerDeletePassenger() {
		// TODO Auto-generated constructor stub
		guiDP= new GUIDeletePassenger();
		fXML= new FilesXML();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiDP.getBDelete().addActionListener(this);
		guiDP.getBExit().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDP.getBDelete()) {
			fXML.deleteXML("Passengers.xml", guiDP.getTPassportDelete().getText());
		}
		if(e.getSource()== guiDP.getBExit()) {
			guiDP.dispose();
		}
	}

}

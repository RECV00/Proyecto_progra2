package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Flight;
import presentation.GUIDeleteFlight;



public class ControllerDeleteFlight implements ActionListener{

	private GUIDeleteFlight guiDF;
	private FilesXML fXML;
	private Flight flight;
	
	public ControllerDeleteFlight() {
		// TODO Auto-generated constructor stub
		guiDF= new GUIDeleteFlight();
		fXML= new FilesXML();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiDF.getBDelete().addActionListener(this);
		guiDF.getBExit().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDF.getBDelete()) {
			fXML.deleteLine("Flights.xml", guiDF.getTVueloDelete().getText());
		}
		if(e.getSource()== guiDF.getBExit()) {
			guiDF.dispose();
		}
	}

}

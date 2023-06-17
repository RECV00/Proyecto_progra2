package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Flight;
import presentation.GUIConsultFlight;

public class ControllerConsultFlight implements ActionListener{
	private GUIConsultFlight guiCF;
	private Flight flight;
	private FilesXML fXML;
	
	public ControllerConsultFlight() {
		guiCF= new GUIConsultFlight();
		fXML = new FilesXML();
		initializer();
	}
	private void initializer() {
		guiCF.getBCheckHistory().addActionListener(this);
		guiCF.getBSearch().addActionListener(this);
		guiCF.getBExit().addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==guiCF.getBCheckHistory()) {
			//fXML.readXMLString("Flights.xml", "Flight");
		}
		if(e.getSource()== guiCF.getBSearch()) {
			try {
				fXML.searchXML("Flights.xml", guiCF.getTConsultNameVuelo().getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== guiCF.getBExit()) {
			guiCF.dispose();
		}
	}

}

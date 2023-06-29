package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.LogicXML;
import domain.Flight;
import presentation.GUIConsultFlight;

public class ControllerConsultFlight implements ActionListener{
	private GUIConsultFlight guiCF;
	private Flight flight;
	private FilesXML fXML;
	private LogicXML lo;
	
	public ControllerConsultFlight() {
		guiCF= new GUIConsultFlight();
		fXML = new FilesXML();
		lo= new LogicXML();
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
			
			guiCF.getDTMTFlight().setRowCount(0);
			guiCF.setArrayListFlight(lo.getListFlight("Flights.xml", "Flight"));
			guiCF.fillTable(guiCF.getArrayListFlight());
			
		}
		if(e.getSource()== guiCF.getBSearch()) {
			try {
				
				guiCF.getDTMTFlight().setRowCount(0);
				guiCF.setArrayListFlight(lo.searchXMLFlight("Flights.xml", "Flight", "numFlight", guiCF.getTConsultNameVuelo().getText()));
				guiCF.fillTable(guiCF.getArrayListFlight());
				
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

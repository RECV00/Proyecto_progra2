package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.LogicXML;
import domain.Flight;
import presentation.GUIDeleteFlight;



public class ControllerDeleteFlight implements ActionListener{

	private GUIDeleteFlight guiDF;
	private FilesXML fXML;
	private Flight flight;
	private LogicXML lo;
	
	public ControllerDeleteFlight() {
		// TODO Auto-generated constructor stub
		guiDF= new GUIDeleteFlight();
		fXML= new FilesXML();
		lo= new LogicXML();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiDF.getBDelete().addActionListener(this);
		guiDF.getBExit().addActionListener(this);
	
		guiDF.getDTMTFlight().setRowCount(0);
		guiDF.setArrayListFlight(lo.getListFlight("Flights.xml","Flight"));
		guiDF.fillTable(guiDF.getArrayListFlight());
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDF.getBDelete()) {
			fXML.deleteXML("Flights.xml","Flight","numFlight", guiDF.getTVueloDelete().getText());
			guiDF.getDTMTFlight().setRowCount(0);
			guiDF.setArrayListFlight(lo.getListFlight("Flights.xml","Flight"));
			guiDF.fillTable(guiDF.getArrayListFlight());
		
		}
		if(e.getSource()== guiDF.getBExit()) {
			guiDF.dispose();
		}
	}

}

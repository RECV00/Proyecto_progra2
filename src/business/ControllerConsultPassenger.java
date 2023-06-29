package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.LogicXML;
import domain.Passenger;
import domain.User;
import presentation.GUIConsultPassenger;

public class ControllerConsultPassenger implements ActionListener{
	
	private GUIConsultPassenger guiCP;
	private FilesXML fXML;
	private Passenger passenger;
	private LogicXML lo;
	ArrayList<Passenger>arrayLPassenger;
	public ControllerConsultPassenger() {
		guiCP = new GUIConsultPassenger();
		passenger= new Passenger();
		lo= new LogicXML();
		initializer();
	}
	private void initializer() {
		guiCP.getBCheckHistory().addActionListener(this);
		guiCP.getBSearch().addActionListener(this);
		guiCP.getBExit().addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiCP.getBCheckHistory()) {
			guiCP.getDTMTPassenger().setRowCount(0);
			guiCP.setArrayListPassenger(lo.getListPassenger("Passengers.xml", "Passenger"));
			guiCP.fillTable(guiCP.getArrayListPassenger());
		}
		if(e.getSource()==guiCP.getBSearch()) {
		try {//cambiar metodo getlispassenger
			arrayLPassenger = lo.searchXMLPassenger("Passengers.xml", "Passenger","passport", guiCP.getTConsultPasspotPassenger().getText());
			guiCP.getDTMTPassenger().setRowCount(0);
			guiCP.setArrayListPassenger(lo.searchXMLPassenger("Passengers.xml", "Passenger", "passport", guiCP.getTConsultPasspotPassenger().getText()));
			guiCP.fillTable(guiCP.getArrayListPassenger());		
			
		} catch (Exception e1) {

			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		if(e.getSource()==guiCP.getBExit()) {
			guiCP.dispose();
		}
	}

}

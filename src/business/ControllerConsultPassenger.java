package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Passenger;
import presentation.GUIConsultPassenger;

public class ControllerConsultPassenger implements ActionListener{
	
	private GUIConsultPassenger guiCP;
	private FilesXML fXML;
	private Passenger passenger;
	
	public ControllerConsultPassenger() {
		guiCP = new GUIConsultPassenger();
;		passenger= new Passenger();
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
			fXML.readXMLString("Passengers.xml","Passenger");
		}
		if(e.getSource()==guiCP.getBSearch()) {
		try {
			fXML.searchXML("Passengers.xml",guiCP.getTConsultPasspotPassenger().getText());
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

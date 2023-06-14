package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Airline;
import presentation.GUIConsultAirline;

public class ControllerConsultAirline implements ActionListener{
	
	private GUIConsultAirline guiCA;
	private Airline air;
	private FilesXML fXML;
	
	public ControllerConsultAirline() {
		guiCA= new GUIConsultAirline();
		air = new Airline();
		fXML = new FilesXML();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiCA.getBCheckHistory().addActionListener(this);
		guiCA.getBSearch().addActionListener(this);
		guiCA.getBExit().addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiCA.getBCheckHistory()) {
			fXML.readXMLString("Airlines.xml","Airline");
		}
		if(e.getSource()==guiCA.getBSearch()) {
		try {
			fXML.searchXML("Airlines.xml",guiCA.getTConsultAirline().getText());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		if(e.getSource()==guiCA.getBExit()) {
			guiCA.dispose();
		}
	}

}
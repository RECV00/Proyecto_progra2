package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import data.FilesXML;
import data.Logic;
import domain.Airline;
import presentation.GUIConsultAirline;

public class ControllerConsultAirline implements ActionListener{
	
	private GUIConsultAirline guiCA;
	private Airline air;
	private FilesXML fXML;
	private Logic lo;
	ArrayList<Airline>arrayLAirline;
	
	public ControllerConsultAirline() {
		guiCA= new GUIConsultAirline();
		air = new Airline();
		lo= new Logic();
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
		//guiCA.getDTMTAirline().addRow(air.readXMLVector2("Airlines.xml","Airline",air.getDataName()));
			//System.out.print(air.readXMLVector2("Airlines.xml","Airline",air.getDataName()));
	
		}
		if(e.getSource()==guiCA.getBSearch()) {
			try {
				guiCA.getDTMTAirline().addRow(lo.searchXMLVector("Airlines.xml",guiCA.getTConsultAirline().getText()));
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

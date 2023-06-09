package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.LogicXML;
import domain.Airline;
import presentation.GUIUpdateAirline;


public class ControllerUpdateAirline implements ActionListener{

	private GUIUpdateAirline guiUA;
	private FilesXML fXML;
	private LogicXML lo;
	private Airline airline;
	
	public ControllerUpdateAirline() {
		guiUA= new GUIUpdateAirline();
		fXML= new FilesXML();
		lo=new LogicXML();
		airline= new Airline();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUA.getBUpdate().addActionListener(this);
		guiUA.getBExit().addActionListener(this);
		guiUA.getBSearch().addActionListener(this);
		//muestra la tabla llena con datos delas aerolíneas
		guiUA.getDTMTAirline().setRowCount(0);
		guiUA.setArrayListAirline(lo.getListAirline("Airlines.xml","Airline"));
		guiUA.fillTable(guiUA.getArrayListAirline());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUA.getBSearch()) {
			airline=lo.searchAirline("Airlines.xml", "Airline", "name", guiUA.getTNameAeroUpdate().getText());
			guiUA.getTUpdateContry().setText(airline.getContry());
		}
		if(e.getSource()==guiUA.getBUpdate()) {
			
			airline = new Airline(guiUA.getTNameAeroUpdate().getText(),
					guiUA.getTUpdateContry().getText());
			try {
				
				fXML.updateXML("Airlines.xml","Airline",airline.getDataName(),airline.getData());
				guiUA.getDTMTAirline().setRowCount(0);
				guiUA.getDTMTAirline().addRow(new Object [] {airline.getName(),airline.getContry()});
				guiUA.setArrayListAirline(lo.getListAirline("Airlines.xml","Airline"));
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== guiUA.getBExit()) {
			guiUA.dispose();
		}
	}

}

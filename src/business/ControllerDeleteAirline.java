package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.Logic;
import domain.Airline;
import presentation.GUIDeleteAirline;

public class ControllerDeleteAirline implements ActionListener{

	private GUIDeleteAirline guiDA;
	private FilesXML fXML;
	private Airline air;
	private Logic lo;
	
	public ControllerDeleteAirline() {
		// TODO Auto-generated constructor stub
		guiDA= new GUIDeleteAirline();
		fXML= new FilesXML();
		lo=new Logic();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiDA.getBDelete().addActionListener(this);
		guiDA.getBExit().addActionListener(this);
		
		guiDA.getDTMTAirline().setRowCount(0);
		guiDA.setArrayListAirline(lo.getListAirline("Airlines.xml","Airline"));
		guiDA.fillTable(guiDA.getArrayListAirline());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDA.getBDelete()) {
			fXML.deleteXML("Airlines.xml","Airline","name",guiDA.getTNameDeleteAero().getText());
			
			guiDA.getDTMTAirline().setRowCount(0);
			guiDA.setArrayListAirline(lo.getListAirline("Airlines.xml","Airline"));
			guiDA.fillTable(guiDA.getArrayListAirline());
		}
		if(e.getSource()== guiDA.getBExit()) {
			guiDA.dispose();
		}
	}

}

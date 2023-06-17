package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import domain.Airline;
import presentation.GUIRegisterAirline;


public class ControllerRegisterAirline implements ActionListener{
	private ArrayList<Airline>arrayLAirline;
	private GUIRegisterAirline guiRA;
	private FilesXML fXML;
	private Airline air;
	
	public ControllerRegisterAirline() {
	guiRA= new GUIRegisterAirline();
	fXML = new FilesXML();
	air = new Airline();
	fXML.createXML("Airlines", "Airlines.xml");
	initializer();
	}

	private void initializer() {
		guiRA.getBExit().addActionListener(this);
		guiRA.getBRegister().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	if(e.getSource()== guiRA.getBRegister()) {
			
			air = new Airline(guiRA.getTNameAerolinea().getText(),guiRA.getTContry().getText());
			
			fXML.writeXML("Airlines.xml","Airline",air.getDataName(),air.getData());
			arrayLAirline= air.readXMLArrayList("Airlines.xml","Airline",air.getDataName());
			guiRA.cleanForm();
			guiRA.getDTMTAirline().addRow(new Object[] {air.getName(),air.getContry()});
		}
		if(e.getSource()== guiRA.getBExit()) {
			//meter la pagina anterior
			guiRA.dispose();
			//System.exit(0);
		}
	}

}

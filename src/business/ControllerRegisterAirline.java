package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import data.FilesXML;
import domain.Airline;
import presentation.GUIRegisterAirline;


public class ControllerRegisterAirline implements ActionListener{

	private GUIRegisterAirline guiRA;
	private FilesXML fXML;
	private Airline air;
	//ArrayListUser<User> arrayLUser;
	
	public ControllerRegisterAirline() {
	guiRA= new GUIRegisterAirline();
	fXML = new FilesXML();
	air = new Airline();
	fXML.createXML("Airline", "Airlines.xml");
	initializer();
	}

	private void initializer() {
		guiRA.getBExit().addActionListener(this);
		guiRA.getBRegister().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	//	System.out.println(guiRA.getArrayListUser().size());
		//guiRA.print(guiRA.getTUser());//pdf
		
		if(e.getSource()== guiRA.getBRegister()) {
			
			air = new Airline(guiRA.getTNameAerolinea().getText(),guiRA.getTContry().getText());
			guiRA.cleanForm();
			fXML.writeXML("Airlines.xml","Airline",air.getDataName(),air.getData());
			//guiRU.getComboBoxState().getSelectedItem().toString());
			guiRA.getArrayListAirline().add(air);
			//guiRA.getDTMTAirline().addRow(air);
		}
		if(e.getSource()== guiRA.getBExit()) {
			//meter la pagina anterior
			guiRA.dispose();
			//System.exit(0);
		}
	}

}

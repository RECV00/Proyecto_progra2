package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Airline;
import presentation.GUIDeleteAirline;

public class ControllerDeleteAirline implements ActionListener{

	private GUIDeleteAirline guiDA;
	private FilesXML fXML;
	private Airline air;
	
	public ControllerDeleteAirline() {
		// TODO Auto-generated constructor stub
		guiDA= new GUIDeleteAirline();
		fXML= new FilesXML();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiDA.getBDelete().addActionListener(this);
		guiDA.getBExit().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDA.getBDelete()) {
			fXML.deleteXML("Airlines.xml","Airline", guiDA.getTNameDeleteAero().getText());
		}
		if(e.getSource()== guiDA.getBExit()) {
			guiDA.dispose();
		}
	}

}

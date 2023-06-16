package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUIUpdateFlight;


public class ControllerUpdateFlight implements ActionListener{

	private GUIUpdateFlight guiUF;
	private FilesXML fXML;
	
	public ControllerUpdateFlight() {
		guiUF= new GUIUpdateFlight();
		fXML= new FilesXML();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUF.getBUpdate().addActionListener(this);
		guiUF.getBExit().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUF.getBUpdate()) {
			try {
				fXML.updateXML("Flights.xml",guiUF.getTNumFlight().getText(),"hola");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== guiUF.getBExit()) {
			guiUF.dispose();
		}
	}
}

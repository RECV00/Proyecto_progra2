package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUIUpdatePassenger;


public class ControllerUpdatePassenger implements ActionListener{

	private GUIUpdatePassenger guiUP;
	private FilesXML fXML;
	
	public ControllerUpdatePassenger() {
		guiUP= new GUIUpdatePassenger();
		fXML= new FilesXML();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUP.getBUpdate().addActionListener(this);
		guiUP.getBExit().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUP.getBUpdate()) {
			try {
				fXML.updateXML("Passengers.xml",guiUP.getTPassportPassenger().getText(),"hola");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== guiUP.getBExit()) {
			guiUP.dispose();
		}
	}
}

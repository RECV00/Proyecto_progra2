package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUIUpdateAirline;


public class ControllerUpdateAirline implements ActionListener{

	private GUIUpdateAirline guiUA;
	private FilesXML fXML;
	
	public ControllerUpdateAirline() {
		guiUA= new GUIUpdateAirline();
		fXML= new FilesXML();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUA.getBUpdate().addActionListener(this);
		guiUA.getBExit().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUA.getBUpdate()) {
			try {
				fXML.updateXML("Airlines.xml",guiUA.getTNameAeroUpdate().getText(),"hola");
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

package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUIUpdatePlane;

public class ControllerUpdatePlane implements ActionListener{


	private GUIUpdatePlane guiUPlane;
	private FilesXML fXML;
	
	public ControllerUpdatePlane() {
		guiUPlane= new GUIUpdatePlane();
		fXML= new FilesXML();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUPlane.getBUpdate().addActionListener(this);
		guiUPlane.getBExit().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiUPlane.getBUpdate()) {
			try {
				fXML.updateXML("Planes.xml",guiUPlane.getTNamePlaneUpdate().getText(),"hola");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== guiUPlane.getBExit()) {
			guiUPlane.dispose();
		}
	}
}

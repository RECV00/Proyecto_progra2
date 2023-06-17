package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Plane;
import presentation.GUIDeletePlane;


public class ControllerDeletePlane implements ActionListener{

	private GUIDeletePlane guiDPlane;
	private FilesXML fXML;
	private Plane plane;
	
	public ControllerDeletePlane() {
		// TODO Auto-generated constructor stub
		guiDPlane= new GUIDeletePlane();
		fXML= new FilesXML();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiDPlane.getBDelete().addActionListener(this);
		guiDPlane.getBExit().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDPlane.getBDelete()) {
			fXML.deleteXML("Planes.xml", guiDPlane.getTPlaneDeletePlane().getText());
		}
		if(e.getSource()== guiDPlane.getBExit()) {
			guiDPlane.dispose();
		}
	}

}

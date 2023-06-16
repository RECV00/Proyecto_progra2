package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Plane;
import presentation.GUIConsultPlane;

public class ControllerConsultPlane implements ActionListener{

	private GUIConsultPlane guiCPlane;
	private Plane plane;
	private FilesXML fXML;
	
	public ControllerConsultPlane() {
		guiCPlane= new GUIConsultPlane();
		fXML = new FilesXML();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiCPlane.getBCheckHistory().addActionListener(this);
		guiCPlane.getBSearch().addActionListener(this);
		guiCPlane.getBExit().addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiCPlane.getBCheckHistory()) {
			//fXML.readXMLString("Planes.xml","Plane");
		}
		if(e.getSource()==guiCPlane.getBSearch()) {
		try {
			fXML.searchXML("Planes.xml",guiCPlane.getTConsultPlane().getText());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		if(e.getSource()==guiCPlane.getBExit()) {
			guiCPlane.dispose();
		}
	}

}

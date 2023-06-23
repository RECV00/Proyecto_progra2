package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.Logic;
import domain.Plane;
import presentation.GUIConsultPlane;

public class ControllerConsultPlane implements ActionListener{

	private GUIConsultPlane guiCPlane;
	private Plane plane;
	private FilesXML fXML;
	private Logic lo;

	
	public ControllerConsultPlane() {
		guiCPlane= new GUIConsultPlane();
		fXML = new FilesXML();
		lo= new Logic();
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
			guiCPlane.getDTMTPlane().setRowCount(0);
			guiCPlane.setArrayListPlane(lo.getListPlane("Planes.xml", "Plane"));
			guiCPlane.fillTable(guiCPlane.getArrayListPlane());
		}
		if(e.getSource()==guiCPlane.getBSearch()) {
		try {//cambiar metodo
			guiCPlane.getDTMTPlane().setRowCount(0);
			guiCPlane.setArrayListPlane(lo.searchXMLPlane("Planes.xml", "Plane", "plate", 
			guiCPlane.getTConsultPlane().getText()));
			guiCPlane.fillTable(guiCPlane.getArrayListPlane());		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		if(e.getSource()==guiCPlane.getBExit()) {
			guiCPlane.dispose();
		}
	}

}

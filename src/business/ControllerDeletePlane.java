package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Plane;
import data.LogicXML;
import presentation.GUIDeletePlane;


public class ControllerDeletePlane implements ActionListener{

	private GUIDeletePlane guiDPlane;
	private FilesXML fXML;
	private Plane plane;
	private LogicXML lo;
	
	public ControllerDeletePlane() {
		// TODO Auto-generated constructor stub
		guiDPlane= new GUIDeletePlane();
		fXML= new FilesXML();
		lo= new LogicXML();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiDPlane.getBDelete().addActionListener(this);
		guiDPlane.getBExit().addActionListener(this);
		
		guiDPlane.getDTMTPlane().setRowCount(0);
		guiDPlane.setArrayListPlane(lo.getListPlane("Planes.xml","Plane"));
		guiDPlane.fillTable(guiDPlane.getArrayListPlane());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDPlane.getBDelete()) {
			fXML.deleteXML("Planes.xml","Plane","plate",guiDPlane.getTPlaneDeletePlane().getText());
			
			guiDPlane.getDTMTPlane().setRowCount(0);
			guiDPlane.setArrayListPlane(lo.getListPlane("Planes.xml","Plane"));
			guiDPlane.fillTable(guiDPlane.getArrayListPlane());
		}
		if(e.getSource()== guiDPlane.getBExit()) {
			guiDPlane.dispose();
		}
	}

}

package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.Logic;
import domain.Plane;
import presentation.GUIUpdatePlane;

public class ControllerUpdatePlane implements ActionListener{


	private GUIUpdatePlane guiUPlane;
	private FilesXML fXML;
	private Plane plane;
	private Logic lo;
	
	public ControllerUpdatePlane() {
		guiUPlane= new GUIUpdatePlane();
		fXML= new FilesXML();
		lo=new Logic();
		plane = new Plane();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUPlane.getBUpdate().addActionListener(this);
		guiUPlane.getBExit().addActionListener(this);
		
		guiUPlane.getDTMTPlane().setRowCount(0);
		guiUPlane.setArrayListPlane(lo.getListPlane("Planes.xml","Plane"));
		guiUPlane.fillTable(guiUPlane.getArrayListPlane());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiUPlane.getBUpdate()) {
			plane = new Plane(guiUPlane.getTAvionUpdatePlane().getText(),
					guiUPlane.getTAirplaneUpdatePalne().getText(),
					guiUPlane.getTModelUpdatePlane().getText(),
					guiUPlane.getTYearUpdatePlane().getText());
			try {
				fXML.updateXML("Planes.xml","Plane",plane.getDataName(),plane.getData());
				
				guiUPlane.getDTMTPlane().setRowCount(0);
				guiUPlane.getDTMTPlane().addRow(new Object [] {plane.getPlate(),plane.getAirline(),plane.getModel(),plane.getYear()});
				guiUPlane.setArrayListPlane(lo.getListPlane("Planes.xml","Plane"));
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

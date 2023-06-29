package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.LogicXML;
import domain.Airline;
import domain.Model;
import domain.Plane;
import presentation.GUIRegisterPlane;
import presentation.GUIUpdatePlane;

public class ControllerUpdatePlane implements ActionListener{


	private GUIUpdatePlane guiUPlane;
	private FilesXML fXML;
	private Plane plane;
	private LogicXML lo;
	ArrayList<Airline> arrayLA;
	ArrayList<Model> arrayLM;
	
	public ControllerUpdatePlane() {
		fXML= new FilesXML();
		lo=new LogicXML();
		plane = new Plane();
		//muestra la lista seleccionable de los comboBox
		arrayLA=lo.getNAirline("Airlines.xml", "Airline");
		arrayLM=lo.getNModel("Models.xml", "Model");
		guiUPlane= new GUIUpdatePlane(arrayLA,arrayLM);
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUPlane.getBUpdate().addActionListener(this);
		guiUPlane.getBExit().addActionListener(this);
		guiUPlane.getBSearch().addActionListener(this);
		//muestra tabla llena
		guiUPlane.getDTMTPlane().setRowCount(0);
		guiUPlane.setArrayListPlane(lo.getListPlane("Planes.xml","Plane"));
		guiUPlane.fillTable(guiUPlane.getArrayListPlane());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUPlane.getBSearch()) {
			
			plane = lo.searchPlane("Planes.xml","Plane","plate",guiUPlane.getTAvionUpdatePlane().getText());
			guiUPlane.getTAvionUpdatePlane().setText(plane.getPlate());
			guiUPlane.getComboBoxAirline().setSelectedItem(plane.getAirline());
			guiUPlane.getComboBoxModel().setSelectedItem(plane.getModel());
			guiUPlane.getTYearUpdatePlane().setText(plane.getYear());
			
		}
		if(e.getSource()== guiUPlane.getBUpdate()) {
			plane = new Plane(guiUPlane.getTAvionUpdatePlane().getText(),
					guiUPlane.getComboBoxAirline().getSelectedItem().toString(),
					guiUPlane.getComboBoxModel().getSelectedItem().toString(),
					guiUPlane.getTYearUpdatePlane().getText());
			try {
				fXML.updateXML("Planes.xml","Plane",plane.getDataName(),plane.getData());
				
				guiUPlane.getDTMTPlane().setRowCount(0);
				guiUPlane.getDTMTPlane().addRow(new Object [] {plane.getPlate(),
						guiUPlane.getComboBoxAirline().getSelectedItem().toString(),
						guiUPlane.getComboBoxModel().getSelectedItem().toString(),
						plane.getYear()});
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

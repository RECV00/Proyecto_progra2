package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.Logic;
import domain.Brand;
import presentation.GUIConsultBrand;

public class ControllerConsultBrand implements ActionListener{
	private GUIConsultBrand guiCB;
	private FilesXML fXML;
	private Logic lo;
	private Brand brand;
	
	public ControllerConsultBrand() {
		guiCB = new GUIConsultBrand();
		fXML = new FilesXML();
		lo= new Logic();
		initializer();
	}

	private void initializer() {
		guiCB.getBCheckHistory().addActionListener(this);
		guiCB.getBSearch().addActionListener(this);
		guiCB.getBExit().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getSource()==guiCB.getBCheckHistory()) {
			guiCB.getDTMTBrand().setRowCount(0);
			guiCB.setArrayListBrand(lo.getListBrand("Brands.xml", "Brand"));
			guiCB.fillTable(guiCB.getArrayListBrand());
		}
		if(e.getSource()==guiCB.getBSearch()) {
			try {//cambiar por el metodo buscar
				guiCB.getDTMTBrand().setRowCount(0);
				guiCB.setArrayListBrand(lo.getListBrand("Airlines.xml", "Airline"));
				guiCB.fillTable(guiCB.getArrayListBrand());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==guiCB.getBExit()) {
			guiCB.dispose();
		}
	}

}

package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.Logic;
import domain.Brand;
import presentation.GUIDeleteBrand;


public class ControllerDeleteBrand implements ActionListener{

	private GUIDeleteBrand guiDB;
	private FilesXML fXML;
	private Brand brand;
	private Logic lo;
	
	public ControllerDeleteBrand() {
		// TODO Auto-generated constructor stub
		guiDB= new GUIDeleteBrand();
		fXML= new FilesXML();
		lo= new Logic();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiDB.getBDelete().addActionListener(this);
		guiDB.getBExit().addActionListener(this);
		
		guiDB.getDTMTBrand().setRowCount(0);
		guiDB.setArrayListBrand(lo.getListBrand("Brands.xml","Brand"));
		guiDB.fillTable(guiDB.getArrayListBrand());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDB.getBDelete()) {
			fXML.deleteXML("Brands.xml","Brand","name", guiDB.getTNameDelete().getText());
			
			guiDB.getDTMTBrand().setRowCount(0);
			guiDB.setArrayListBrand(lo.getListBrand("Brands.xml","Brand"));
			guiDB.fillTable(guiDB.getArrayListBrand());
		}
		if(e.getSource()== guiDB.getBExit()) {
			guiDB.dispose();
		}
	}

}

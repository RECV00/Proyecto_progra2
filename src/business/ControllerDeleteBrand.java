package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Brand;
import presentation.GUIDeleteBrand;


public class ControllerDeleteBrand implements ActionListener{

	private GUIDeleteBrand guiDB;
	private FilesXML fXML;
	private Brand brand;
	
	public ControllerDeleteBrand() {
		// TODO Auto-generated constructor stub
		guiDB= new GUIDeleteBrand();
		fXML= new FilesXML();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiDB.getBDelete().addActionListener(this);
		guiDB.getBExit().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDB.getBDelete()) {
			fXML.deleteXML("Brands.xml","Brand", guiDB.getTNameDelete().getText());
		}
		if(e.getSource()== guiDB.getBExit()) {
			guiDB.dispose();
		}
	}

}

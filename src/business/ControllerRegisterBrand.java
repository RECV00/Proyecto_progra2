package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.Logic;
import domain.Brand;
import domain.User;
import presentation.GUIRegisterBrand;


public class ControllerRegisterBrand implements ActionListener{

	private GUIRegisterBrand guiRB;
	private FilesXML fXML;
	private Brand brand;
	private Logic lo;
	private ArrayList<Brand> arrayLBrand;
	
	public ControllerRegisterBrand() {
	guiRB= new GUIRegisterBrand();
	fXML = new FilesXML();
	lo = new Logic(); 
	brand = new Brand();
	fXML.createXML("Brands", "Brands.xml");
	initializer();
	}

	private void initializer() {
		guiRB.getBExit().addActionListener(this);
		guiRB.getBRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== guiRB.getBRegister()){
			
			brand = new Brand (guiRB.getTNameRegisterBrand().getText());
			fXML.writeXML("Brands.xml","Brand",brand.getDataName(),brand.getData());
			arrayLBrand = lo.readXMLArrayListBrand("Brands.xml","Brand",brand.getDataName());
			guiRB.cleanForm();
			guiRB.getDTMTBrand().addRow(new Object [] {brand.getName(),});
				
			}
		if(e.getSource()== guiRB.getBExit()) {
			//meter la pagina anterior
			guiRB.dispose();
			//System.exit(0);
		}
	}
}

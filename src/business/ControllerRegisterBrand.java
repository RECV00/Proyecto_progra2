package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Brand;
import presentation.GUIRegisterBrand;


public class ControllerRegisterBrand implements ActionListener{

	private GUIRegisterBrand guiRB;
	private FilesXML fXML;
	private Brand brand;
	//ArrayListUser<User> arrayLUser;
	
	public ControllerRegisterBrand() {
	guiRB= new GUIRegisterBrand();
	fXML = new FilesXML();
	brand = new Brand();
	fXML.createXML("Brand", "Brands.xml");
	initializer();
	}

	private void initializer() {
		guiRB.getBExit().addActionListener(this);
		guiRB.getBRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	//	System.out.println(guiRA.getArrayListUser().size());
		//guiRA.print(guiRA.getTUser());//pdf
		
		if(e.getSource()== guiRB.getBRegister()) {
			
			brand = new Brand(guiRB.getTNameRegisterBrand().getText());
			
			guiRB.cleanForm();
			fXML.writeXML("Brands.xml","Brand",brand.getDataName(),brand.getData());
			//guiRU.getComboBoxState().getSelectedItem().toString());
			guiRB.getArrayListBrand().add(brand);
			
			//guiRA.getDTMTAirline().addRow(air);
			
		}
		if(e.getSource()== guiRB.getBExit()) {
			//meter la pagina anterior
			guiRB.dispose();
			//System.exit(0);
		}
	}
}

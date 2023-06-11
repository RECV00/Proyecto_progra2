package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Brand;
import presentation.GUIConsultBrand;

public class ControllerConsultBrand implements ActionListener{
	private GUIConsultBrand guiCB;
	private FilesXML fXML;
	private Brand brand;
	
	public ControllerConsultBrand() {
		guiCB = new GUIConsultBrand();
		fXML = new FilesXML();
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
		if(e.getSource()==guiCB.getBSearch()) {
			try {
				fXML.searchXML("Brands.xml", guiCB.getTNameConsultMarca().getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==guiCB.getBCheckHistory()) {
			fXML.readXMLString("Brands.xml", "Brand");
		}
		if(e.getSource()==guiCB.getBExit()) {
			guiCB.dispose();
		}
	}

}

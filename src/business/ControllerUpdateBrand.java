package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUIUpdateBrand;
;

public class ControllerUpdateBrand implements ActionListener{

	private GUIUpdateBrand guiUB;
	private FilesXML fXML;
	
	public ControllerUpdateBrand() {
		guiUB= new GUIUpdateBrand();
		fXML= new FilesXML();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUB.getBUpdate().addActionListener(this);
		guiUB.getBExit().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUB.getBUpdate()) {
			try {
				fXML.updateXML("Brands.xml",guiUB.getTNameBrandUpdate().getText(),"hola");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== guiUB.getBExit()) {
			guiUB.dispose();
		}
	}

}

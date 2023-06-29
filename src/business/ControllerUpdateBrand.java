package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.LogicXML;
import domain.Brand;
import presentation.GUIUpdateBrand;
;

public class ControllerUpdateBrand implements ActionListener{

	private GUIUpdateBrand guiUB;
	private FilesXML fXML;
	private LogicXML lo;
	private Brand b;
	
	public ControllerUpdateBrand() {
		guiUB= new GUIUpdateBrand();
		fXML= new FilesXML();
		lo=new LogicXML();
		b= new Brand();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUB.getBUpdate().addActionListener(this);
		guiUB.getBExit().addActionListener(this);
		guiUB.getBSearch().addActionListener(this);
		//inicializa la tabla con las marcas
		guiUB.getDTMTBrand().setRowCount(0);
		guiUB.setArrayListBrand(lo.getListBrand("Brands.xml","Brand"));
		guiUB.fillTable(guiUB.getArrayListBrand());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUB.getBSearch()) {
			b=lo.searchBrand("Brands.xml", "Brand", "name", guiUB.getTNameBrandUpdate().getText());
			guiUB.getTNameBrandUpdate().setText(b.getName());
		}
		if(e.getSource()==guiUB.getBUpdate()) {
			
				b = new Brand (guiUB.getTNameBrandUpdate().getText());
			try {
				fXML.updateXML("Brands.xml","Brand",b.getDataName(),b.getData());
				guiUB.getDTMTBrand().setRowCount(0);
				guiUB.getDTMTBrand().addRow(new Object [] { b.getName()});
				guiUB.setArrayListBrand(lo.getListBrand("Brands.xml","Brand"));
	
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

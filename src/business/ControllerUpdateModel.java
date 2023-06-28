package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.Logic;
import domain.Brand;
import domain.Model;
import presentation.GUIRegisterModel;
import presentation.GUIUpdateModel;


public class ControllerUpdateModel implements ActionListener{

	private GUIUpdateModel guiUM;
	private FilesXML fXML;
	private Logic lo;
	private Model model;
	ArrayList<Brand> arrayLB;
	
	public ControllerUpdateModel() {
		fXML= new FilesXML();
		lo=new Logic();
		model = new Model();
		arrayLB=lo.getNameBrand("Brands.xml", "Brand");
		//muestra la lista seleccionable de marcas
		guiUM= new GUIUpdateModel(arrayLB);
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUM.getBUpdate().addActionListener(this);
		guiUM.getBExit().addActionListener(this);
		guiUM.getBSearch().addActionListener(this);
		//muestra tabla llena
		guiUM.getDTMTModel().setRowCount(0);
		guiUM.setArrayListModel(lo.getListModel("Models.xml","Model"));
		guiUM.fillTable(guiUM.getArrayListModel());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
if(e.getSource()==guiUM.getBSearch()) {
			
			model = lo.searchModel("Models.xml","Model","name",guiUM.getTNameModel().getText());
			guiUM.getComboBoxBrand().setSelectedItem(model.getMarca());
			guiUM.getTCanAsientosModelEJE().setText(String.valueOf(model.getCantSeatExecutive()));
			guiUM.getTCanAsientosTUR().setText(String.valueOf(model.getCantSeatEconomic()));
			guiUM.getTCanAsientosECO().setText(String.valueOf(model.getCantSeatTourist()));
			
		}
		if(e.getSource()==guiUM.getBUpdate()) {
			model = new Model(guiUM.getTNameModel().getText(),
					guiUM.getComboBoxBrand().getSelectedItem().toString(),
					Integer.valueOf(guiUM.getTCanAsientosModelEJE().getText()),
					Integer.valueOf(guiUM.getTCanAsientosTUR().getText()),
					Integer.valueOf(guiUM.getTCanAsientosECO().getText()));
			try {
				fXML.updateXML("Models.xml","Model",model.getDataName(),model.getData());
				
				guiUM.getDTMTModel().setRowCount(0);
				guiUM.getDTMTModel().addRow(new Object [] {model.getName(),
				guiUM.getComboBoxBrand().getSelectedItem().toString(),
				model.getCantSeatExecutive(),model.getCantSeatEconomic(),model.getCantSeatTourist()});
				guiUM.setArrayListModel(lo.getListModel("Models.xml","Model"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== guiUM.getBExit()) {
			guiUM.dispose();
		}
	}
}

package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.Logic;
import domain.Model;
import presentation.GUIUpdateModel;


public class ControllerUpdateModel implements ActionListener{

	private GUIUpdateModel guiUM;
	private FilesXML fXML;
	private Logic lo;
	private Model model;
	
	public ControllerUpdateModel() {
		guiUM= new GUIUpdateModel();
		fXML= new FilesXML();
		lo=new Logic();
		model = new Model();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUM.getBUpdate().addActionListener(this);
		guiUM.getBExit().addActionListener(this);
		
		guiUM.getDTMTModel().setRowCount(0);
		guiUM.setArrayListModel(lo.getListModel("Models.xml","Model"));
		guiUM.fillTable(guiUM.getArrayListModel());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUM.getBUpdate()) {
			model = new Model(guiUM.getTNameModel().getText(),guiUM.getTMarcaModel().getText(),
					Integer.valueOf(guiUM.getTCanAsientosModelEJE().getText()),
					Integer.valueOf(guiUM.getTCanAsientosTUR().getText()),
					Integer.valueOf(guiUM.getTCanAsientosECO().getText()));
			try {
				fXML.updateXML("Models.xml","Model",model.getDataName(),model.getData());
				
				guiUM.getDTMTModel().setRowCount(0);
				guiUM.getDTMTModel().addRow(new Object [] {model.getName(),model.getMarca(),
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

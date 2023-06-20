package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.Logic;
import domain.Model;
import presentation.GUIRegisterModel;

public class ControllerRegisterModel implements ActionListener{

	private GUIRegisterModel guiRM;
	private FilesXML fXML;
	private Model model;
	private Logic lo;
	ArrayList<Model> arrayLModel;
	
	public ControllerRegisterModel() {
	guiRM= new GUIRegisterModel();
	fXML = new FilesXML();
	lo=new Logic();
	model = new Model();
	fXML.createXML("Models", "Models.xml");
	initializer();
	}

	private void initializer() {
		guiRM.getBExit().addActionListener(this);
		guiRM.getBRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()== guiRM.getBRegister()) {
			
			model = new Model(guiRM.getTNameModel().getText(),guiRM.getTMarcaModel().getText(),
					Integer.valueOf(guiRM.getTCanMarcaModelEJE().getText()),
					Integer.valueOf(guiRM.getTCanAsientosECO().getText()),
					Integer.valueOf(guiRM.getTCanAsientosTUR().getText()));
			
			fXML.writeXML("Models.xml","Model",model.getDataName(),model.getData());
			arrayLModel= lo.readXMLArrayListModel("Models.xml","Model", model.getDataName());
		    guiRM.cleanForm();
			guiRM.getDTMTModel().addRow(new Object [] {model.getName(),model.getMarca(),
			model.getCantSeatExecutive(),model.getCantSeatEconomic(),model.getCantSeatTourist()});
			
		}
		if(e.getSource()== guiRM.getBExit()) {
			guiRM.dispose();
			//System.exit(0);
		}
	}

}

package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.Logic;
import domain.Model;
import presentation.GUIDeleteModel;


public class ControllerDeleteModel implements ActionListener{

	private GUIDeleteModel guiDM;
	private FilesXML fXML;
	private Model model;
	private Logic lo;
	
	public ControllerDeleteModel() {
		// TODO Auto-generated constructor stub
		guiDM= new GUIDeleteModel();
		fXML= new FilesXML();
		lo = new Logic();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiDM.getBDelete().addActionListener(this);
		guiDM.getBExit().addActionListener(this);
		
		guiDM.getDTMTModel().setRowCount(0);
		guiDM.setArrayListModel(lo.getListModel("Models.xml","Model"));
		guiDM.fillTable(guiDM.getArrayListModel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDM.getBDelete()) {
			fXML.deleteXML("Models.xml","Model", "name",guiDM.getTNameDeleteModelo().getText());
			guiDM.getDTMTModel().setRowCount(0);
			guiDM.setArrayListModel(lo.getListModel("Models.xml","Model"));
			guiDM.fillTable(guiDM.getArrayListModel());
		}
		if(e.getSource()== guiDM.getBExit()) {
			guiDM.dispose();
		}
	}


}

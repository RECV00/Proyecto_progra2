package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.Logic;
import domain.Model;
import presentation.GUIConsultModel;

public class ControllerConsultModel implements ActionListener{
	private GUIConsultModel guiCM;
	private FilesXML fXML;
	private Logic lo;
	private Model model;
	
public ControllerConsultModel() {
	guiCM= new GUIConsultModel();
	fXML= new FilesXML();
	lo= new Logic();
	initializer();
	}
private void initializer() {
	guiCM.getBCheckHistory().addActionListener(this);
	guiCM.getBSearch().addActionListener(this);
	guiCM.getBExit().addActionListener(this);
		
	}
@Override
public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiCM.getBCheckHistory()) {
			guiCM.getDTMTModel().setRowCount(0);
			guiCM.setArrayListModel(lo.getListModel("Models.xml", "Model"));
			guiCM.fillTable(guiCM.getArrayListModel());
		}
		if(e.getSource()==guiCM.getBSearch()) {
		try {
			guiCM.getDTMTModel().setRowCount(0);
			guiCM.setArrayListModel(lo.getListModel("Models.xml", "Model"));
			guiCM.fillTable(guiCM.getArrayListModel());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		if(e.getSource()==guiCM.getBExit()) {
			guiCM.dispose();
		}
	}

}

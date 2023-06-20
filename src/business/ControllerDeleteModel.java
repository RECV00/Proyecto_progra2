package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Model;
import presentation.GUIDeleteModel;


public class ControllerDeleteModel implements ActionListener{

	private GUIDeleteModel guiDM;
	private FilesXML fXML;
	private Model model;
	
	public ControllerDeleteModel() {
		// TODO Auto-generated constructor stub
		guiDM= new GUIDeleteModel();
		fXML= new FilesXML();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiDM.getBDelete().addActionListener(this);
		guiDM.getBExit().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDM.getBDelete()) {
			fXML.deleteXML("Models.xml","Model", guiDM.getTNameDeleteModelo().getText());
		}
		if(e.getSource()== guiDM.getBExit()) {
			guiDM.dispose();
		}
	}


}

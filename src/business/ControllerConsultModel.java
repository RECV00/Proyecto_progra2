package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Model;
import presentation.GUIConsultModel;

public class ControllerConsultModel implements ActionListener{
	private GUIConsultModel guiCM;
	private FilesXML fXML;
	private Model model;
	
public ControllerConsultModel() {
	guiCM= new GUIConsultModel();
	fXML= new FilesXML();
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
			fXML.readXMLString("Models.xml","Model");
		}
		if(e.getSource()==guiCM.getBSearch()) {
		try {
			fXML.searchXML("Models.xml",guiCM.getTConsultName().getText());
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

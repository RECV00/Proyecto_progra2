package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUIUpdateModel;


public class ControllerUpdateModel implements ActionListener{

	private GUIUpdateModel guiUM;
	private FilesXML fXML;
	
	public ControllerUpdateModel() {
		guiUM= new GUIUpdateModel();
		fXML= new FilesXML();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUM.getBUpdate().addActionListener(this);
		guiUM.getBExit().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUM.getBUpdate()) {
			try {
				fXML.updateXML("Models.xml",guiUM.getTNameModelUpdate().getText(),"hola");
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

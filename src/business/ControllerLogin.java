package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUILogin;

public class ControllerLogin implements ActionListener{
     private GUILogin guiL;
	 private FilesXML fXML;
	 
	public ControllerLogin() {
		guiL=new GUILogin();
		fXML=new FilesXML();
		initalizer();
	}

	private void initalizer() {
		guiL.getBLogin().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==guiL.getBLogin()) {
			try {
				if(fXML.getValidateUser(guiL.getTUser().getText(),guiL.getTPassword().getText()) == "administrador") {
					
				}else {
					
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			//new ControllerAdmin;
			guiL.dispose();
		}else {
			
		}
		
	}

}

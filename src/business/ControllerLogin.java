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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

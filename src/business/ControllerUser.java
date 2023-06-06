package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUIUser;

public class ControllerUser implements ActionListener{
	private GUIUser guiU;
	private FilesXML fXML;
	
	public ControllerUser() {
	guiU= new GUIUser();
	fXML = new FilesXML();
	initializer();
	}

	private void initializer() {

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.User;
import presentation.GUIUpdateUser;

public class ControllerUpdateUser implements ActionListener{
	private GUIUpdateUser guiUu;
	private FilesXML fXML;
	private User user;
	
	public ControllerUpdateUser() {
		guiUu= new GUIUpdateUser();
		fXML= new FilesXML();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUu.getBUpdate().addActionListener(this);
		guiUu.getBExit().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUu.getBUpdate()) {
			
		}
		if(e.getSource()== guiUu.getBExit()) {
			guiUu.dispose();
		}
	}

}

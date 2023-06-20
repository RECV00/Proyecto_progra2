package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import data.FilesXML;
import data.Logic;
import domain.User;
import presentation.GUIDeleteUser;

public class ControllerDeleteUser implements ActionListener{
	private GUIDeleteUser guiDU;
	private FilesXML fXML;
	private User user;
	private Logic lo;
	private ArrayList<User>arrayLUser;
	
	
	public ControllerDeleteUser() {
		// TODO Auto-generated constructor stub
		guiDU= new GUIDeleteUser();
		fXML= new FilesXML();
		lo= new Logic();
		user = new User();
		initializer();
	}

private void initializer() {
		// TODO Auto-generated method stub
		guiDU.getBDelete().addActionListener(this);
		guiDU.getBExit().addActionListener(this);
	}

	@Override
public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		guiDU.getDTMTUser().setRowCount(0);
		guiDU.setArrayListUser(lo.getListUser("Users.xml","User"));
		guiDU.fillTable(guiDU.getArrayListUser());
		
		if(e.getSource()== guiDU.getBDelete()) {
			
		fXML.deleteXML("Users.xml",guiDU.getTNameDelete().getText());
			
		}
		if(e.getSource()== guiDU.getBExit()) {
			guiDU.dispose();
		}
	}

}

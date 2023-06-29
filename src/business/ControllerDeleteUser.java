package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import data.FilesXML;
import data.LogicXML;
import domain.User;
import presentation.GUIDeleteUser;

public class ControllerDeleteUser implements ActionListener{
	private GUIDeleteUser guiDU;
	private FilesXML fXML;
	private User user;
	private LogicXML lo;
	private ArrayList<User>arrayLUser;
	
	
	public ControllerDeleteUser() {
		// TODO Auto-generated constructor stub
		guiDU= new GUIDeleteUser();
		fXML= new FilesXML();
		lo= new LogicXML();
		user = new User();
		initializer();
	}

private void initializer() {
		// TODO Auto-generated method stub
		guiDU.getBDelete().addActionListener(this);
		guiDU.getBExit().addActionListener(this);
		
		guiDU.getDTMTUser().setRowCount(0);
		guiDU.setArrayListUser(lo.getListUser("Users.xml","User"));
		guiDU.fillTable(guiDU.getArrayListUser());
	}
	
	@Override
public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()== guiDU.getBDelete()) {
			
		fXML.deleteXML("Users.xml","User","userName",guiDU.getTNameDelete().getText());
		guiDU.getDTMTUser().setRowCount(0);
		guiDU.setArrayListUser(lo.getListUser("Users.xml","User"));
		guiDU.fillTable(guiDU.getArrayListUser());
		}
		if(e.getSource()== guiDU.getBExit()) {
			guiDU.dispose();
		}
	}

}

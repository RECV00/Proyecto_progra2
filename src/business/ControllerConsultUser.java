package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.Logic;
import domain.User;
import presentation.GUIConsultUser;

public class ControllerConsultUser implements ActionListener{
	private GUIConsultUser guiCU;
	private Logic lo;
	private FilesXML fXML;
	private User user;
	ArrayList<User>arrayLUser;
	public ControllerConsultUser() {
		// TODO Auto-generated constructor stub
		guiCU= new GUIConsultUser();
		fXML= new FilesXML();
		lo = new Logic();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiCU.getBSearch().addActionListener(this);
		guiCU.getBExit().addActionListener(this);
		guiCU.getBCheckHistory().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()== guiCU.getBCheckHistory()) {
			
			guiCU.getDTMTUser().setRowCount(0);
			guiCU.setArrayListUser(lo.getListUser("Users.xml","User"));
			guiCU.fillTable(guiCU.getArrayListUser());
		}
		if(e.getSource()== guiCU.getBSearch()) {
			try {
				arrayLUser = lo.searchXMLUser("Users.xml","User","userName",guiCU.getTConsultName().getText());
			    guiCU.getDTMTUser().setRowCount(0);
				guiCU.setArrayListUser(arrayLUser);
				guiCU.fillTable(guiCU.getArrayListUser());
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== guiCU.getBExit()) {
			guiCU.dispose();
		}
	}

}

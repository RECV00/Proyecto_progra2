package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.Logic;
import domain.User;
import presentation.GUIConsultUser;

public class ControllerConsultUser implements ActionListener{
	private GUIConsultUser guiCU;
	private Logic lo;
	private FilesXML fXML;
	private User user;
	
	public ControllerConsultUser() {
		// TODO Auto-generated constructor stub
		guiCU= new GUIConsultUser();
		fXML= new FilesXML();
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
		guiCU.getDTMTUser().setRowCount(0);
			guiCU.setArrayListUser(lo.getListUser("Users.xml","User"));
			guiCU.fillTable(guiCU.getArrayListUser());
			
		if(e.getSource()== guiCU.getBCheckHistory()) {
			
			
		}
		if(e.getSource()== guiCU.getBSearch()) {
			try {
				fXML.searchXML("Users", guiCU.getTConsultName().getText());
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

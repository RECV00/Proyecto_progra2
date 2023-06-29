package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import data.FilesXML;
import data.LogicXML;
import domain.User;
import presentation.GUIUpdateUser;

public class ControllerUpdateUser implements ActionListener{
	private GUIUpdateUser guiUu;
	private FilesXML fXML;
	private User user;
	private LogicXML lo;
	ArrayList<User>arrayLU;
	public ControllerUpdateUser() {
		guiUu= new GUIUpdateUser();
		fXML= new FilesXML();
		user=new User();
		lo=new LogicXML();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUu.getBUpdate().addActionListener(this);
		guiUu.getBExit().addActionListener(this);
		guiUu.getBSearch().addActionListener(this);
		//muestra la tabla llena
		guiUu.getDTMTUser().setRowCount(0);
		guiUu.setArrayListUser(lo.getListUser("Users.xml","User"));
		guiUu.fillTable(guiUu.getArrayListUser());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUu.getBSearch()) {
			
			user = lo.searchUser("Users.xml","User","userName",guiUu.getTNameUpdate().getText());
			guiUu.getTContrasena().setText(user.getPassword());
			guiUu.getComboBoxTypeUser().setSelectedItem(user.getTypeUser());
			guiUu.getComboBoxState().setSelectedItem(user.getState());
			
		}
		if(e.getSource()==guiUu.getBUpdate()) {
			
			user = new User(guiUu.getTNameUpdate().getText(),
					guiUu.getTContrasena().getText(),
					guiUu.getComboBoxTypeUser().getSelectedItem().toString(),
					guiUu.getComboBoxState().getSelectedItem().toString());
			try {
			
				fXML.updateXML("Users.xml","User",user.getDataName(),user.getData());
				guiUu.getDTMTUser().setRowCount(0);
				guiUu.getDTMTUser().addRow(new Object [] {user.getUserName(),user.getPassword(),user.getTypeUser(),user.getState()});
				guiUu.setArrayListUser(lo.getListUser("Users.xml","User"));
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()== guiUu.getBExit()) {
			guiUu.dispose();
		}
	}

}

package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import domain.User;
import presentation.GUIRegisterUser;

public class ControllerRegisterUser implements ActionListener{
	private GUIRegisterUser guiRU;
	private FilesXML fXML;
	private User user;
	private ArrayList<User> arrayLUser;
	
	public ControllerRegisterUser() {
	guiRU= new GUIRegisterUser();
	fXML = new FilesXML();
	user = new User();
	fXML.createXML("Users", "Users.xml");
	initializer();
	}

	private void initializer() {
		guiRU.getBExit().addActionListener(this);
		guiRU.getBRegister().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== guiRU.getBRegister()) {
			
			user = new User(guiRU.getTName().getText(),guiRU.getTContrasena().getText(),
					guiRU.getTTypeUser().getText(),guiRU.getComboBoxState().getSelectedItem().toString());


			fXML.writeXML("Users.xml","User",user.getDataName(),user.getData());
			arrayLUser = user.readXMLArrayList("Users.xml","User",user.getDataName());
			guiRU.cleanForm();
			guiRU.getDTMTUser().addRow(new Object [] {user.getUserName(),user.getPassword(),user.getTypeUser(),user.getState()});
		}
		if(e.getSource()== guiRU.getBExit()) {
			//meter la pagina anterior
			guiRU.dispose();
			//System.exit(0);
		}
	}

}

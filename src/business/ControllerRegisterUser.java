package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.LogicXML;
import domain.User;
import presentation.GUIRegisterUser;

public class ControllerRegisterUser implements ActionListener{
	private GUIRegisterUser guiRU;
	private FilesXML fXML;
	private User user;
	private LogicXML lo;
	private ArrayList<User>arrayLUser;
	
	public ControllerRegisterUser() {
	guiRU= new GUIRegisterUser();
	fXML = new FilesXML();
	lo= new LogicXML();
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
					guiRU.getComboBoxTypeUser().getSelectedItem().toString(),
					guiRU.getComboBoxState().getSelectedItem().toString());


			fXML.writeXML("Users.xml","User",user.getDataName(),user.getData());
			arrayLUser = lo.readXMLArrayListUser("Users.xml","User",user.getDataName());
			guiRU.getDTMTUser().addRow(new Object [] {user.getUserName(),user.getPassword(),user.getTypeUser(),user.getState()});
			guiRU.cleanForm();
		}
		if(e.getSource()== guiRU.getBExit()) {
			//meter la pagina anterior
			guiRU.dispose();
			//System.exit(0);
		}
	}

}

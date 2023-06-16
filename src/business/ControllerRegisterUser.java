package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.User;
import presentation.GUIRegisterUser;

public class ControllerRegisterUser implements ActionListener{
	private GUIRegisterUser guiRU;
	private FilesXML fXML;
	private User user;
	
	//ArrayListUser<User> arrayLUser;
	public ControllerRegisterUser() {
	guiRU= new GUIRegisterUser();
	fXML = new FilesXML();
	user = new User();
	fXML.createXML("Users", "User.xml");
	initializer();
	}

	private void initializer() {
		guiRU.getBExit().addActionListener(this);
		guiRU.getBRegister().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	//	System.out.println(guiRU.getArrayListUser().size());
		//guiRU.print(guiRU.getTUser());//pdf
		
		if(e.getSource()== guiRU.getBRegister()) {
			
			user = new User(guiRU.getTName().getText(),guiRU.getTContrasena().getText(),
					guiRU.getTTypeUser().getText(),guiRU.getComboBoxState().getSelectedItem().toString());
			
			//arrayLP.addPerson(per);
			fXML.writeXML("Users.xml","User",user.getDataName(),user.getData());
			//guiRU.print(user);
			guiRU.cleanForm();
		}
		if(e.getSource()== guiRU.getBExit()) {
			//meter la pagina anterior
			guiRU.dispose();
			//System.exit(0);
		}
	}

}

package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.User;
import presentation.GUIRegisterUser;

public class ControllerUser implements ActionListener{
	private GUIRegisterUser guiRU;
	private FilesXML fXML;
	private User u;
	
	public ControllerUser() {
	guiRU= new GUIRegisterUser();
	fXML = new FilesXML();
	fXML.createXML("User", "User.xml");
	initializer();
	}

	private void initializer() {
		guiRU.getBExit().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(guiRU.getArrayListUser().size());
		guiRU.print(guiRU.getTUser());//pdf

		if(e.getSource()== guiRU.getBExit()) {
			//meter la pagina anterior
			
		}
	}

}

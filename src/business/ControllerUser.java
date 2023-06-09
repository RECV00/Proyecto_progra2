package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.User;
import presentation.GUIUser;

public class ControllerUser implements ActionListener{
	private GUIUser guiU;
	private FilesXML fXML;
	private User u;
	
	public ControllerUser() {
	guiU= new GUIUser();
	fXML = new FilesXML();
	fXML.createXML("User", "User.xml");
	initializer();
	}

	private void initializer() {
		guiU.getBExit().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(guiU.getArrayListUser().size());
		guiU.print(guiU.getTUser());//pdf

		if(e.getSource()== guiU.getBExit()) {
			//meter la pagina anterior
		}
	}

}

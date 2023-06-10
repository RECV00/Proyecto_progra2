package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.User;
import presentation.GUIConsultUser;
import presentation.GUIDeleteUser;
import presentation.GUIRegisterUser;
import presentation.GUIUpdateUser;

public class ControllerUser implements ActionListener{
	private GUIRegisterUser guiRU;
	private GUIDeleteUser guiDU;
	private GUIUpdateUser guiUU;
	private GUIConsultUser guiCU;
	private FilesXML fXML;
	private User u;
	
	public ControllerUser() {
	guiRU= new GUIRegisterUser();
	guiDU= new GUIDeleteUser();
	guiUU= new GUIUpdateUser();
	guiCU= new GUIConsultUser();
	fXML = new FilesXML();
	fXML.createXML("User", "User.xml");
	initializer();
	}

	private void initializer() {
		guiRU.getBRegister().addActionListener(this);
		guiRU.getBExit().addActionListener(this);
		
		guiDU.getBDelete().addActionListener(this);
		guiDU.getBExit().addActionListener(this);
		
		guiUU.getBExit().addActionListener(this);
		
		guiCU.getBSearch().addActionListener(this);
		guiCU.getBExit().addActionListener(this);
		guiCU.getBCheckHistory().addActionListener(this);
		
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

package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.User;
import presentation.GUILogin;

public class ControllerLogin implements ActionListener{
     private GUILogin guiL;
	 private FilesXML fXML;
	 private User u;
	 
	public ControllerLogin() {
		guiL=new GUILogin();
		fXML=new FilesXML();
		u = new User();
		fXML.createXML("Users", "Users.xml");
		initalizer();
	}

	private void initalizer() {
		guiL.getBLogin().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			u= new User("admin","admin","administrador","activo");
		fXML.writeXML("Users.xml","User",u.getDataName(),u.getData());
		
		if(e.getSource()==guiL.getBLogin()) {
			
		
			try {
				if(fXML.getValidateUser("Users.xml","User",guiL.getTUser().getText(),guiL.getTPassword().getText()) == "administrador") {
					new ControllerAdmin();
					
				}else {
					//new ControllerCo;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			guiL.dispose();
		}else {
			guiL.showMessage("Acceso Inválido");
		}
		
	}

}

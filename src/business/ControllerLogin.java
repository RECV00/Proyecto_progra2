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
		guiL.getBExit().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==guiL.getBLogin()) {
			

			try {
				String userType = fXML.validateUser("Users.xml","User",guiL.getTUser().getText(),String.valueOf(guiL.getPfPassword().getPassword()));
					if(userType.equals("Administrador")) {
						guiL.dispose();
						new ControllerAdmin();
					}
					else if(userType.equals("Colaborador")) {
						guiL.dispose();
						new ControllerColaborador();
					}
					else {
						guiL.showMessage("Acceso Inválido,verifique si los datos son correctos..");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
		}
		if(e.getSource()==guiL.getBExit()) {
			guiL.dispose();
			new Controller();
		}
	}
}

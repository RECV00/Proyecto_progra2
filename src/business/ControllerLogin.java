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
		
		
		if(e.getSource()==guiL.getBLogin()) {
			//
			//u= new User("keyna","1234","administrador","activo");
		    //fXML.writeXML("Users.xml","User",u.getDataName(),u.getData());
			System.out.print(fXML.readXMLString("Users.xml", "User"));
				try {
					if(fXML.getValidateUser("Users.xml","User",guiL.getTUser().getText(),String.valueOf(guiL.getPfPassword().getPassword()))=="administrador") {
						//System.out.print("hola"+fXML.getValidateUser("Users.xml","User",guiL.getTUser().getText(),String.valueOf(guiL.getPfPassword().getPassword())));
						new ControllerAdmin();
						guiL.dispose();
					}
					else if(fXML.getValidateUser("Users.xml","User",guiL.getTUser().getText(),String.valueOf(guiL.getPfPassword().getPassword()))=="colaborador") {
						new ControllerColaborador();
						guiL.dispose();
					}else {
						guiL.showMessage("Acceso Inválido");
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}
	}
}

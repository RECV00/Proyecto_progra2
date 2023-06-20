package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import data.FilesXML;
import domain.User;
import presentation.GUIDeleteUser;

public class ControllerDeleteUser implements ActionListener{
	private GUIDeleteUser guiDU;
	private FilesXML fXML;
	private User user;
	
	public ControllerDeleteUser() {
		// TODO Auto-generated constructor stub
		guiDU= new GUIDeleteUser();
		fXML= new FilesXML();
		initializer();
	}

private void initializer() {
		// TODO Auto-generated method stub
		guiDU.getBDelete().addActionListener(this);
		guiDU.getBExit().addActionListener(this);
	}

	@Override
public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDU.getBDelete()) {
			//Object data = fXML.readXML("Users.xml");

			
			
			//String dato = fXML.mostrarDato("Users.xml","User");
			//System.out.println(dato);
			//System.out.println("!!!"+fXML.procesarCadena(vaco));
			//ArrayList<String[]> vaca=fXML.divideCadenas(dato);
			//guiDU.getDTMTUser().addRow(new Object[] {fXML.procesarCadena(fXML.mostrarDato("Users.xml","User"))});
			//guiDU.getDTMTUser().addRow((Vector<?>) data);
			//System.out.println(fXML.readXML("Users.xml"));
			
			System.out.println(fXML.mostrarDato("Users.xml","User"));
		//	guiDU.getDTMTUser();

			//fXML.deleteXML("Users.xml", guiDU.getTNameDelete().getText());
			
			
		}
		if(e.getSource()== guiDU.getBExit()) {
			guiDU.dispose();
		}
	}

}

package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
	private GUIWelcome gui;
	
	public Controller() {
		gui= new GUIWelcome();
		inicializer();
	}

	private void inicializer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==gui.getBInicioSesion()) {
			new ControllerLogin();
		}
	}

}

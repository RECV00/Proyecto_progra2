package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GUIWelcome;

public class Controller implements ActionListener{
	private GUIWelcome gui;
	
	public Controller() {
		gui= new GUIWelcome();
		inicializer();
	}

	private void inicializer() {
		// TODO Auto-generated method stub
		gui.getBInicioSesion().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==gui.getBInicioSesion()) {
			new ControllerLogin();
			gui.dispose();
		}
	}

}

package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Ticket;
import presentation.GUIDeleteTicket;


public class ControllerDeleteTicket implements ActionListener{

	private GUIDeleteTicket guiDT;
	private FilesXML fXML;
	private Ticket ticket;
	
	public ControllerDeleteTicket() {
		// TODO Auto-generated constructor stub
		guiDT= new GUIDeleteTicket();
		fXML= new FilesXML();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiDT.getBDelete().addActionListener(this);
		guiDT.getBExit().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDT.getBDelete()) {
			fXML.deleteXML("Tickets.xml","Ticket", guiDT.getTNameDeleteTicket().getText());
		}
		if(e.getSource()== guiDT.getBExit()) {
			guiDT.dispose();
		}
	}

}

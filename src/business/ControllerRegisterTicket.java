package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import domain.Ticket;
import domain.User;
import presentation.GUIRegisterTicket;


public class ControllerRegisterTicket implements ActionListener{
	
	private GUIRegisterTicket guiRT;
	private FilesXML fXML;
	private Ticket ticket;
	private ArrayList<Ticket> arrayLTicket;
	
	public ControllerRegisterTicket() {
	guiRT= new GUIRegisterTicket();
	fXML = new FilesXML();
	ticket = new Ticket();
	fXML.createXML("Tickets", "Tickets.xml");
	initializer();
	}

	private void initializer() {
		guiRT.getBExit().addActionListener(this);
		guiRT.getBRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== guiRT.getBRegister()) {
			//creando en objeto
			ticket = new Ticket(guiRT.getTNumTicket().getText(),
					guiRT.getTPassportTicket().getText(),
					guiRT.getTNumFlightTicket().getText());
			fXML.writeXML("Tickets.xml","Ticket",ticket.getDataName(),ticket.getData());
			
			arrayLTicket = ticket.readXMLArrayList("Tickets.xml","Ticket",ticket.getDataName());
			guiRT.cleanForm();
			
				guiRT.getDTMTTicket().addRow(new Object [] {ticket.getNumTicket(),ticket.getPassport(),ticket.getNumFlight()});
		
		}
		if(e.getSource()== guiRT.getBExit()) {
			//meter la pagina anterior
			guiRT.dispose();
			//System.exit(0);
		}
	}
}

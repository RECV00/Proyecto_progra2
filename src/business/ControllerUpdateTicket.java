package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.Logic;
import domain.Ticket;
import presentation.GUIUpdateTicket;


public class ControllerUpdateTicket implements ActionListener{

	private GUIUpdateTicket guiUT;
	private FilesXML fXML;
	private Ticket ticket;
	private Logic lo;
	
	public ControllerUpdateTicket() {
		guiUT = new GUIUpdateTicket();
		fXML= new FilesXML();
		ticket = new Ticket();
		lo= new Logic();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUT.getBUpdate().addActionListener(this);
		guiUT.getBExit().addActionListener(this);
		guiUT.getBSearch().addActionListener(this);
		//muestra tabla llena
		guiUT.getDTMTTicket().setRowCount(0);
		guiUT.setArrayListTicket(lo.getListTicket("Tickets.xml","Ticket"));
		guiUT.fillTable(guiUT.getArrayListTicket());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiUT.getBSearch()) {
			
			ticket = lo.searchTicket("Tickets.xml","Ticket","numTicket",guiUT.getTNumTicket().getText());
			//guiUT.getTNumTicket().setText(ticket.getNumTicket());
			guiUT.getTPassportTicket().setText(ticket.getPassport());
			guiUT.getTNumFlightTicket().setText(ticket.getNumFlight());
			
		}
		if(e.getSource() == guiUT.getBUpdate()) {
			ticket = new Ticket(guiUT.getTNumTicket().getText(),
					guiUT.getTPassportTicket().getText(),
					guiUT.getTNumFlightTicket().getText());
			try {
				fXML.updateXML("Tickets.xml","Ticket",ticket.getDataName(),ticket.getData());
				
				guiUT.getDTMTTicket().setRowCount(0);
				guiUT.getDTMTTicket().addRow(new Object [] {ticket.getNumTicket(),ticket.getPassport(),ticket.getNumFlight()});
				guiUT.setArrayListTicket(lo.getListTicket("Tickets.xml","Ticket"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== guiUT.getBExit()) {
			guiUT.dispose();
		}
	}
}

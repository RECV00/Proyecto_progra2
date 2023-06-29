package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.LogicXML;
import domain.Ticket;
import presentation.GUIDeleteTicket;


public class ControllerDeleteTicket implements ActionListener{

	private GUIDeleteTicket guiDT;
	private FilesXML fXML;
	private Ticket ticket;
	private LogicXML lo;
	
	public ControllerDeleteTicket() {
		// TODO Auto-generated constructor stub
		guiDT= new GUIDeleteTicket();
		fXML= new FilesXML();
		lo= new LogicXML();
		ticket= new Ticket();
		initializer();
	}

	private void initializer() {
		// TODO Auto-generated method stub
		guiDT.getBDelete().addActionListener(this);
		guiDT.getBExit().addActionListener(this);
		
		guiDT.getDTMTTicket().setRowCount(0);
		guiDT.setArrayListTicket(lo.getListTicket("Tickets.xml", "Ticket"));
		guiDT.fillTable(guiDT.getArrayListTicket());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiDT.getBDelete()) {
			fXML.deleteXML("Tickets.xml","Ticket", "numTicket",guiDT.getTNameDeleteTicket().getText());
			guiDT.getDTMTTicket().setRowCount(0);
			guiDT.setArrayListTicket(lo.getListTicket("Tickets.xml", "Ticket"));
			guiDT.fillTable(guiDT.getArrayListTicket());
		
		}
		if(e.getSource()== guiDT.getBExit()) {
			guiDT.dispose();
		}
	}

}

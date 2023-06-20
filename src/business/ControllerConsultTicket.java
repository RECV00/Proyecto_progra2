package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import data.Logic;
import domain.Ticket;
import presentation.GUIConsultTicket;

public class ControllerConsultTicket implements ActionListener{

	private GUIConsultTicket guiCT;
	private Ticket ticket;
	private FilesXML fXML;
	private Logic lo;
	
	public ControllerConsultTicket() {
		guiCT= new GUIConsultTicket();
		fXML = new FilesXML();
		lo= new Logic();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiCT.getBCheckHistory().addActionListener(this);
		guiCT.getBSearch().addActionListener(this);
		guiCT.getBExit().addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiCT.getBCheckHistory()) {
			guiCT.getDTMTTicket().setRowCount(0);
			guiCT.setArrayListTicket(lo.getListTicket("Tickets.xml", "Ticket"));
			guiCT.fillTable(guiCT.getArrayListTicket());
		}
		if(e.getSource()==guiCT.getBSearch()) {
		try {//cambiar metodo
			guiCT.getDTMTTicket().setRowCount(0);
			guiCT.setArrayListTicket(lo.getListTicket("Tickets.xml", "Ticket"));
			guiCT.fillTable(guiCT.getArrayListTicket());		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		if(e.getSource()==guiCT.getBExit()) {
			guiCT.dispose();
		}
	}

}

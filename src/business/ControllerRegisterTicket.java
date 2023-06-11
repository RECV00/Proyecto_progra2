package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Ticket;
import presentation.GUIRegisterTicket;


public class ControllerRegisterTicket implements ActionListener{
	
	private GUIRegisterTicket guiRT;
	private FilesXML fXML;
	private Ticket ticket;
	//ArrayListUser<User> arrayLUser;
	
	public ControllerRegisterTicket() {
	guiRT= new GUIRegisterTicket();
	fXML = new FilesXML();
	ticket = new Ticket();
	fXML.createXML("Ticket", "Tickets.xml");
	initializer();
	}

	private void initializer() {
		guiRT.getBExit().addActionListener(this);
		guiRT.getBRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	//	System.out.println(guiRA.getArrayListUser().size());
		//guiRA.print(guiRA.getTUser());//pdf
		
		if(e.getSource()== guiRT.getBRegister()) {
			//creando en objeto
			ticket = new Ticket(guiRT.getTNumTicket().getText(),
					guiRT.getTPassportTicket().getText(),
					guiRT.getTNumFlightTicket().getText());
			
			guiRT.cleanForm();
			//escribiendo en el XML Tiquetes
			fXML.writeXML("Tickets.xml","Ticket",
					ticket.getDataName(),ticket.getData());
			//guiRF.getArrayListFlight().add(flight);
			//guiRA.getDTMTAirline().addRow(air);
		}
		if(e.getSource()== guiRT.getBExit()) {
			//meter la pagina anterior
			guiRT.dispose();
			//System.exit(0);
		}
	}
}

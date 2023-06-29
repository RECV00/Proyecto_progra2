package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.LogicXML;
import domain.Flight;
import domain.Passenger;
import domain.Ticket;
import domain.User;
import presentation.GUIRegisterTicket;


public class ControllerRegisterTicket implements ActionListener{
	
	private GUIRegisterTicket guiRT;
	private FilesXML fXML;
	private Ticket ticket;
	private LogicXML lo;
	private ArrayList<Ticket> arrayLTicket;
	ArrayList<Passenger>arrayLPassenger;
	ArrayList<Flight> arrayLF;
	public ControllerRegisterTicket() {
	
	fXML = new FilesXML();
	ticket = new Ticket();
	lo= new LogicXML();
	fXML.createXML("Tickets", "Tickets.xml");
	arrayLF = lo.getNameFlight("Flights.xml", "Flight");
	arrayLPassenger=lo.getNamePassport("Passengers.xml", "Passenger");
	guiRT= new GUIRegisterTicket(arrayLPassenger,arrayLF);
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
			ticket = new Ticket(String.valueOf(guiRT.numRandom()),
					guiRT.getComboBoxPass().getSelectedItem().toString(),
					guiRT.getComboBoxFlight().getSelectedItem().toString());
			
			fXML.writeXML("Tickets.xml","Ticket",ticket.getDataName(),ticket.getData());
			arrayLTicket = lo.readXMLArrayListTicket("Tickets.xml","Ticket",ticket.getDataName());
			guiRT.getDTMTTicket().addRow(new Object [] {guiRT.numRandom(),guiRT.getComboBoxPass().getSelectedItem().toString(),ticket.getNumFlight()});
			guiRT.cleanForm();
			
		}
		if(e.getSource()== guiRT.getBExit()) {
			
			guiRT.dispose();
			
		}
	}
}

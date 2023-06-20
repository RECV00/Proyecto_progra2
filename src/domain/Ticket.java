package domain;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ticket {

	private String numTicket;
	private String passport;
	private String numFlight;
	
	public Ticket() {
		
	};
	
	public Ticket(String numTicket, String passport, String numFlight) {
		super();
		this.numTicket = numTicket;
		this.passport = passport;
		this.numFlight = numFlight;
	}

	public String getNumTicket() {
		return numTicket;
	}

	public void setNumTicket(String numTicket) {
		this.numTicket = numTicket;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getNumFlight() {
		return numFlight;
	}

	public void setNumFlight(String numFlight) {
		this.numFlight = numFlight;
	}
	
	public boolean availability(String dato) {
		
		return true;
	}
	
	public boolean existTicket(String dato) {
		
		return true;
	}
	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"numTicket","passport","numFlight"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {numTicket,passport,numFlight};
		return data;
	}
	@Override
	public String toString() {
		return numTicket + "\n" + passport + "\n" + numFlight;
	}
	 

}

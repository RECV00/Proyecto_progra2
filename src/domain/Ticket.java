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

	ArrayList<Ticket> arrayLTicket;
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
	 
	public ArrayList<Ticket> readXMLArrayList(String FileName, String elementType,String[]dataName) {
		
		String info="";
		Ticket ti;
		arrayLTicket= new ArrayList<>();
		try {
			File inputFile = new File(FileName); //new 
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			System.out.println("Raíz de los Elementos:" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName(elementType);
			System.out.println("----------------------------");

			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);
				System.out.println("\nDatos de Tiquetes: " + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					info+=(dataName[0] +":"+eElement.getAttribute(dataName[0])+"\n");
					Ticket t =new Ticket(eElement.getAttribute(dataName[0]),
							eElement.getElementsByTagName(dataName[1]).item(0).getTextContent(),
							eElement.getElementsByTagName(dataName[2]).item(0).getTextContent());
							
					ti=new Ticket(numTicket,passport,numFlight);
					arrayLTicket.add(ti);
					
					for(int i=1;i<dataName.length;i++) {
						info+=dataName[i] +":"+eElement.getElementsByTagName(dataName[i]).item(0).getTextContent();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayLTicket;
	}
}

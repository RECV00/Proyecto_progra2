package domain;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Flight {

	private String numFlight;
	private String departureCity;
	private String departureDateTime;
	private String arrivalCity;
	private String arrivalDateTime;
	private String flight;
	private String seat;
	private int amount;
	ArrayList<Flight> arrayLFlight;
	
	public Flight() {}
	
	public Flight(String numFlight, String departureCity, String departureDateTime, String arrivalCity,
			String arrivalDateTime, String flight, String seat,int amount) {
		super();
		this.numFlight = numFlight;
		this.departureCity = departureCity;
		this.departureDateTime = departureDateTime;
		this.arrivalCity = arrivalCity;
		this.arrivalDateTime = arrivalDateTime;
		this.flight = flight;
		this.seat=seat;
		this.amount = amount;
	}

	public String getNumFlight() {
		//ram numero
		return numFlight;
	}

	public void setNumFlight(String numFlight) {
		this.numFlight = numFlight;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDepartureDateTime() {
		//generar automatico
		return departureDateTime;
	}

	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(String arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public int getAmount(String typeSeat) {
		if (typeSeat=="Clase Ejecutiva") {
			return 48429;
		}else if (typeSeat=="Clase Turista") {
			return 16143;
		}else {
			return 5381;
		}
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"numFlight","departureCity","departureDateTime",
				"arrivalCity","arrivalDateTime","flight","seat","amount"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {numFlight,departureCity,departureDateTime,
				arrivalCity,arrivalDateTime,flight,seat,String.valueOf(amount)};
		return data;
	}
	@Override
	public String toString() {
		return numFlight + "-" + departureCity + "-"+ departureDateTime + "-" + arrivalCity + "-"
				+ arrivalDateTime+ "-" + flight + "-" + seat + "-" + amount;
	}
	public ArrayList<Flight> readXMLArrayList(String FileName, String elementType,String[]dataName) {
		
		String info="";
		Flight flights;
		arrayLFlight= new ArrayList<>();
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
				System.out.println("\nDatos de los vuelos: " + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					info+=(dataName[0] +":"+eElement.getAttribute(dataName[0])+"\n");
					
					Flight f =new Flight(eElement.getAttribute(dataName[0]),
							eElement.getElementsByTagName(dataName[1]).item(0).getTextContent(),
							eElement.getElementsByTagName(dataName[2]).item(0).getTextContent(),
							eElement.getElementsByTagName(dataName[3]).item(0).getTextContent(),
							eElement.getElementsByTagName(dataName[4]).item(0).getTextContent(),
							eElement.getElementsByTagName(dataName[5]).item(0).getTextContent(),
							eElement.getElementsByTagName(dataName[6]).item(0).getTextContent(),
							Integer.parseInt(eElement.getElementsByTagName(dataName[7]).item(0).getTextContent()));
					
					flights = new Flight(numFlight,departureCity,departureDateTime,
							arrivalCity,arrivalDateTime,flight,seat,amount);
					
					arrayLFlight.add(flights);
					
					for(int i=1;i<dataName.length;i++) {
						info+=dataName[i] +":"+eElement.getElementsByTagName(dataName[i]).item(0).getTextContent();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayLFlight;
	}
	
}

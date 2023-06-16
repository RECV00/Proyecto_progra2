package domain;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Passenger {
	ArrayList<Passenger> arrayLPassenger;
	private String passport;
	private String name;
	private String lastName;
	private String birthdate;
	private String gmail;
	private int phone;
	
	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public Passenger(String passport, String name, String lastName, String birthdate, String gmail, int phone) {
		super();
		this.passport = passport;
		this.name = name;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.gmail = gmail;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	
	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"passport","name","lastName","birthdate","gmail","phone"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {passport,name,lastName,birthdate,gmail,String.valueOf(phone)};
		return data;
	}
	@Override
	public String toString() {
		return  passport + "-" + name + "-" + lastName + "-"+ birthdate + "-" + 
				gmail + "-" + phone;
	}

	
	public ArrayList<Passenger> readXMLArrayList(String FileName, String elementType,String[]dataName) {
		
		String info="";
		Passenger pa;
		arrayLPassenger= new ArrayList<>();
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
				System.out.println("\nDatos de Pasajero: " + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					info+=(dataName[0] +":"+eElement.getAttribute(dataName[0])+"\n");
					
					Passenger p =new Passenger(eElement.getAttribute(dataName[0]),
							eElement.getElementsByTagName(dataName[1]).item(0).getTextContent(),
							eElement.getElementsByTagName(dataName[2]).item(0).getTextContent(),
							eElement.getElementsByTagName(dataName[3]).item(0).getTextContent(),
							eElement.getElementsByTagName(dataName[4]).item(0).getTextContent(),
							Integer.parseInt(eElement.getElementsByTagName(dataName[5]).item(0).getTextContent()));
					
					pa =new Passenger(passport,name,lastName,birthdate,gmail,phone);
					arrayLPassenger.add(pa);
					
					for(int i=1;i<dataName.length;i++) {
						info+=dataName[i] +":"+eElement.getElementsByTagName(dataName[i]).item(0).getTextContent();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayLPassenger;
	}
}

package domain;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Plane {
	ArrayList<Plane> arrayLPlane;
	private String plate;
	private String airline;
	private String model;
	private String year;
	
	public Plane() {
		// TODO Auto-generated constructor stub
	}

	

	public Plane(String plate, String airline, String model, String year) {
		super();
		this.plate = plate;
		this.airline = airline;
		this.model = model;
		this.year = year;
	}

	public String getPlate() {
		return plate;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}
	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"plate","airline","model","year"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {plate,airline,model,year};
		return data;
	}
@Override
	public String toString() {
		return plate +"-"+ airline +"-"+ model+"-"+ year;
	}
	
public ArrayList<Plane> readXMLArrayList(String FileName, String elementType,String[]dataName) {
	
	String info="";
	Plane pl;
	arrayLPlane= new ArrayList<>();
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
			System.out.println("\nDatos de Aviones: " + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				info+=(dataName[0] +":"+eElement.getAttribute(dataName[0])+"\n");

				pl=new Plane(plate,airline,model,year);
				arrayLPlane.add(pl);
				
				for(int i=1;i<dataName.length;i++) {
					info+=dataName[i] +":"+eElement.getElementsByTagName(dataName[i]).item(0).getTextContent();
				}
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return arrayLPlane;
}
}

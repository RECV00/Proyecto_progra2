package domain;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Airline {
	
	ArrayList<Airline> arrayLAirline;
	Vector<Airline[]>vect;
	private String name;
	private String contry;
	private String[] words;

//contructores
public Airline() {}

public Airline(String[] words) {
    this.words = words;
}
	public Airline(String name, String contry) {
		super();
		this.name = name;
		this.contry = contry;
	}
//sets y gets
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"name","contry"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {name,contry};
		return data;
	}
//toString
	@Override
	public String toString() {
		return name +":"+ contry;
	}
	
public ArrayList<Airline> readXMLArrayList(String FileName, String elementType,String[]dataName) {
		
		String info="";
		Airline ar;
		arrayLAirline= new ArrayList<>();
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
				System.out.println("\nDatos de la Aerolinea: " + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					info+=(dataName[0] +":"+eElement.getAttribute(dataName[0])+"\n");
					
					
					ar=new Airline(name,contry);
					arrayLAirline.add(ar);
					
					for(int i=1;i<dataName.length;i++) {
						info+=dataName[i] +":"+eElement.getElementsByTagName(dataName[i]).item(0).getTextContent();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayLAirline;
	}
public Vector<Airline[]> readXMLVector2(String address, String elementType, String[] dataName) {
		String info = "";
	    Vector<Airline[]> vect = new Vector<>();
	    Airline ar;

	    try {
	        File inputFile = new File(address);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);

	        NodeList nList = doc.getElementsByTagName(elementType);

	        for (int i = 0; i < nList.getLength(); i++) {
	            Node nNode = nList.item(i);

	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element eElement = (Element) nNode;
	                info += (dataName[0] + ":" + eElement.getAttribute(dataName[0]) + "\n");
	                ar = new Airline(eElement.getAttribute("name"),
	                        eElement.getElementsByTagName("contry").item(0).getTextContent());
	                
	                vect.add(new Airline[dataName.length]);
	                vect.get(i)[0] = ar;

	                for (int in = 1; in < dataName.length; in++) {
	                    String[] words = eElement.getElementsByTagName(dataName[in]).item(0).getTextContent().split(" ");
	                    vect.get(i)[in] = new Airline(words);//words
	                    info += dataName[in] + ":";
	                    for (String word : words) {
	                        info += " " + word;
	                    }
	                    info += "\n";
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return vect;
	}
}

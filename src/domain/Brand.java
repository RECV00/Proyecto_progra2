package domain;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Brand {

	ArrayList<Brand> arrayLBrand;
private String name;

//contructores
public Brand() {}
public Brand(String name) {
		super();
		this.name = name;
	}
//sets y gets
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"name"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {name};
		return data;
	}
//toString
	@Override
	public String toString() {
		return name;
	}
	
	public ArrayList<Brand> readXMLArrayList(String FileName, String elementType,String[]dataName) {
		String name="";
		String info="";
		Brand br;
		arrayLBrand= new ArrayList<>();
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
				System.out.println("\nDatos de las Facturas: " + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					info+=(dataName[0] +":"+eElement.getAttribute(dataName[0])+"\n");
					Brand b =new Brand(eElement.getAttribute(dataName[0]));
					br=new Brand(name);
					arrayLBrand.add(br);
					
					for(int i=1;i<dataName.length;i++) {
						info+=dataName[i] +":"+eElement.getElementsByTagName(dataName[i]).item(0).getTextContent();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayLBrand;
	}
	
}

package domain;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Model {
	
	ArrayList<Model> arrayLModel;
	private String name;
	private String marca;
	private int cantSeatExecutive;
	private int cantSeatTourist;
	private int cantSeatEconomic;
	
	public Model() {
		// TODO Auto-generated constructor stub
	}

	public Model(String name, String marca, int cantSeatExecutive, int cantSeatTourist, int cantSeatEconomic) {
		super();
		this.name = name;
		this.marca = marca;
		this.cantSeatExecutive = cantSeatExecutive;
		this.cantSeatTourist = cantSeatTourist;
		this.cantSeatEconomic = cantSeatEconomic;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCantSeatExecutive() {
		return cantSeatExecutive;
	}

	public void setCantSeatExecutive(int cantSeatExecutive) {
		this.cantSeatExecutive = cantSeatExecutive;
	}

	public int getCantSeatTourist() {
		return cantSeatTourist;
	}

	public void setCantSeatTourist(int cantSeatTourist) {
		this.cantSeatTourist = cantSeatTourist;
	}

	public int getCantSeatEconomic() {
		return cantSeatEconomic;
	}

	public void setCantSeatEconomic(int cantSeatEconomic) {
		this.cantSeatEconomic = cantSeatEconomic;
	}
	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"name","marca","cantSeatExecutive","cantSeatTourist","cantSeatEconomic"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {name,marca,String.valueOf(cantSeatExecutive),String.valueOf(cantSeatTourist),String.valueOf(cantSeatEconomic)};
		return data;
	}

	@Override
	public String toString() {
		return  name + "-" + marca + "-" + cantSeatExecutive
				+ "-" + cantSeatTourist + "-" + cantSeatEconomic;
	}
	
public ArrayList<Model> readXMLArrayList(String FileName, String elementType,String[]dataName) {
	
		String info="";
		Model model;
		arrayLModel= new ArrayList<>();
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
				System.out.println("\nDatos de los modelos: " + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					info+=(dataName[0] +":"+eElement.getAttribute(dataName[0])+"\n");
					
					Model m = new Model(eElement.getAttribute(dataName[0]),
							eElement.getElementsByTagName(dataName[1]).item(0).getTextContent(),
							Integer.parseInt(eElement.getElementsByTagName(dataName[2]).item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName(dataName[3]).item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName(dataName[4]).item(0).getTextContent()));
					
					model = new Model(name,marca,cantSeatExecutive,cantSeatTourist,cantSeatEconomic);
					arrayLModel.add(model);
					
					for(int i=1;i<dataName.length;i++) {
						info+=dataName[i] +":"+eElement.getElementsByTagName(dataName[i]).item(0).getTextContent();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayLModel;
	}
}

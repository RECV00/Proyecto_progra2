package domain;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class User {
	//ArrayList<User> listaUser;
	String userName;
	String password;
	String typeUser;
	String state;
//contructores
	public User() {	
		
	}
	
	public User(String userName, String password, String typeUser, String state) {
		super();
		this.userName = userName;
		this.password = password;
		this.typeUser = typeUser;
		this.state = state;
	}
//sets y gets
	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"userName","password","typeUser","state"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {userName,password,typeUser,state};
		return data;
	}
	
//toString
	@Override
	public String toString() {
		return userName+"\n"+password+"\n"+typeUser+"\n"+state;
	}
	
	public ArrayList<User> readXMLArrayList(String FileName, String elementType) {
		ArrayList<User> arrayLPeople = new ArrayList<User>();
		
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
					
					User u =new User(eElement.getAttribute(userName),eElement.getElementsByTagName(password).item(0).getTextContent(),
							eElement.getElementsByTagName(typeUser).item(0).getTextContent(),
							eElement.getElementsByTagName(state).item(0).getTextContent());
					arrayLPeople.add(u);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayLPeople;
	}
}

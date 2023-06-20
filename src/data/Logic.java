package data;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.Airline;
import domain.Brand;
import domain.Flight;
import domain.Model;
import domain.Passenger;
import domain.Plane;
import domain.Ticket;
import domain.User;

public class Logic {
	
	ArrayList<Airline> arrayLAirline;
	ArrayList<Brand> arrayLBrand;
	ArrayList<Flight> arrayLFlight;
	ArrayList<Model> arrayLModel;
	ArrayList<Passenger> arrayLPassenger;
	ArrayList<Plane> arrayLPlane;
	ArrayList<Ticket> arrayLTicket;
	ArrayList<User> arrayLUser;

	Vector<Airline[]>vect;
	
	public Logic() {
		// TODO Auto-generated constructor stub
	}
	//usuario
	public ArrayList<User> readXMLArrayListUser(String FileName, String elementType,String[]dataName) {
		
		String info="";
		User us = new User();
		arrayLUser= new ArrayList<>();
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
				System.out.println("\nDatos de Usuario: " + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					info+=(dataName[0] +":"+eElement.getAttribute(dataName[0])+"\n");
					
					us=new User(us.getUserName(),us.getPassword(),us.getTypeUser(),us.getState());
					arrayLUser.add(us);
					
					for(int i=1;i<dataName.length;i++) {
						info+=dataName[i] +":"+eElement.getElementsByTagName(dataName[i]).item(0).getTextContent();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayLUser;
	}
	
public ArrayList<User> getListUser(String FileName, String elementType) {
		
		User us = new User();
		arrayLUser= new ArrayList<User>();
		try {
			File inputFile = new File(FileName); //new 
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			
			NodeList nList = doc.getElementsByTagName(elementType);

			for (int indice = 0; indice < nList.getLength(); indice++) {
				Node nNode = nList.item(indice);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					us = new User(eElement.getAttribute("userName"),
							eElement.getElementsByTagName("password").item(0).getTextContent(),
							eElement.getElementsByTagName("typeUser").item(0).getTextContent(), 
							eElement.getElementsByTagName("state").item(0).getTextContent());

					arrayLUser.add(us);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayLUser;
	}

	//Aerolinea
	
public ArrayList<Airline> readXMLArrayListAirline(String FileName, String elementType,String[]dataName) {
		
		String info="";
		Airline ar = new Airline();
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
					
					
					ar = new Airline(ar.getName(),ar.getContry());
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
public ArrayList<Airline> getListAirline(String FileName, String elementType) {
	 arrayLAirline= new ArrayList<>();
	Airline air = new Airline();
	try {
		File inputFile = new File(FileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName(elementType);

		for (int indice = 0; indice < nList.getLength(); indice++) {
			Node nNode = nList.item(indice);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				air = new Airline(eElement.getAttribute("name"),
				eElement.getElementsByTagName("contry").item(0).getTextContent());
				
				arrayLAirline.add(air);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return arrayLAirline;
}


//BRAND
public ArrayList<Brand> readXMLArrayListBrand(String FileName, String elementType,String[]dataName) {
	String name="";
	String info="";
	Brand br= new Brand();
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
			System.out.println("\nDatos de Marca: " + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				info+=(dataName[0] +":"+eElement.getAttribute(dataName[0])+"\n");
				
				br=new Brand(br.getName());
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
public ArrayList<Brand> getListBrand(String FileName, String elementType) {
	 arrayLBrand= new ArrayList<>();
	Brand b = new Brand();
	try {
		File inputFile = new File(FileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName(elementType);

		for (int indice = 0; indice < nList.getLength(); indice++) {
			Node nNode = nList.item(indice);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				b = new Brand(eElement.getAttribute("name"));
				
				arrayLBrand.add(b);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return arrayLBrand;
}

//FLIGHT
public ArrayList<Flight> readXMLArrayListFlight(String FileName, String elementType,String[]dataName) {
	
	String info="";
	Flight flights = new Flight();
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
				
				flights = new Flight(flights.getNumFlight(),flights.getDepartureCity(),flights.getDepartureDateTime(),
						flights.getArrivalCity(),flights.getArrivalDateTime(),flights.getFlight(),flights.getSeat(),flights.getAmount(flights.getSeat()));
				
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
public ArrayList<Flight> getListFlight(String FileName, String elementType) {
	 arrayLFlight= new ArrayList<>();
	Flight f = new Flight();
	try {
		File inputFile = new File(FileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName(elementType);

		for (int indice = 0; indice < nList.getLength(); indice++) {
			Node nNode = nList.item(indice);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				f = new Flight(eElement.getAttribute("numFlight"),
						eElement.getElementsByTagName("departureCity").item(0).getTextContent(),
						eElement.getElementsByTagName("departureDateTime").item(0).getTextContent(),
						eElement.getElementsByTagName("arrivalCity").item(0).getTextContent(),
						eElement.getElementsByTagName("arrivalDateTime").item(0).getTextContent(),
						eElement.getElementsByTagName("flight").item(0).getTextContent(),
						eElement.getElementsByTagName("seat").item(0).getTextContent(),
						Integer.parseInt(eElement.getElementsByTagName("amount").item(0).getTextContent()));
				
				arrayLFlight.add(f);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return arrayLFlight;
}
//MODEL
public ArrayList<Model> readXMLArrayListModel(String FileName, String elementType,String[]dataName) {
	
	String info="";
	Model model = new Model();
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
				
				model = new Model(model.getName(),model.getMarca(),model.getCantSeatExecutive(),
						model.getCantSeatTourist(),model.getCantSeatEconomic());
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
public ArrayList<Model> getListModel(String FileName, String elementType) {
	 arrayLModel= new ArrayList<>();
	Model m = new Model();
	try {
		File inputFile = new File(FileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName(elementType);

		for (int indice = 0; indice < nList.getLength(); indice++) {
			Node nNode = nList.item(indice);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				m = new Model(eElement.getAttribute("name"),
						eElement.getElementsByTagName("marca").item(0).getTextContent(),
						Integer.parseInt(eElement.getElementsByTagName("cantSeatExecutive").item(0).getTextContent()),
						Integer.parseInt(eElement.getElementsByTagName("cantSeatTourist").item(0).getTextContent()),
						Integer.parseInt(eElement.getElementsByTagName("cantSeatEconomic").item(0).getTextContent()));
				
				arrayLModel.add(m);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return arrayLModel;
}
//PASSENGER
public ArrayList<Passenger> readXMLArrayListPassenger(String FileName, String elementType,String[]dataName) {
	
	String info="";
	Passenger pa = new Passenger();
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
				
				pa =new Passenger(pa.getPassport(),pa.getName(),pa.getLastName(),
						pa.getBirthdate(),pa.getGmail(),pa.getPhone());
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
public ArrayList<Passenger> getListPassenger(String FileName, String elementType) {
	 arrayLPassenger= new ArrayList<>();
	Passenger pa = new Passenger();
	try {
		File inputFile = new File(FileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName(elementType);

		for (int indice = 0; indice < nList.getLength(); indice++) {
			Node nNode = nList.item(indice);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				pa = new Passenger(eElement.getAttribute("passport"),
						eElement.getElementsByTagName("name").item(0).getTextContent(),
						eElement.getElementsByTagName("lastName").item(0).getTextContent(),
						eElement.getElementsByTagName("birthdate").item(0).getTextContent(),
						eElement.getElementsByTagName("gmail").item(0).getTextContent(),
						Integer.parseInt(eElement.getElementsByTagName("phone").item(0).getTextContent()));
				
				arrayLPassenger.add(pa);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return arrayLPassenger;
}
//PLANE
public ArrayList<Plane> readXMLArrayListPlane(String FileName, String elementType,String[]dataName) {
	
	String info="";
	Plane pl = new Plane();
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

				pl=new Plane(pl.getPlate(),pl.getAirline(),pl.getModel(),pl.getYear());
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
public ArrayList<Plane> getListPlane(String FileName, String elementType) {
	 arrayLPlane= new ArrayList<>();
	Plane p = new Plane();
	try {
		File inputFile = new File(FileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName(elementType);

		for (int indice = 0; indice < nList.getLength(); indice++) {
			Node nNode = nList.item(indice);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				p = new Plane(eElement.getAttribute("plate"),
						eElement.getElementsByTagName("airline").item(0).getTextContent(),
						eElement.getElementsByTagName("model").item(0).getTextContent(),
						eElement.getElementsByTagName("year").item(0).getTextContent());
				
				arrayLPlane.add(p);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return arrayLPlane;
}
//TICKET
public ArrayList<Ticket> readXMLArrayListTicket(String FileName, String elementType,String[]dataName) {
	
	String info="";
	Ticket ti = new Ticket();
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
				
				ti=new Ticket(ti.getNumTicket(),ti.getPassport(),ti.getNumFlight());
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
public ArrayList<Ticket> getListTicket(String FileName, String elementType) {
	 arrayLTicket= new ArrayList<>();
	Ticket t = new Ticket();
	try {
		File inputFile = new File(FileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName(elementType);

		for (int indice = 0; indice < nList.getLength(); indice++) {
			Node nNode = nList.item(indice);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				t = new Ticket(eElement.getAttribute("numTicket"),
						eElement.getElementsByTagName("passport").item(0).getTextContent(),
						eElement.getElementsByTagName("numFlight").item(0).getTextContent());
						
				
				arrayLTicket.add(t);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return arrayLTicket;
}
	//------------------------------------------------------------------------------------------------
	public Vector<String> searchXMLVector(String archive, String searchWord) throws Exception {
	    Vector<String> result = new Vector<>();

	    // Crear un objeto DocumentBuilderFactory y un objeto DocumentBuilder para obtener el archivo XML
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    // Crear un objeto Document a partir del archivo XML
	    Document doc = builder.parse(archive);

	    // Obtener una lista de todos los elementos del documento XML
	    NodeList nodes = doc.getElementsByTagName("*");

	    // Iterar a través de los nodos y buscar la línea que contiene la palabra buscada
	    for (int i = 0; i < nodes.getLength(); i++) {
	        Node node = nodes.item(i);
	        if (node.getNodeType() == Node.TEXT_NODE) {
	            String text = node.getNodeValue().trim();
	            if (text.equals(searchWord)) {
	                // Obtener el nodo padre que contiene la línea
	                Node parent = node.getParentNode();
	                // Obtener el contenido del nodo padre
	                String line = parent.getTextContent().trim();
	                result.add(line);
	                
	            }
	        }
	    }

	    return result;
	}

}

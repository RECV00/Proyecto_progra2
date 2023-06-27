package data;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

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
public ArrayList<User> searchXMLUser(String fileName,String elementType, String data,String word) {
    arrayLUser = new ArrayList<>();
    User user= new User();
    
    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parsear el archivo XML y obtener el documento
        Document documento = builder.parse(new File(fileName));

        // Obtener la lista de nodos con etiqueta "usuario"
        NodeList listaUser = documento.getElementsByTagName(elementType);

        // Recorrer la lista de usuarios
        for (int i = 0; i < listaUser.getLength(); i++) {
            Node nodoUser = listaUser.item(i);

            if (nodoUser.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nodoUser;

                // Obtener el nombre de usuario del elemento "username"
                String userName = eElement.getAttribute(data);

                if (userName.equals(word)) {
                	
                	user = new User(eElement.getAttribute("userName"),
							eElement.getElementsByTagName("password").item(0).getTextContent(),
							eElement.getElementsByTagName("typeUser").item(0).getTextContent(), 
							eElement.getElementsByTagName("state").item(0).getTextContent());

                    arrayLUser.add(user);
                }
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
public ArrayList<Airline> searchXMLAirline(String fileName,String elementType, String data,String word) {
    arrayLAirline = new ArrayList<>();
    Airline a = new Airline();
    
    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Parsear el archivo XML y obtener el documento
        Document documento = builder.parse(new File(fileName));
        // Obtener la lista de nodos con etiqueta "usuario"
        NodeList listaUser = documento.getElementsByTagName(elementType);
        // Recorrer la lista de usuarios
        for (int i = 0; i < listaUser.getLength(); i++) {
            Node nodoUser = listaUser.item(i);
            if (nodoUser.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nodoUser;
                // Obtener el nombre de la Aerolinea del elemento "name"
                String name = eElement.getAttribute(data);

                if (name.equals(word)) {
                	
                	a = new Airline(eElement.getAttribute("name"),
							eElement.getElementsByTagName("contry").item(0).getTextContent());

                    arrayLAirline.add(a);
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return arrayLAirline;
}
public ArrayList<Airline> getNAirline(String rutaArchivo, String elementType) {
    arrayLAirline= new ArrayList<>();
    Airline a = new Airline();

    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parsear el archivo XML y obtener el objeto Document
        File archivoXML = new File(rutaArchivo);
        Document documento = builder.parse(archivoXML);

        // Obtener la lista de elementos de avión en el documento
        NodeList nodeList = documento.getElementsByTagName(elementType);

        // Recorrer los elementos de avión y obtener las placas
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element elementoAvion = (Element) nodeList.item(i);
            String nameAirline = elementoAvion.getAttribute("name");
            a=new Airline(nameAirline);
            arrayLAirline.add(a);
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
public ArrayList<Brand> searchXMLBrand(String fileName,String elementType, String data,String word) {
    arrayLBrand = new ArrayList<>();
    Brand b = new Brand();
    
    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Parsear el archivo XML y obtener el documento
        Document documento = builder.parse(new File(fileName));
        // Obtener la lista de nodos con etiqueta "usuario"
        NodeList listaUser = documento.getElementsByTagName(elementType);
        // Recorrer la lista de usuarios
        for (int i = 0; i < listaUser.getLength(); i++) {
            Node nodoUser = listaUser.item(i);
            if (nodoUser.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nodoUser;
                // Obtener el nombre de la marca del elemento "name"
                String name = eElement.getAttribute(data);

                if (name.equals(word)) {
                	
                	b = new Brand(eElement.getAttribute("name"));

                    arrayLBrand.add(b);
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return arrayLBrand;
}
public ArrayList<Brand> getNameBrand(String rutaArchivo, String elementType) {
    arrayLBrand= new ArrayList<>();
    Brand b = new Brand();

    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parsear el archivo XML y obtener el objeto Document
        File archivoXML = new File(rutaArchivo);
        Document documento = builder.parse(archivoXML);

        // Obtener la lista de elementos de avión en el documento
        NodeList nodeList = documento.getElementsByTagName(elementType);

        // Recorrer los elementos de los modelos y obtener los nombres
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element elementoAvion = (Element) nodeList.item(i);
            String nameBrand = elementoAvion.getAttribute("name");
            b = new Brand(nameBrand);
            arrayLBrand.add(b);
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
	 arrayLFlight= new ArrayList<Flight>();
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
public ArrayList<Flight> searchXMLFlight(String fileName,String elementType, String data,String word) {
    arrayLFlight = new ArrayList<>();
    Flight f = new Flight();
    
    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Parsear el archivo XML y obtener el documento
        Document documento = builder.parse(new File(fileName));
        // Obtener la lista de nodos con etiqueta "usuario"
        NodeList listaUser = documento.getElementsByTagName(elementType);
        // Recorrer la lista de usuarios
        for (int i = 0; i < listaUser.getLength(); i++) {
            Node nodoUser = listaUser.item(i);
            if (nodoUser.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nodoUser;
                // Obtener el nombre de la marca del elemento "name"
                String numFlight = eElement.getAttribute(data);

                if (numFlight.equals(word)) {
                	
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
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return arrayLFlight;
}
public ArrayList<Flight> searchXMLAvion(String fileName,String elementType, String data,String word) {
    arrayLFlight = new ArrayList<>();
    Flight f = new Flight();
    
    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Parsear el archivo XML y obtener el documento
        Document documento = builder.parse(new File(fileName));
        // Obtener la lista de nodos con etiqueta "usuario"
        NodeList listaUser = documento.getElementsByTagName(elementType);
        // Recorrer la lista de usuarios
        for (int i = 0; i < listaUser.getLength(); i++) {
            Node nodoUser = listaUser.item(i);
            if (nodoUser.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nodoUser;
               
                String numFlight = eElement.getAttribute(data);

                if (numFlight.equals(word)) {
                	
                	f = new Flight(eElement.getElementsByTagName("flight").item(0).getTextContent());

                    arrayLFlight.add(f);
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return arrayLFlight;
}
public ArrayList<Flight> getNameFlight(String rutaArchivo, String elementType) {
    ArrayList<Flight> vuelo = new ArrayList<>();
    Flight f = new Flight();

    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parsear el archivo XML y obtener el objeto Document
        File archivoXML = new File(rutaArchivo);
        Document documento = builder.parse(archivoXML);

        // Obtener la lista de elementos de avión en el documento
        NodeList nodeList = documento.getElementsByTagName(elementType);

        // Recorrer los elementos de avión y obtener las placas
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element elementoAvion = (Element) nodeList.item(i);
            String numV = elementoAvion.getAttribute("numFlight");
            f=new Flight(numV);
            vuelo.add(f);
 
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return vuelo;
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
public ArrayList<Model> searchXMLModel(String fileName,String elementType, String data,String word) {
    arrayLModel = new ArrayList<>();
    Model m = new Model();
    
    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Parsear el archivo XML y obtener el documento
        Document documento = builder.parse(new File(fileName));
        // Obtener la lista de nodos con etiqueta "usuario"
        NodeList listaUser = documento.getElementsByTagName(elementType);
        // Recorrer la lista de usuarios
        for (int i = 0; i < listaUser.getLength(); i++) {
            Node nodoUser = listaUser.item(i);
            if (nodoUser.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nodoUser;
                // Obtener el nombre de la model del elemento "name"
                String nameModel = eElement.getAttribute(data);

                if (nameModel.equals(word)) {
                	
                	m = new Model(eElement.getAttribute("name"),
    						eElement.getElementsByTagName("marca").item(0).getTextContent(),
    						Integer.parseInt(eElement.getElementsByTagName("cantSeatExecutive").item(0).getTextContent()),
    						Integer.parseInt(eElement.getElementsByTagName("cantSeatTourist").item(0).getTextContent()),
    						Integer.parseInt(eElement.getElementsByTagName("cantSeatEconomic").item(0).getTextContent()));
    				
    				arrayLModel.add(m);
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return arrayLModel;
}
public ArrayList<Model> getNModel(String rutaArchivo, String elementType) {
    arrayLModel= new ArrayList<>();
    Model m = new Model();

    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parsear el archivo XML y obtener el objeto Document
        File archivoXML = new File(rutaArchivo);
        Document documento = builder.parse(archivoXML);

        // Obtener la lista de elementos de avión en el documento
        NodeList nodeList = documento.getElementsByTagName(elementType);

        // Recorrer los elementos de los modelos y obtener los nombres
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element elementoAvion = (Element) nodeList.item(i);
            String nameModel = elementoAvion.getAttribute("name");
            m = new Model(nameModel);
            arrayLModel.add(m);
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
public ArrayList<Passenger> searchXMLPassenger(String fileName,String elementType, String data,String word) {
    arrayLPassenger = new ArrayList<>();
    Passenger p = new Passenger();
    
    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Parsear el archivo XML y obtener el documento
        Document documento = builder.parse(new File(fileName));
        // Obtener la lista de nodos con etiqueta "usuario"
        NodeList listaUser = documento.getElementsByTagName(elementType);
        // Recorrer la lista de usuarios
        for (int i = 0; i < listaUser.getLength(); i++) {
            Node nodoUser = listaUser.item(i);
            if (nodoUser.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nodoUser;
                // Obtener el  Pasaporte del elemento "name"
                String passaport = eElement.getAttribute(data);

                if (passaport.equals(word)) {
                	
                	p = new Passenger(eElement.getAttribute("passport"),
    						eElement.getElementsByTagName("name").item(0).getTextContent(),
    						eElement.getElementsByTagName("lastName").item(0).getTextContent(),
    						eElement.getElementsByTagName("birthdate").item(0).getTextContent(),
    						eElement.getElementsByTagName("gmail").item(0).getTextContent(),
    						Integer.parseInt(eElement.getElementsByTagName("phone").item(0).getTextContent()));
    				
    				arrayLPassenger.add(p);
    				
                }
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
public ArrayList<Plane> searchXMLPlane(String fileName,String elementType, String data,String word) {
    arrayLPlane = new ArrayList<>();
    Plane p = new Plane();
    
    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Parsear el archivo XML y obtener el documento
        Document documento = builder.parse(new File(fileName));
        // Obtener la lista de nodos con etiqueta "usuario"
        NodeList listaUser = documento.getElementsByTagName(elementType);
        // Recorrer la lista de usuarios
        for (int i = 0; i < listaUser.getLength(); i++) {
            Node nodoUser = listaUser.item(i);
            if (nodoUser.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nodoUser;
                // Obtener la placa del elemento "plate"
                String plate = eElement.getAttribute(data);

                if (plate.equals(word)) {
                	
    				p = new Plane(eElement.getAttribute("plate"),
    						eElement.getElementsByTagName("airline").item(0).getTextContent(),
    						eElement.getElementsByTagName("model").item(0).getTextContent(),
    						eElement.getElementsByTagName("year").item(0).getTextContent());
    				
    				arrayLPlane.add(p);
    				
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return arrayLPlane;
}
//-------------------------------------------------------------------------------------
public ArrayList<Plane> getNamePlane(String rutaArchivo, String elementType) {
    ArrayList<Plane> aviones = new ArrayList<>();
    Plane p = new Plane();

    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parsear el archivo XML y obtener el objeto Document
        File archivoXML = new File(rutaArchivo);
        Document documento = builder.parse(archivoXML);

        // Obtener la lista de elementos de avión en el documento
        NodeList nodeList = documento.getElementsByTagName(elementType);

        // Recorrer los elementos de avión y obtener las placas
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element elementoAvion = (Element) nodeList.item(i);
            String placa = elementoAvion.getAttribute("plate");
            p=new Plane(placa);
            aviones.add(p);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return aviones;
}
@SuppressWarnings("unlikely-arg-type")
public ArrayList<Plane> getNamePlaneAirline(String rutaArchivo, String elementType,ArrayList<Flight>avion) {
    ArrayList<Plane> aviones = new ArrayList<>();
    Plane p = new Plane();

    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parsear el archivo XML y obtener el objeto Document
        File archivoXML = new File(rutaArchivo);
        Document documento = builder.parse(archivoXML);

        // Obtener la lista de elementos de avión en el documento
        NodeList nodeList = documento.getElementsByTagName(elementType);

        // Recorrer los elementos de avión y obtener las placas
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element elementoAvion = (Element) nodeList.item(i);
            String name = elementoAvion.getAttribute("plate");
            if(name.equals(avion)) {
            String a = elementoAvion.getElementsByTagName("airline").item(0).getTextContent();
            p=new Plane(a);
            aviones.add(p);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return aviones;
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
public ArrayList<Ticket> searchXMLTicket(String fileName,String elementType, String data,String word) {
    arrayLTicket = new ArrayList<>();
    Ticket t = new Ticket();
    
    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Parsear el archivo XML y obtener el documento
        Document documento = builder.parse(new File(fileName));
        // Obtener la lista de nodos con etiqueta "usuario"
        NodeList listaUser = documento.getElementsByTagName(elementType);
        // Recorrer la lista de usuarios
        for (int i = 0; i < listaUser.getLength(); i++) {
            Node nodoUser = listaUser.item(i);
            if (nodoUser.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nodoUser;
                // Obtener el numero tiquete del elemento "numTicket"
                String numTicket = eElement.getAttribute(data);

                if (numTicket.equals(word)) {
                	
                	t = new Ticket(eElement.getAttribute("numTicket"),
    						eElement.getElementsByTagName("passport").item(0).getTextContent(),
    						eElement.getElementsByTagName("numFlight").item(0).getTextContent());
    				arrayLTicket.add(t);
    				
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return arrayLTicket;
}
}

package data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import domain.Airline;

import org.w3c.dom.*;


import javax.xml.parsers.*;
import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesXML {

public void createXML(String objectName,String fileName) {

		File file = new File(fileName);

		if(!file.exists()) {
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

				Document doc = dBuilder.newDocument();

				Element rootElement = doc.createElement(objectName);
				doc.appendChild(rootElement);

				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();

				DOMSource source = new DOMSource(doc);

				StreamResult result = new StreamResult(file);
				transformer.transform(source, result);

				System.out.println("Archivo Creado");

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

public void writeXML(String FileName, String elementType, String[] dataName, String[] data) {

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.parse(new File(FileName));
			doc.getDocumentElement().normalize();

			Element rootElement  =  doc.getDocumentElement();

			Element ele = doc.createElement(elementType);
			rootElement.appendChild(ele);
//la informacion dentro del XML
			Attr attr = doc.createAttribute(dataName[0]);//pestalla para ver datos 
			attr.setValue(data[0]);
			ele.setAttributeNode(attr);

			for(int i = 1; i < data.length; i++){//cuenta desde el atributo siguiente 

				Element dato = doc.createElement(dataName[i]);

				dato.appendChild(doc.createTextNode(data[i]));//saca los datos

				ele.appendChild(dato);//agrega
			}

			//escribirmos el contenido en un archivo xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(new File(FileName));
			transformer.transform(source, result);

			System.out.println("Registro Guardado");

		}catch(ParserConfigurationException pce) {

			pce.printStackTrace();

		}catch (SAXException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (TransformerConfigurationException e) {

			e.printStackTrace();
		} catch (TransformerException e) {

			e.printStackTrace();
		}
}
	
public void deleteXML(String archive, String wordDelete) {//3parametros
	    try {
	        // Leer el archivo XML y cargarlo en un objeto Document
	        File xmlFile = new File(archive);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        org.w3c.dom.Document doc = dBuilder.parse(xmlFile);

	        // Buscar la línea que contenga la palabra a eliminar
	        NodeList nodeList = doc.getElementsByTagName("*");
	        for (int i = 0; i < nodeList.getLength(); i++) {
	            Node node = nodeList.item(i);
	            String lineaActual = node.getTextContent().trim();
	            if (lineaActual.contains(wordDelete)) {
	                // Si la línea contiene la palabra a eliminar, removerla del Document
	                node.getParentNode().removeChild(node);
	            }
	        }

	        // Escribir el nuevo contenido del Document en el archivo original
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File(archive));
	        transformer.transform(source, result);
	        
	        System.out.println("La línea que contiene la palabra \"" + wordDelete + "\" ha sido eliminada del archivo.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


public String validateUser(String fileName, String elementType, String userName, String password) throws Exception {
   try {
	File inputFile = new File(fileName);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(inputFile);
    doc.getDocumentElement().normalize();
//verificar si el usuario esta repetido
    NodeList userList = doc.getElementsByTagName(elementType);
    Set<String> encounteredUserNames = new HashSet<>();
    Set<String> encounteredPasswords = new HashSet<>();

    for (int i = 0; i < userList.getLength(); i++) {
        Node userNode = userList.item(i);
        if (userNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eUser = (Element) userNode;

            String name = eUser.getAttribute("userName");
            String pass = eUser.getElementsByTagName("password").item(0).getTextContent();
            String sta = eUser.getElementsByTagName("state").item(0).getTextContent();
            String userType = eUser.getElementsByTagName("typeUser").item(0).getTextContent();

            if (encounteredUserNames.contains(name) || encounteredPasswords.contains(pass)) {
                throw new Exception("Duplicate user or password found");
            }

            encounteredUserNames.add(name);
            encounteredPasswords.add(pass);

            if (userName.equals(name) && password.equals(pass)) {
                if (sta.equals("Activo")) {
                	//System.out.print(userType);
                    return userType;
                } else {
                    throw new Exception("User is not active");
                }
            }
        }
    }
    
   throw new Exception("User not found");
}catch(Exception e) {
    e.printStackTrace();
    return "Error: "+e.getMessage();
    }
   	  
}

public ArrayList<Airline> readXMLToArrayList(String FileName, String elementType) {
	String dato = " ";
	ArrayList<Airline> arrayLAirline= new ArrayList<>();
	Airline a = new Airline();
	try {
		File inputFile = new File(FileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();

		System.out.println("Raíz de los Elementos:" + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName(elementType);
		System.out.println("----------------------------");

		for (int indice = 0; indice < nList.getLength(); indice++) {
			Node nNode = nList.item(indice);
			System.out.println("\nDatos de las Aerolineas: " + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				a.setName(eElement.getAttribute("name"));
				a.setContry(eElement.getElementsByTagName("contry").item(0).getTextContent());
				arrayLAirline.add(a);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return arrayLAirline;
}
//------------------------------------------------------------
public static String readXML(String archivo) {
    StringBuilder result = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line.trim());
        }

        String xmlContent = sb.toString();
        Pattern pattern = Pattern.compile("<(.*?)>(.*?)</\\1>");
        Matcher matcher = pattern.matcher(xmlContent);
        while (matcher.find()) {
            String value = matcher.group(2);
            result.append(value).append("\n");
        }
    } catch (IOException e) {
        System.out.println("Error en la lectura del archivo XML!");
    }

    return result.toString();
}
public static String[] extraerDatos(String etiqueta) {
    List<String> datos = new ArrayList<>();

    int inicio = 0;
    int fin = 0;

    while (inicio != -1 && fin != -1) {
        inicio = etiqueta.indexOf(">");
        fin = etiqueta.indexOf("<", inicio + 1);

        if (inicio != -1 && fin != -1) {
            datos.add(etiqueta.substring(inicio + 1, fin));
        }

        etiqueta = etiqueta.substring(fin + 1);
    }

    String[] vectorDatos = new String[datos.size()];
    vectorDatos = datos.toArray(vectorDatos);

    return vectorDatos;
}
//----------------------------------------------------------------------------

public  String searchXML(String archive, String searchWord)throws Exception {

	    // Crear un objeto DocumentBuilderFactory y un objeto DocumentBuilder para obtener el archivo XML
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();

	    // Crear un objeto Document a partir del archivo XML
	    File archivo = new File(archive);
	    Document doc = builder.parse(archivo);

	    // Obtener una lista de todos los elementos del documento XML
	    NodeList nodos = doc.getElementsByTagName("*");

	    // Iterar a través de los nodos y buscar la línea que contiene la palabra buscada
	    for (int i = 0; i < nodos.getLength(); i++) {
	        Node nodo = nodos.item(i);
	        if (nodo.getNodeType() == Node.TEXT_NODE) {
	            String texto = nodo.getNodeValue().trim();
	            if (texto.equals(searchWord)) {
	                // Obtener el nodo padre que contiene la línea
	                Node padre = nodo.getParentNode();
	                // Obtener el contenido del nodo padre
	                String linea = padre.getNodeValue().trim();
	                return linea;
	            }
	        }
	    }
	    return null; // Si no se encontró la línea, retorna null
	}
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
public Vector<Airline> readXML(String address,String elementType,String[]dataName) {

    Vector<Airline> vect = new Vector<>();
    String info="";
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
                info+=(dataName[0] +":"+eElement.getAttribute(dataName[0])+"\n");
                ar = new Airline(eElement.getAttribute("name"), 
                		eElement.getElementsByTagName("contry").item(0).getTextContent());
                vect.add(ar);
                
                for(int in=1;in<dataName.length;in++) {
					info+=dataName[in] +":"+eElement.getElementsByTagName(dataName[in]).item(0).getTextContent();
				}
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return vect;
}
public void updateXML(String archive, String word, String update) throws Exception {
    // Cargar el documento XML desde el archivo
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(archive);

    // Buscar el primer elemento "nombre"
    NodeList lista = doc.getElementsByTagName(word);
    if (lista.getLength() > 0) {
        Element elem = (Element) lista.item(0);
        // Modificar el valor de la etiqueta
        elem.setTextContent(update);
    }

    // Escribir el contenido del documento modificado en el archivo
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    StreamResult output = new StreamResult(new java.io.File(archive));
    Source input = new DOMSource(doc);
    transformer.transform(input, output);
}


}

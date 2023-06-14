package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
	
	public void deleteLine(String archive, String wordDelete) {//3parametros
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

public String getValidateUser(String fileName,String elementType,String userName, String password) throws Exception {
		String type=null;
	    File inputfile = new File(fileName);
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(inputfile);
	    doc.getDocumentElement().normalize();

	    // Get the list of user nodes
	    NodeList userList = doc.getElementsByTagName(elementType);
	    System.out.print("tamaño"+userList.getLength());
	    // Loop through each user
	    for (int i = 0; i < userList.getLength(); i++) {
	    	System.out.print(",VACA");
	        Node userNode = userList.item(i);
	        if (userNode.getNodeType() == Node.ELEMENT_NODE) {
	        	System.out.print(",SAPA");
	            Element eUser = (Element) userNode;

	            // Get the user's credentials and status
	            String name = eUser.getAttribute("userName");
	            String pass = eUser.getElementsByTagName("password").item(0).getTextContent();
	            String sta = eUser.getElementsByTagName("state").item(0).getTextContent();
	            		type = eUser.getElementsByTagName("typeUser").item(0).getTextContent();
	            // valida username and password 
	            		//System.out.print(name+pass);
	            if (userName.equals(name) && password.equals(pass)) {
	            	System.out.print(",YEGUA");
	            	//System.out.print(name+"\n");
	            	//System.out.print(pass+"\n");
	            	
	            	if(sta.equals("activo")) {//valida si esta activo
	            		// Return the user's type
	            		System.out.print(",PUTA");
	                    return type;
	                    
	            	}else {
	                    throw new Exception("User is not active");
	                    
	                }
	            	
	            }
	        }
	    }
	    //throw new Exception("User is not encontrado");
	    return type;
}

public String readXMLString(String FileName, String elementType) {
	String dato = " ";
	
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
			System.out.println("\nDatos de los usuarios: " + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				dato += ("\nUsuario: " + eElement.getAttribute("userName"));         
				dato += ("\nContraseña: " + eElement.getElementsByTagName("password").
						item(0).getTextContent());
				dato +=("\nTipo de Usuario: "  + eElement.getElementsByTagName("typeUser").
						item(0).getTextContent());
				dato+=("\nEstado: "  + eElement.getElementsByTagName("state").
						item(0).getTextContent())+"\n"; 
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return dato;
}
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

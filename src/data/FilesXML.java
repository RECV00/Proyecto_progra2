package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.xml.sax.InputSource;
import org.xml.sax.InputSource;

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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesXML {
//-----------------------------------------------------------------------------------------------------
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
//-----------------------------------------------------------------------------------------------------

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
//-----------------------------------------------------------------------------------------------------
	
public void deleteXML(String FileName, String elementType,String data, String wordDelete) {
	
    try {
        File inputFile = new File(FileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);

        NodeList nList = doc.getElementsByTagName(elementType);
        Element element;

        for (int i = 0; i < nList.getLength(); i++) {

            element = (Element) nList.item(i);

            if (element.getAttribute(data).equals(wordDelete)) {

                element.getParentNode().removeChild(element);

            }
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(doc);

        StreamResult result = new StreamResult(new File(FileName));
        transformer.transform(source, result);

        System.out.println("Registro Eliminado");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

//--------------------------------------------------------------------------------------------------
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



//-----------------------------------------------------------------------------------------------------

public void updateXML(String FileName, String elementType, String dataName[], String data[]) {

    try {
        File inputFile = new File(FileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName(elementType);
        Element eElement;

        for (int i = 0; i < nList.getLength(); i++) {

            eElement = (Element) nList.item(i);

            if (eElement.getAttribute(dataName[0]).equals(data[0])) {

                for (int j = 1; j < data.length; j++) {

                    eElement.getElementsByTagName(dataName[j]).item(0).setTextContent(data[j]);
                }
            }
        }
        //Actualizamos el contenido en un archivo xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(doc);

        StreamResult result = new StreamResult(new File(FileName));
        transformer.transform(source, result);

        System.out.println("Registro Actualizado");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//-----------------------------------------------------------------------------------------------------

public List<String> buscarAtributos(String rutaArchivo,String elementType) {
    List<String> atributos = new ArrayList<>();

    try {
        // Crear el objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Crear el objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parsear el archivo XML y obtener el objeto Document
        File archivoXML = new File(rutaArchivo);
        Document documento = builder.parse(archivoXML);

        // Obtener la lista de nodos del documento
        NodeList nodos = documento.getElementsByTagName(elementType);

        // Recorrer los nodos y obtener los atributos
        for (int i = 0; i < nodos.getLength(); i++) {
            Node nodo = nodos.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                NamedNodeMap atributosNodo = nodo.getAttributes();
                for (int j = 0; j < atributosNodo.getLength(); j++) {
                    Node atributo = atributosNodo.item(j);
                    atributos.add(atributo.getNodeName());
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return atributos;
}

}

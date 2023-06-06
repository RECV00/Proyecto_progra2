package data;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FilesXML {

	public static void deleteLine(String archive, String wordDelete) {
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

}

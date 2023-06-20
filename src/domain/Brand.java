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
	
	
}

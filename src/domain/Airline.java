package domain;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Airline {
	
	private String name;
	private String contry;
	private String[] words;

//contructores
public Airline() {}

public Airline(String[] words) {
    this.words = words;
}
	public Airline(String name, String contry) {
		super();
		this.name = name;
		this.contry = contry;
	}
//sets y gets
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"name","contry"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {name,contry};
		return data;
	}
//toString
	@Override
	public String toString() {
		return name +":"+ contry;
	}
	

}

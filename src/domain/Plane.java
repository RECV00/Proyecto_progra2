package domain;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Plane {
	private String plate;
	private String airline;
	private String model;
	private String year;
	
	public Plane() {
		// TODO Auto-generated constructor stub
	}

	public Plane(String plate, String airline, String model, String year) {
		super();
		this.plate = plate;
		this.airline = airline;
		this.model = model;
		this.year = year;
	}

	public Plane(String plate) {
		// TODO Auto-generated constructor stub
		this.plate=plate;
	}

	public String getPlate() {
		return plate;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}
	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"plate","airline","model","year"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {plate,airline,model,year};
		return data;
	}
@Override
	public String toString() {
		return plate +"-"+ airline +"-"+ model+"-"+ year;
	}
	

}

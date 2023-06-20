package domain;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Model {
	

	private String name;
	private String marca;
	private int cantSeatExecutive;
	private int cantSeatTourist;
	private int cantSeatEconomic;
	
	public Model() {
		// TODO Auto-generated constructor stub
	}

	public Model(String name, String marca, int cantSeatExecutive, int cantSeatTourist, int cantSeatEconomic) {
		super();
		this.name = name;
		this.marca = marca;
		this.cantSeatExecutive = cantSeatExecutive;
		this.cantSeatTourist = cantSeatTourist;
		this.cantSeatEconomic = cantSeatEconomic;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCantSeatExecutive() {
		return cantSeatExecutive;
	}

	public void setCantSeatExecutive(int cantSeatExecutive) {
		this.cantSeatExecutive = cantSeatExecutive;
	}

	public int getCantSeatTourist() {
		return cantSeatTourist;
	}

	public void setCantSeatTourist(int cantSeatTourist) {
		this.cantSeatTourist = cantSeatTourist;
	}

	public int getCantSeatEconomic() {
		return cantSeatEconomic;
	}

	public void setCantSeatEconomic(int cantSeatEconomic) {
		this.cantSeatEconomic = cantSeatEconomic;
	}
	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"name","marca","cantSeatExecutive","cantSeatTourist","cantSeatEconomic"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {name,marca,String.valueOf(cantSeatExecutive),String.valueOf(cantSeatTourist),String.valueOf(cantSeatEconomic)};
		return data;
	}

	@Override
	public String toString() {
		return  name + "-" + marca + "-" + cantSeatExecutive
				+ "-" + cantSeatTourist + "-" + cantSeatEconomic;
	}
	

}

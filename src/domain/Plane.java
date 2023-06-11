package domain;


public class Plane {
	String plate;
	String airline;
	String model;
	String year;
	
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

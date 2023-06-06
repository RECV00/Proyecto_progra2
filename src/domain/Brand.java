package domain;

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

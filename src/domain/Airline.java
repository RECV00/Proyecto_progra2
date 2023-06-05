package domain;

public class Airline {
	
	private String name;
	private String contry;
	

	public Airline(String name, String contry) {
		super();
		this.name = name;
		this.contry = contry;
	}
	
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
	
	@Override
	public String toString() {
		return name +"-"+ contry;
	}
	
	
}

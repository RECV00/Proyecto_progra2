package domain;

public class Model {
	
	String name;
	String marca;
	int cantSeatExecutive;
	int cantSeatTourist;
	int cantSeatEconomic;
	
	public Model() {
		// TODO Auto-generated constructor stub
	}

	public Model(String name, String marca, int cantSeatExecutive, int cantSeatTourist, int cantSeatEconomic,
			int cant) {
		super();
		this.name = name;
		this.marca = marca;
		this.cantSeatExecutive = cantSeatExecutive;
		this.cantSeatTourist = cantSeatTourist;
		this.cantSeatEconomic = cantSeatEconomic;
		this.cant = cant;
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

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	@Override
	public String toString() {
		return  name + "-" + marca + "-" + cantSeatExecutive
				+ "-" + cantSeatTourist + "-" + cantSeatEconomic + "-" + cant;
	}

	

}

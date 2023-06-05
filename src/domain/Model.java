package domain;

public class Model {
	
	String name;
	String marca;
	int cantAsientosEjecutivo;
	int cantAsientosTurista;
	int cantAsientosEconomico;
	int cant;
	public Model() {
		// TODO Auto-generated constructor stub
	}

	public Model(String name, String marca, int cantAsientosEjecutivo, int cantAsientosTurista,
			int cantAsientosEconomico) {
		super();
		this.name = name;
		this.marca = marca;
		this.cantAsientosEjecutivo = cantAsientosEjecutivo;
		this.cantAsientosTurista = cantAsientosTurista;
		this.cantAsientosEconomico = cantAsientosEconomico;
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

	public int getCantAsientosEjecutivo() {
		return cantAsientosEjecutivo;
	}

	public void setCantAsientosEjecutivo(int cantAsientosEjecutivo) {
		this.cantAsientosEjecutivo = cantAsientosEjecutivo;
	}

	public int getCantAsientosTurista() {
		return cantAsientosTurista;
	}

	public void setCantAsientosTurista(int cantAsientosTurista) {
		this.cantAsientosTurista = cantAsientosTurista;
	}

	public int getCantAsientosEconomico() {
		return cantAsientosEconomico;
	}

	public void setCantAsientosEconomico(int cantAsientosEconomico) {
		this.cantAsientosEconomico = cantAsientosEconomico;
	}

	@Override
	public String toString() {
		return  name + "-" + marca + "-" + cantAsientosEjecutivo
				+ "-" + cantAsientosTurista + "-" + cantAsientosEconomico;
	}

}

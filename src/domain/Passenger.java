package domain;

public class Passenger {
	
	String passport;
	String nombre;
	String apellidos;
	String birthdate;
	String gmail;
	int phone;
	int hola;
	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public Passenger(String passport, String nombre, String apellidos, String birthdate, String gmail, int phone) {
		super();
		this.passport = passport;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.birthdate = birthdate;
		this.gmail = gmail;
		this.phone = phone;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return  passport + "-" + nombre + "-" + apellidos + "-"
				+ birthdate + "-" + gmail + "-" + phone;
	}

}

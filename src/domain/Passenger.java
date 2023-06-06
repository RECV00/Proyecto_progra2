package domain;

public class Passenger {
	
	String passport;
	String name;
	String lastName;
	String birthdate;
	String gmail;
	int phone;
	
	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public Passenger(String passport, String name, String lastName, String birthdate, String gmail, int phone) {
		super();
		this.passport = passport;
		this.name = name;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.gmail = gmail;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
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
	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"passport","name","lastName","birthdate","gmail","phone"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {passport,name,lastName,birthdate,gmail,String.valueOf(phone)};
		return data;
	}
	@Override
	public String toString() {
		return  passport + "-" + name + "-" + lastName + "-"+ birthdate + "-" + 
				gmail + "-" + phone;
	}

}

package domain;

public class User {
	
	String name;
	String password;
	String typeUser;
	String state;
	public User() {	
		
	}
	
	public User(String name, String password, String typeUser, String state) {
		super();
		this.name = name;
		this.password = password;
		this.typeUser = typeUser;
		this.state = state;
	}
	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return name+"-"+password+"-"+typeUser+"-"+state;
	}
	

}

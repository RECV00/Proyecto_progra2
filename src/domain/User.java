package domain;

public class User {
	
	String name;
	String password;
	String typeUser;
	String state;
//contructores
	public User() {	
		
	}
	
	public User(String name, String password, String typeUser, String state) {
		super();
		this.name = name;
		this.password = password;
		this.typeUser = typeUser;
		this.state = state;
	}
//sets y gets
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
	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"name","password","typeUser","state"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {name,password,typeUser,state};
		return data;
	}
//toString
	@Override
	public String toString() {
		return name+"\n"+password+"\n"+typeUser+"\n"+state;
	}
	

}

package domain;

import java.util.ArrayList;

public class User {
	//ArrayList<User> listaUser;
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
	
	/*public void imprimirListaUser() {
		for(User user : listaUser) {
			System.out.println(user);
		}
	}
	public ArrayList<User> getLista(){
		return listaUser;
	}
	
	public User obtUser(String data) {
		User u=null;
		for(User user : listaUser) {
			if(user.getDocumento().equals(data)) {
				u=user;
			}
			//system.out.println(persona);
			}
		return u;
	}*/
}

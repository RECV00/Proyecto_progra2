package domain;

import java.util.ArrayList;

public class User {
	//ArrayList<User> listaUser;
	String userName;
	String password;
	String typeUser;
	String state;
//contructores
	public User() {	
		
	}
	
	public User(String userName, String password, String typeUser, String state) {
		super();
		this.userName = userName;
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
	
	public String getUserName() {
		return userName;
	}

	public void setName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"userName","password","typeUser","state"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {userName,password,typeUser,state};
		return data;
	}
//toString
	@Override
	public String toString() {
		return userName+"\n"+password+"\n"+typeUser+"\n"+state;
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
			//system.out.println(user);
			}
		return u;
	}*/
}

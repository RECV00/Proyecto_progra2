package domain;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class User {
	private String userName;
	private String password;
	private String typeUser;
	private String state;
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
	

}

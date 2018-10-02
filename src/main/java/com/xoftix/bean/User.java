package com.xoftix.bean;
/*
 * Clase User: Representa al usuario en inicio de sesi�n
 * 
 * */

public class User {
	private int IDUser;
	public int getIDUser() {
		return IDUser;
	}

	public void setIDUser(int iDUser) {
		IDUser = iDUser;
	}

	private String userName;
	private String pass;
	private String login;
	private int tipoUsuario;
	
	public User() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
}

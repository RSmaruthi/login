package com.bridgelabz.webapp.model;

public class Login {
	private String userName;
	private String Password;

	public Login() {

	}

	public Login(String userName, String password) {
		super();
		this.userName = userName;
		Password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", Password=" + Password + "]";
	}

}

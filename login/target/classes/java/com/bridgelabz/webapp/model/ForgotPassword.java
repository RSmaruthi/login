package com.bridgelabz.webapp.model;

/******************************************************************************
 * Purpose:ForgotPassword Pojo Class
 * 
 * @author BridgeLabz/punithhr
 * @version 1.0
 * @since 28-02-2019
 * 
 ******************************************************************************/
public class ForgotPassword {
	private String userName;
	private String email;
	private String password;

	public ForgotPassword() {
		super();

	}

	public ForgotPassword(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ForgotPassword [userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}

}

package com.bridgelab.autowire;

import org.springframework.stereotype.Component;

@Component("lap1")
public class laptop {
	private int id;
	private String Lname;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	
		@Override
	public String toString() {
		return "laptop [id=" + id + ", Lname=" + Lname + "]";
	}
public void compiler()
{
	System.out.println("compling");
	
}
}

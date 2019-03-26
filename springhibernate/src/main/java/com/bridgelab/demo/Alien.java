package com.bridgelab.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Alien {
	
	private int gid;
	private String name;
	
	
	public Alien() {
		super();
		System.out.println("object created");
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	void show()
	{
		System.out.println("haii i am maruthi");
	}

}

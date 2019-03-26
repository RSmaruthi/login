package com.bridgelab.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Alien {
	
	private int gid;
	private String name;
	@Autowired
	@Qualifier("lap1")
	private laptop laptop;
	
	
	public laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(laptop laptop) {
		this.laptop = laptop;
	}
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
		laptop.compiler();
	}

}

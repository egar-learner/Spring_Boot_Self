package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//This says that the Spring Container has to create a Spring Bean for this class whenever asked
//By default uses "SINGLETON DESIGN PATTERN" and all the component Spring Beans are created once in the
//Spring Container
@Component
//TO CHANGE THE DEFAULT SCOPE WHICH WAS SINGLETON
@Scope(value = "prototype")
public class Alien {
	
	private int aid;

	private String aname;
	
	private String tech;
	
	//If we don't specify the @autowired here, then there will be a laptop object or Spring Bean
	//already created in the Spring Container but the Alien Class doesn't know that it has to go there
	//and search for it.
	//That's Why @autowired
	@Autowired
	@Qualifier("hplaptop")
	//@Qualifier("name_of_object_that_we_want_to_search_for")
	private Laptop laptop;
	
	public Alien() {
		System.out.println("Object created");
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	public void show() {
		System.out.println("Show content of alien");
		this.laptop.compile();
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

}

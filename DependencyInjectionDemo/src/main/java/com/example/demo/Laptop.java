package com.example.demo;

import org.springframework.stereotype.Component;

//@Component("name_of_Object_we_want_to_have_inside_spring_container")
@Component("hplaptop")
public class Laptop {
	
	private int lid;
	private String brand;
	
	
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", brand=" + brand + "]";
	}
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	

	public void compile() {
		System.out.println("Compiling.....");
	}
}

package com.hw4.model.dto;

import java.util.ArrayList;
import java.util.List;

public class Toy {
	

	private String name; 
	private int age; 
	private int price; 
	private String color; 
	private int date; 
	private String material;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	
	public Toy(String name, int price, String color, int age, int date, String material) {
		super();
		this.name = name;
		this.age = age;
		this.price = price;
		this.color = color;
		this.date = date;
		this.material = material;
	} 	
	
	
	@Override
	public String toString() {

		return String.format("이름 : %s / 가격 : %d / 색상 : %s / 사용가능연령 : %d / 제조년월일 : %d / 재료 : %s",
				name, price, color, age, date, material); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

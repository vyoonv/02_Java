package com.hw4.model.dto;

import java.util.Objects;
import java.util.Set;

public class ToyA {
	
	private String name; 
	private int age; 
	private int price; 
	private String manufactureDate; 
	private String color; 
	private Set<String> materials; //중복되지 않는 값으로 저장 -> set 사용 
	
	public ToyA() {}

	public ToyA(String name, int age, int price, String manufactureDate, String color, Set<String> materials) {
		super();
		this.name = name;
		this.age = age;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.color = color;
		this.materials = materials;
	}

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

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Set<String> getMaterials() {
		return materials;
	}

	public void setMaterials(Set<String> materials) {
		this.materials = materials;
	}
	
	
	
	
	//materials 안에 있는 모든 재료 문자열 형태로 만들어 반환하는 메서드 
	public String getMaterialsAsString() {
		
		StringBuilder sb = new StringBuilder(); 
		for( String material : materials ) {
			sb.append(material).append(", "); 
			
		}
		
		//마지막 쉼표와 공백 제거하기 
		if(sb.length()>0) {
			sb.setLength(sb.length() -2); //마지막 쉼표 공백 2개제거  
		}
		return sb.toString(); 
	}
	

	@Override
	public String toString() {
		return String.format("이름 : %s / 가격 : %d / 색상 : %s / 사용가능연령 : %d / 제조년월일 : %s / 재료 : %s", 
				name, price, color, age, manufactureDate, getMaterialsAsString() ); 
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, color, manufactureDate, materials, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToyA other = (ToyA) obj;
		return age == other.age && Objects.equals(color, other.color)
				&& Objects.equals(manufactureDate, other.manufactureDate) && Objects.equals(materials, other.materials)
				&& Objects.equals(name, other.name) && price == other.price;
	}
	


	

}

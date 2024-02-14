package com.hw3.model.vo;

import com.hw3.controller.ProductController;

public class Product {
	
	private int pId; //제품번호 
	private String pName; //제품명
	private int price; //제품가격
	private double tax; //제품세금 
	
	

	

	
	
	//Product의 기본 생성자 및
//	매개변수 생성자로 Product 객체
//	생성시 마다 ProductController의
//	객체 수 카운트를 1 증가
	
	
	

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	
	
	
	

	public Product() {
		
		ProductController.count++; 
		
	}
	
	
	
	
	public Product(int pId, String pName, int price, double tax) {
		this.pId = pId; 
		this.pName = pName; 
		this.price = price; 
		this.tax = tax; 
		

		
	}
	
	public String information() {
	
		
		return  "제품번호 : " + pId + ", 제품명 : " + pName + ", 제품가격 : " + price + ", 제품 세금 : " + tax; 
	}
	

}

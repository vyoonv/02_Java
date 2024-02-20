package com.hw3.model.dto;

public class Book {
	
	private int bNum; 
	private String bTitle; 
	private String author; 
	private int price; 
	private String bCom;
	
	
	public int getbNum() {
		return bNum;
	}


	public void setbNum(int bNum) {
		this.bNum = bNum;
	}


	public String getbTitle() {
		return bTitle;
	}


	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getbCom() {
		return bCom;
	}


	public void setbCom(String bCom) {
		this.bCom = bCom;
	}


	public Book(int bNum, String bTitle, String author, int price, String bCom) {
		super();
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.author = author;
		this.price = price;
		this.bCom = bCom;
	} 
	
	@Override
	public String toString() {

		return String.format("%d번 도서 : [도서제목 : %s / 도서저자 : %s / 도서가격 : %d / 출판사 : %s ] ", 
				bNum, bTitle, author, price, bCom); 
	}

}

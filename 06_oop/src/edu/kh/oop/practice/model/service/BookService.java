package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Book;


public class BookService {
	
	public void practice() {
		
		Book bs = new Book (); 
		
		bs.setTitle("자바의정석");
		bs.setPrice(30000);
		bs.setDiscountRate(0.2);
		bs.setAuthor("남궁성");

		
	}
 
}

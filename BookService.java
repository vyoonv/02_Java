package edu.kh.oop.practice.model.service;

import java.util.Arrays;

import edu.kh.oop.practice.model.vo.Book;

public class BookService {
	
	public void practice() {
		
		Book book1 = new Book(); 
		System.out.println(book1.toString());
		Book book2 = new Book("자바의 정석", 30000, 0.2, "남궁성"); 		
		System.out.println(book2.toString());
		System.out.println("==================");
		
		
		book2.setTitle("자바의 정석"); 
		book2.setPrice(30000);
		book2.setDiscountRate(0.2); 
		book2.setAuthor("남궁성");
		
		book1.setTitle("C언어");
		book1.setPrice(30000);
		book1.setDiscountRate(0.1);
		book1.setAuthor("홍길동");
		System.out.println("수정된 결과 확인");
		System.out.println(book1.toString());
		
		int result = book1.getPrice() - (int)(book1.getPrice()* book1.getDiscountRate()); 
		int result2 = book2.getPrice() - (int)(book2.getPrice()* book2.getDiscountRate()); 
		
		System.out.println("=====================");
		System.out.println("도서명 : " + book1.getTitle());
		System.out.printf("할인된 가격 : " + result + "원");
		System.out.println();
		System.out.println("도서명 : " + book2.getTitle());
		System.out.println("할인된 가격 : " + result2 + "원");
		
		
		
		
		
	}

}

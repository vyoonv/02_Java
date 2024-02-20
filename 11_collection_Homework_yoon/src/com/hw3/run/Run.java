package com.hw3.run;

import com.hw3.model.bookService.BookService;

public class Run {
	
	public static void main(String[] args) {
		
		BookService bs = new BookService(); 
		
		bs.displayMenu();
		
	}

}

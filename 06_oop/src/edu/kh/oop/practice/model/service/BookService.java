package edu.kh.oop.practice.model.service;


import edu.kh.oop.practice.model.vo.Book;

public class BookService {
	
	
	public void practice() {
		
		// 1) 기본 생성자를 이용하여 첫 번째 Book 객체 생성
		// 2) 매개변수 생성자를 이용하여 두 번째 Book 객체 생성 (사용 데이터 참고)
		// 3) 객체가 가진 필드 값을 toString()을 이용하여 출력

		// 4) 첫 번째 객체가 가진 값을 setter를 이용하여 수정
		// 5) 수정된 객체의 필드 값을 toString() 메소드를 이용하여 출력

		// 6) 각 객체의 할인율을 적용한 책 가격을 계산해서 출력
		// 7) 할인된 가격 = 가격 - (가격 * 할인율)
		

		Book book1 = new Book(); 
		Book book2 = new Book(null, 0, 0, null);  

		
		
		
		book1.setTitle("자바의 정석"); 
		book1.setPrice(30000);
		book1.setDiscountRate(0.2);
		book1.setAuthor("남궁성");
		
		System.out.printf("%s / %d / %d / %s" , 
				book1.getTitle(), book1.getPrice(), book1.getDiscountRate(), 
				book1.getDiscountRate(), book1.getAuthor() );
		
		book2.setTitle("C언어");
		book2.setPrice(30000);
		book2.setDiscountRate(0.1);
		book2.setAuthor("홍길동");
		
		System.out.printf("%s / %d / %d / %s" , 
				book1.getTitle(), book1.getPrice(), book1.getDiscountRate(), 
				book1.getDiscountRate(), book1.getAuthor() );
		
		
	}

}

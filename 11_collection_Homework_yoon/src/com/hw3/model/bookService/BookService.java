package com.hw3.model.bookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hw3.model.dto.Book;

public class BookService {
	
	Scanner sc = new Scanner(System.in); 
	
	private List<Book> bookList = new ArrayList<Book>();  
	
	public void displayMenu() {
		
		
		
		System.out.println("===도서 목록 프로그램===");
		int menuNum = 0;
		
		do {
		
			System.out.println("1. 도서등록");
			System.out.println("2. 도서조회");
			System.out.println("3. 도서수정");
			System.out.println("4. 도서삭제");
			System.out.println("5. 즐겨찾기 추가");
			System.out.println("6. 즐겨찾기 삭제");
			System.out.println("7. 즐겨찾기 조회");
			System.out.println("8. 추천도서 뽑기");
			System.out.println("0. 프로그램 종료");
			
			System.out.println("메뉴를 입력하세요 : ");
			menuNum = sc.nextInt(); 
			
			switch (menuNum) {
			
			case 1 : System.out.println(addBook()); break; 
			case 2 : viewBook(); break; 
			case 3 : System.out.println(updateBook()); break; 
			case 4 : deleteBook(); break; 
			case 5 : addBookMark(); break; 
			case 6 : deleteBookMark(); break; 
			case 7 : viewBookMark(); break; 
			case 8 : pickRecBook(); break; 
			case 0 : System.out.println("프로그램 종료");
			default : System.out.println("메뉴 번호 확인 후 입력");
			
		
			}
		
		
		} while(menuNum != 0); 
		
	}
	
	
	public String addBook() {
		
		System.out.println("=====도서 등록=====");
		
		System.out.print("도서 번호 : ");
		int bNum = sc.nextInt(); 
		sc.nextLine(); 
		System.out.print("도서 제목 : ");
		String bTitle = sc.nextLine(); 
		System.out.print("도서 저자 : ");
		String author = sc.nextLine(); 
		System.out.print("도서 가격 : ");
		int price = sc.nextInt(); 
		sc.nextLine(); 
		System.out.print("도서 출판사 : ");
		String bCom = sc.nextLine(); 
		
		if(bookList.add(new Book (bNum, bTitle, author, price, bCom))) {
			return "성공"; 
		} else {
			return "실패"; 
		}
		
	}
	
	public void viewBook() {
		
		System.out.println("===== 도서 조회 =====");
		
		//북리스트가 저장된게 없으면 정보가 없다는 문구 출력
		//아니라면 북 리스트 출력 
		if (bookList.isEmpty()) {
			System.out.println("도서 정보가 없습니다.");
			return; 
		}

		for(Book book : bookList) {
			System.out.println(book);
		}
		
		
		
		
	}
	
	public String updateBook() {
		
		int editMenu = 0; 
		

		System.out.println("===== 도서 정보 수정 =====");
		
		System.out.println("도서 번호 입력 : ");
		int num = sc.nextInt(); 
		
		//도서 번호랑 받은 번호랑 일치하는지 확인 
		//일치하면 출력 아니면 다시 입력 
		
		boolean flag = true; 
		
		for(Book book : bookList) {
			
			if(num == book.getbNum()) {
				flag =false; 
				
				System.out.println("1. 도서명");
				System.out.println("2. 도서 저자");
				System.out.println("3. 도서 가격");
				System.out.println("4. 도서 출판사");
				System.out.println("0. 수정 종료");
				
				System.out.print("어떤 정보를 수정하시겠습니까?");
				editMenu = sc.nextInt(); 
				sc.nextLine(); 
				
				switch(editMenu) {
				case 1 : 
					System.out.print("도서명 입력 : ");
					String bTitle = sc.nextLine(); 
					book.setbTitle(bTitle);
					break; 
				case 2 :
					System.out.print("저자명 입력 : ");
					String author = sc.nextLine(); 
					book.setAuthor(author); 
					break;
				case 3 : 
					System.out.print("가격 입력 : ");
					int price = sc.nextInt(); 
					book.setPrice(price);
					break; 
				case 4 : 
					System.out.print("출판사 입력 : ");
					String bCom = sc.nextLine(); 
					book.setbCom(bCom);
					break; 
				case 0 : System.out.println("수정을 종료합니다."); break; 
				default : System.out.println("번호 확인 후 다시 입력해주세요");
				} 
				
			}
			
		}
				
				if(flag) {
					return "일치하는 도서가 없습니다"; 
				}
				
				
				
		 return "수정완료"; 
			
		}
		

	
	public void deleteBook() {
		
	}
	
	public void addBookMark() {
		
	}
	
	public void deleteBookMark() {
		
	}
	
	public void viewBookMark() {
		
	}
	
	public void pickRecBook() {
		
	}
	
	
	

}

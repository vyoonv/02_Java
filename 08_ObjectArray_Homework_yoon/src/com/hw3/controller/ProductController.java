package com.hw3.controller;

import java.util.Scanner;

import com.hw3.model.vo.Product;

public class ProductController {
	
	
	private Product[] pro = null; 	
	public static int count = 0 ;   //클래스명.변수명으로 호출 
	
	Scanner sc = new Scanner(System.in); 
		

	
	//초기화 블럭 이용하여 10개의 product 배열 크기 할당 
	
	{ //초기화 블럭 { }
		
		pro = new Product[10]; 
		
	}
	
//	Product[] proArr = new Product[10]; 


	
	public void mainMenu() {
		
		//do while문 이용하여 반복적으로 메뉴화면 출력 각 버튼 선택 시 각각의 메소드 호출
		int menuNum = 0; //메뉴 선택용 변수 
		
		
		do {
			
			System.out.println("===== 제품 관리 메뉴 =====");			
			System.out.println("1. 제품 정보 추가");
			System.out.println("2. 제품 전체 조회");
			System.out.println("0. 프로그램 종료");
			
			System.out.println("메뉴 선택 : ");
			menuNum = sc.nextInt(); 
			
			switch (menuNum) {
			
			case 1 : productInput(); break;
			case 2 : productPrint(); break; 
			case 0 : System.out.println("프로그램 종료"); break; 
			default : System.out.println("다시 입력해주세요"); 
						
			}
		
			
		}
		while(menuNum != 0); 

		
	}
	

	
	public void productInput() {
		
		System.out.println("=======제품 정보 추가=======");
		
		System.out.println("제품 번호 : ");
		int pId = sc.nextInt(); 
		
		sc.nextLine(); //int형다음에 문자형 올 때 입력버퍼에 남은 개행문자 제거 
		
		System.out.println("제품명 : ");
		String pName = sc.nextLine(); 
		
		System.out.println("제품가격 : ");
		int price = sc.nextInt();
		
		System.out.println("제품세금 : ");
		double tax = sc.nextDouble();
		
		pro[count] = new Product(pId, pName, price, tax); 

	
	}	
		
		//새로운 제품 정보 기록을 위해 키보드로 정보들을 입력 받아 객체를 생성하고 
		//현재 카운트 인덱스에 주소 저장
		

	
	public void productPrint() {
		
		
		//현재까지 기록된 도서 정보 모두 출력
		System.out.println("=========제품 전체 조회=========");
		
		for(int i = 0; i < count; i++ ) {
							//현재 있는 객체까지만 
			
			System.out.println(pro[i].information());
			
		
		
	
		}
		
		
		
		
		
		
	}
	
	
	

}

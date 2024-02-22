package com.hw4.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.hw4.model.dto.Toy;
import com.hw4.model.dto.ToyMaterial;


public class ToyFactory {
	
	Scanner sc = new Scanner(System.in); 
	
	
//	중복 제거 set
//
//	재료는 재료번호:재료명 -> map

	
	
	
	
	/* 
	 *  1. 장난감의 정보를 효과적으로 관리하고 출력할 수 있는 클래스를 구현.
		2. 사용자로부터 입력을 받고, 입력에 따라 적절한 동작을 수행하는 메서드를 작성
		3. 컬렉션을 활용하여 장난감 정보를 저장하고 관리
		4. 장난감의 제조일에 따라 정렬하고, 연령별로 사용 가능한 장난감을 출력하는 기능을 구현
		
		
		
		

	    1. 전체 장난감 조회하기: 공장에 있는 모든 장난감의 정보를 출력
		2. 새로운 장난감 만들기: 새로운 장난감을 추가하고, 사용자가 입력한 정보로 객체를 생성
		3. 장난감 삭제하기: 공장에서 장난감을 삭제
		4. 장난감 제조일 순으로 조회하기: 장난감을 제조일에 따라 정렬하여 출력
		5. 연령별 사용 가능한 장난감 리스트 조회하기: 사용 가능한 연령을 입력받고, 해당하는 장난감을 출력
		6. 재료 추가: 새로운 재료를 등록하고, 장난감에 해당 재료를 추가
		7. 재료 제거: 등록된 재료를 삭제하고, 해당하는 재료를 사용하는 장난감에서 제거
		
		
		
		
		1. 장난감은 똑같은 재료를 중복으로 저장할 수 없다.
		2. 똑같은 장난감을 만들 수 없다.
		3. 장난감을 저장할 컬렉션에 중복된 장난감이 있어서는 안된다.
		4. 재료는 { 고유번호 : 재료명 } 형식으로 작성되어 있어야 한다.
		5. 재료의 고유번호는 중복될 수 없다.
		6. 재료 등록 시 이미 등록된 고유번호의 재료가 있으면, 덮어쓰겠냐는 질문을 하고 y/n
		으로 답변을 입력받아 처리해야 한다.
		7. 재료 삭제 시 고유번호가 아닌, 재료명을 입력받아 같은 재료명이 있으면 삭제한다.
		
		*/
	
	//재료 리스트?
	
	   	private List<ToyMaterial> mtrList = new ArrayList <ToyMaterial>(); 	//재료 리스트 
		private List<Toy> toyList = new ArrayList <Toy>();  //제작된 리스트 
	   	

		public ToyFactory() {
			
			toyList.add(new Toy ("키시미시", 15000, "분홍색", 5, 19940505,"면직물") ); 
			toyList.add(new Toy ("캣냅", 27000, "보라색", 8, 19960128,"면직물, 플라스틱") ); 
			toyList.add(new Toy ("파피", 57000, "빨간색", 12, 19931225,"고무, 면직물, 플라스틱") ); 
			toyList.add(new Toy ("허기워기", 12000, "파란색", 5, 19940312,"면직물, 플라스틱") ); 
			toyList.add(new Toy ("마미롱레그", 36000, "분홍색", 8, 19950805,"고무, 면직물") ); 
			
			mtrList.add(new ToyMaterial(1, "면직물"));   //cotton
			mtrList.add(new ToyMaterial(2, "플라스틱")); //plastic
			mtrList.add(new ToyMaterial(3, "유리")); //glass
			mtrList.add(new ToyMaterial(4, "고무")); //rubber
			
		}
	
	
		public void displayMenu() {
			
			
			int menuNum = 0; 
			
			do {
					System.out.println("<<플레이타임 공장>>");
					System.out.println("1. 전체 장난감 조회하기");
					System.out.println("2. 새로운 장난감 만들기");
					System.out.println("3. 장난감 삭제하기");
					System.out.println("4. 장난감 제조일 순으로 조회하기");
					System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
					System.out.println("6. 재료추가");
					System.out.println("7. 재료제거");
					System.out.println("0. 프로그램 종료");
					
					System.out.println("선택 : ");
					menuNum = sc.nextInt(); 
					System.out.println();

					switch(menuNum) {

					case 1 : viewToyList(toyList); break; 
					case 2 : System.out.println(createToy()); break; 
					case 3 : deleteToy(); break; 
					case 4 : viewAsDate(); break; 
					case 5 : viewAsAge(); break; 
					case 6 : addMaterial(); break; 
					case 7 : deleteMaterial(); break; 
					case 0 : System.out.println("프로그램을 종료합니다."); break; 
					default : System.out.println("메뉴 번호 확인 후 입력하세요"); break; 

		
					}

				
			} while(menuNum != 0); 
			
		
		}
	
		
		
		
		public void viewToyList(List<Toy> toyList) {
			
			System.out.println("<전체 장난감 목록>");
			
			if(toyList.isEmpty()) {
				System.out.println("조회할 수 있는 장난감이 없습니다."); 
				return; 
			} 
				
			for(Toy toylist : toyList) {
					System.out.println(toylist);
				}

			
		}
 		
		
		public String createToy() {			
//			2. 똑같은 장난감을 만들 수 없다.
//			3. 장난감을 저장할 컬렉션에 중복된 장난감이 있어서는 안된다.

			
			System.out.println("<새로운 장난감 추가>");
			System.out.print("장난감 이름 : ");
			String name = sc.next(); 
			System.out.print("사용 가능 연령 : ");
			int age = sc.nextInt(); 
			System.out.print("가격 : ");
			int price = sc.nextInt(); 
			sc.nextLine(); 
			System.out.print("색상 : ");
			String color = sc.next(); 
			System.out.print("제조일(YYYYMMDD 형식으로 입력): ");
			int date = sc.nextInt(); 
			sc.nextLine(); 			
			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요): ");
			String material = sc.nextLine(); 
			char ch = material.toString().toUpperCase().charAt(0);
			
			if(ch == 'Q') {
				Toy newToy = new Toy(name, price, color, age, date, material); 
				toyList.add(newToy); 

				return "새로운 장난감이 추가되었습니다.";
				
				
			} else {
				System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요): ");
				String material2 = sc.nextLine(); 
				char ch2 = material2.toString().toUpperCase().charAt(0);
				return null; 
			}
		
			

			
			
			
		}


		public void deleteToy() {
			
			viewToyList(toyList) ;
			System.out.println();
			
			System.out.print("삭제할 장난감의 이름을 입력하세요 : ");
			String delName = sc.next(); 

		for(Toy temp : toyList) {
			
			if(temp.getName().equals(delName)) {
				
				System.out.println("정말 삭제하시겠습니까? (y/n) : ");
				char answer = sc.next().toUpperCase().charAt(0); 
				
				if(answer == 'Y') {
					toyList.remove(temp);
					System.out.println("삭제되었습니다");
					break; 
				} else {
					System.out.println("삭제하지 않습니다");
				}
				
				
				
			}
		}  
		
			
		}
		
		
		public void viewAsDate() {
			
			Comparator<Toy> dateComparator = Comparator.comparing(Toy::getDate);
			

			Collections.sort(toyList, dateComparator);
		

			for(Toy toy : toyList) {
				System.out.println(toy);
			
		}
		
	}

		
		public void viewAsAge() {
			
			Comparator<Toy> ageComparator = Comparator.comparing(Toy::getAge);
			
			Collections.sort(toyList, ageComparator);
			

			for(Toy toy : toyList) {
				System.out.println(toy);
			
			
			
		}
		}
		
		
		public void addMaterial() {
		
//			1. 장난감은 똑같은 재료를 중복으로 저장할 수 없다.
//			2. 똑같은 장난감을 만들 수 없다.
//			3. 장난감을 저장할 컬렉션에 중복된 장난감이 있어서는 안된다.
//			4. 재료는 { 고유번호 : 재료명 } 형식으로 작성되어 있어야 한다.
//			5. 재료의 고유번호는 중복될 수 없다.
//			6. 재료 등록 시 이미 등록된 고유번호의 재료가 있으면, 덮어쓰겠냐는 질문을 하고 y/n
//			으로 답변을 입력받아 처리해야 한다.
//			7. 재료 삭제 시 고유번호가 아닌, 재료명을 입력받아 같은 재료명이 있으면 삭제한다.
				
			
			/*
			 * <재료추가>
			 * --현재 등록된 재료--
			 * 1: 면직물
			 * 2: 플라스틱
			 * 3: 유리
			 * 4: 고무 
			 * -------------
			 * 재료 고유번호(key)입력 
			 * 재료명 입력 
			 * 새로운 재료가 성공적으로 등록되었습니다
			 * */
			
	// private List<ToyMaterial> mtrList = new ArrayList <ToyMaterial>(); 	//재료 리스트
			 
			System.out.println("<재료추가>");
			System.out.println("=== 현재 등록된 재료 ===");
			for(ToyMaterial temp : mtrList) {
				System.out.println(temp);
			}
			System.out.println("------------------------");
			
			System.out.print("재료 고유번호(Key)입력 : ");
			int key = sc.nextInt();
			sc.nextLine(); 
			System.out.print("재료명 입력 : ");
			String name = sc.nextLine(); 
			
			boolean flag =true; 
			
			for(ToyMaterial temp : mtrList) {
				
			if(temp.getMtrNum()==key) {
				System.out.println("고유 번호로 입력해주세요");
				break; 
			} else if(temp.getMtrName().equals(name)) {
				System.out.println("같은 재료는 입력할 수 없습니다");
				break; 
			} else {
				mtrList.add(new ToyMaterial (key, name)); 
				flag = false;
				break; 	
			}
		}
			if(!flag) {
				System.out.println("새로운 재료가 성공적으로 등록되었습니다.");
			}
			
			
		}
		
		
		public void deleteMaterial() {
			
			System.out.println("<재료 삭제>");
			System.out.println("==== 현재 등록된 재료 ====");
			for(ToyMaterial temp : mtrList) {
				System.out.println(temp);
			}
			System.out.println("==========================");
			System.out.print("삭제할 재료명 입력 : ");
			String name = sc.next(); 
			
			boolean flag = true; 
			
			
			for(ToyMaterial temp : mtrList) {

				if(temp.getMtrName().contains(name)) {
					
					System.out.print("정말 삭제하시겠습니까?(y/n) : ");
					char answer = sc.next().toUpperCase().charAt(0); 
					
					if(answer == 'Y') {
						mtrList.remove(temp); 
						flag = false; 
						break; 
					} else {
						System.out.println("삭제를 진행하지 않습니다.");
					} 
				

				} else {
					System.out.println("해당 이름의 재료가 존재하지 않습니다");
					break; 
				}
			}
			if(!flag) {
				
				System.out.printf("재료 '%s'가 성공적으로 제거되었습니다\n", name);
			}
			
			
		}
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		

}

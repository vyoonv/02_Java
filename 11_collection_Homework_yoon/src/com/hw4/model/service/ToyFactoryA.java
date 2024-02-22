package com.hw4.model.service;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.hw4.model.dto.ToyA;

public class ToyFactoryA {

	private Scanner sc = new Scanner(System.in);
	private Set<ToyA> toySet = new HashSet<ToyA>(); // 중복된 Toy객체가 없도록 저장할 컬렉션 중 Set
	private Map<Integer, String> materialMap = new HashMap<Integer, String>();  //재료가 저장되어있는 map
	
	
	public ToyFactoryA() {
		
		//기본 등록된 재료 
		materialMap.put(1, "면직물"); 
		materialMap.put(2, "플라스틱"); 
		materialMap.put(3, "유리"); 
		materialMap.put(4, "고무"); 		
		
		//장난감 5개 생성 
		toySet.add(new ToyA("마미롱레그", 8, 36000, "분홍색", "19950805", addMaterials(1, 4)));		
		toySet.add(new ToyA("파피", 12, 57000, "빨간색", "19931225", addMaterials(1, 2, 4)));
		toySet.add(new ToyA("허기워기", 5, 12000, "파란색", "19940312", addMaterials(1, 2)));
		toySet.add(new ToyA("키시미시", 5, 15000, "분홍색", "19940505", addMaterials(1, 2)));
		toySet.add(new ToyA("캣냅", 7, 18000, "보라색", "19980808", addMaterials(1, 3, 4)));
		
		
	}
	
	
	//materials에 전달받은 값들을 추가하고 Set으로 반환하는 메서드 
	public Set<String> addMaterials(Integer...newMaterials) {
		
		Set<String> addedMaterials = new HashSet<String>();
		
		for( Integer materialKey : newMaterials) {
			
			//맵에서 해당 번호(key)에 대응하는 재료를 가져와 추가 
			String materialValue = materialMap.get(materialKey); 
			
			if(materialValue != null) {
				addedMaterials.add(materialValue); 
			}
			
			
		}
		
		return addedMaterials; 
		
		
		
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
			
			
			try {
				
				menuNum = sc.nextInt(); 
				
				switch(menuNum) {
				
				case 1 : displayAllToys(); break; 
				case 2 : createNewToy(); break; 
				case 3 : deleteToy(); break; 
				case 4 : displayByManufactureDate(); break; 
				case 5 : displayByAge(); break; 
				case 6 : addMaterial(); break; 
				case 7 : removeMaterialByName(); break; 
				case 0 : System.out.println("프로그램을 종료합니다."); break; 
				default : System.out.println("메뉴 번호 확인 후 입력하세요"); 
				
				}
				
			}   catch(Exception e) {
				System.out.println("확인 후 입력해주세요");
				
				sc.nextLine(); 
				
				menuNum = -1;  //첫반복에서 예외 발생시 종료되지 않도록 menuNum 값을 임의로 세팅
						
			}
	
		} while(menuNum != 0); 
	}
	
	
	//전체 장난감 조회하기
	public void displayAllToys() {
		
		System.out.println("<전체 장난감 목록>");
		
		int index = 1; 
		
		for(ToyA toy : toySet) {
			System.out.println(index + ". " + toy);
			index++; 			
		}

		
	}
	
	
	//장난감 만들기
	public void createNewToy() throws Exception {
		System.out.println("<새로운 장난감 추가>");
		
		System.out.print("장난감 이름 : ");
		String name = sc.next(); 
		
		//기존에 있는 장난감인지 확인 		
		for( ToyA existingToy : toySet) {
			
			if(existingToy.getName().equals(name)) {				
				System.out.println("이미 존재하는 장난감입니다");								
				return;    //바로 종료 
			}
		} //중복 장난감 없는 것 확인 후 
		
		System.out.print("사용 가능 연령 : ");
		int age = sc.nextInt(); 
		
		System.out.print("가격 : ");
		int price = sc.nextInt(); 
		
		System.out.print("색상 : ");
		String color = sc.next(); 
		
		System.out.print("제조일 (YYYYMMDD)형식으로 입력 : ");
		String manufactureDate = sc.next(); 
		
		//재료 반복문으로 입력 받음 
		Set<String> materials = new HashSet<String>(); //재료 저장할 컬렉션 
		while (true) {
			
			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요) : ");
			String input = sc.next(); 
			
			if(input.equals("q")) {
				break; 
			} 
			//q 입력받은게 아니면 입력받은 재료 저장 
			materials.add(input); 
		}
		
		ToyA newToy = new ToyA(name, age, price, color, manufactureDate, materials); 
		
		toySet.add(newToy); 
		System.out.println("새로운 장난감이 추가되었습니다");
		
		
	}
	
	
	//장난감 삭제하기 
	public void deleteToy() {
		
		System.out.print("삭제할 장난감의 이름을 입력하세요 : ");
		String toyName = sc.next(); 
		
		boolean flag = false; 
		
		for(ToyA toy : toySet) {
			if(toy.getName().equals(toyName)) {
				toySet.remove(toy); 
				flag = true; 
				break; 
			}
		}
		
		//반복문 종료 후 flag 기준으로 
		if(flag) {
			System.out.println("장난감이 삭제되었습니다");
		} else {
			System.out.println("해당하는 장난감을 찾을 수 없습니다");
		}
		
	}
	
		
	//제조일 순으로 조회(정렬)하기 
	public void displayByManufactureDate() {
		
		System.out.println("<제조일 순으로 장난감을 정렬>"); 
		
		//리스트 사용해서 sort사용 
		
		List<ToyA> toySortedByDate = new ArrayList<ToyA>(toySet);  
		
		toySortedByDate.sort(Comparator.comparing(ToyA :: getManufactureDate));

		int index = 1; 
		for(ToyA toy : toySortedByDate) {
			System.out.println(index + ". " + toy);
			index++; 
		}
		
	}
	
	
	//연령별 장난감 정렬하여 출력하기 
	public void displayByAge() {
		
		System.out.println("<연령별로 사용 가능한 장난감>");
		
		Map<Integer, List<ToyA>> toysByAge = new HashMap<Integer, List<ToyA>>(); 
		//toysByAge 라는 이름의 새로운 맵을 생성 
		// -> 연령을 key로 하고, 해당 연령을 가진 장난감 리스트를 value로 가짐
		// { K : V} -> { 5 : ["키시미시", "허기워기"]}
		
		for (ToyA toy : toySet) {
			
			int age  = toy.getAge(); //5
			
			toysByAge.putIfAbsent(age, new ArrayList<>());    // 5라는 키를 가진 맵이 없으면 새로 생성
			//putIfAbsent() : Map인터페이스에서 제공되는 메서드, 
			//해당 키가 존재하지 않는 경우에만 전달받은 값을 추가 
			//-> Map에 해당 연령의 리스트가 없는 경우에만 새로운 리스트를 생성하여 추가 
			
			toysByAge.get(age).add(toy);
			
		}
		
		for( Entry<Integer, List<ToyA>> entry : toysByAge.entrySet()) {
			
			int age = entry.getKey(); 
			
			List<ToyA> toyList = entry.getValue(); 
			
			System.out.println("[연령 : " + age + "세]");
			int index = 1; 
			
			for(ToyA toy : toyList) {
				System.out.println(index + ". " + toy);
				index++; 
			}
			
		}
		
		
	}
	
	
	//재료 추가하기 
	public void addMaterial() throws Exception {
		
		System.out.println("<재료추가>");
		System.out.println("----현재 등록된 재료----");
		for(Entry<Integer, String> entry : materialMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		System.out.println("---------------------------");
		
		System.out.print("재료 고유번호(Key) 입력 : ");
		int key = sc.nextInt(); 
		
		System.out.println("재료명 입력 : ");
		String material = sc.next(); 
		
		if(materialMap.containsKey(key)) {
			
			System.out.println("이미 해당키에 재료가 등록되어있습니다.");
			System.out.print("덮어쓰시겠습니까? (y/n) : ");
			String input = sc.next(); 
			
			if (input.equalsIgnoreCase("Y")) {
				materialMap.put(key, material); 
				System.out.println("재료가 성공적으로 덮어쓰기되었습니다.");
			} else {
				System.out.println("재료 추가가 취소되었습니다.");
			}
				

		} else { 
			
			materialMap.put(key, material); 
			System.out.println("새로운 재료가 성공적으로 등록되었습니다.");			
		}
		
		
	}
	
	
	//재료 삭제하기 
	public void removeMaterialByName() throws Exception {
		
		System.out.println("<재료 삭제>");
		
		System.out.println("----현재 등록된 재료----");
		for(Entry<Integer, String> entry : materialMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		System.out.println("---------------------------");
		
		System.out.print("삭제할 재료명 입력 : ");
		String materialName = sc.next(); 
		
		boolean flag = false ; 
		
		for( Entry<Integer, String> entry : materialMap.entrySet()) {
			
			if(entry.getValue().equals(materialName)) {
				materialMap.remove(entry.getKey()); //키를 전달하면 키랑 밸류 다 삭제 
				System.out.println("재료 '" + materialName + "' 가 성공적으로 제거되었습니다.");
				flag = true; 
				break; 
			}

		}
		
		if(!flag) {
			
			System.out.println("해당 이름의 재료가 존재하지 않습니다.");	
			
		}
		
		
		
	}
	
		
		
		
}
		
		
		
		



package com.project.model.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.project.model.Toy;
import com.project.model.service.ToyListService;
import com.project.model.service.ToyListServiceImpl;

public class ToyListView {
	
	
	private BufferedReader br = null; 
	private ToyListService service = null; 
	private List<Toy> toyList = new ArrayList<Toy>(); 
	
	
	//기본 생성자 
	public ToyListView() {
		
		try {		
			service = new ToyListServiceImpl(); 			
			br = new BufferedReader(new InputStreamReader(System.in)); 		
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
		
		
		
		
	}
	
	
	//시작 화면 
	
	public void preView() {
		
		int input = 0; 
		
		do {
			try {
				input = selectMenu();
				
				switch (input) {
				case 1 : displayToyType(); break; 
				case 2 : addDIYToy(); break; 
				case 3 : updateDIYToy(); break; 
				case 4 : deleteDIYToy(); break; 
				case 0 : System.out.println("프로그램 종료");
				default : System.out.println("메뉴 번호 확인 후 입력해주세요!");
				
				}
				
				System.out.println("===========================================");
				
			}
			catch(NumberFormatException e) {
				System.out.println("숫자만 입력해주세요!");
			} catch(IOException e) {
				System.out.println("입출력 예외 발생");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while(input != 0); 
		
	}


	public int selectMenu() throws NumberFormatException, IOException {
		
		System.out.println("========== Welcome ToyLand ==========\n");
		
		System.out.println("1. 구매 가능한 장난감 조회");
		System.out.println("2. DIY TOY 등록하기");
		System.out.println("3. DIY TOY 수정하기");
		System.out.println("4. DIY TOY 삭제하기");
		System.out.println("0. EXIT ToyLand");
		
		System.out.print("원하는 메뉴 번호 입력 : ");
		int input = Integer.parseInt(br.readLine()); 
		System.out.println();
		
		return input;
	}
	
	
	public void displayToyType() {
		
		System.out.println("\n==========[ 장난감 조회 ]==========\n");
		
		Map<String, List<Toy>> toysByType = service.displayToyType(); 
		List<Toy> toyList = toysByType.get("toyType"); 
//		for(Toy toy : toyList) {
//			String typeOfToy = toy.getToyType();
//			toysByType.putIfAbsent(typeOfToy, new ArrayList<>()); 
//			toysByType.get(typeOfToy).add(toy); 
//		}
//		
//		for(Entry<String, List<Toy>> entry : toysByType.entrySet()) {
//			String typeOfToy = entry.getKey(); 
//			List<Toy> toysList = entry.getValue(); 
//			System.out.println("[종류 : " + typeOfToy + "]");  	
//			
			for(Toy toy : toyList) {
				System.out.println(toy);
			}
			
//		}
		
	
		

		}
		
	public void addDIYToy() throws IOException, Exception{
		
		System.out.println("\n==========[ DIY TOY 등록하기 ]==========\n");
		
		System.out.print("장난감 종류 입력 : ");
		String type = br.readLine(); 
		
		System.out.print("장난감 이름 입력 : ");
		String name = br.readLine(); 
		
		System.out.println("장난감 세부 정보 입력 (입력 종료시 !zz 입력 후 엔터)");
		System.out.println("----------------------------------------------------");
		
		StringBuilder sb = new StringBuilder(); 
		
		while(true) {
			
			String content = br.readLine(); 
			
			if(content.equals("!zz")) break; 
			
			sb.append(content);
		}
		
		int index = service.addDIYToy(type, name, sb.toString()); 
		
		if(index==-1) {
			System.out.println("추가 실패");
			return; 
		}
		System.out.println("추가 성공!");
		
		
		
		
		
		
		
	}
	
	public void updateDIYToy() throws Exception {
		
		System.out.println("\n==========[ DIY TOY 수정하기 ]==========\n");
		
		System.out.print("수정할 장난감 이름 입력 : ");
		String input = br.readLine(); 
		
		String toyList = service.displayToyType().toString(); 
		
		if(toyList.contains(input)){
			
			System.out.print("장난감 종류 수정 입력 : ");
			String type = br.readLine(); 
			
			System.out.print("장난감 이름 수정 입력 : ");
			String name = br.readLine(); 
			
			System.out.println("수정 장난감 세부 정보 입력 (입력 종료시 !zz 입력 후 엔터)");
			
			StringBuilder sb = new StringBuilder(); 
			
			while(true) {
				
				String content = br.readLine(); 				
				if(content.equals("!zz")) break; 				
				sb.append(content); 		
			
				
			}
		boolean result = service.UpdateDIYToy(type, name, sb.toString());
		
		if(result) System.out.println("수정 완료!");
		else System.out.println("수정 실패!");
		
 
		
		}	
		
		
		
	}
	
	
	public void deleteDIYToy() throws Exception{
		
		System.out.println("\n==========[ DIY TOY 삭제하기 ]==========\n");
		
		System.out.println("삭제할 인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine()); 
		
		String result = service.deleteDIYToy(index); 
		
		if(result == null) System.out.println("### 인덱스가 존재하지 않습니다 ###");
		else System.out.printf("[%s] 가 삭제되었습니다\n", result);
		
		
		
	}
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


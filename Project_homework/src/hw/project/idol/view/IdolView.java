package hw.project.idol.view;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import hw.project.model.idol.dto.Idol;
import hw.project.model.idol.service.IdolService;
import hw.project.model.idol.service.IdolServiceImpl;

public class IdolView {
	
	
	private BufferedReader br = null;
	private IdolService service = null;
	
	public IdolView() {
		
		try {			
			service = new IdolServiceImpl();
			br = new BufferedReader(new InputStreamReader(System.in));		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void firstDisplay() throws Exception{		
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = 0;
		
		do {
			
			try {
				
				System.out.println("\n============= MONTHLY IDOL =============\n");
				System.out.printf("1. View All Members\n");
				System.out.printf("2. New Member \n");
				System.out.printf("3. Ranked by Followers\n");
				System.out.printf("4. Ranked by Income\n");
				System.out.printf("5. Update Profile\n");
				System.out.printf("6. Terminate contract\n");
				System.out.printf("0. Game Over\n");
				System.out.println("\n =========================================\n");
				System.out.print("Input Menu >>> ");
				input = Integer.parseInt(br.readLine());
				
				switch(input) {
				case 1 : displayIdolList(); break;
				case 2 : createIdol(); break;
				case 3 : sortByFanNum(); break;
				case 4 : sortByRevenue(); break;
				case 5 : updateProfile(); break;
				case 6 : deleteMember(); break;
				case 0 : System.out.println("<<< 월 간 아 이 돌 을 종 료 합 니 다 =33 >>>"); break;
				default : System.out.println("~~~번호 확인 후 입력~~~");
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}while(input != 0);
		
	}
	

	public void displayIdolList() {
		
		System.out.println("\n========================================== [ Your Idol ] ===========================================\n");
		
		List<Idol> idolList = service.displayIdolList();  
	
		
		for(Idol idol : idolList) {
			System.out.println(idol);

		}
		
		System.out.println("\n====================================================================================================\n");
		
	}
	
	
	public void createIdol() throws Exception {
		System.out.println("\n===================== [ Get Your Own IDol ] ======================\n");
		
		System.out.print("당신의 아이돌 이름은? : ");
		String name = br.readLine();
		
		System.out.print("지난 정산 주기 정산액! : ");
		int revenue  = Integer.parseInt(br.readLine());
		
		System.out.print("팔로워 수 : ");
		int fanNum= Integer.parseInt(br.readLine());
		
		System.out.print("다음 앨범명 : ");
		String albumTitle = br.readLine();
		
		System.out.print("다음 앨범 컨셉 : ");
		String albumConcept = br.readLine();
		
		
		
		service.createIdol(name, revenue, fanNum, albumTitle, albumConcept);
		
		
		System.out.println( name + " [[ \\ 멤버 영입 완료! / ]]");
		
		System.out.println("===================================================================\n");
		
		
	}


	public void sortByFanNum() {
		
		System.out.println("====================================== [ Followers Ranking ] =======================================\n");
		
		 		
		List<Idol> idolsList = new ArrayList<Idol>();
		idolsList = service.displayIdolList();
		idolsList.sort(Comparator.comparing(Idol::getFanNum).reversed());
		
		for(Idol idol : idolsList) {
			 System.out.println(idol);
		}
		
		System.out.println("\n====================================================================================================\n");
		
	}


	public void sortByRevenue() {
		
		System.out.println("======================================= [ Income Ranking ] ======================================\n");
		
		List<Idol> idolsList = new ArrayList<Idol>();
		idolsList = service.displayIdolList();
		idolsList.sort(Comparator.comparing(Idol::getRevenue).reversed());
		for(Idol idol : idolsList) {
			 System.out.println(idol);
		}
		
		
		System.out.println("\n=================================================================================================\n");
	}
	
	
	
	
	public void updateProfile()throws Exception {
		
		
		Scanner sc = new Scanner(System.in); 
		int editMenu = 0; 
		List<Idol> idolList = service.displayIdolList(); 
		
		System.out.println("================ [ Update Profile ] =================\n");
		
		System.out.print("수정할 멤버를 입력해주세요 : ");
		String inputMem = sc.next(); 
		
		boolean flag = true; 
		
		for(Idol temp : idolList) {
			
			if(inputMem.equals(temp.getMemberName())) {
				
				flag = false; 
				
				System.out.println("1. 이름");
				System.out.println("2. 수익 현황");
				System.out.println("3. 팔로워");
				System.out.println("4. 앨범명");
				System.out.println("5. 앨범 컨셉");
				System.out.println("0. 수정 종료");
				System.out.println("어떤 정보를 수정하시겠습니까?");
				
				editMenu = sc.nextInt(); 
				sc.nextLine(); 
				
				switch (editMenu) {
				
				case 1 : 
				System.out.print("멤버 이름 : ");
				String name = sc.nextLine(); 
				temp.setMemberName(name);
				break; 
				case 2 : 
				System.out.print("수익 현황 업데이트 : ");
				int revenue = sc.nextInt(); 
				temp.setRevenue(revenue);
				break; 
				case 3 : 
				System.out.print("팔로워 업데이트 : ");
				int fanNum = sc.nextInt(); 
				temp.setFanNum(fanNum);
				break; 
				case 4 : 
				System.out.print("앨범명 : ");
				String albumTitle = sc.next(); 
				temp.setAlbumTitle(albumTitle);
				break; 
				case 5 : 
				System.out.print("앨범 컨셉 : ");
				String albumConcept = sc.next(); 
				temp.setAlbumConcept(albumConcept);
				break; 
				case 0 : System.out.println("[[ \\ 수정 종료 / ]]"); break; 
				
				default : System.out.println("번호 확인 후 입력하세요!"); break; 
				
				}
			
			}
			
		}
		if(flag) {
			System.out.println("멤버 이름을 확인해주세요!");
		}
		else {
			System.out.println("[[ \\ 수정완료 / ]]");
		}
	
		
		System.out.println("=================================================\n");
		
	}
	
	

	public void deleteMember() throws Exception {
		Scanner sc = new Scanner(System.in);
		
		List<Idol> idolList = service.displayIdolList(); 
		
		System.out.println("============= [ Terminate Contract ] ==============\n");
		
		System.out.print("계약 해지할 멤버를 입력하세요 : ");
		String inputMem = sc.next();
		
		boolean flag = false; 
		
		for(Idol idol  : idolList) {
		
			if(inputMem.equals(idol.getMemberName())) {
				idolList.remove(idol);
				flag = true; 
				break; 
				
			}
	}
	if(flag) {
		System.out.println("\n....계약 해지 완료....\n");
	} else {
		System.out.println("\n이름 확인 후 입력해주세요!!\n");
	}
	
	
	}

	

}

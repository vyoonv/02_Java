package edu.kh.oarr.model.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {
	
	//속성 
	private Scanner sc = new Scanner (System.in); 
	
	//Member 5칸짜리 객체배열 선언 및 할당 
	private Member[] memberArr = new Member[5]; 
	
	//현재 로그인한 회원의 정보를 저장할 변수 선언 
	private Member loginMember = null; 
	
	public MemberService() {//기본 생성자 
		
		//memberArr 배열 0,1,2인덱스 초기화 
		memberArr[0] = new Member("user01", "pass01", "홍길동", 30, "서울"); 
		memberArr[1] = new Member("user02", "pass02", "계보린", 25, "경기"); 
		memberArr[2] = new Member("user03", "pass03", "고길동", 45, "강원"); 
		
		
		
	}
	

	
	//기능 
	
	//메뉴 출력용 메서드 
	public void displayMenu() {
		
		int menuNum = 0; //메뉴 선택용 변수 
		
		//무조건 한 번은 반복 
		do {
			
			System.out.println("=======회원 정보 관리 프로그램 ver.2=======");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보 조회");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원 검색 (지역)");
			System.out.println("0. 프로그램 종료");
		
			System.out.println("메뉴 입력 : ");
			menuNum = sc.nextInt(); 
			
			sc.nextLine(); //입력 버퍼에 남은 개행문자 제거용 
			
			switch(menuNum) {
			
			case 1 : System.out.println(signUp());break; /*회원가입기능*/
			case 2 : System.out.println(login());break; /*로그인기능*/
			case 3 : System.out.println(searchMember());break; /*회원 정보 조회 기능*/
			case 4 : 
				int result = updateMember(); 
				
				if(result == -1) {
					System.out.println("로그인 후 이용바람");
				} else if (result == 0) {
					System.out.println("회원정보 수정 실패(비밀번호 불일치)");
				} else {
					System.out.println("회원정보가 수정되었습니다.");
				} break;
				
			case 5 : searchRegion();break; 
			case 0 : System.out.println("프로그램 종료");break; 
			default : System.out.println("잘못 입력하셨습니다. 다시 입력하세요."); 
							
			}
			
			
		} while (menuNum != 0); //menuNum이 0이되면 반복 종료 
		
		
	}
	
	//memberArr의 비어있는 인덱스 번호를 반환하는 메서드
	//단, 비어있는 인덱스가 없다면 -1 반환 
	public int emptyIndex() {
		//memberArr 배열을 0 인덱스부터 끝까지 접근해서 
		//참조하는 값이 null인 경우의 인덱스를 반환 
		for(int i=0; i<memberArr.length; i++) {
			
			if(memberArr[i] == null) {
				return i; //현재 메서드를 종료하고 호출한 곳으로 i 값을 가지고 돌아간다는 뜻 
				
			}
			
		}
		 //for문을 수행했지만 return이 되지 않은 경우 해당위치 코드 수행
	     //for문에서 return되지 않았다 == 배열에 빈칸이 없다 	 
		return -1; 
				
	}
	
	
	//회원 가입 메서드 
	public String signUp() {
		System.out.println("\n==========회원가입==========");
		
		// 객체 배열 memberArr에 가입한 회원정보를 저장할 예정 
		// -> 새로운 회원정보를 저장할 공간이 있는지 확인하고 
		// 빈 공간의 인덱스 번호를 얻어오기 
		int index = emptyIndex(); //memberArr배열에서 비어있는 인덱스 반환받음 (없다면 -1 반환)
		
		if(index == -1) {//비어있는 인덱스가 없는 경우 -> 회원가입 불가 
			return "회원가입이 불가능합니다(인원수초과)"; 
								
		}
		
		System.out.println("아이디 : ");
		String memberId = sc.next(); 
		
		System.out.println("비밀번호 : ");
		String memberPw = sc.next(); 
		
		System.out.println("비밀번호 확인 : ");
		String memberPw2 = sc.next(); 
		
		System.out.println("이름 : ");
		String memberName = sc.next();
		
		System.out.println("나이 : ");
		int memberAge = sc.nextInt(); 
		
		System.out.println("지역 : ");
		String region = sc.next(); 
		
		//비밀번호, 비번확인이 일치하면 회원가입 //일치하지 않으면 회원가입 실패 
		if(memberPw.equals(memberPw2)) { //일치하는 경우 
			
			//Member 객체 생성 할당된 주소를 memberArr의 비어있는 인덱스에 대입 
			memberArr[index] = new Member(memberId, memberPw, memberName, memberAge, region); 
			
			return "회원가입 성공!"; 
			
			
		} else { 
			
			return "회원가입 실패(비밀번호 불일치)"; 
			
		}

		
	}
	

	//로그인 메서드 
	public String login() {
		
		System.out.println("\n==========로그인==========");
		
		System.out.print("아이디 입력 : ");
		String memberId =sc.next(); 
		
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next(); 
		
		//1) memberArr 배열 내 요소를 순서대로 접근하여 null이 아닌지 확인 
		for(int i=0; i<memberArr.length; i++) {
			
			if (memberArr[i] != null) {//회원정보가 있을 경우 
				//2) 회원정보(memberArr[i]의 아이디, 비밀번호와 
				//입력받은 아이디(memberId)와 비밀번호(memberPw)가 같은지 확인 
				if(memberArr[i].getMemberId().equals(memberId) &&
						memberArr[i].getMemberPw().equals(memberPw)) {
					
					//로그인 회원 정보 객체를 참조하는 변수 loginMember에 
					//현재 접근중인 memberArr[i] 요소에 저장된 주소를 얕은 복사 
					
					loginMember = memberArr[i];
					break; //더이상 같은 아이디, 비밀번호가 없기 때문에 for문 종료 
					
				
				}
				
			}
			
		}
		
		//4) 로그인 성공/실패 여부에 따라 결과 값 반환 
		if (loginMember == null) { //로그인 실패 
			
			return "아이디 또는 비밀번호가 일치하지 않습니다."; 
			
		} else { //로그인 성공 
			
			return loginMember.getMemberName() + "님 환영합니다!"; 
						
		}
						
	}

	
	//회원정보 조회 기능 
	public String searchMember() {
		
		System.out.println("\n=========회원정보조회===========");
		
		//로그인 여부 확인 -> 필드 loginMember가 참조하는 객체가 있는지 확인 
		
		if(loginMember ==null) {
			
			return "로그인 후 이용바람"; 
				
		}
		
		//로그인이 되어있는 경우 회원정보를 출력할 문자열을 만들어서 반환 //비밀번호 제외 
		String str = "이름 : " + loginMember.getMemberName(); 
		str += "\n아이디 : " + loginMember.getMemberId(); 
		str += "\n나이 : " + loginMember.getMemberAge(); 
		str += "\n지역 : " + loginMember.getRegion(); 
		
		return str; 
		
	}
		
//		System.out.println("아이디 입력 : ");
//		String searchId = sc.next(); 
//		System.out.println("비밀번호 입력 : ");
//		String searchPw = sc.next(); 
//		
//		boolean flag = true;
//		
//		for (int i=0; i<memberArr.length; i++) {
//			
//			if( memberArr[i] == null ) {
//				return "로그인 후 이용해주세요"; 
//			}
//			
//			if (memberArr[i].getMemberId().equals(searchId) && memberArr[i].getMemberPw().equals(searchPw)) {
//				
//				System.out.printf("이름 : %s, 나이 : %s, 지역 : %s ", 
//						memberArr[i].getMemberName(), memberArr[i].getMemberAge(), memberArr[i].getRegion());
//				 flag = false; 
//		
//			}
//			
//			
//		}
//		if (flag) {
//			System.out.println("회원정보 조회 실패");
//		}
//		
//		
//	}
//	
	
	
	//회원정보 수정 메서드  
	public int updateMember() {
		
		System.out.println("==========회원정보수정=========");
		
		//로그인 여부 판별 
		//로그인이 되어있지 않으면 -1 반환 
		if (loginMember == null ) {
			
			return -1;	
			
		}
		//2) 수정할 회원정보 입력 받기 (이름, 나이, 지역) 
		System.out.print("수정할 이름 입력 : ");
		String inputName = sc.next(); 
		System.out.print("수정할 나이 입력 : ");
		int inputAge = sc.nextInt(); 
		System.out.print("수정할 지역 입력 : ");
		String inputRegion = sc.next(); 
		
		//비밀번호 입력받아서 
		//로그인한 회원의 비밀번호와 일치하는지 확인 
		System.out.println("비밀번호 입력 : ");
		String inputPw = sc.next(); 
		
		if(inputPw.equals(loginMember.getMemberPw())) {
			//비밀번호가 같을 경우 
			//로그인한 회원의 이름, 나이 지역정보를 입력받은 값으로 변경 후 반환 
			loginMember.setMemberName(inputName);
			loginMember.setMemberAge(inputAge);
			loginMember.setRegion(inputRegion);
			
			return 1; 
			
		} else { 
			//비밀번호가 다른 경우 0 반환 
			return 0 ; 			
			
		} 
		
		
		
		
	}
	
	
	
	//회원 검색(지역) 메서드 
	public void searchRegion() {
		
		System.out.println("\n=======회원 검색(지역)=======");
		
		System.out.print("검색할 지역을 입력하세요 : ");
		String inputRegion = sc.next(); 
		
		boolean flag = true; //검색 결과 신호용 변수 
		
		//1) memberArr 배열의 모든 요소 순차 접근 
		for( int i = 0; i<memberArr.length; i++) {
			
			//2) memberArr[i] 요소가 null인 경우 반복 종료 
			if(memberArr[i] == null ) {
				break; 				
			}
			
			//3) memberArr[i] 요소에 저장된 지역이(region)
			//입력받은 지역 (inputregion)과 같을 경우 회원의 아이디, 이름을 출력 
			if(memberArr[i].getRegion().equals(inputRegion)) {
				System.out.printf("아이디 : %s, 이름 : %s\n", 
						memberArr[i].getMemberId(), memberArr[i].getMemberName());
				
				flag = false; 
				
			}
						
		}
		
		
		if(flag) {
			
			System.out.println("일치하는 검색 결과가 없습니다.");
						
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

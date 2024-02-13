package edu.kh.oop.method.model.service;

import java.util.Scanner;

import edu.kh.oop.method.model.vo.Member;

public class MemberService {
	
	
	// 속성 (필드)
	private Scanner sc = new Scanner(System.in);
		
	private Member memberInfo = null; //가입한 회원의 정보를 저장할 변수 
	private Member loginMember = null; //로그인한 회원의 정보를 저장할 변수 
	
	
	// 기능 (생성자, 메서드)
	
	//메뉴 화면 출력 기능 
	public void displayMenu() {
		
		int menuNum =0; //메뉴 선택용 변수 
		
		//무조건 한 번은 반복 ->do while문 
		do {
			
			System.out.println("=====회원 정보 관리 프로그램=====");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정"); 
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			menuNum = sc.nextInt(); 
			sc.nextLine(); //입력 버퍼에 남은 개행문자 제거용 
			
			switch(menuNum) {
			
			case 1 : System.out.println( signUp() ); break; //회원가입 기능 호출 
			case 2 : System.out.println( login() ); break; //로그인 기능 호출
			case 3 : System.out.println(selectMember()); break; //회원정보 조회 기능 호출
			case 4 : 
				int result = updateMember(); 
				if(result == -1) {
					System.out.println("로그인 후 이용해주세요.");
				} else if (result == 0) {
					System.out.println("회원 정보 수정 실패 (비밀번호 불일치)");
				} else {
					System.out.println("회원 정보가 수정되었습니다.");
				} break; //회원 정보 수정 
			case 0 : System.out.println("프로그램 종료"); break;
			default : System.out.println("잘못 입력하셨습니다.. 메뉴에 있는 번호만 입력해주세요");
			
			}
			
			
		} while(menuNum != 0); //menuNum이 0이면 종료 
		
				
		
	}
	
	
	//회원 가입 기능 
	public String signUp() {
		  //반환형 
		  //해당 메서드는 끝나고 호출한 곳으로 돌아갈 때 
		  //String 자료형 값을 가지고 돌아간다 
				
		System.out.println("\n*****회원가입*****"); //메뉴입력에 print 사용했기 때문에 개행 필요 
		
		System.out.print("아이디 : ");
		String memberId = sc.nextLine(); 
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next(); 
		
		System.out.print("비밀번호 확인 : ");
		String memberPw2 = sc.next(); 
		
		System.out.print("이름 : ");
		String memberName = sc.next(); 
		
		System.out.print("나이 : ");
		int memberAge = sc.nextInt(); 
		
		
		// 비밀번호, 비밀번호 확인이 일치하면 회원가입 
		// 일치하지 않으면 회원가입 실패 
		
		if( memberPw.equals(memberPw2) ) { //일치하는 경우 
			
			// 입력 받은 정보를 이용해서 Member 객체 생성한 후 
			// 생성된 객체의 주소를 필드에 있는 memberInfo에 대입 
			memberInfo = new Member(memberId, memberPw, memberName, memberAge); 
			
			return "회원가입 성공!!"; 
			
		} else { //일치하지 않는 경우 
			
			return "회원가입 실패!!(비밀번호 불일치)"; 
			
		}
		
		
		
	}
	
	
	//로그인 기능 
	public String login() {
		
		System.out.println("\n*******로그인*******");
		
		
		//회원가입 여부 확인 
		//memberInfo가 객체를 참조하고 있는지 확인 (null 여부)
		if(memberInfo == null) {//미가입 상태인 경우 
			//null : 아무것도 참조하고 있지 않음 
			return "회원가입부터 진행해주세요"; 
						
		}  //회원가입된 상태라면 로그인 기능 수행 
		
			System.out.println("아이디 입력 : ");
			String memberId = sc.next(); 
			
			System.out.println("비밀번호 입력 : ");
			String memberPw = sc.next(); 
			
			//회원가입된 정보(memberInfo가 참조하는 member객체)와 일치 여부 
			//입력받은 아이디, 비밀번호와 같으면 로그인 성공 
			
			//아이디, 비밀번호 모두 일치할 경우 
			if(memberId.equals(memberInfo.getMemberId())  && 
					memberPw.equals(memberInfo.getMemberPw())) {//입력받은 id,pw와 memberInfo에서 참조한 m
																//ember객체의 id,pw가 일치하는지 여부

				//loginMember에 Member객체 주소 대입 
				loginMember = memberInfo; 
			   //참조형 변수 -> Member 객체 주소 (얕은 복사)
								
				// 회원가입 정보를 loginmember에 대입한 어떤 회원이 로그인했는지 구분할 수 있게 함 
				return loginMember.getMemberName() + "님 환영합니다."; 
								
			} else {
				
				return "아이디 또는 비밀번호가 일치하지 않습니다."; 
				
			}
			
		
	}
	
	
	//회원 정보 조회 기능 
	public String selectMember() {
		
		//1) 로그인 여부 확인 
		//로그인 하지 않았을 때 ->로그인 후 이용해주세요 return 
		
		//2) 로그인 되어있는 경우 
		//회원정보를 출력할 문자열을 만들어서 반환 //단, 비밀번호는 제외
		//이름 :  //아이디 :  //나이 :
		
		System.out.println("\n*******회원 정보 조회*******");
		
		
		if(loginMember == null) {
			
			return "로그인 후 이용해주세요"; 
			
		} 
			String str = "이름 : " + loginMember.getMemberName(); 
			str += "\n아이디 : " + loginMember.getMemberId(); 
			str += "\n나이 : " + loginMember.getMemberAge() + "세"; 
		
			return str; 
			
			

	}
	
	
	//회원 정보 수정 기능 
	public int updateMember() {
		
		System.out.println("\n*******회원 정보 수정*******");
		
		//1) 로그인 여부 판별 
		//로그인이 되어있지 않으면 -1 반환 
		if(loginMember == null) {
			return -1;
		}
		//2) 로그인 상태일때 
		//2-1 수정할 회원정보 입력받기 (이름, 나이)
		System.out.print("수정할 이름 입력 : ");
		String inputName = sc.next(); 
		
		System.out.print("수정할 나이 입력 : ");
		int inputAge = sc.nextInt(); 
		
		//2-2 비밀번호를 입력받아 로그인한 회원의 비밀번호와 일치하는지 확인 
		System.out.print("비밀번호 입력 : ");
		String inputPw = sc.next(); 
		
		if(inputPw.equals(loginMember.getMemberPw())) {
			//비밀번호 같을 경우 로그인한 회원 이름, 나이 정보를 입력받은 값으로 변경 후 1 반환 
			
			loginMember.setMemberName(inputName);
			loginMember.setMemberAge(inputAge);
			
			return 1; 
			
		} else {//비밀번호가 다를 경우 0 반환 
					
			return 0; 
			
			
		}
			
			
		
	}
	
	
	
	
	
	
	
	

}

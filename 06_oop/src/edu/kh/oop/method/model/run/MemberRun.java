package edu.kh.oop.method.model.run;

import edu.kh.oop.method.model.service.MemberService;

public class MemberRun {
	
	
	
	
	public static void main(String[] args) {
//[접근제한자] //[예약어] //반환형 // 메서드명 ([매개변수])  
		//-> 대괄호 안에 있는 것 생략 가능 
		
		
		MemberService service = new MemberService(); 
		
		//MemberService의 기본생성자가 작성되어있지 않지만 컴파일러가 코드를 번역할 때
		//클래스 내부에 생성자가 하나도 없다면 자동으로 기본생성자를 추가하기 때문에 
		//문제 없이 사용 가능 
		//**주의사항** //만약 생성자가 하나라도 있으면 자동생성하지 않음 
		
		service.displayMenu();
			
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

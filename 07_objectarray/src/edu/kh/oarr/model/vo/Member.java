package edu.kh.oarr.model.vo;

public class Member {
	
	//속성(필드 = 멤버변수)
	private String memberId; 
	private String memberPw; 
	private String memberName;
	private int memberAge; 
	private String region; 
	
	
	
	
	//기능 (생성자, 메서드) 
	//생성자 
	//기본생성자, 매개변수 생성자 
	//생성자 만드는 규칙 
	//1. 생성자 이름은 클래스명과 같아야 함 
	//2. 반환형이 없다 
	//**기본 생성자는 컴파일러가 자동으로 생성, 
	//생성자가 하나라도 있으면 자동생성하지 않음 
	//->매개변수 생성자가 있다면 기본생성자 직접 작성해야 함 
	
	
	public Member() {}  //기본 생성자 //객체 생성의 역할/기능 
	
	
	//오버로딩 : 매개변수의 타입, 순서, 개수 중 하나가 달라야 함 
	public Member(String memberId, String memberPw, String memberName, 
					int memberAge, String region) {//매개변수 생성자 
		
		this.memberId = memberId; 
		this.memberName= memberName; 
		this.memberAge = memberAge; 
		this.memberPw = memberPw;
		this.region = region; 
		
	}

	
	

	//메서드 
	//getter/setter 
	//간접접근의 용도로 만들어짐, 다 접근 가능하도록 public, 
	

	public String getMemberId() {
		//반환형 String 자료형을 돌려보내겠다 
		return memberId;//매개변수가 없어서 중복된 이름의 memberId가 없어서 memberId라고만 써도 가능 
	}

	//반환형 : void 반환값이 없음.
	public void setMemberId(String memberId) {
		//setter :  무엇을 세팅할지 전달받은 것이 매개변수이다 
		this.memberId = memberId;
		//모든 메서드는 종료시 호출한 곳으로 돌아가는 return 구문이 작성되어야 하지만
		//단, void일 경우 생략 가능 -> 생략시 컴파일러가 자동 추가 
		
	}


	public String getMemberPw() {
		return memberPw;
	}


	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public int getMemberAge() {
		return memberAge;
	}


	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
	
	
	

}

package edu.kh.inheritance.model.dto;


//DTO(Data Transfer Object) : 비즈니스 계층과 데이터 교환을 위해 사용하는 객체 
public class Person {
	//Object 클래스 
	//모든 클ㄹ래스의 최상위 부모 
	//class선언부에 상속 구문이 하나도 작성되지 않았다면 
	//컴파일ㄹ

	
	private String name; 
	private int age; 
	private String nationality; 
	
	
	
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public String getNationality() {
		return nationality;
	}




	public void setNationality(String nationality) {
		this.nationality = nationality;
	}




	//생성자
	public Person() {} //기본 생성자 



	//매개변수 생성자 
	
	public Person(String name, int age, String nationality) {
		super();
		this.name = name;
		this.age = age;
		this.nationality = nationality;
	}
	
	
	


	
	public void breath() {
		System.out.println("사람은 코나 입으로 숨 쉴 수 있다");
		
	}
	
	
	public void move() {
		System.out.println("사람은 움직일 수 있다");
	}



	//필드를 문자열 형태로 표현 alt+shift+s -> toString
	@Override
	public String toString() {
		//Object의 toString() 재정의 
		
		return name + " / " + age + " / " + nationality ;
	
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
}

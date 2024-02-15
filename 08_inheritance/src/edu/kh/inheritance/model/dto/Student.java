package edu.kh.inheritance.model.dto;



/*
 * Object 
 * 		|- Person
 * 			|- Student 
 * 
 * */







public class Student extends Person {
	//student 클래스에 person 클래스 내용을 연장한다 
	// == student 클래스에 person 클래스 내용(필드, 메서드)을 추가하여 확장한다
	
	//**상속**
	//자식 extends 부모 
	
	
	//필드 
//	private String name; 
//	private int age; 
//	private String nationality; 
	private int grade; 
	private int classroom; 
	
	
	public Student() {}


	public Student(String name, int age, String nationality, int grade, int classroom) {
		
//		this.name = name;
//		this.age = age;
//		this.nationality = nationality;
		/* 
		setName(name); 
		setAge(age); 
		setNationality(nationality); 
		*/
		
		//부모의 기본 생성자 
		// super(); 
		
		//매개변수 생성자 이용해서 전달 
		super(name, age, nationality); 
		
		this.grade = grade;
		this.classroom = classroom;
	}


//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public int getAge() {
//		return age;
//	}
//
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//
//	public String getNationality() {
//		return nationality;
//	}
//
//
//	public void setNationality(String nationality) {
//		this.nationality = nationality;
//	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public int getClassroom() {
		return classroom;
	}


	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	
	
	//ctrl+space override하고 싶은 것 선택 
	@Override
	public String toString() {
		
		return super.toString() + " / " + grade + " / " + classroom ;
		//super->person .toString()->Person의 toString 호출 
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

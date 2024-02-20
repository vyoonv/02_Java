package edu.kh.collection.pack1.model.vo;

public class Student implements Comparable<Student>{
	
	//필드 
	private String name; 
	private int age; 
	private String region; 
	private char gender; 
	private int score; 
	
	
	public Student() { } //기본 생성자 


	
	//getter/setter
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


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}

	
	//매개변수 생성자 
	public Student(String name, int age, String region, char gender, int score) {
		super();
		this.name = name;
		this.age = age;
		this.region = region;
		this.gender = gender;
		this.score = score;
	}


	//alt + shift + s -> s (generate toString)
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", region=" + region + ", gender=" + gender + ", score="
				+ score + "]";
	}



	@Override
	public int compareTo(Student other) {
		//나이를 기준으로 오름차순 정렬 
		return this.age - other.age;
		
		//나이를 기준으로 내림차순 정렬 
		//return other.age - this.age; 
		
	}

	
	

	
	
}

package edu.kh.oop.basic;

import java.util.Arrays;

public class MyClass {
	
	public void ex1() {
        System.out.println("너의 이름은?");
    }
	
	public int ex2(int num1, int num2) {
		return num1 + num2;
	}
	
	public void ex3(String name, int age) {
		 System.out.println("이름: " + name + ", 나이: " + age);
	}
	
	public String ex4(String name, boolean isActive) {
		if(isActive) {
			return name + "은 일하는중이다";
		}else {
			return name + "은 퇴근했다";
		}
	}
	
	
	public boolean ex5(String str) {
		return str.length() > 5 ? true : false;
	}
	
	
	public boolean getTitle(String title) {
		if(title.equals("아이언맨")) {
			return true;
		}else {
			return false;
		}
	}

	
	public String ex6() {
		
		if(getTitle("아쿠아맨")) {
			return "아이언맨 보고싶었는데..";
		} else {
			return "아이언맨 역시 굿";
		}
		
	}
	
	public String getInfo(String name1, String name2) { // 메서드의 정의
		
		String[] strArr = {name1, name2};
		return Arrays.toString(strArr); // [김나나, 홍길동]
		
		// Void methods cannot return a value
		// 
	}
	
	
	
	
	
	
	
	
	

	
	
	
	
	
}

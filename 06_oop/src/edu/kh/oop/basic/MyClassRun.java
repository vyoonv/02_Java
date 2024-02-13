package edu.kh.oop.basic;

import java.util.Scanner;

public class MyClassRun {
	public static void main(String[] args) {
		
		MyClass obj = new MyClass();
		
		// 다음 코드를 실행하면 어떤값이 나올까?
		
		// 1.
		obj.ex1(); // 너의 이름은?
		
		// 2.
		System.out.println(obj.ex2(5, 3)); // 8 
		
		// 3.
		obj.ex3("길동", 25); // 이름 : 길동, 나이 : 25
	
		// 4.
		System.out.println(obj.ex4("미현", true)); // 미현은 일하는 중이다!
		
		// 5.
		System.out.println(obj.ex5("집에가고싶다")); //  true
		
		// 6.
		System.out.println(obj.ex6()); // 아이언맨 역시 굿
		
		System.out.println("============================");
		
		/* getInfo() : 입력받은 이름 두개를 배열로 만들어 반환하는 메서드
		 * 				콘솔 출력 시 ["김나나", "홍길동"]
		 * 
		 * - getInfo() 정의와 호출을 해야함. 
		 * - 호출 시 입력받은 이름 두개를 전달인자로 전달할 것
		 * - getInfo() 메서드의 정의는 전달받은 매개변수 값을 이용할 것 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름1 : ");
		String n1 = sc.next();
		
		System.out.print("이름2 : ");
		String n2 = sc.next();
		
		
		System.out.println(obj.getInfo(n1, n2)); // 호출
		
		
		
		
		
		
		
		
		
		
		
	}
}

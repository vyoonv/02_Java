package com.kh.variable.practice2;

import java.util.Scanner;

public class Practice2 {
	
	public void ex1() {
		/*
		 * 
		 * 키보드로 문자 하나를 입력 받아 그 문자의 유니코드를 출력하세요.

			ex.
			문자 : A
			
			A unicode : 65
		 * 
		 * 
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자 : ");
		
		
		char result = sc.next().charAt(0);
		
		
		System.out.printf("%c unicode : %d", result, (int)result);
		
		
		
	}
}

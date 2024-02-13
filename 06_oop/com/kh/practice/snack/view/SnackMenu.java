package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {
	
	Scanner sc = new Scanner(System.in); 
	
	SnackController scr = new SnackController(); 
	
	
	
	public void menu() {
		
		
			System.out.println("스낵류를 입력하세요 : ");
			System.out.println("종류 : ");
			String kind = sc.next(); 
			System.out.println("이름 : ");
			String name = sc.next(); 
			System.out.println("맛 : ");
			String flavor = sc.next(); 
			System.out.println("개수 : ");
			int numOf = sc.nextInt(); 
			System.out.println("가격 : ");
			int price = sc.nextInt(); 


		
	}

}

package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Student;

public class Run {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		Student[] std = new Student[3]; 
		
		std[0] = new Student ("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과"); 
		std[1] = new Student ("김말똥", 21, 187.3, 80.0, 2, "경영학과"); 
		std[2] = new Student ("강개순", 23, 167.0, 45.0, 4, "정보통신학과"); 
		
		for (Student std1 : std) {
			System.out.println(std1.information());
		}
		
		Employee[] emps = new Employee[10];
		
		int count = 0; 
		
		while (true) {
			
			System.out.println("사원정보 입력");
			System.out.println("이름 : ");
			String name = sc.next(); 
			System.out.println("나이 : ");
			int age = sc.nextInt(); 
			System.out.println("키 : ");
			double height = sc.nextDouble(); 
			System.out.println("몸무게 : ");
			double weight = sc.nextDouble(); 
			System.out.println("급여 : ");
			int salary = sc.nextInt(); 
			System.out.println("부서 : ");
			String dept = sc.next(); 
			
			emps[count] = new Employee(name, age, height, weight, salary, dept); 
			count++; 
			
			System.out.println("계속 추가하시겠습니까? (y/n) : ");
			String str = sc.next().toUpperCase();
			
			if (str.equals("N")) break; 
	
			
		}	
		
		for (Employee emp : emps) {
			if (emp==null) break; 
			
			System.out.println(emp.information());
		}

		
		
		
		
	}

}

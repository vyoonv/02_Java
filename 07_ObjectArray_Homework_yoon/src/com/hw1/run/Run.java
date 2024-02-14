package com.hw1.run;

import java.util.Arrays;

import com.hw1.model.vo.Employee;

public class Run {
	
	public static void main(String[] args) {
		
		//객체 배열 크기 3으로 할당 3개 생성자 이용 객체 생성 후 출력 
		//3개 객체 중 값이 없는 필드에 각각 값을 넣은 뒤 출력 
		//직원 각각의 보너스가 적용된 1년 연봉 계산 출력 
		//연봉 = (급여 + (급여*보너스포인트))*12
		//3명의 직원 연봉 평균 
		
	
		
		Employee[] emp = new Employee[3]; 
	
	
		emp[0] = new Employee();
		
		emp[1] = new Employee(1, "홍길동", " " , " ", 19 ,
								'M', 0, 0.0, "01022223333", "서울 잠실");
		emp[2]= new Employee(2, "강말순", "교육부", "강사", 20, 'F', 
							1000000, 0.01, "01011112222", "서울 마곡"); 
		

		System.out.println("======================");
		System.out.println(emp[0].information());
		System.out.println(emp[1].information());
		System.out.println(emp[2].information());
		
		emp[0] = new Employee(0, "김말똥", "영업부", "팀장", 30, 
							'M', 3000000, 0.2, "01055559999", "전라도 광주"); 
		
		emp[1] = new Employee(1, "홍길동", "영업부", "팀장", 30, 
								'M', 4000000, 0.3, "01022223333", "서울 잠실"); 
		
		
		System.out.println("======================");
		System.out.println(emp[0].information());
		System.out.println(emp[1].information());
		
		int salary1 = (emp[0].getSalary() + (int)( emp[0].getSalary() * emp[0].getBonusPoint() ) ) * 12 ; 
		int salary2 = (emp[1].getSalary() + (int)( emp[1].getSalary() * emp[1].getBonusPoint() ) ) * 12 ; 
		int salary3 = (emp[2].getSalary() + (int)( emp[2].getSalary() * emp[2].getBonusPoint() ) ) * 12 ; 
		
		System.out.println(emp[0].getEmpName() + "의 연봉 : " + salary1);
		System.out.println(emp[1].getEmpName() + "의 연봉 : " + salary2);
		System.out.println(emp[2].getEmpName() + "의 연봉 : " + salary3);
		
		int avg = (salary1+salary2+salary3) / 3 ; 
		
		System.out.println("===========================");
		
		System.out.println("직원들의 연봉의 평균 : " + avg + "원");
		
		
		
		
		
		
		
		
//		for (int i=0; i<emp.length; i++) {
//			System.out.println( "emp[" + i + "]:" + emp[i].information() );
//		}
//		
//		
//		
//		emp[0].setEmpNo(0);
//		emp[0].setEmpName("김말똥");
//		emp[0].setDept("영업부");
//		emp[0].setJob("팀장");
//		emp[0].setAge(30);
//		emp[0].setGender('M'); 
//		emp[0].setSalary(3000000);
//		emp[0].setBonusPoint(0.2);
//		emp[0].setPhone("01055559999");
//		emp[0].setAddress("전라도 광주");
//		
//		int sum = 0; 
//		
//		for (int = 0; i<emp.length; i++) {
//			int sumSalary = (int) (emp[i].getSalary() + (emp[i].getSalary() * emp[i].getBonusPoint()) ) * 12 ; 
//		
//		System.out.println((emp[i].getEmpName()+"의 연봉 : "+ sumSalary + "원"));
//		
//		sum += sumSalary; 
//		
//		}
//		
//		System.out.println("직원 연봉의 평균 : " + sum/emp.length + "원");
//		
	}

}

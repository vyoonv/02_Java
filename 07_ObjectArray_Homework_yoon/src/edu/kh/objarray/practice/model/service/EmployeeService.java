package edu.kh.objarray.practice.model.service;

import java.util.Scanner;

import edu.kh.objarray.practice.model.vo.Employee;

public class EmployeeService {
	
	
	private Employee[] employees = new Employee[3]; 
	
	private Scanner sc = new Scanner(System.in); 
	
	public void displayMenu() {
		
		int sel = 0; 
		
		do {
			
			System.out.println("=== 직원 관리 프로그램 ===");
			System.out.println("1. 직원 정보 입력(3명)");
			System.out.println("2. 모든 직원 정보 출력");
			System.out.println("3. 특정 직원 정보 출력(이름 검색)");
			System.out.println("4. 특정 직원 급여/연봉 출력(사번 검색)");
			System.out.println("5. 모든 직원 급여 합/연봉 합 출력");
			System.out.println("6. 모든 직원중 급여가 가장 높은 직원의 이름, 부서, 급여 출력");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 >> ");
			sel = sc.nextInt();
			sc.nextLine();
			
			switch (sel) {
			case 1:  break;
			case 2:  break;
			case 3:  break;
			case 4:  break;
			case 5:  break;
			case 6:  break;
			case 0: System.out.println("프로그램 종료."); break;

			default: System.out.println("잘못 입력하셨습니다.");
			
			}
			
		}
		
		while(sel != 0); 
	
	}
	

	
	public void initEmployee(String emNum, String emName, 
			String dept, String job, int salary) {
		
	}

	public String allEmployeesInformation() {
		return null; 
	}

	public String searchEmployee() {
		
		return null;
	}
	
	
	public String salaryCheck() {
		
		return null;
	}
	
	
	public int allSalaryCheck() {
		
		return 0;
	}
	
	
	public void topSalaryEmployee() {
	
		
	}
	
	
	
	
	
	
}
	



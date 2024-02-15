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
			case 1: initEmployee(); break;
			case 2: System.out.println(allEmployeesInformation()); break;
			case 3: System.out.println(searchEmployee()); break;
			case 4: System.out.println(salaryCheck()); break;
			case 5: allSalaryCheck(); break;
			case 6: topSalaryEmployee();  break;
			case 0: System.out.println("프로그램 종료."); break;

			default: System.out.println("잘못 입력하셨습니다.");
			
			}
			
		}
		
		while(sel != 0); 
	
	}
	

	
	public void initEmployee() {
		
		int input = 0; 
			
		System.out.println("=====1번째 사원정보 입력=====");
		System.out.println("사번 : ");
		int emNum1 = sc.nextInt(); 
		sc.nextLine(); 
		System.out.println("이름 : ");
		String emName1 = sc.nextLine(); 
		System.out.println("부서 : ");
		String dept1 = sc.next(); 
		System.out.println("직급 : ");
		String job1 = sc.next(); 
		System.out.println("급여 : ");
		int salary1 = sc.nextInt(); 
		
	
		System.out.println("=====2번째 사원정보 입력=====");
		System.out.println("사번 : ");
		int emNum2 = sc.nextInt(); 
		sc.nextLine(); 
		System.out.println("이름 : ");
		String emName2 = sc.nextLine(); 
		System.out.println("부서 : ");
		String dept2 = sc.next(); 
		System.out.println("직급 : ");
		String job2 = sc.next(); 
		System.out.println("급여 : ");
		int salary2 = sc.nextInt(); 
		
		
		System.out.println("=====3번째 사원정보 입력=====");
		System.out.println("사번 : ");
		int emNum3 = sc.nextInt(); 
		sc.nextLine(); 
		System.out.println("이름 : ");
		String emName3 = sc.nextLine(); 
		System.out.println("부서 : ");
		String dept3 = sc.next(); 
		System.out.println("직급 : ");
		String job3 = sc.next(); 
		System.out.println("급여 : ");
		int salary3 = sc.nextInt();
		
		
		employees[input] = new Employee (); 
		
	}

	public String allEmployeesInformation() {
		
		System.out.println("=====모든 직원 정보 조회=====");
		
		for(int i=0; i<employees.length; i++) {
			System.out.println(employees[i].information());
		}
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
	



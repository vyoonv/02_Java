package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;

public class Company implements ManagementSystem{
	
	
	private Employee[] employees ; 
	
	private int employeeCount; 
	
	public Company(int size) {
		
		//매개 변수로 전달받은 size를 이용해 객체 배열은 size크기로 생성
		
		this.employees = new Employee[size]; 
		this.employeeCount = 0; 
		
		
		
	}

	@Override
	public void addPerson(Person person) {
		
		//person 객체가 Employee 클래스의 인스턴스이며 
		//배열에 공간이 있다면 해당 객체를 employees 배열에 추가 후 추가된 객체정보 출력
		//공간 없으면 인원 충원되었다는 메시지 출력
		
		if(person instanceof Employee && employeeCount < employees.length) {
			
			employees[employeeCount++] = (Employee) person; 
			System.out.println("직원이 추가되었습니다 - " + person.getInfo());
			
		}	else {
			
			System.out.println("인원이 모두 충원되었습니다.");
		}
		
		
	}

	@Override
	public void removePerson(String id) {
		
		//매개변수로 전달 받은 id와 일치하는 직원을 찾으면 해당 직원 삭제하고, 관련 정보를 출력
		//일치하는 id가 없다면 해당 id를 가진 직원을 찾을 수 없다는 메시지 출력 
		for (int i = 0; i<employeeCount; i++) {
			if (employees[i].getId().equals(id)) {
				System.out.println("직원이 삭제되었습니다 - " + employees[i].getInfo());
				employees[i] = null; 
				for (int j=i; j<employeeCount - 1; j++) {
					employees[j] = employees[j+1];
				}
				employees[--employeeCount] = null; 
				return; 
			}
			else {
				System.out.println("ID : " + id + "인 직원을 찾을 수 없습니다." );
			}
		}
		
		
		

		
		
	}

	@Override
	public void displayAllPersons() {
		
		System.out.println("전체 직원 명단 : ");
		
		for (int i = 0; i<employeeCount; i++) {
			System.out.println(employees[i].getInfo());
		}
	
		
	}

	
	
	
	

}

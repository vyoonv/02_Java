package com.hw2.model.service;

import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;

public class Prison implements ManagementSystem {
	
	private Prisoner[] prisoners; 
	
	private int prisonerCount; 
	
	public Prison(int size) {
		
		this.prisoners = new Prisoner[size]; 
		this.prisonerCount = 0; 
		
	}

	@Override
	public void addPerson(Person person) {
		
		//매개변수로 전달받은 Person 객체가  Prisoner 클래스의 인스턴스이며 
		//배열에 공간이 있다면 해당 객체를  prisoners  배열에 추가 후 추가된 객체 정보 출력
		//배열에 더이상 공간이 없다면 인원이 모두 충원되었다는 메세지 출력 
	
		if(person instanceof Prisoner && prisonerCount < prisoners.length) {
			
			prisoners[prisonerCount++]= (Prisoner) person; 
			System.out.println("수감자가 추가되었습니다 - " + person.getInfo());

			} else {
				
				System.out.println("수용소가 만실 상태입니다.");

		}
		
		
		
	}

	@Override
	public void removePerson(String id) {
		
		for (int i = 0; i<prisonerCount; i++) {
		
		if(prisoners[i].getId().equals(id)) {
			
			System.out.println("수감자가 삭제되었습니다 - " + prisoners[i].getInfo()); 
			
			prisoners[i] = null; 
			
			for (int j=i; j<prisonerCount - 1; j++) {
				
				prisoners[j] = prisoners[j+1]; 
				
			}
			
			prisoners[--prisonerCount] = null; 
			return; 
			
		}
		
	}
		System.out.println("ID : "+ id + "인 직원을 찾을 수 없습니다.");
	
		
	}

	@Override
	public void displayAllPersons() {
		
		System.out.println("전체 수감자 명단 : ");
		for (int i=0; i<prisonerCount; i++) {
			
			System.out.println(prisoners[i].getInfo());
		}
		
	}
	

}

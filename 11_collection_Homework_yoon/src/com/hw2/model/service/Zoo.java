package com.hw2.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hw2.model.dto.Animal;
import com.hw2.model.dto.Monkey;
import com.hw2.model.dto.Tiger;

public class Zoo {
	
	Scanner sc = new Scanner(System.in); 

	private List<Animal> animals;  //= new ArrayList<Animal>(); 
	
	public Zoo() {	
		animals = new ArrayList<Animal>(); 

	}
	
	public void addAnimal(Animal animal) {
		
		animals.add(animal); 

	
	}
	
	public void showAnimals() {
		
		System.out.println("동물들의 울음소리를 들어보세요");
	
		for(Animal ani : animals) {

			ani.sound();
			
		}
		
	}
	
	public void displayMenu() {
		
			
		int menuNum = 0; 
		
		do {
			
			System.out.println("***** KH 동물원 *****");			
			System.out.println("원하는 작업을 선택하세요 : ");		
			System.out.println("1. 동물들의 울음소리 듣기");
			System.out.println("2. 종료");
			System.out.println("선택 : ");
			menuNum = sc.nextInt(); 
			
			
			switch(menuNum){
			
			case 1 : showAnimals(); break; 
			case 2 : System.out.println("종료"); break; 
			default : System.out.println("입력 가능한 메뉴를 선택해주세요");

			}
			
			
		} while(menuNum != 2); 
		
		
		
	}
	
	

	}



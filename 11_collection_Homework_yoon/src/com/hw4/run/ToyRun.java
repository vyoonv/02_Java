package com.hw4.run;

import com.hw4.model.service.ToyFactory;
import com.hw4.model.service.ToyFactoryA;

public class ToyRun {
	
	public static void main(String[] args) {
	
//		ToyFactory factory = new ToyFactory(); 
//		
//		factory.displayMenu();
		
		ToyFactoryA factoryA = new ToyFactoryA(); 
		
		factoryA.displayMenu();
		
	}

}

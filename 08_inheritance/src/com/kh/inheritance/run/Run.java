package com.kh.inheritance.run;

import com.kh.inheritance.model.dto.BasicPhone;
import com.kh.inheritance.model.dto.SmartPhone;

public class Run {
	
	public static void main(String[] args) {
		
		SmartPhone SP = new SmartPhone(); 
		
		//SmartPhone SP = new SmartPhone("Samsung", "Galaxy S20",...);
		
		SP.setBrand("Samsung");
		SP.setModel("Galaxy S20");
		SP.setYear(2020);
		SP.setPrice(1200000);
		SP.setOperatingSystem("Android"); 
		SP.setStorageCapacity(128);
		
		SP.printInfo();
		System.out.println("=============================");
		
		
		BasicPhone BP = new BasicPhone(); 
		BP.setBrand("Nokia");
		BP.setModel("3310");
		BP.setYear(2000);
		BP.setPrice(100000);
		BP.setHasPhysicalKeyboard(false);
		
		BP.printInfo();		
		BP.checkKeyboard();
		
		
		
	}
	
	
	
	
	
	

}

package com.hw2.model.service;

import com.hw2.model.dto.Person;

public interface ManagementSystem {
	
	public void addPerson(Person person);
	
	public void removePerson(String id); 
	
	
	
	
	public void displayAllPersons(); 
	
	

}

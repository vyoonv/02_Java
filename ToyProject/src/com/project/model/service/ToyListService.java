package com.project.model.service;

import java.util.List;
import java.util.Map;

import com.project.model.Toy;

public interface ToyListService {
	
	public abstract Map<String, List<Toy>> displayToyType() ;

	public abstract int addDIYToy(String type, String name, String content) throws Exception;

	public abstract boolean UpdateDIYToy(String type, String name, String content) throws Exception;

	public abstract String deleteDIYToy(int index) throws Exception; 
	


}

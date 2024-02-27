package com.project.model.dao;

import java.util.List;

import com.project.model.Toy;

public interface ToyListDAO {
	
	void saveFile() throws Exception;

	List<Toy> displayToyType();

	int addDIYToy(Toy toy) throws Exception;

	Boolean UpdateDIYToy(String type, String name, String content) throws Exception;

	Toy deleteDIYToy(int index) throws Exception;


}

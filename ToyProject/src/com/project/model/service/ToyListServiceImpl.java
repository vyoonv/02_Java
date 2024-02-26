package com.project.model.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.model.Toy;
import com.project.model.dao.ToyListDAO;
import com.project.model.dao.ToyListDAOImpl;

public class ToyListServiceImpl implements ToyListService {
	
		private ToyListDAO dao = null; 

		public ToyListServiceImpl() throws FileNotFoundException, IOException, ClassNotFoundException{
			dao = new ToyListDAOImpl(); 
		}

		@Override
		public Map<String, List<Toy>> displayToyType() {
			
			List<Toy> toyList = dao.displayToyType(); 
			
			Map<String, List<Toy>> toysByType = new HashMap<String, List<Toy>>(); 
			toysByType.put("toyType", toyList);
			
			return toysByType; 
			
			
		}

		@Override
		public int addDIYToy(String type, String name, String content) throws Exception {
			Toy toy = new Toy(type, name, content); 
			
			int index = dao.addDIYToy(toy); 
			
			return index; 
		}

		@Override
		public boolean UpdateDIYToy(String type, String name, String content) throws Exception {
			
			return dao.UpdateDIYToy(type, name, content);
		}

		@Override
		public String todoDelete(int index) throws Exception {
			Toy toy = dao.deleteDIYToy(index); 
			
			if(toy == null) return null; 
			
			return toy.getName();
		}





	
	
	

}

package com.project.model.dao;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Toy;

public class ToyListDAOImpl implements ToyListDAO{
	
	private final String FILE_PATH = "/io_test/ToyList.dat"; 

	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null; 
	
	private List<Toy> toyList = null; 
	

	public ToyListDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
	
		File file = new File(FILE_PATH);
		
		if(file.exists()) {
			try {				

				ois = new ObjectInputStream(new FileInputStream(FILE_PATH)); 
				toyList = (ArrayList)ois.readObject(); 
		
			} finally {
				if(ois != null) ois.close();
				
			}
			
			
		} else { 
			File directory = new File("/io_test"); 
			if(!directory.exists()) directory.mkdir(); 		

			toyList = new ArrayList<Toy>();
			
			toyList.add(new Toy("인형", "티니핑", "크기 : 18cm, 색상 : 분홍색, 가격 : 17,000원")); 
			toyList.add(new Toy("인형", "팡팡이", "크기 : 20cm, 색상 : 검정색/흰색, 가격 : 8,000원")); 
			toyList.add(new Toy("인형", "미미", "크기 : 15cm, 색상 : 노랑색, 가격 : 15,000원")); 
			toyList.add(new Toy("자동차", "레이몬", "크기 : 11cm, 색상 : 파랑색, 가격 : 7,500원")); 
			toyList.add(new Toy("자동차", "미니몬", "크기 : 11cm, 색상 : 초록색, 가격 : 7,500원")); 
			toyList.add(new Toy("자동차", "일렉몬", "크기 : 11cm, 색상 : 보라색, 가격 : 7,500원")); 
			toyList.add(new Toy("로봇", "로보카폴리", "크기 : 13cm, 색상 : 파랑색, 가격 : 12,500원")); 
			toyList.add(new Toy("로봇", "변신레오", "크기 : 12cm, 색상 : 주황색, 가격 : 24,500원")); 
			toyList.add(new Toy("로봇", "코코몽", "크기 : 11cm, 색상 : 빨강색, 가격 : 47,000원")); 
			
			
			try {

			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(toyList); 
			} 
				finally {
			
					if(oos != null) oos.close(); }
			
			System.out.println("*** ToyList.dat 파일 생성 완료 ***");
		}

 
	}


	@Override
	public void saveFile() throws Exception {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(toyList); 
		
		} finally {
			
			oos.close();
		}
		
	}


	@Override
	public List<Toy> displayToyType() {
		
		return toyList;
	}


	@Override
	public int addDIYToy(Toy toy) throws Exception {
		
		if(toyList.add(toy)) {
			saveFile(); 
			
			return toyList.size()-1; 
		}
		
		return -1;
	}


	@Override
	public Boolean UpdateDIYToy(String type, String name, String content) throws Exception {
		
		Toy toy = new Toy (type, name, content); 
		
		if(toyList.set(0, toy) != null ) {
			saveFile(); 
			return true; 
		}
		return false; 
	}


	@Override
	public Toy deleteDIYToy(int index) throws Exception {
		if(index<0 || index>= toyList.size()) return null; 
		
		Toy toy = toyList.remove(index); 
		
		saveFile(); 
		return toy;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

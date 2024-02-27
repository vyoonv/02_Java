package hw.project.model.idol.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import hw.project.model.idol.dto.Idol;

public class IdolDAOImpl implements IdolDAO{
	
private final String FILE_BOARD_PATH = "\\io_test\\Idol.dat";
	
	private ObjectInputStream ois = null; // 객체 입력 스트림
	private ObjectOutputStream oos = null; // 객체 출력 스트림
	
	private List<Idol> idolList = null; // 리스트 참조 변수
	
	public IdolDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File file = new File(FILE_BOARD_PATH);
		
		if(file.exists()) { // 파일이 존재하면
			
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_BOARD_PATH));
				
				idolList = (ArrayList<Idol>)ois.readObject();
			} finally {
				
				if(ois != null) {
					ois.close();
				}
				
			}
			
		}else {
			
			File directory = new File("\\io_test");
			if(!directory.exists()) {
				directory.mkdir();
			}
			
			// 처음에 들어가 있는 게시물 작성
			
			idolList = new ArrayList<Idol>();
			
			idolList.add(new Idol("민지", 900000, 100000, "NewJeans", "UK Garage"));
			idolList.add(new Idol("하니", 700000, 80000, "OMG", "hiphopR&B"));
			idolList.add(new Idol("다니엘", 5700000, 70000, "Ditto", "Baltimore"));
			idolList.add(new Idol("해린", 1000000, 150000, "HypeBoy", "Moombahton"));
			idolList.add(new Idol("혜인", 800000, 90000, "Attention", "Teen"));
			
			
			try {
				oos = new ObjectOutputStream(new FileOutputStream(FILE_BOARD_PATH));
				oos.writeObject(idolList);
			}finally {
				
				if(oos != null) {
					oos.close();
				}
				
			}
			
			System.out.println("======= Idol.dat 파일 생성 완료 =======");
			
		}
	}
	
	
	public void saveFile()throws Exception {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_BOARD_PATH));
			
			oos.writeObject(idolList);
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			oos.close();
		}
		
	}
	


	@Override
	public List<Idol> displayIdolList() {
		
		return idolList;
	}


	@Override
	public void createIdol(String name, int revenue, int fanNum, String albumTitle, String albumConcept)
			throws Exception {
		
		idolList.add(new Idol(name, revenue, fanNum, albumTitle, albumConcept)); 
		saveFile(); 
		
		
	}




}

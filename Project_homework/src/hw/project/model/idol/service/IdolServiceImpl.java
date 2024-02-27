package hw.project.model.idol.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import hw.project.model.idol.dao.IdolDAO;
import hw.project.model.idol.dao.IdolDAOImpl;
import hw.project.model.idol.dto.Idol;

public class IdolServiceImpl implements IdolService  {
	
	private IdolDAO dao = null;
	
	public IdolServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		
		dao = new IdolDAOImpl();
	}

	@Override
	public List<Idol> displayIdolList() {
		
		List<Idol> idolList = dao.displayIdolList(); 
		return idolList;
	}

	@Override
	public void createIdol(String name, int revenue, int fanNum, String albumTitle, String albumConcept) throws Exception {
		
		dao.createIdol(name, revenue, fanNum, albumTitle, albumConcept); 
		
	}




}

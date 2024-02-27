package hw.project.model.idol.dao;

import java.util.List;

import hw.project.model.idol.dto.Idol;

public interface IdolDAO {

	List<Idol> displayIdolList();

	void createIdol(String name, int revenue, int fanNum, String albumTitle, String albumConcept) throws Exception;
	

}

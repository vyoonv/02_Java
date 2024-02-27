package hw.project.model.idol.service;

import java.util.List;

import hw.project.model.idol.dto.Idol;

public interface IdolService {

	List<Idol> displayIdolList();

	void createIdol(String name, int revenue, int fanNum, String albumTitle, String albumConcept) throws Exception;

//	boolean deleteMember(String inputMem) throws Exception;


}

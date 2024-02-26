package com.project.model;

import java.io.Serializable;

public class Toy implements Serializable {
	
	
	/*	토이 프로젝트 

		추가, 조회, 수정, 삭제 필요 
		model - DAO
		view - View 
		controller/service - Service
		
		장난감 종류별 조회 
		인형 / 차 / 레고 / DIY
		
		DIY 장난감 추가 / 수정 / 삭제 
	*/
	
	
	private String toyType; //장난감 종류 
	private String name; //장난감 이름 
	private String detail; //장난감 세부 정보  
	
	public Toy() {}

	public String getToyType() {
		return toyType;
	}

	public void setToyType(String toyType) {
		this.toyType = toyType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Toy(String toyType, String name, String detail) {
		super();
		this.toyType = toyType;
		this.name = name;
		this.detail = detail;
	}
	
	
	@Override
	public String toString() {

		return "Toy [toyType : " + toyType + "/ name : " + name + "/ detail : " + detail + "]" ;
		
	}
	

}

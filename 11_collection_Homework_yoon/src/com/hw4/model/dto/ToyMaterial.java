package com.hw4.model.dto;

public class ToyMaterial {

	private int mtrNum;
	private String mtrName;
	

	
	public int getMtrNum() {
		return mtrNum;
	}



	public void setMtrNum(int mtrNum) {
		this.mtrNum = mtrNum;
	}



	public String getMtrName() {
		return mtrName;
	}



	public void setMtrName(String mtrName) {
		this.mtrName = mtrName;
	}


	
	
	

	public ToyMaterial(int mtrNum, String mtrName) {
		super();
		this.mtrNum = mtrNum;
		this.mtrName = mtrName;
	}



	@Override
	public String toString() {

		return mtrNum + ": " + mtrName ;
	}
	
	
	
	
}

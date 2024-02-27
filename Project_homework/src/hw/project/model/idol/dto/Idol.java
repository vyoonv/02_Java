package hw.project.model.idol.dto;

import java.io.Serializable;

public class Idol implements Serializable{
	

	private String memberName; 
	private int revenue; 
	private int fanNum;
	private String albumTitle; 
	private String albumConcept; 
	
	
	public Idol() {}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public int getRevenue() {
		return revenue;
	}


	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}


	public int getFanNum() {
		return fanNum;
	}


	public void setFanNum(int fanNum) {
		this.fanNum = fanNum;
	}


	public String getAlbumTitle() {
		return albumTitle;
	}


	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}


	public String getAlbumConcept() {
		return albumConcept;
	}


	public void setAlbumConcept(String albumConcept) {
		this.albumConcept = albumConcept;
	}


	public Idol(String memberName, int revenue, int fanNum, String albumTitle, String albumConcept) {
		super();
		this.memberName = memberName;
		this.revenue = revenue;
		this.fanNum = fanNum;
		this.albumTitle = albumTitle;
		this.albumConcept = albumConcept;
	}


	@Override
	public String toString() {
		return "[Member : " + memberName + " / Income : " + revenue + " / Followers : " + fanNum + " / AlbumTitle : "
				+ albumTitle + " / AlbumConcept : " + albumConcept + "]";
	}






	
	

	
	
	
	
	

}

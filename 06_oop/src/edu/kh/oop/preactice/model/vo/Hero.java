package edu.kh.oop.preactice.model.vo;

public class Hero {
	
	
//	
//	private String nickName ;
//	private String job ; 
//	private int hp ;
//	private int mp ;
//	private int level ; 
//	private int exp ;
//	
//	public String getNickName() {
//		return nickName;
//	}
//	public void setNickName(String nickName) {
//		this.nickName = nickName;
//	}
//	public String getJob() {
//		return job;
//	}
//	public void setJob(String job) {
//		this.job = job;
//	}
//	public int getHp() {
//		return hp;
//	}
//	public void setHp(int hp) {
//		this.hp = hp;
//	}
//	public int getMp() {
//		return mp;
//	}
//	public void setMp(int mp) {
//		this.mp = mp;
//	}
//	public int getLevel() {
//		return level;
//	}
//	public void setLevel(int level) {
//		this.level = level;
//	}
//	public int getExp() {
//		return exp;
//	}
//	public void setExp(int exp) {
//		this.exp = exp;
//	}
//	
//	public void attack(int exp) {	
//		System.out.println(nickName + "은/는 공격을 했다!");
//		Scanner sc = new Scanner(System.in);
//		System.out.println(exp);	
//		int input = sc.nextInt() ; 
//				
//		 for(int i= 0; i<exp; i++) {
//			  
//			  if (i>=500) { 
//			  int level = 0; 
//			
//			  }
//			 
//		 }
//		
//
//		
//	}
//	
//	public void magicJump() {
//		
//	}
//	
	
	//속성
	
	private String nickName; 
	private String job;
	private int hp; //체력
	private int mp; //마력
	private int level; 
	private int exp; //경험치 
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	//필드 == 멤버 변수 
	//기능
	//attack(exp)
	
	public void attack(int exp) {
		System.out.println(nickName + "은/는 공격을 했다");
		//전달받은 경험치 현재 경험치에 누적
		this.exp += exp; 
		//매개변수와 필드에 있는 변수 같을때 this.변수명 으로 불러옴
		if(this.exp > 500) {
			level += 1; //경험치가 500 넘었을 때 레벨 1씩 올리기
			System.out.println("레벨이 올랐습니다 현재 레벨 : " + level);
		}
		
	}
	
	//magicJump()
	public void magicJump() {
		if(mp<=0) {
			System.out.println("더이상 매직점프 할 수 없습니다");
		} else {
			mp -= 10; 
			System.out.println(nickName + "의 점프!");
		}
	}
	
}
	

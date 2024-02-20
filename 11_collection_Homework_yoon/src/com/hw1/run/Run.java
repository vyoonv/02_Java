package com.hw1.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hw1.model.dto.Friend;

public class Run {

	public static void main(String[] args) {
		
		//Friend 객체만 넣을 수 있는 ArrayList 객체 생성
		//< >리스트에 들어올 수 있는 타입 제한 
		List<Friend> fLeader = new ArrayList<Friend>(); 
		
		//객체 생성하여 ArrayList에 추가하기 
		
		//리스트에 객체 추가하는 방법 
		// 	 1)	
		fLeader.add(new Friend ("짱구")); 
		fLeader.add(new Friend ("철수")); 
		fLeader.add(new Friend ("유리")); 
		fLeader.add(new Friend ("훈이")); 
		fLeader.add(new Friend ("맹구")); 
	
		
		// 2)
		// Collections.addAll(); 
		/*
		Collections.addAll(fLeader, new Friend ("짱구"), new Friend ("철수"), new Friend ("유리"),
				new Friend ("훈이"), new Friend ("맹구")); 
		*/
		
		//3) 
		//List.of() : java 9 이상 버전에서 사용 가능 
		/*
		 * List<Friend> fLeader = List.of(new Friend ("짱구"), new Friend ("철수"), new Friend ("유리"),
	
				new Friend ("훈이"), new Friend ("맹구")); 
		*/
		
		
		//랜덤으로 골목대장 뽑기 
		//Random random = new Random();   : 난수 생성하는 클래스 
		
		int randomIndex = (int)(Math.random() * fLeader.size()); 
			//0~4
		
		Friend leader = fLeader.get(randomIndex); 
		
		leader.pickLeader(); 
		
		
	
	
				
		
		
		
	}
}

package edu.kh.lambda.test.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.kh.lambda.test.LambdaTest;

public class TestRun {
	
	
	public static void main(String[] args) {
		
		LambdaTest lt = new LambdaTest();
		lt.ex();
		
		
		System.out.println("-----------------------------------");
		
		//Comparator의 compare 메서드를 람다식으로 대체하여 사용해보기 
		
		//숫자 리스트 생성
		List<Integer>numbers = new ArrayList<>(); 
		numbers.add(7); 
		numbers.add(0); 
		numbers.add(9); 
		numbers.add(3);
		
		System.out.println("정렬 전 : " + numbers);
		Collections.sort(numbers, (a, b ) -> a - b );
		System.out.println("정렬 후 : " + numbers);
		
		System.out.println("==============================");
		
		//Runnable 인터페이스를 람다식 구현 
		Runnable runnable = () -> {
			
			//이안에 run()에서 수행할 코드를 작성 
			System.out.println("Hello, Lambda!");
						
		} ; 
		
		//스레드 생성 및 시작 
		Thread thread = new Thread(runnable); 
		thread.start();
		
		
		
		
		
//		서버 서비스를 제공하는 프로그램 /컴퓨터 
//
//		클라이언트  서비스를 요청하여 제공받은 서비스를 사용하는 프로그램 /컴퓨터 
//
//		포트 1~65535번까지 
//		0~1023(이미 사용되고 있는 것들)
//
//
//		TCP (전달을 제어하는 규약/데이터 정확성/신뢰적인 전송방식, 실패시 재전송 기능 있음)
//		UDP (빠른 전달 목적/스트리밍 등/비신뢰적인 전송방식, 단순히 보내기만 함)
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

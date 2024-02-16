package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.vo.Car;
import edu.kh.poly.ex1.model.vo.Spark;
import edu.kh.poly.ex1.model.vo.Tesla;

public class PolyService {
	
	
	
	public void ex1() {
		//다형성 확인 예제 
		
		//Car 객체 생성 
		Car car = new Car(); 
		//부모 타입 참조변수 = 부모객체 
		
		//Tesla 객체 생성 
		Tesla tesla = new Tesla(); 
		//자식 타입 참조변수 = 자식객체 
		
		//*********다형성**********
		//부모 타입 참조변수 = 자식객체 
		Car car2 = new Tesla(); //오류 발생 없음 
		//테슬라 객체를 참조하는 변수의 타입이 Car(부모)
		//Tesla 객체가 Car 객체로 변화함 
		
		Car car3 = new Spark();
		
		
		// ***** 다형성(업캐스팅) 작성 방법 *****
		// 1) 자식 객체가 부모 객체로 변하였기 때문에 자식만의 고유한 필드, 메서드를 사용할 수 없다. 
		
		// 1-1) car (부모 = 부모)
		car.setEngine("v6 6기통 엔진");
		car.setFuel("휘발유");
		car.setWheel(4);
		// Car 메서드 모두 사용 가능 
		
		//1-2) tesla (자식 = 자식) 
		tesla.setEngine("전기모터");
		tesla.setFuel("전기");
		tesla.setWheel(4);
		tesla.setBatteryCapacity(1000000);
		//부모, 본인의 메서드 모두 사용 가능 
		
		//1-3) car2 (부모 = 자식(tesla))
		car2.setEngine("전기모터");
		car2.setFuel("전기");
		car2.setWheel(4);
		//car2.setBatteryCapacity(1000000); is undefined for the type car 
		
		//car3 (부모 = 자식(Spark()) 
		//Car car3 = new Spark(); 
		car3.setEngine("경차 엔진");
		car3.setWheel(4);
		car3.setFuel("휘발유");
		//car3.setDiscountOffer(0.5); ->부모 것만 사용 가능하고 본인 것은 사용 못함 
		
		//------------------------------------------
		
		// 2) 다형성을 이용한 객체배열 
		
		// 객체 배열 : 같은 객체 참조 자료형의 변수를 하나의 묶음으로 다루는 것 
				     //부모 타입 잠조 자료형의 변수를 하나의 묶음으로 다루는 것 
		
		Car[] arr = new Car[3]; // 부모타입 참조변수 배열 선언 및 할당 
		//각 배열 요소 Car 타입 참조변수 
		
		arr[0] = car; // Car 주소 
		
		arr[1] = car2; //Tesla 주소 
		
		arr[2] = car3; //Spark 주소 
		
		for(int i=0; i<arr.length; i++) {			
			System.out.println(i + "번 째 인덱스의 엔진 : " + arr[i].getEngine());						
		}
		//상속 + 다형성 
		//상속 특징 : Car 상속 클래스는 모두 getEngine()을 가지고 있다를 정의 
		//다형성(업캐스팅) : 부모타입 참조변수 arr[i]로 자식 객체를 참조할 수 있다. 
	
		
	}
	
	
	// 전달받은 Car 또는 자식객체의 엔진, 연료, 바퀴갯수를 출력하는 메서드 
	// 매개변수의 부모타입 참조변수를 작성하면 모든 자식객체를 전달받을 수 있음
	public void printCar(Car temp) {
		//부모 타입 참조변수 = 자식타입객체 
		//다형성의 업캐스팅 모양과 같음
		//->temp에는 tesla, spark, car의 주소가 넘어와도 ok(업캐스팅)
		
		System.out.println("엔진 : " + temp.getEngine());
		System.out.println("연료 : " + temp.getFuel());
		System.out.println("바퀴갯수 : " + temp.getWheel() + "개");
		System.out.println(); //줄바꿈 
		
	}
	
	
	public Car createCar(int num) {
		
		Car result = null; 
		
		switch(num) {
		case 1 : result = new Car(); break; 
		case 2 : result = new Tesla(); break; 
		case 3 : result = new Spark(); break; 
		}
		
		return result; 
		
	}

	
	public void ex2() {
		
		//다형성(업캐스팅)을 이용한 매개변수 사용법 
		Tesla t = new Tesla("전기모터", "전기", 4, 1000000);
		
		Spark s = new Spark("경차엔진", "휘발유", 4, 0.5); 
		
		Car c = new Car("경유엔진", "경유", 12); 
		
		printCar(t); //Tesla 
		printCar(s); //Spark
		printCar(c); //Car 
		
		System.out.println("---------------------------------");
		
		// 다형성을 이용한 반환형 사용법 
		
		//Car[] arr = { new Car(), new Tesla(), new Spark() };
		Car[] arr = { createCar(1), createCar(2), createCar(3) }; 
					//Car  			//Car(Tesla)	//Car(Spark)
		
		//instanceof 연산자 : 객체의 자료형을 검사하는 연산자 
		// -> 참조하는 객체가 특정 자료형이거나 부모쪽 상속관계인지 확인 
		
		System.out.println(arr[1] instanceof Tesla); //true
		System.out.println(arr[1] instanceof Spark); //false
		System.out.println(arr[1] instanceof Car); //true
		
					
	}
	
	
	public void ex3() {
		
		//*****다형성 중 다운캐스팅*****
		
		//다운 캐스팅이란?
		//부모타입 참조변수가 자식객체를 참조하는 기술로 
		//업캐스팅 상태에서만 진행할 수 있다. 
		//부모타입을 자식타입으로 "강제 형변환" 해서 
		//자식객체의 본래 필드, 메서드를 사용 가능하게 한다. 
		
		Car c1 = new Tesla("전기모터", "전기", 4, 50000); 
		//업 캐스팅 상태 
		
		System.out.println( ((Tesla)c1).getBatteryCapacity() );
		// ! 주의 ! " . " 연산자가 
		//(Tesla) 형변환 연산자보다 우선순위가 높기 때문에  ((Tesla)c1). 으로 형변환 
		
		Tesla t1 = (Tesla)c1; 
		
		System.out.println( t1.getBatteryCapacity() );
				
		
	}
	
	
	public void ex4() {
		//다운 캐스팅 주의사항!
		
		
		Car c1 = new Tesla(); 
		
		// Spark s1 = (Spark)c1; //실행시 오류  
		// ClassCastException : 형변환 예외 
		// c1이 참조하는 객체는 Tesla인데 Spark 참조변수로 Tesla를 참조하려고하면 문제 발생
		
		// 해결방법 : instanceof 와 같이 사용해야 함 
		if(c1 instanceof Spark) {
			Spark s1 = (Spark)c1; //다운캐스팅
			System.out.println("성공");
		} else {
			System.out.println("실패, Spark 타입이 아님");
		}
		
		
	}
	
	
	public void ex5() {
		
		//바인딩 (Binding)
		//실제 실행할 메소드 코드와 호출하는 코드를 연결시키는 것 
		
		Car c1 = new Car("경유엔진", "경유", 8); 
		
		System.out.println(c1.getEngine());
		// Car 객체에 있는 getEngine() 메소드를 호출 == 바인딩
		// edu.kh.poly.ex1.model.vo.Car.getEngine()
		
		// 프로그램 '실행 전' 
		// 컴파일러는 getEngine() 메소드가 Car에 있는 걸로 인식 
		// c1.getEngine() 호출코드와 edu.kh.poly.ex1.model.vo.Car.getEngine() 메소드 코드를 연결 
		// -> 정적 바인딩 
		
		// *** 다형성 적용시 바인딩 ***
		Car c2 = new Spark("경차엔진", "휘발유", 4, 0.5);
		// 업캐스팅 적용 -> 부모 부분만 참조 가능한 상태 
		
		System.out.println(c2.toString());
		
		//참조변수 c2가 Car 타입이므로 
		//toString()도 Car의 toString() 호출 - 정적바인딩
		
		// but 실행해보면 자식(Spark)의 toString()이 호출되는 것을 확인 
		// -> 컴파일시에는 부모(Car)와 바인딩 == 정적바인딩
		// -> 실행시 자식(Spark)의 오버라이딩된 메소드와 바인딩 == 동적바인딩 
	
		
	}
 	
	
	
	
	
	

}

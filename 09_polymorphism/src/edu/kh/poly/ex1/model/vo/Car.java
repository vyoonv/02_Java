package edu.kh.poly.ex1.model.vo;

public class Car {


	//속성
	private String engine ; 
	private String fuel; 
	private int wheel; //바퀴개수 
	
	
	public Car() {}
	

	public Car(String engine, String fuel, int wheel) {
		super();
		this.engine = engine;
		this.fuel = fuel;
		this.wheel = wheel;
	}
	

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	
	
	//Object.toString()오버라이딩 
	@Override //오버라이딩 메소드라는 것을 컴파일러에게 알려주는 override annotation(컴파일러 인식용 주석)
	public String toString() {
	
		return engine + " / " + fuel + " / " + wheel;
	
	}


	








}

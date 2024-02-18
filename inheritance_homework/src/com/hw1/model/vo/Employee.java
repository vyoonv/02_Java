package com.hw1.model.vo;

public class Employee extends Person{

	private int salary; 
	private String dept; 
	
	public Employee() {}

	public Employee(String name, int age, double height, double weight, int salary, String dept) {
		super(name, age, height, weight);
		this.salary = salary;
		this.dept = dept;
	}
	
	
@Override
public String information() {
	
	return super.information() + String.format(" / 급여 : %d / 부서 : %s", salary, dept);
}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
	
	
}

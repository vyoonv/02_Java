package edu.kh.objarray.practice.model.vo;

public class Employee {
	
	
	private String emNum; 
	private String emName; 
	private String dept; 
	private String job; 
	private int salary;
	
	
	
	public String getEmNum() {
		return emNum;
	}
	public void setEmNum(String emNum) {
		this.emNum = emNum;
	}
	public String getEmName() {
		return emName;
	}
	public void setEmName(String emName) {
		this.emName = emName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	} 
	
	
	public Employee() {
		
		
	}
	
	public Employee(String emNum, String emName, String dept, String job, int salary) {

		this.emNum = emNum;
		this.emName = emName;
		this.dept = dept;
		this.job = job;
		this.salary = salary;
	}
	
	public String information() {
		
		return "사번 : " + emNum + ", 이름 : " + emName + 
				", 부서 : " + dept + "직급 : " + job + ", 급여 : " + salary ; 
		
	}
	

	
	

}

package edu.kh.oop.basic;

public class AccountRun {
	
	public static void main(String[] args) {
		
		// account 객체 생성 
		
		Account a1 = new Account(); 
		
		//호출의 개념 method.""()
		a1.setName("홍길동"); 
		a1.setAccountNumber("1234-56-7890");
		a1.setBalance(1000000);
		a1.setPassword("7890");
		
		System.out.println(a1.getName());
		System.out.println(a1.getAccountNumber());
		System.out.println(a1.getBalance());
		System.out.println(a1.getPassword());
		
		a1.deposit(50000);
		a1.withdraw("1234", 5000);
		a1.withdraw("7890", 200000000); 
		a1.withdraw("7890", 10000);
		
		Account a2 = new Account(); 
		
		a2.setAccountNumber("7777-1111-11");
		a2.setName("");
		a2.setBalance(0);
		a2.setPassword("1111");
		
		a2.deposit(10000);
		a2.withdraw("2222", 1000);
		a2.withdraw("1111", 100000000);
		a2.withdraw("1111", 1000);
		
		
	}

}

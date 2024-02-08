package edu.kh.oop.basic;


//계좌 클래스 
public class Account {
	
	//이름 계좌번호 잔액 비밀번호
	//getter/setter
	//deposit() : 전달받은 금액을 잔액에 누적한 후 
	//			현재 잔액을 콘솔에 출력
	//withdraw() : 비밀번호와 출금할 금액을 전달받아 조건에 맞으면 잔액에서 차감 후 현재잔액 출력
	//		1)비밀번호와 일치하지 않으면 "비밀번호 불일치" 출력
	//		2)출금할 금액이 잔액보다 크면 "잔액부족" 출력

		
	
	//속성(값)
	private String name; 
	private String accountNumber; 
	private long balance; //잔액이 int를 초과  
	private String password;
	
	//기능(getter/setter)
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	
	
	
	public void deposit(long amount) {
		//전달받은 금액 잔액에 누적
		balance += amount ; 
		//현재 잔액 콘솔에 출력
		System.out.println(name + "의 현재 잔액" + balance);
		

	}
	
	public void withdraw(String pw, long amount) {
		
		if(!password.equals(pw)) { //같으면 true, 다르면 false
			//다를 경우 
			System.out.println("비밀번호 불일치");
			return; //메서드 종료 -> 호출한 곳으로 돌아감 
	
		}
		//출금한 금액이 잔액보다 큰 경우 
		if(amount>balance) {
			System.out.println("잔액부족");
			return; 
		}
		//잔액을 출금할 금액만큼 차감
		balance -= amount ; 
		//balance = balance-amount; 
		System.out.printf("%s 계좌에서 %d원 출금 \n", accountNumber, amount);
		System.out.println(name + "의 현재 잔액 :" + balance);
		
	}
	
	

}

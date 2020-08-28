package kr.or.ddit.basic;

/*
 *  은행의 입출금 작업을 쓰레드로 처리하는 예제
 *  
 */

public class ThreadTest17 {
	private int balance;	// 잔액이 저장될 변수
	
	public synchronized int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	// 입금을 처리 하는 메소드
	
	public void deposit(int money){
		balance += money;
	}
	
	// 출금을 처리하는 메소드
	// 출금이 성공하면 true 실패하면 false 반환
	// 동기화 영역에서 호출하는 메소드도 동기화 처리를 해주어야 안전하다. ex ) 현재 예제에서는 getBalance가 있기 때문에 위에 getBalance() 메소드도 동기화처리
	public synchronized boolean withdraw(int money){
		if(balance >= money){ // 잔액 확인
			for(int i=1; i<=100_000_000; i++){}; // 시간 지연용
			
			balance -= money;
			System.out.println("메소드 안에서 balance = " + getBalance());
			return true;
		} else {
		return false;
		}
	}

	public static void main(String[] args) {
		final ThreadTest17 acount = new ThreadTest17();
		acount.setBalance(10000); // 잔액을 10000원으로 설정한다.
		
		Runnable r1 = new Runnable() { // 익명구현체 안에서 지역변수를 쓰려면 final로 선언해야 한다.
			
			@Override
			public void run() {
				boolean result = acount.withdraw(6000); // 6000원 출금
				System.out.println("쓰레드에서 result = " + result + ", balance = " + acount.getBalance());
				
			}
		};
		
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r1);
		th1.start();
		th2.start();
		
	}

}













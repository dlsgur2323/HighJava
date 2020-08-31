package kr.or.ddit.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *  은행의 입출금 작업을 쓰레드로 처리하는 예제
 *  Lock 객체를 이용한 동기화 처리 예제
 */
public class ThreadTest18 {
	private int balance; // 잔액
	
	// Lock 객체 생성 ==> 되도록이면 private final로 만든다.
	private final Lock lock = new ReentrantLock();
	
	public int getBalance(){
		return balance;
	}
	public void setBalance(int balance){
		this.balance = balance;
	}
	
	// 입금하는 메소드
	public void deposit(int money){
		// Lock 객체는 lock() 메소드로 락을 설정하고 
		// 반드시 unlock() 메소드로 락을 해제해 주어야 한다.
		lock.lock(); // 락 설정 시작...
		
		balance += money;
		
		lock.unlock(); // 락 해제...
	}
	
	// 출금하는 메소드
	public boolean withdraw(int money){
		
		// 만약 try-catch 블럭이 사용되는 부분에서
		// unlock() 메소드를 호출할 때는 finally 영역에서 호출 한다.
		
		boolean chk = false;
		try{
			lock.lock();
			if(balance >= money){
				for(int i=1; i<=100_000_000; i++){}; // 시간 지연용
				
				balance -= money;
				System.out.println("메소드 안에서 balance = " + getBalance());
				chk = true;
			} else {
				chk = false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		
		return chk;
	}
	
	public static void main(String[] args) {
		final ThreadTest18 acount = new ThreadTest18();
		acount.setBalance(10000); // 잔액을 10000원으로 설정한다.
		
		// 익명구현체
		Runnable r1 = new Runnable() { // 익명구현체 안에서 지역변수를 쓰려면 final로 선언해야 한다.
			@Override
			public void run() {
				boolean result = acount.withdraw(6000); // 6000원 출금
				System.out.println("쓰레드에서 result = " + result + ", balance = " + acount.getBalance());
				
			}
		};
		// 익명구현체

		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r1);
		th1.start();
		th2.start();

	}

}

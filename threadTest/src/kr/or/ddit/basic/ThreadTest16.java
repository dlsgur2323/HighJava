package kr.or.ddit.basic;

public class ThreadTest16 {

	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		TestThread th1 = new TestThread("Test1", sObj);
		TestThread th2 = new TestThread("Test2", sObj);
		
		th1.start();
		th2.start();
		

	}

}

class TestThread extends Thread{
	private ShareObject sObj;

	public TestThread(String name, ShareObject sObj) {
		super(name); //쓰레드의 name 설정
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			sObj.add();
		}
	}
	
}


class ShareObject{
	private int sum = 0;
	//동기화 처리 하기
//	public synchronized void add(){ // 동기화 방법 1 : 메소드 자체에 동기화 설정을 한다.
	public void add(){
		
		synchronized (this){ // 동기화 방법 2 : 동기화 블럭으로 설정한다.
			int n = sum;
			n += 10;
			sum = n;
			System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
		}
	}
}








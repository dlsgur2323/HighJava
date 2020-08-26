package kr.or.ddit.basic;

/*
 *  1 ~ 20억 까지의 합계를 구하는 프로그램을 하나의 쓰레드가 단독으로 처리할 때와
 *  여러개의 쓰레드가 협력해서 처리할 때의 경과시간을 비교해 보자.
 * 
 */
public class ThreadTest04 {

	public static void main(String[] args) {
		// 단독으로 처리하는 쓰레드
		
		SumThread sm = new SumThread(1L, 2_000_000_000L);
		
		// 여럿의 협력해서 처리하는 쓰레드
		SumThread[] smArr = new SumThread[]{
			new SumThread(			  1L, 	500_000_000L), 	
			new SumThread(	500_000_001L, 1_000_000_000L), 	
			new SumThread(1_000_000_001L, 1_500_000_000L), 	
			new SumThread(1_500_000_001L, 2_000_000_000L), 	
		};
		
		//단독으로 처리하기
		long startTime = System.currentTimeMillis();
		sm.start();
		try {
			sm.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("단독 처리 경과 시간 : " + (endTime - startTime) );
		System.out.println("----------------------------------------");
		System.out.println();
		
		// 여러 쓰레드가 협력해서 처리하기
		startTime = System.currentTimeMillis();
		
		for(int i = 0; i < smArr.length; i++){
			smArr[i].start();
		}
		for(SumThread sms : smArr){
			try {
				sms.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("협력 처리 경과 시간 : " + (endTime - startTime) );
		
		
	}

}

class SumThread extends Thread{
	private long start, end;  // 합계를 구할 영역의 시작값과 종료값이 저장될 변수 선언

	public SumThread(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		long sum = 0l;
		for(long i = start; i <= end; i++){
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
	
}





















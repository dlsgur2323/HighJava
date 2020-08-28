package kr.or.ddit.basic;

// 쓰레드에서 객체를 공통으로 사용하는 예제 연습

/*
 * 	- 원주율을 계산하는 쓰레드와 원주율을 출력하는 쓰레드가 있다.
 *  - 원주율을 저장하는 객체가 필요하다.
 *    이 객체를 두 쓰레드에서 공통으로 사용해서 처리한다.
 */
public class ThreadTest15 {

	public static void main(String[] args) {
		// 공통으로 사용할 객체 생성
		ShareData sd = new ShareData();
		CalcPIThread cpt = new CalcPIThread(sd);
		PrintPIThread ppt = new PrintPIThread(sd);
		
		cpt.start();
		ppt.start();
		
	}

}

// 원주율을 관리하는 클래스 작성 ( 공통으로 사용할 클래스 )

class ShareData{
	public double result;	// 계산된 원주율이 저장될 변수
	
	// volatile ==> 이 키워드가 붙은 변수는 컴파일러의 최저과 대상에서 제외된다.
	//				즉, 값이 변경되는 즉시 변수에 적용시킨다.
	public volatile boolean isOk;	// 계산이 완료되었는지 여부를 나타내는 변수 (계산이 완료되면 true)
	
	
}

// 원주율을 계산하는 쓰레드
class CalcPIThread extends Thread{
	private ShareData sd;

	public CalcPIThread(ShareData sd) {
		super();
		this.sd = sd;
	}
	@Override
	public void run() {
//		원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 - ...) * 4
//				1	-	3	+	5	-	7	+	9
		double sum = 0.0;
		for(int i = 1; i <= 500_000_000; i+=2){
			if((i/2)%2 == 0){
				sum += (1.0/i);
			} else {
				sum -= (1.0/i);
			}
		}
		sd.result = sum * 4;
		sd.isOk = true;
		System.out.println("계산완료...");
		
	}
}

// 원주율을 출력하는 쓰레드
class PrintPIThread extends Thread{
	private ShareData sd;

	public PrintPIThread(ShareData sd) {
		super();
		this.sd = sd;
	}
	
	@Override
	public void run() {
		while(true){
			if(sd.isOk){
				break;
			}
		}
		//계산된 원주율 출력하기
		System.out.println();
		System.out.println("결과 : " + sd.result);
		System.out.println("결과 : " + Math.PI);
	}
	
}












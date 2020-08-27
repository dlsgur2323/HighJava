package kr.or.ddit.basic;

// 3개의 쓰레드가 각각 알파벳을 A~Z까지 출력하는데,
// 출력을 끝낸 순서대로 결과를 나타내는 프로그램을 작성해 보자.

public class ThreadTest12 {

	public static void main(String[] args) {
		DisplayChar[] disp = new DisplayChar[]{
				new DisplayChar("홍길동"),
				new DisplayChar("이순신"),
				new DisplayChar("변학도")
		};
		
		for(DisplayChar dc : disp){
			dc.start();
		}
		for(DisplayChar dc : disp){
			try {
				dc.join();
			} catch (Exception e) {}
		}
		
		System.out.println();
		System.out.println("경기 결과 : " + DisplayChar.setRank);
		
	}

}

// A~Z까지 출력하는 메소드
class DisplayChar extends Thread{
	public static String setRank = "";
	private String name;
	
	
	public DisplayChar(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(char c = 'A'; c <= 'Z'; c++){
			System.out.println(name + "의 출력 문자 : " + c);
			try {
				// 201~500 사이의 난수값을 이용하여 일시 정지 시킨다.
				Thread.sleep((int)(Math.random()*500 + 1));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println(name + " 출력 끝...");
		
		DisplayChar.setRank += name + "  ";
	}
}













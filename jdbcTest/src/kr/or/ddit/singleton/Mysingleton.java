package kr.or.ddit.singleton;

/*
 * 	Singleton 패턴 ==> 객체가 1개만 만들어지게 하는 방법
 * 				(외부에서 new명령을 사용하지 못하게 한다.)
 * 
 * 	- Singleton패턴의 클래스를 만드는 방법 (필수요소)
 * 	1. 자신 class의 참조값이 저장될 변수를 private static으로 선언한다.
 * 
 * 	2. 생성자의 접근 제한자를 private으로 한다.
 * 
 * 	3. 자신 class의 인스턴스를 생성하고 반환하는 메소드를 public static으로 작성한다.
 * 		(이 메소드의 이름은 보통 getInstance로 한다.)
 * 
 * 
 */


public class Mysingleton {
	// 1번
	private static Mysingleton single;
	
	// 2qjs
	private Mysingleton(){
		System.out.println("생성자입니다...");
	}
	
	// 3번
	public static Mysingleton getInstance(){
		if(single==null) single = new Mysingleton();
		return single;
	}
	
	// 기타 이 클래스가 처리할 내용들을 기술한다.
	public void displayTest(){
		System.out.println("싱글톤 패턴의 메소드를 호출했습니다...");
	}
	
}























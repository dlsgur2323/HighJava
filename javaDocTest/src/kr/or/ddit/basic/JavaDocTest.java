package kr.or.ddit.basic;

// JavaDoc 문서 만들기 예제를 위한 인터페이스 
/**
 * 
 * @author 청길남
 * @version 1.0
 * 
 * <p>
 * 파일명 : JavaDocTest.java<br>
 * 설 명 : JavaDoc문서 작성을 위한 연습용 interface<br>
 * </p>
 * 
 * 수정 이력<br>
 * ------------------------------------------<br>
 * 수정 일자 : 2020-09-07<br>
 * 작 성 자 : 청길남<br>
 * 수정 내용 : 최초 생성<br>
 * ------------------------------------------<br>
 * 
 * 
 */
public interface JavaDocTest {
	/**
	 * 메소드명 : methodTest
	 * 설 명 : 반환값이 없는 메소드
	 * 
	 * @param a 첫번째 매개변수(정수형)
	 * @param b 두번째 매개변수(정수형)
	 */
	public void methodTest(int a, int b);
	
	/**
	 * 메소드명 : methodAdd
	 * 설 명 : 반환값이 있는 메소드
	 * @param x 정수형 첫번째 매개변수
	 * @param y 정수형 두번째 매개변수
	 * @return 처리된 결과를 정수형으로 반환
	 */
	public int methodAdd(int x, int y);
	
	/**
	 * 메소드명 : methodSub
	 * 설 명 : 매개변수가 없는 메소드
	 * @return 정수형으로 반환
	 */
	public int methodSub();
	
	
}

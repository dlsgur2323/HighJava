package kr.or.ddit.basic;

/*
		 	enum(열거형)	==> 서로 관련있는 상수들의 집합을 나타낸다.
		 				==> 클래스 처럼 보이게 하는 상수
		 				==> 열거형은 클래스처럼 독립된 java파일에 만들 수 있고,
		 				==> 하나의 java파일에 클래스와 같이 만들 수 있고,
		 				==> 클래스 안에 내부 클래스처럼 만들 수 있다.
		 				
		 	- 열거형의 속성 및 메소드
		 	 	name()	 ==> 열거형 상수의 이름을 문자열로 반환한다.
		 	 	odinal() ==> 열거형 상수가  정의된 순서값(index값)을 반환한다. (index는 0부터 시작)
		 	 	valueOf("열거형 상수명") ==> 지정된 열거형에서 '열거형 상수명'과 일치하는 열거형 상수를 반환한다.
		 	 	열거형이름.상수명		 	==> valueOf() 메소드와 같다.
		 	
		 	- 열거형 선언하기
		 	방법 1)
		 		enum 열거형 이름 { 상수명1, 상수명2, 상수명3, ... }
		 	
		 	방법 2)
		 		ennum 열거형 이름 {
		 			상수명1(값들...),
		 			상수명2(값들...),
		 			...
		 			상수명n(값들...)
		 			
		 			// '값들'이 저장될 변수들을 선언한다..
		 			 private 자료형이름 변수명1;
		 			 ...
		 			 
		 			 // 열거형의 생성자를 만든다.
		 			  	열거형의 생성자는 '열거형 상수'에 '값들'을 셋팅하는 역할을 수행한다.
		 			  	열거형 생성자는 묵시적으로 private이다.
		 			  	
		 			  	'변수명'은 '값들'과 개수가 같고, 각각의 '값들'과 자료형이 맞아야 된다. 
		 			  	private 열거형이름{자료형 변수명1, 자료형 변수명2,....){
		 			  	위에 선언된 변수들을 초기화하는 작업을 수행한다.
		 			  	... 
		 			  	}
		 			  	
		 			  	// 구성된 '값들'을 외부에서 불러올 수 있는 getter메소드를 만든다.
		 		}
		  
 */

public class EnumTest {
	public enum Color { RED, GREEN, BLUE };
	public enum Count { ONE, TWO, THREE };
	
	public enum Season {
		봄("3월부터 5월까지",10),  // 상수명(값들) 형식의 선언
		여름("6월부터 8월까지",20),
		가을("9월부터 11월까지",30),
		겨울("12월부터 2월까지",40);
		
		private String span; // 값들이 저장될 변수 선언
		private int num;
		
		//생성자
		Season(String months, int num){ // private Season(String months, int num) {와 같다.
			span = months;
			this.num = num;
		}
		
		public String getSpan(){
			return span;
		}
		public int getNum(){
			return num;
		}
		
	}
	
	public static void main(String[] args) {
		/*
		System.out.println("Red : " + ConstTest.RED);
		System.out.println("Three : " + ConstTest.THREE);
		
		if(ConstTest.RED == ConstTest.TWO){
			System.out.println("같다. *****************");
		} else {
			System.out.println("같지 않다. @@@@@@@@@@@@@@@@");
		}
		*/
		
		//열거형 상수값 가져오기
		Color mycol = Color.RED; // Color.valueOf("RED");와 같다.
		Count mycnt = Count.valueOf("TWO"); // Count.TWO;와 같다.
		
		System.out.println("mycol : " + mycol.name());
		System.out.println("mycnt : " + mycnt.name());
		System.out.println();
		
		System.out.println("mycol ordinal : " + mycol.ordinal());
		System.out.println("mycnt ordinal : " + mycnt.ordinal());
		
		// 서로 다른 종류의 열거형끼리 비교는 불가하다.
//		if(mycol == mycnt)
		if(mycol == Color.valueOf("BLUE")){
			System.out.println("같다.");
		} else{
			System.out.println("같지 않다.");
		}
		
		System.out.println("-------------------------------------");
		System.out.println();
		
		Season ss = Season.valueOf("봄");
		System.out.println("name : " + ss.name());
		System.out.println("ordinal : " + ss.ordinal());
		System.out.println("span : " + ss.getSpan());
		System.out.println("num : " + ss.getNum());
		System.out.println("-------------------------------------");
		
		// 열거형이름.values()  ==> 모든 상수들을 배열로 가져온다.
		for(Season time : Season.values()){
			System.out.println(time + " === " + time.name() + " ==> " + time.getSpan() + ", " + time.getNum());
		}
		System.out.println("-----------------------------------------------------");
		for(Color col : Color.values()){
			System.out.println(col + " ==> " + col.ordinal());
		}
	}

}














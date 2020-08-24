package kr.or.ddit.basic;

public class ArgsTest {

	// 배열을 이용한 메소드
	public int sumArr(int[] data){
		int total = 0;
		for(int i = 0; i < data.length; i++){
			total += data[i];
		}
		return total;
	}
	
	/*
	 	가변형 인수 	- 메소드의 매개변수의 개수가 호출될 때마다 다를 경우 사용한다.
	 			- 이 가변형 인수는 메소드 내에서는 배열로 처리된다.
	 			- 가변형 인수는 하나의 메소드에 하나만 사용할 수 있다.
	 */
	
	/*
	 * 하나의 메소드에 2개 이상의 가변형 변수 사용 불가
	 * public void argTest(int...t, float...k){
	 * 
	 * }
	 * 
	 */
	//	가변형 변수와 일반 변수를 같이 사용할 경우에는 가변형 변수를 제일 뒤에 배치해야 한다.
//	 public void argTest(int...data, String name){
//		 컴퓨터는 어디까지가 가변형 변수인지 잘 인식하지 못하기때문
//	 }
	 public void argTest(String name, int...data){
		 
	 }
	 
	
	
	
	// 가변형 인수를 이용한 메소드
	public int sumArg(int...data){
		int total = 0;
		for(int i = 0; i < data.length; i++){
			total += data[i];
		}
		return total;
	}
	
	
	
	
	public static void main(String[] args) {
		ArgsTest test = new ArgsTest();
		int[] nums = {1,2,3,4,5,6,7,8,9};
		int result = test.sumArr(nums);
		System.out.println("result : " + result);
		
		System.out.println(test.sumArr(new int[]{10,20,30,40}));
		System.out.println("--------------------------------");
		
		System.out.println(test.sumArg(1,2,3,4,5,6,7,8,9));
		System.out.println(test.sumArg(10,20,30,40));
		System.out.println();
		
		
		
	}

}

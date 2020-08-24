package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayListTest02 {
	/*
	 * 문제) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후에
	 * 		이들 중 '김'씨 성의 이름을 모두 출력하시오.
	 * 		(단, 입력은 scanner객체를 이용한다.)
	 */
	
	
	public static void main(String[] args) {
		
		ArrayList<String> nameList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++){
			System.out.println("이름을 입력하세요.");
			nameList.add(sc.nextLine());
		}
		
		System.out.println("김씨 성을 가진 이름");

//		charAt을 이용 ( substring 도 가능) (indexOf("김") == 0 으로도 가능) (startWith("김") 으로 첫 글짜 비교 가능)
		for(String name : nameList){
			if(name.charAt(0) == '김'){
				System.out.println(name);
			}
		}
		
		// startWith("김")
		for(String name : nameList){
			if(name.startsWith("김")){
				System.out.println(name);
			}
		}
		
		
//		정규표현식 이용
		String regex = "^김.*";
		Pattern p = Pattern.compile(regex);
		
		for(String name : nameList){
			Matcher m = p.matcher(name);
			if(m.matches()){
				System.out.println(name);
			}
		}

	}

}












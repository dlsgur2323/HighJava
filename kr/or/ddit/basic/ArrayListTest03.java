package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제1) 5명의 별명을 입력받아 ArrayList에 저장한 후
 * 		이들 중 별명의 길이가 제일 긴 별명을 출력하시오.
 * 			(단, 입력한 각각의 별명의 길이는 모두 다르다.)
 * 
 * 문제2) 문제1에서 별명의 길이가 같은 것이 중복될 경우를 처리하시오.
 */


public class ArrayListTest03 {

	public static void main(String[] args) {

		ArrayList<String> nameList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++){
			System.out.println("별명을 입력하세요 >");
			nameList.add(sc.nextLine());
		}
		int max = 0;
		for(int i = 0; i < nameList.size(); i++){
			if(nameList.get(max).length() < nameList.get(i).length()){
				max = i;
			}
		}
		System.out.println("제일 긴 별명 : " + nameList.get(max));
		
	}

}

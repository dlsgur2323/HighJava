package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 	문제 ) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 		컴퓨터의 숫자는 난수를 이용하여 구한다.(1~9사이의 서로 다른 숫자 3개)
 		(스트라이크는 S, 볼은 B로 나타낸다.)
 		
 	예시)
 		컴퓨터 난수 ==> 957
 	
 	실행예시)
 	숫자입력 >> 3 5 6
 	 3 5 6 ==> 1S 0B
 	 
 	숫자입력 >> 7 8 9
 	 7 8 9 ==> 0S 2B
 	
 	숫자입력 >> 9 7 5
 	 9 7 5 ==> 1S 2B
 	 
 	숫자입력 >> 9 5 7
 	 9 5 7 ==> 3S 0B
 	 
 	 축하합니다.
 	 당신은 4번째 만에 맞췄습니다.
 	 
 	 set으로 난수를 받고 그것을 list로 받아서 섞고 사용한다.
 */

public class BaseBallTest {

	public static int strike;
	public static int ball;
	public static void main(String[] args) {
		ArrayList<Integer> numbers = makeRandom();
		Scanner sc = new Scanner(System.in);
		System.out.println("게임을 시작합니다!");
		int count = 1;
		while(true){
			System.out.println("세자리 숫자를 입력하세요.");
			System.out.print(">");
			int input = Integer.parseInt(sc.nextLine());
			checkNumber(count,input, numbers);
			if(strike == 3){
				System.out.println("축하합니다.\n당신은 " + count + "번째 만에 맞췄습니다.");
				break;
			} else {
				count ++;
			}
		}

	}

	private static void checkNumber(int count, int input, ArrayList<Integer> numbers) {
		ArrayList<Integer> inputNum = new ArrayList<>();
		strike = 0;
		ball = 0;
		inputNum.add(input/100);
		inputNum.add((input/10)%10);
		inputNum.add(input%10);
		
		for(int i = 0; i < inputNum.size(); i++){
			for(int j = 0; j < numbers.size(); j++){
				if(inputNum.get(i) == numbers.get(j) && i==j){
					strike ++;
				} else if (inputNum.get(i) == numbers.get(j) && i !=j){
					ball ++;
				}
			}
			
		}
		
		System.out.println(input + " ==> " + strike + "S " + ball + "B");
		
		
	}

	private static ArrayList<Integer> makeRandom() {
		Set<Integer> num = new HashSet<>();
		while(num.size()<3){
			num.add((int)(Math.random()*9+1));
		}
		ArrayList<Integer> numbers = new ArrayList<>(num);
		Collections.shuffle(numbers);
		return numbers;
	}

}





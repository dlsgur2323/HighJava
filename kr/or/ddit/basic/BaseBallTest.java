package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 	���� ) Set�� �̿��Ͽ� ���� �߱� ���� ���α׷��� �ۼ��Ͻÿ�.
 		��ǻ���� ���ڴ� ������ �̿��Ͽ� ���Ѵ�.(1~9������ ���� �ٸ� ���� 3��)
 		(��Ʈ����ũ�� S, ���� B�� ��Ÿ����.)
 		
 	����)
 		��ǻ�� ���� ==> 957
 	
 	���࿹��)
 	�����Է� >> 3 5 6
 	 3 5 6 ==> 1S 0B
 	 
 	�����Է� >> 7 8 9
 	 7 8 9 ==> 0S 2B
 	
 	�����Է� >> 9 7 5
 	 9 7 5 ==> 1S 2B
 	 
 	�����Է� >> 9 5 7
 	 9 5 7 ==> 3S 0B
 	 
 	 �����մϴ�.
 	 ����� 4��° ���� ������ϴ�.
 	 
 	 set���� ������ �ް� �װ��� list�� �޾Ƽ� ���� ����Ѵ�.
 */

public class BaseBallTest {

	public static int strike;
	public static int ball;
	public static void main(String[] args) {
		ArrayList<Integer> numbers = makeRandom();
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �����մϴ�!");
		int count = 1;
		while(true){
			System.out.println("���ڸ� ���ڸ� �Է��ϼ���.");
			System.out.print(">");
			int input = Integer.parseInt(sc.nextLine());
			checkNumber(count,input, numbers);
			if(strike == 3){
				System.out.println("�����մϴ�.\n����� " + count + "��° ���� ������ϴ�.");
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





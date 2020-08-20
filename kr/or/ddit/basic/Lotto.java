package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
	public static void main(String[] args) {
		new Lotto().start();

	}

	Scanner sc = new Scanner(System.in);
	private void start() {
		while(true){
			System.out.println("\n\n");
			System.out.println("===================");
			System.out.println("   Lotto 프로그램");
			System.out.println("-------------------");
			System.out.println("   1. Lotto 구입");
			System.out.println("   2. 프로그램 종료");
			System.out.println("===================");
			System.out.println("메뉴선택 : 1");
			System.out.print("입력 >");
			String input = sc.nextLine();
			if(input.equals("2")){
				System.out.println("\n\n");
				System.out.println("감사합니다.");
				System.exit(0);
			} else if(input.equals("1")){
				System.out.println("\n\n");
				System.out.println("1000원에 로또번호 하나 입니다. (최대 100장 구입 가능)");
				System.out.print("금액 입력 >");
				int input2 = Integer.parseInt(sc.nextLine());
				if(input2 > 100000){
					System.out.println("\n\n");
					System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
				} else if (input2 < 1000){
					System.out.println("\n\n");
					System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
				} else {
					System.out.println("\n\n");
					System.out.println("행운의 로또번호는 아래와 같습니다.");
					for(int i = 1; i <= input2/1000; i++){
						Set<Integer> number = new HashSet<>();
						while(number.size()<6){
							number.add((int)(Math.random()*45+1));
						}
						ArrayList<Integer> numbers = new ArrayList<>(number);
						Collections.sort(numbers);
						System.out.println("로또번호" + i + " : " + numbers);
					}
					System.out.println("\n\n");
					System.out.println("받은 금액은 " + input2 + "원이고 거스름돈은 " + input2%1000 + "원입니다.");
				}
			}
		}
		
	}

}

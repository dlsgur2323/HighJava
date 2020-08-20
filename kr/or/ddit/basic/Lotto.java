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
			System.out.println("   Lotto ���α׷�");
			System.out.println("-------------------");
			System.out.println("   1. Lotto ����");
			System.out.println("   2. ���α׷� ����");
			System.out.println("===================");
			System.out.println("�޴����� : 1");
			System.out.print("�Է� >");
			String input = sc.nextLine();
			if(input.equals("2")){
				System.out.println("\n\n");
				System.out.println("�����մϴ�.");
				System.exit(0);
			} else if(input.equals("1")){
				System.out.println("\n\n");
				System.out.println("1000���� �ζǹ�ȣ �ϳ� �Դϴ�. (�ִ� 100�� ���� ����)");
				System.out.print("�ݾ� �Է� >");
				int input2 = Integer.parseInt(sc.nextLine());
				if(input2 > 100000){
					System.out.println("\n\n");
					System.out.println("�Է� �ݾ��� �ʹ� �����ϴ�. �ζǹ�ȣ ���� ����!!!");
				} else if (input2 < 1000){
					System.out.println("\n\n");
					System.out.println("�Է� �ݾ��� �ʹ� �����ϴ�. �ζǹ�ȣ ���� ����!!!");
				} else {
					System.out.println("\n\n");
					System.out.println("����� �ζǹ�ȣ�� �Ʒ��� �����ϴ�.");
					for(int i = 1; i <= input2/1000; i++){
						Set<Integer> number = new HashSet<>();
						while(number.size()<6){
							number.add((int)(Math.random()*45+1));
						}
						ArrayList<Integer> numbers = new ArrayList<>(number);
						Collections.sort(numbers);
						System.out.println("�ζǹ�ȣ" + i + " : " + numbers);
					}
					System.out.println("\n\n");
					System.out.println("���� �ݾ��� " + input2 + "���̰� �Ž������� " + input2%1000 + "���Դϴ�.");
				}
			}
		}
		
	}

}

package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {

	public static void main(String[] args) {
		ArrayList<String> nameList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++){
			System.out.println("������ �Է��ϼ��� >");
			nameList.add(sc.nextLine());
		}
		int max = 0;
		for(int i = 0; i < nameList.size(); i++){
			if(nameList.get(max).length() < nameList.get(i).length()){
				max = i;
			}
		}
		for(int i = 0; i < nameList.size(); i++){
			if(nameList.get(i).length() == nameList.get(max).length())
				System.out.println("���� �� ���� : " + nameList.get(i));
		}

	}

}

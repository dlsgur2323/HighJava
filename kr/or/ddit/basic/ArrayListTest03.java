package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * ����1) 5���� ������ �Է¹޾� ArrayList�� ������ ��
 * 		�̵� �� ������ ���̰� ���� �� ������ ����Ͻÿ�.
 * 			(��, �Է��� ������ ������ ���̴� ��� �ٸ���.)
 * 
 * ����2) ����1���� ������ ���̰� ���� ���� �ߺ��� ��츦 ó���Ͻÿ�.
 */


public class ArrayListTest03 {

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
		System.out.println("���� �� ���� : " + nameList.get(max));
		
	}

}

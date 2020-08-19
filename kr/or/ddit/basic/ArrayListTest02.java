package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayListTest02 {
	/*
	 * ����) 5���� ��� �̸��� �Է¹޾� ArrayList�� ������ �Ŀ�
	 * 		�̵� �� '��'�� ���� �̸��� ��� ����Ͻÿ�.
	 * 		(��, �Է��� scanner��ü�� �̿��Ѵ�.)
	 */
	
	
	public static void main(String[] args) {
		
		ArrayList<String> nameList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++){
			System.out.println("�̸��� �Է��ϼ���.");
			nameList.add(sc.nextLine());
		}
		
		System.out.println("�达 ���� ���� �̸�");

//		charAt�� �̿� ( substring �� ����) (indexOf("��") == 0 ���ε� ����) (startWith("��") ���� ù ��¥ �� ����)
		for(String name : nameList){
			if(name.charAt(0) == '��'){
				System.out.println(name);
			}
		}
		
		// startWith("��")
		for(String name : nameList){
			if(name.startsWith("��")){
				System.out.println(name);
			}
		}
		
		
//		����ǥ���� �̿�
		String regex = "^��.*";
		Pattern p = Pattern.compile(regex);
		
		for(String name : nameList){
			Matcher m = p.matcher(name);
			if(m.matches()){
				System.out.println(name);
			}
		}

	}

}












package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest01 {
	/*
	 	Set�� Ư¡ (List�� ��)
	 	
	 	1. List
	 		- �������� ����(index)�� �ִ�.
	 		- �ߺ��Ǵ� �����͸� ������ �� �ִ�.
	 	
	 	2. Set
	 		- �������� ����(index)�� ����.
	 		- �ߺ��Ǵ� �����͸� ������ �� ����.
	 		
	 */

	public static void main(String[] args) {
		
		HashSet hs1 = new HashSet<>();
		
		// ������ �߰� : add() �޼ҵ� �̿�
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set�� ���� : " + hs1.size());
		System.out.println("Set ������ : " + hs1);
		
		// set�� �ߺ��Ǵ� �����͸� �߰��ϸ� false �� ��ȯ�ϰ� �����ʹ� �߰����� �ʴ´�.
		
		
		boolean isAdd = hs1.add("FF");
		System.out.println("�ߺ����� ���� �� : " + isAdd);
		System.out.println("Set ������ : " + hs1);
		
		isAdd = hs1.add("CC");
		System.out.println("�ߺ��� �� : " + isAdd);
		System.out.println("Set ������ : " + hs1);
		
		// Set�� �����͸� �����Ϸ��� �����ϴ� ����� ���� ���� ������
		// �ش� �ڷḦ ������ �� �߰��� �ִ� ����� ����Ѵ�.
		
		//�����ϱ� : remove(�������ڷ�) ==> ��ȯ�� : ��������(true), ��������(false)
		//		clear() ==> ��ü ����
		
		// "FF"���ڿ��� "EE"���ڿ��� �����ϱ�
		hs1.remove("FF");
		System.out.println("���� �� Set" + hs1);
		hs1.add("EE");
		System.out.println("�߰� �� Set" + hs1);
		
//		hs1.clear();
//		System.out.println("clear �� Set : " + hs1);
		
		HashSet<Integer> intset = new HashSet<>();
		intset.add(10);
		intset.add(7);
		intset.add(9);
		intset.add(3);
		intset.add(5);
		
		// Set�� ��� �������� �հ� ���ϱ�
		
		/*
		 	Set�� �����ʹ� ����(index)�� ���� ������ Listó�� index�� �����͸� �ϳ��� �ҷ��� �� ����.
		 	�׷��� �����͸� �ϳ��� ��� ���ؼ��� Iterator�� ��ü�� ��ȯ�ؼ� ����ؾ� �Ѵ�.
		  	
		  	- Set ���� �����͸� Iterator�� ��ü�� ��ȯ�� �ִ� �޼ҵ� ==> iterator()
		  	
		 */
		Iterator<Integer> it = intset.iterator(); // Set �����͸� Iterator�� ��ȯ�ϱ�
		
		// Iterator�� hasNext()�޼ҵ� ==> Iterator�� �����͸� ����Ű�� ��������  ������°�� ��ġ�� �����Ͱ� ������ true, ������ false�� ��ȯ�Ѵ�.
		
		
		int sum=0;
		while(it.hasNext()){
			
			// Iterator�� next()�޼ҵ� ==> �����͸� ������° ��ġ�� �̵��� �� �� �ڸ��� �����͸� ��ȯ
			int num = it.next();
			sum += num;
		}
		
		System.out.println("�� �հ� : "+sum);
		
		// �츮�� �л��� �� ��ȣ�� �̿��Ͽ� ��÷�ϴ� ���α׷��� �ۼ��� ����
		// ��ȣ�� 1������ 25������ �ְ�, ��÷�� �ο��� 3���̴�.
		// ��û�ڸ� ����� ����.
		
//		int[] numArr = new int[3];
//		for(int i = 0; i <numArr.length; i++){
//			numArr[i] = (int)(Math.random()*25 +1);
//			for(int j = 0; j < i; j++){
//				if(numArr[i] == numArr[j]){
//					i--;
//					continue;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(numArr));

		HashSet<Integer> numSet = new HashSet<>();
		while(numSet.size()<3){
			numSet.add((int)(Math.random()*25 +1));
		}
		System.out.println("��÷�� ��ȣ : " + numSet);
		
		// Set ������ �ڷḦ List������ ��ȯ�ϱ�
		ArrayList<Integer> testList = new ArrayList<>(numSet);
		
		System.out.println("List ������ ���");
		for(Integer num : testList){
			System.out.println(num);
		}
		
		
	}

}


























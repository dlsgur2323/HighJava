package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest01 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("������");
		list.add("ȫ�浿");
		list.add("������");
		list.add("���е�");
		list.add("�̼���");
		
		System.out.println("���� �� : " + list);
		
		// ������ Collections.sort() �޼ҵ带 �̿��Ͽ� �����Ѵ�.
		// 		==> ���� ������ �⺻������ �������� ������ �����Ѵ�.
		
		Collections.sort(list);
		System.out.println("���� �� : " + list);
		
		Collections.shuffle(list);  // �ڷḦ �����ش�.
		System.out.println("�ڷ� ���� �� : " + list);
		
		//�ܺ� ���� ���� Ŭ������ �̿��Ͽ� �����ϱ�
		Collections.sort(list, new Desc());
		System.out.println("���� �� : " + list);
		
	}

}


// ���� ����� �����ִ� class�� �����.('�ܺ� ���� ���� Ŭ����' ��� �Ѵ�.)
// �ܺ� ���� ���� Ŭ������ Comparator�������̽��� �����ؼ� �ۼ��ؾ� �Ѵ�.
// Comparator �������̽��� ������ Ŭ������ compare()��� �޼ҵ带 ������ �ؼ�
// ���ı����� �����Ѵ�.

class Desc implements Comparator<String>{

	// compare()�޼����� �Ű������� 2���̰� ������ �����͸� ��ȯ�Ѵ�.
	
	// compare()�޼ҵ��� ��ȯ��
	// 1. �� ���� ���� ��� 0�� ��ȯ�ϵ��� �Ѵ�.
	// 2. ����� ��ȯ�ϸ� ��, �� �������� ������ �ٲ��.
	// 3. ������ ��ȯ�ϸ� ��, �� �������� ������ �ٲ��� �ʴ´�.
	
	// ��) ���������� ���  ==> ���� ���� ũ�� ���, ������ 0, ���� ���� ������ ������ ��ȯ�ϵ��� �ۼ��Ѵ�.
	
	// String ��ü���� ������ ���ؼ� compareTo() �޼ҵ尡 �����Ǿ� �ִµ�
	// �� �޼ҵ��� ��ȯ���� ���������� �°� ��ȯ�ǵ��� �����Ǿ� �ִ�.
	// (Wrapper Ŭ������ Date, File Ŭ�������� �����Ǿ� �ִ�.)
	@Override
	public int compare(String o1, String o2) {
		// ������������ �����ϵ��� �����ϱ�
		if(o1.compareTo(o2)<0){
			return 1;
		} else if (o1.compareTo(o2) == 0){
			return 0;
		} else {
			return -1;
		}
	}
}


















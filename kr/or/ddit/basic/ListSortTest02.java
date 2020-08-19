package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<>();
		
		memList.add(new Member(3, "������", "010-3333-1111"));
		memList.add(new Member(1, "ȫ�浿", "010-1111-1111"));
		memList.add(new Member(4, "������", "010-5555-1111"));
		memList.add(new Member(6, "���", "010-7777-1111"));
		memList.add(new Member(7, "�̼���", "010-2222-1111"));
		memList.add(new Member(2, "���е�", "010-6666-1111"));
		memList.add(new Member(5, "������", "010-4444-1111"));
		
		System.out.println("���� ��...");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("---------------------------------");
		
		System.out.println("���� ��...");
		Collections.sort(memList);
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("���� ��...");
		Collections.sort(memList, new Desc2());
		for(Member mem : memList){
			System.out.println(mem);
		}
		
	}

}

// �������� ������ ������ Ŭ������ Comparable�������̽��� �����ؾ� �Ѵ�.
// (Collection�� �߰��Ǵ� ������ ��ü�� ���� ������ �־��ִ� ���� ���Ѵ�.)

// Comparable�� �����ϴ� Ŭ�������� compareTo() �޼ҵ带 ������ �ؼ�

class Member implements Comparable<Member>{
	private int num;
	private String name;
	private String tel;
	
	// ������
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	
	
	// Member�� �̸��� ������������ �����ϴ� ���� ���� ���� �����ϱ�
//	@Override
//	public int compareTo(Member mem) {
//		
//		return this.name.compareTo(mem.getName());
//	}
	
	
	// Member�� ��ȣ�� ������������ �����ϴ� ���� ���� ���� �����ϱ�
	@Override
	public int compareTo(Member mem) {
		// �񱳹��1
//		if(this.num > mem.getNum()){
//			return -1;
//		} else if(this.num == mem.getNum()){
//			return 0;
//		} else {
//			return 1;
//		}
		//�񱳹�� 2 ==> WrapperŬ������ �̿��ϴ� ���
		return new Integer(this.num).compareTo(mem.getNum()) * -1; 
	}
	
	// ��ȭ��ȣ�� ������������ ������ �� �ִ� �ܺ� ���� ������ ����� ������ ����� ����Ͻÿ�.
//	@Override
//	public int compareTo(Member mem) {
//		
//		return this.tel.compareTo(mem.getTel());
//	}
	
	
	
}

class Desc2 implements Comparator<Member>{
	@Override
//	public int compare(Member m1, Member m2){
//		if(m1.compareTo(m2) > 0){
//			return -1;
//		} else if (m1.compareTo(m2) == 0 ){
//			return 0;
//		} else {
//			return 1;
//		}
//	}
	
	public int compare(Member m1, Member m2){
		return m1.getTel().compareTo(m2.getTel()) * -1;
	}
	
}


















package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * ����) �й�, �̸�, ��������, ��������, ��������, ����, ����� ����� ���� Student Ŭ������ �����.
 * 		�� Ŭ������ �����ڿ����� �й�, �̸�, ��������, ��������, ���������� �Ű������� �޾Ƽ� �ʱ�ȭ ó���� �Ѵ�.
 * 
 * 		�� Student��ü�� List�� �����Ͽ� �����Ѵ�.
 * 		
 * 		List�� ����� �����͵��� �й��� �������� ������ �� �� �ִ� ���� ���ı����� �����ϰ�,
 * 		������ �������� �����ϴµ� ������ ������ �̸��� ������������ ������ �Ǵ� �ܺ� ���� ���� Ŭ������ �ۼ��Ͽ�
 * 		���ĵ� ����� ����Ͻÿ�.
 * 
 * 		(����� List�� ��ü �����Ͱ� �߰��� �Ŀ� ����ǵ��� �Ѵ�.)
 */

public class StudentTest {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("05", "������", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		students.add(new Student("04", "ȫ�浿", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		students.add(new Student("00", "������", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		students.add(new Student("01", "���", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		students.add(new Student("03", "�̼���", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		students.add(new Student("02", "���е�", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		students.add(new Student("06", "������", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		
		Collections.sort(students, new SumDesc());
		for(int i = 0; i < students.size(); i++){
			int count = 1;
			for(int j = 0; j < students.size(); j++){
				if(students.get(i).getSum() < students.get(j).getSum()){
					count ++;
				}
			}
			students.get(i).setRank(count);
		}
		
		Collections.shuffle(students);
		System.out.println("���� ��");
		for(Student student : students){
			System.out.println(student);
		}
		
		
		System.out.println("�й����� ����");
		Collections.sort(students);
		for(Student student : students){
			System.out.println(student);
		}
		
		System.out.println("�������� ����");
		Collections.sort(students, new SumDesc());
		for(Student student : students){
			System.out.println(student);
		}
		
	}

}

class Student implements Comparable<Student>{
	private String studentNo;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank;
	
	public Student(String studentNo, String name, int kor, int eng, int math) {
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor + eng + math;
		this.rank = 0;

	}
	
	
	
	
	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", name=" + name + ", kor="
				+ kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum
				+ ", rank=" + rank + "]";
	}




	public int getRank() {
		return rank;
	}




	public void setRank(int rank) {
		this.rank = rank;
	}




	public String getStudentNo() {
		return studentNo;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}




	public int getSum() {
		return sum;
	}




	public void setSum(int sum) {
		this.sum = sum;
	}



// 	�й����� �������� ����
	@Override
	public int compareTo(Student student) {
		
		return this.getStudentNo().compareTo(student.getStudentNo());
	}
	
	
}

class SumDesc implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		if(new Integer(s1.getSum()).compareTo(s2.getSum()) == 0){
			return s1.getName().compareTo(s2.getName());
		} else {
			return new Integer(s1.getSum()).compareTo(s2.getSum()) * -1;
		}
	}
}

















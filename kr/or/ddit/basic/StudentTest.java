package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student 클래스를 만든다.
 * 		이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리를 한다.
 * 
 * 		이 Student객체는 List에 저장하여 관리한다.
 * 		
 * 		List에 저장된 데이터들을 학번의 오름차순 정렬이 될 수 있는 내부 정렬기준을 구현하고,
 * 		총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준 클래스를 작성하여
 * 		정렬된 결과를 출력하시오.
 * 
 * 		(등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 */



public class StudentTest {

	public static void setRank(List<Student> students){
		for(int i = 0; i < students.size(); i++){
			int rank = 1;
			for(int j = 0; j < students.size(); j++){
				if(students.get(i).getSum() < students.get(j).getSum()){
					rank ++;
				}
			}
			students.get(i).setRank(rank);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("05", "성춘향", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		students.add(new Student("04", "홍길동", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		students.add(new Student("00", "일지매", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		students.add(new Student("01", "김삿갓", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		students.add(new Student("03", "이순신", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		students.add(new Student("02", "변학도", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		students.add(new Student("06", "강감찬", (int)(Math.random()*100)+1, (int)(Math.random()*100)+1, (int)(Math.random()*100)+1));
		
		setRank(students);
		
		Collections.shuffle(students);
		System.out.println("정렬 전");
		for(Student student : students){
			System.out.println(student);
		}
		
		System.out.println("학번으로 정렬");
		Collections.sort(students);
		for(Student student : students){
			System.out.println(student);
		}
	
		System.out.println("총점으로 정렬");
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



// 	학번으로 오름차순 정렬
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

















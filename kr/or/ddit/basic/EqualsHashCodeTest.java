package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
		p2.setId(1);
		p2.setName("홍길동");
		
		
		System.out.println(p1 == p2); // ==은 해당 변수의 값 비교 (p1,p2는 객체생성해서 그 값은 클래스의 주소가 저장되어있다)
		System.out.println(p1.equals(p2)); // class 상속을 아무것도 받지 않으면 Object를 상속받는데, Object의 equals가 ==처럼 작동한다.
		System.out.println("-------------------------------");
		
		Set<Person> testSet = new HashSet<>();
		
		testSet.add(p1);
		testSet.add(p2);
		System.out.println("Set의 크기 : " + testSet.size());
		
		System.out.println("p1 : " + p1.hashCode());
		System.out.println("p2 : " + p2.hashCode());
		/*
		 	- equals() 	 ==> 두 객체의 내용이 같은지 검사하는 연산자
		 	- hashCode() ==> 두 객체의 동일성을 검사하는 연산자.
		 	
		 	- HashSet, Hashtable, HashMap과 같이 Hash로 시작하는 컬렉션들은 객체의 의미상의 동일성을 비교하기 위해 HashCode() 메서드를 호출하여 비교한다.
		 		그러므로, 객체가 같은지 여부를 결정하려면 hashCode() 메소드를 재정의 해야 한다.
		  
		  	- HashCode() 메소드에서 사용하는 '해싱 알고리즘'은 서로 다른 객체들에 대해서 같은 hashcode를 나타낼 수도 있다.
		 */
	}

}

class Person{
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if(obj == null) return false;
//		
//		// 같은 유형의 클래스인지 검사.
//		if(this.getClass()!=obj.getClass()) return false;
//		
//		// 참조값이 같은지 비교
//		if(this==obj) return true;
//		
//		// 매개변수값을 현재 객채 유형으로 형변환
//		Person myPerson = (Person)obj;
//		
//		if(this.name == null && myPerson.getName()!=null){ return false;}
//		
//		//id가 같고 name이 모두 null인 경우
//		if(this.id==myPerson.getId() && this.name == myPerson.getName()){ return true;}
//		//id가 같고 name도 같은경우
//		if(this.id==myPerson.getId() && this.name.equals(myPerson.getName())){ return true;}
//		//더이상 true인 조건이 없으니.
//		return false;
//	}
//	
	
	
}










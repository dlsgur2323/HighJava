package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("ȫ�浿");
		
		Person p2 = new Person();
		p2.setId(1);
		p2.setName("ȫ�浿");
		
		
		System.out.println(p1 == p2); // ==�� �ش� ������ �� �� (p1,p2�� ��ü�����ؼ� �� ���� Ŭ������ �ּҰ� ����Ǿ��ִ�)
		System.out.println(p1.equals(p2)); // class ����� �ƹ��͵� ���� ������ Object�� ��ӹ޴µ�, Object�� equals�� ==ó�� �۵��Ѵ�.
		System.out.println("-------------------------------");
		
		Set<Person> testSet = new HashSet<>();
		
		testSet.add(p1);
		testSet.add(p2);
		System.out.println("Set�� ũ�� : " + testSet.size());
		
		System.out.println("p1 : " + p1.hashCode());
		System.out.println("p2 : " + p2.hashCode());
		/*
		 	- equals() 	 ==> �� ��ü�� ������ ������ �˻��ϴ� ������
		 	- hashCode() ==> �� ��ü�� ���ϼ��� �˻��ϴ� ������.
		 	
		 	- HashSet, Hashtable, HashMap�� ���� Hash�� �����ϴ� �÷��ǵ��� ��ü�� �ǹ̻��� ���ϼ��� ���ϱ� ���� HashCode() �޼��带 ȣ���Ͽ� ���Ѵ�.
		 		�׷��Ƿ�, ��ü�� ������ ���θ� �����Ϸ��� hashCode() �޼ҵ带 ������ �ؾ� �Ѵ�.
		  
		  	- HashCode() �޼ҵ忡�� ����ϴ� '�ؽ� �˰���'�� ���� �ٸ� ��ü�鿡 ���ؼ� ���� hashcode�� ��Ÿ�� ���� �ִ�.
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
//		// ���� ������ Ŭ�������� �˻�.
//		if(this.getClass()!=obj.getClass()) return false;
//		
//		// �������� ������ ��
//		if(this==obj) return true;
//		
//		// �Ű��������� ���� ��ä �������� ����ȯ
//		Person myPerson = (Person)obj;
//		
//		if(this.name == null && myPerson.getName()!=null){ return false;}
//		
//		//id�� ���� name�� ��� null�� ���
//		if(this.id==myPerson.getId() && this.name == myPerson.getName()){ return true;}
//		//id�� ���� name�� �������
//		if(this.id==myPerson.getId() && this.name.equals(myPerson.getName())){ return true;}
//		//���̻� true�� ������ ������.
//		return false;
//	}
//	
	
	
}










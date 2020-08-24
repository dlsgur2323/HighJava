package kr.or.ddit.basic;

import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
	/*
	 	Properties 객체는 Map객체보다 축소된기능의 객체라고 할 수 있다.
	 	
	 	Map은 key값과 value값에 모든 형태의 객체를 사용할 수 있다.
	 	Properties는 key 와 value에 String만 쓸 수 있다.
	 	
	 	Map은 put()메소드, get()메소드를 이용하여 데이터를 입출력하지만,
	 	Properties는 setProperty()메소드, getProperty()메소드를 통해서 데이터를 입출력한다.
	 	
	 	Properties는 데이터를 파일로 입출력할 수 있다.
	 	
	 */

		Properties prop = new Properties();
		
		// 데이터 입력
		prop.setProperty("name", "홍길동");
		prop.setProperty("age", "20");
		prop.setProperty("tel", "010-1212-3434");
		prop.setProperty("addr", "대전");
		
		//데이터 출력
		String name = prop.getProperty("name");
		int age = Integer.parseInt(prop.getProperty("age"));
		String tel = prop.getProperty("tel");
		String addr = prop.getProperty("addr");
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("전화 : " + tel);
		System.out.println("주소 : " + addr);
		
		
	}

}












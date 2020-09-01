package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIoTest {

	public static void main(String[] args) {
		// 객체를 파일에 저장하는 예제
		
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("홍길서", 30, "서울");
		Member mem3 = new Member("홍길남", 40, "인천");
		Member mem4 = new Member("홍길북", 50, "강릉");
		
		try {
			// 객체를 파일에 저장하기
			
			// 파일 저장용 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("d:/d_other/memObj.bin");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oout = new ObjectOutputStream(bout);
			
			// 쓰기 작업 수행...
			System.out.println("객체 저장하기 시작...");
			oout.writeObject(mem1);
			oout.writeObject(mem2);
			oout.writeObject(mem3);
			oout.writeObject(mem4);
			System.out.println("객체 저장 작업 완료...");
			
			// 스트림 닫기
			oout.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		System.out.println("========================================");
		ObjectInputStream oin = null;
		try {
			// 저장된 객체를 읽어와 그 내용을 화면에 출력하기
			// 입력용 스트림 객체 생성
			oin = new ObjectInputStream(new BufferedInputStream
										(new FileInputStream("d:/d_other/memObj.bin")));
			Object obj; // 읽어온 객체를 저장할 변수
			
			// readObject() 메소드의 반환값은 Object형이다.
			// readObject() 메소드가 데이터를 끝까지 다 읽어오면 EOF Exception이 발생된다.
			while((obj=oin.readObject()) != null){
				Member mem = (Member)obj;
				
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("-------------------------");
			}
			
		} catch (EOFException e){
			System.out.println("파일 읽기 완료");
		} catch (IOException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		 // 사용한 스트림을 닫을 때는 finally영역에서 닫는다.
			try { oin.close(); } catch (IOException e) {
				e.printStackTrace();
		}
		}
		
	}

}

// 데이터 저장용 클래스 작성(VO와 같은 역할을 하는 클래스)
class Member implements Serializable{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1096438140999733430L;
	private String name;
	
	// trnsient ==> 직렬화가 되지 않을 인스턴스 변수에 지정한다.
	//			==> 직렬화가 되지 않은 인스턴스 변수는 기본값으로 저장된다.
	//				(참조변수 ==> null, 숫자유형의 변수 ==> 0, 논리형 변수 ==> false)
	private transient int age;
	private transient String addr;
	
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
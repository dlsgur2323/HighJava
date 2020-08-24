package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
 	문제 ) 이름, 주소, 나이, 전화번호를 멤버변수로 같는 Phone클래스를 만들고
 		Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 		
 		이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체 출력하는 기능이 있다.
 		삭제와 검색 기능은 '이름'을 입력 받아 처리한다.
 		(Map의 구조는 key값으로 그 사람의 '이름'을 사용하고,
 		 			value값으로는 'Phone클래스의 인스턴스'로 한다.)
 		 			
 		실행예시 ) 
 			다음 메뉴를 선택하세요.
 			1. 전화번호 등록
 			2. 전화번호 수정
 			3. 전화번호 삭제
 			4. 전화번호 검색
 			5. 전화번호 전체 출력
 			0. 프로그램 종료
 			------------
 			번호입력>> 1
 			
 			새롭게 등록할 전화번호 정보를 입력하세요
 			이름 >> 홍길동   <<- 중복 불가 처리 ('홍길동'은 이미 등록된 사람입니다.)
 			전화번호 >> 010-1111-1111
 			나이 >> 30
 			주소 >> 대전시 중구 대흥동
 			
 			'홍길동' 전화번호 등록 완료!!
 			
 			전체출력
 			
 			=================================
 			          번호    이름    전화번호    나이    	주소
 			=================================
 			     1     홍길동   010-1111-1111 30 대전시 중구 대흥동
 			     ~~~
 			     ~~~~
 			=================================
 			출력 완료...
 			(바로 다시 메뉴가 나오도록)
 		
 */
public class PhoneBookTest {

	public static void main(String[] args) {
		new PhoneBookTest().strat();

	}
	
	HashMap<String, Phone> phoneBook = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	
	private void strat() {
		while(true){
			System.out.println("\n===============");
			System.out.println("다음 메뉴를 선택하세요.");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("0. 프로그램 종료");
			System.out.println("===============");
			System.out.print("번호입력>>");
			int input = Integer.parseInt(sc.nextLine());
			switch(input){
				case 0 : 
					System.out.println("\n프로그램을 종료합니다...");
					System.exit(0);
				case 1 :
					insertPhone();
					break;
				case 2 :
					updatePhone();
					break;
				case 3 :
					deletePhone();
					break;
				case 4 :
					searchPhone();
					break;
				case 5 :
					listPhone();
					break;
					
			}
		}
		
	}
	
	private void listPhone() {
		Set<String> list = phoneBook.keySet();
		int num = 1;
		System.out.println("================================================");
		System.out.println("번호\t이름\t전화번호\t\t나이\t주소");
		System.out.println("================================================");
		for(String name : list){
			System.out.println(num +"\t"+ name + "\t"+phoneBook.get(name).ph+"\t"+phoneBook.get(name).age+"\t"+phoneBook.get(name).address);
			num++;
		}
	}

	private void searchPhone() {
		System.out.println("검색할 전화번호 정보를 입력하세요");
		System.out.print("이름 >>");
		String name = sc.nextLine();
		
		
		if(!phoneBook.containsKey(name)){
			System.out.println("\n'" + name +"'" + "은 등록되지 않은 사람입니다.");
		} else {
			System.out.println("===================");
			System.out.println("이름\t전화번호\t\t나이\t주소");
			System.out.println("===================");
			System.out.print(name + " " + phoneBook.get(name).ph + "\t" + phoneBook.get(name).age + " " + phoneBook.get(name).address);
			System.out.println();
		}
		
	}

	private void deletePhone() {
		System.out.println("삭제할 전화번호 정보를 입력하세요");
		System.out.print("이름 >>");
		String name = sc.nextLine();
		
		if(!phoneBook.containsKey(name)){
			System.out.println("\n'" + name +"'" + "은 등록되지 않은 사람입니다.");
		} else {
			System.out.println("삭제완료!!");
			phoneBook.remove(name);
		}
		
	}

	private void updatePhone() {
		System.out.println("수정할 전화번호 정보를 입력하세요");
		System.out.print("이름 >>");
		String name = sc.nextLine();
		
		if(!phoneBook.containsKey(name)){
			System.out.println("\n'" + name +"'" + "은 등록되지 않은 사람입니다.");
		} else {
			System.out.print("전화번호 >>");
			String ph = sc.nextLine();
			System.out.print("나이 >>");
			int age = Integer.parseInt(sc.nextLine());
			System.out.print("주소 >>");
			String address = sc.nextLine();
			phoneBook.put(name, new Phone(name, age, address, ph));
			System.out.println("'" + name + "'" + " 전화번호 수정 완료 !!");
			
		}
		
	}

	private void insertPhone() {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요");
		System.out.print("이름 >>");
		String name = sc.nextLine();
		
		if(phoneBook.containsKey(name)){
			System.out.println("\n'" + name +"'" + "은 이미 등록된 사람입니다.");
		} else {
			System.out.print("전화번호 >>");
			String ph = sc.nextLine();
			System.out.print("나이 >>");
			int age = Integer.parseInt(sc.nextLine());
			System.out.print("주소 >>");
			String address = sc.nextLine();
			phoneBook.put(name, new Phone(name,age, address, ph));
			System.out.println("'" + name + "'" + " 전화번호 등록 완료 !!");
			
		}
		
	}

}

class Phone {
	String name;
	int age;
	String address;
	String ph;
	
	public Phone(String name, int age, String address, String ph) {
		super();
		this.age = age;
		this.address = address;
		this.ph = ph;
	}
}










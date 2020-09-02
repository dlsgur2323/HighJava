package kr.or.ddit.basic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;

/*
 	문제 ) 이름, 주소, 나이, 전화번호를 멤버변수로 같는 Phone클래스를 만들고
 		Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 		
 		이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체 출력하는 기능이 있다.
 		삭제와 검색 기능은 '이름'을 입력 받아 처리한다.
 		(Map의 구조는 key값으로 그 사람의 '이름'을 사용하고,
 		 			value값으로는 'Phone클래스의 인스턴스'로 한다.)
 		 			
 		- 추가조건)
 			1) '6. 전화번호 저장' 메뉴를 추가하고 구현한다.
 				(저장 파일명 : phoneData.dat)
 			2) 프로그램이 시작될 때 저장된 파일이 있으면, 그 데이터를 읽어와 Map에 셋팅한다.
 			
 			3) 프로그램을 종료할 때 Map의 데이터가 변경되었거나 추가 또는 삭제되면 새로 저장한 후 종료되도록 한다.
 		
 		 			
 		실행예시 ) 
 			다음 메뉴를 선택하세요.
 			1. 전화번호 등록
 			2. 전화번호 수정
 			3. 전화번호 삭제
 			4. 전화번호 검색
 			5. 전화번호 전체 출력
 			6. 전화번호 저장
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
public class PhoneBookTest{

	HashMap<String, Phone> phoneBook = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	boolean dataChange = false; // 데이터가 변경되었는지 여부를 나타내는 변수
								// 데이터가 변경되면 true가 된다.
	
	public static void main(String[] args) {
		PhoneBookTest phbt = new PhoneBookTest(); 		
		
		phbt.strat();

	}
	
	
	private void strat() {
		callPhoneData();
		while(true){
			mainmenu();			
		}
	}
	public void mainmenu(){
		System.out.println("\n===============");
		System.out.println("다음 메뉴를 선택하세요.");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("6. 전화번호 저장");
		System.out.println("0. 프로그램 종료");
		System.out.println("===============");
		System.out.print("번호입력 >>");
		int input = Integer.parseInt(sc.nextLine());
			if(input == 1){
				insertPhone();
			} else if(input == 2){
				updatePhone();
			} else if(input == 3){
				deletePhone();
			} else if(input == 4){
				searchPhone();
			} else if(input == 5){
				listPhone();
			} else if(input == 6){
				save();
			} else if(input == 0){
				if(dataChange){ // 변경되었으면...
					save();
				}
				System.out.println("\n프로그램을 종료합니다...");
				System.exit(0);
			}
	}
	
	public void callPhoneData() {
		ObjectInputStream oin = null;
		File f = new File("d:/d_other/phoneData.dat");
		if(!f.exists()){
			System.out.println("저장된 데이터가 없습니다.");
			return;
		} else {
			try {
				
				oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
				
				Object obj;
				
				while((obj=oin.readObject()) != null){
					Phone ph = (Phone)obj;
					phoneBook.put(ph.name, ph); 
				}
				
			} catch (EOFException e){
				System.out.println("저장된 데이터를 가져옵니다.");
			} catch (IOException e) {
				// TODO: handle exception
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try { oin.close(); } catch (IOException e) {
					e.printStackTrace();
			}
			}
		}
	}


	public void save() {
		System.out.println("전화번호 저장 중...");
		ObjectOutputStream oout = null;
		Set<String> list2 = phoneBook.keySet();
		try {
			oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/d_other/phoneData.dat")));
			for(String key : list2){
				oout.writeObject(phoneBook.get(key));
			}
			System.out.println("저장 완료!");
			oout.close();
			dataChange = false;
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}

	public void listPhone() {
		Set<String> list = phoneBook.keySet();
		int num = 1;
		System.out.println("================================================");
		System.out.println("번호\t이름\t전화번호\t\t나이\t주소");
		System.out.println("================================================");
		for(String name : list){
			System.out.println(num +"\t"+ name + "\t"+phoneBook.get(name).ph+"\t"+phoneBook.get(name).age+"\t"+phoneBook.get(name).address);
			num++;
		}
		System.out.println("================================================");
	}

	public void searchPhone() {
		System.out.println("검색할 전화번호 정보를 입력하세요");
		System.out.print("이름 >>");
		String name = sc.nextLine();
		
		
		if(!phoneBook.containsKey(name)){
			System.out.println("\n'" + name +"'" + "은 등록되지 않은 사람입니다.");
		} else {
			System.out.println("================================================");
			System.out.println("이름\t전화번호\t\t나이\t주소");
			System.out.println("================================================");
			System.out.print(name + "\t" + phoneBook.get(name).ph + "\t" + phoneBook.get(name).age + "\t" + phoneBook.get(name).address);
			System.out.println();
			System.out.println("================================================");
		}
		
	}

	public void deletePhone() {
		System.out.println("삭제할 전화번호 정보를 입력하세요");
		System.out.print("이름 >>");
		String name = sc.nextLine();
		
		if(!phoneBook.containsKey(name)){
			System.out.println("\n'" + name +"'" + "은 등록되지 않은 사람입니다.");
		} else {
			System.out.println("삭제완료!!");
			phoneBook.remove(name);
			dataChange = true;
		}
		
	}

	public void updatePhone() {
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
			dataChange = true;
		}
		
	}

	public void insertPhone() {
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
			dataChange = true;
		}
		
	}


	
}

class Phone implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5588112755218446017L;
	String name;
	int age;
	String address;
	String ph;
	
	public Phone(String name, int age, String address, String ph) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.ph = ph;
	}
}









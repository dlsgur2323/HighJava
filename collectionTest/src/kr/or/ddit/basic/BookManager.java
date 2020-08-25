package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
 	Book클래스 - 도서번호, 제목, 지은이, 장르, 대출가능여부(boolean)로 구성됨
	     (도서번호는 중복되지 않는다.) - 도서 등록할 때 도서번호가 중복여부를 확인한다.

	Map를 이용해서 관리 (key값:도서번호, value값:Book의 인스턴스)
	
	사용할 메뉴를 선택하세요.
	1. 도서 정보 등록
	2. 도서 정보 수정
	3. 도서 정보 삭제
	4. 도서 정보 검색
	5. 전체 도서 정보 출력
	6. 도서 반납 및 대여(x)
	0. 프로그램 종료
	--------------------------
	번호 선택 >> 
 */
public class BookManager {
	HashSet<String> pkn = new HashSet<>();
	Scanner sc = new Scanner(System.in);
	HashMap<String, Book> bookMap = new HashMap<>();
	
	public static void main(String[] args) {
		new BookManager().start();

	}
	
	private void start() {
		while(true){
			mainMenu();
		}
		
	}

	private void mainMenu() {
		System.out.println("\n\n사용할 메뉴를 선택하세요.");
		System.out.println("1. 도서 정보 등록");
		System.out.println("2. 도서 정보 수정");
		System.out.println("3. 도서 정보 삭제");
		System.out.println("4. 도서 정보 검색");
		System.out.println("5. 전체 도서 정보 출력");
		System.out.println("6. 도서 반납 및 대여(x)");
		System.out.println("0. 프로그램 종료");
		System.out.println("-----------------");
		System.out.print("번호 선택 >>");
		int input = Integer.parseInt(sc.nextLine());
		switch(input){
			case 0 :
				System.exit(0);
			case 1 :
				registBook();
				break;
			case 2 :
				updateBook();
				break;
			case 3 :
				deleteBook();
				break;
			case 4 :
				searchBook();
				break;
			case 5 :
				listBook();
				break;
			case 6 :
				lendOrReturn();
				break;
		}
		
	}

	private void lendOrReturn() {
		System.out.println("1.대출\t2.반납");
		int input = Integer.parseInt(sc.nextLine());
		switch(input){
			case 1:
				System.out.println("대출할 도서번호를 입력하세요.");
				String bookNo = sc.nextLine();
				if(bookMap.containsKey(bookNo)){
					if(!bookMap.get(bookNo).lendable){
						System.out.println("이미 대출중인 도서입니다.");
					} else {
						System.out.println(bookNo + "번 도서 대출되었습니다.");
						bookMap.get(bookNo).lendable = false;
					}
				} else {
					System.out.println("등록되지 않은 도서입니다.");
				}
				break;
			case 2:
				System.out.println("반납할 도서번호를 입력하세요.");
				bookNo = sc.nextLine();
				if(bookMap.containsKey(bookNo)){
					if(bookMap.get(bookNo).lendable){
						System.out.println("대출되지 않은 도서입니다.");
					} else {
						System.out.println(bookNo + "번 도서 반납되었습니다.");
						bookMap.get(bookNo).lendable = true;
					}
				} else {
					System.out.println("등록되지 않은 도서입니다.");
				}
				break;
		}
		
	}

	private void listBook() {
		ArrayList<String> pkList = new ArrayList<>(bookMap.keySet());
		Collections.sort(pkList);
		System.out.println("============================================");
		System.out.println("\t\t전체 도서 정보");
		System.out.println("--------------------------------------------");
		System.out.println("도서번호\t제목\t\t지은이\t장르\t대출상태");
		System.out.println("--------------------------------------------");
		for(String pkn : pkList){
			System.out.print(pkn + "\t" + bookMap.get(pkn).title + "\t" + bookMap.get(pkn).author + "\t" + 
								bookMap.get(pkn).genre + "\t");
			if(bookMap.get(pkn).lendable == true){
				System.out.println("대출가능");
			} else {
				System.out.println("대출중");
			}
		}
		System.out.println("============================================");
		
		
	}

	private void searchBook() {
		System.out.println("검색할 도서번호를 입력하세요");
		String bookNo = sc.nextLine();
		if(bookMap.containsKey(bookNo)){
			System.out.println("도서 정보");
			System.out.println("============================================");
			System.out.println("도서번호\t제목\t\t지은이\t장르\t대출상태");
			System.out.println("----------------------");
			System.out.print(bookNo + "\t" + bookMap.get(bookNo).title + "\t" + bookMap.get(bookNo).author + "\t" + 
					bookMap.get(bookNo).genre + "\t");
			if(bookMap.get(bookNo).lendable == true){
				System.out.println("대출가능");
			} else {
				System.out.println("대출중");
			}
			System.out.println("============================================");
		} else {
			System.out.println("등록되지 않은 도서번호 입니다.");
		}
		
		
		
	}

	private void deleteBook() {
		System.out.println("삭제할 도서번호를 입력하세요.");
		String bookNo = sc.nextLine();
		if(bookMap.containsKey(bookNo)){
			bookMap.remove(bookNo);
			System.out.println(bookNo + "번 도서가 삭제되었습니다.");
		} else {
			System.out.println("등록되지 않은 도서번호 입니다.");
		}
		
	}

	private void updateBook() {
		System.out.println("수정할 도서번호를 입력하세요.");
		String bookNo = sc.nextLine();
		if(bookMap.containsKey(bookNo)){
			System.out.println("수정할 내용을 입력하세요.");
			System.out.print("제목 >>");
			String title = sc.nextLine();
			System.out.print("지은이 >>");
			String author = sc.nextLine();
			System.out.print("장르 >>");
			String genre = sc.nextLine();
			bookMap.put(bookNo, new Book(bookNo, title, author, genre));
			System.out.println("\n" + bookNo + "번 도서가 수정되었습니다.");
		} else {
			System.out.println("등록되지 않은 도서번호 입니다.");
		}
		
	}

	private void registBook() {
		System.out.println("등록할 도서 정보를 입력하세요.");
		System.out.print("제목 >>");
		String title = sc.nextLine();
		System.out.print("지은이 >>");
		String author = sc.nextLine();
		System.out.print("장르 >>");
		String genre = sc.nextLine();
		String bookNo = makePk();
		bookMap.put(bookNo, new Book(bookNo, title, author, genre));
		System.out.println("\n새로운 도서가 등록되었습니다.");
	}

	private String makePk(){
		boolean notOverlap = false;
		String pk = "";
		while(!notOverlap){
			if((int)(Math.random()*2)+1 == 1){
				char first = (char)((Math.random()*26)+97);
				pk += first;
			} else {
				int first = (int)((Math.random()*9)+1);
				pk += first;
			}
			if((int)(Math.random()*2)+1 == 1){
				char snd = (char)((Math.random()*26)+97);
				pk += snd;
			} else {
				int snd = (int)((Math.random()*9)+1);
				pk += snd;
			}
			if((int)(Math.random()*2)+1 == 1){
				char th = (char)((Math.random()*26)+97);
				pk += th;
			} else {
				int th = (int)((Math.random()*9)+1);
				pk += th;
			}
			notOverlap = pkn.add(pk);
		}
		return pk;
	}
	
	
	
	
	
}

class Book {
	String bookNo;
	String title;
	String author;
	String genre;
	Boolean lendable;
	
	Book(String bookNo, String title, String author, String genre){
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.lendable = true;  
	}
}













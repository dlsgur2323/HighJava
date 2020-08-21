package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Hotel {

	public static void main(String[] args) {
		new Hotel().start();

	}
	
	Scanner sc = new Scanner(System.in);
	HashMap<Integer, Room> roomMap = new HashMap<>();
	
	private void start() {
		
		for(int j = 1; j <= 9; j++){
			roomMap.put((200)+j, new Room((200)+j, "싱글룸"));
		}
		for(int j = 1; j <= 9; j++){
			roomMap.put((300)+j, new Room((300)+j, "더블룸"));
		}
		for(int j = 1; j <= 9; j++){
			roomMap.put((400)+j, new Room((400)+j, "스위트룸"));
		}
		
		System.out.println("*********************************************");
		System.out.println("호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		while(true){
		    System.out.println("\n\n-----------------------------------------------------------");
		    System.out.println("어떤 업무를 하시겠습니까?");
		    System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		    System.out.println("-----------------------------------------------------------");
		    System.out.print("선택>>");
		    int input = Integer.parseInt(sc.nextLine());
		    switch(input){
		    	case 4 :
		    		System.out.println("\n\n*********************************************");
		    		System.out.println("호텔문을 닫았습니다.");
		    		System.out.println("*********************************************");
		    		System.exit(0);
		    	case 1 : checkIn(); break;
		    	case 2 : checkOut(); break;
		    	case 3 : roomStatus(); break;
		    }
		}
		
	}

	private void checkOut() {
		System.out.println("\n\n----------------------------------------------");
		System.out.println("체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요 >>");
		int input = Integer.parseInt(sc.nextLine());
		if(roomMap.containsKey(input) == false){
			System.out.println(input + "호 객실은 존재하지 않습니다.");
		} else {
			if(roomMap.get(input).name == null){
				System.out.println(input + "호 객실에는 체크인 한 사람이 없습니다.");
			} else {
				System.out.println(input +"호 객실의 " + roomMap.get(input).name + "님 체크아웃을 완료하였습니다.");
				roomMap.get(input).name = null;
			}
		}
		
	}

	private void checkIn() {
		System.out.println("\n\n----------------------------------------------");
		System.out.println("체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println("* 201~209 : 싱글룸");
		System.out.println("* 301~309 : 더블룸");
		System.out.println("* 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호 입력 >>");
		int input = Integer.parseInt(sc.nextLine());
		if(roomMap.containsKey(input) == false){
			System.out.println(input + "호 객실은 존재하지 않습니다.");
		} else {
			if(roomMap.get(input).name != null){
				System.out.println(input + "호 객실은 이미 손님이 있습니다.");
			} else {
				System.out.println("누구를 체크인 하시겠습니까?");
				String name = sc.nextLine();
				roomMap.get(input).name = name;
				System.out.println("체크인이 완료되었습니다.");
			}
		}
		
	}

	private void roomStatus() {
		ArrayList<Integer> keyList = new ArrayList<>(roomMap.keySet());
		Collections.sort(keyList);
		System.out.println("\n\n----------------------------------------------");
		System.out.println("현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호	 방 종류	 투숙객 이름");
		System.out.println("----------------------------------------------");
		for(Integer key : keyList){
			System.out.print(key + "\t" + roomMap.get(key).kinds + "\t");
			if(roomMap.get(key).name == null){
				System.out.print("-\n");
			} else {
				System.out.print(roomMap.get(key).name + "\n");
			}
		}
		System.out.println("----------------------------------------------");
		
	}

}

class Room{
	
	
	public Room(int roomNo, String kinds) {
		super();
		this.roomNo = roomNo;
		this.kinds = kinds;
	}


	int roomNo;
	String kinds;
	String name;
}










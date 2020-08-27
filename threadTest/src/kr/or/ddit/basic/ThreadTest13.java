package kr.or.ddit.basic;

import java.util.Arrays;

/*
 *  10마리의 말들이 경주하는 경마 프로그램 작성하기
 *  
 *  말은 Horse라는 이름의 클래스로 구성한다.(이 각각의 말들은 하나의 경기를 진행하는 쓰레드가 된다.)
 *  이 클래스는 말이름(String), 등수(int), 말의 현재 위치(int)를 멤버변수로 갖는다.
 *  그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다. (Comparable 인터페이스 구현)
 *  
 * 	경기 구간을 1~ 50 구간으로 되어 있다.
 * 	
 * 	경기 중 중간 중간에 각 말들의 위치를 나타내시오.
 *  예)
 *  말이름01  ----------->---------------------------
 *  말이름02  --------------------------->-----------
 *  말이름03  -->------------------------------------
 *  말이름04  ------->-------------------------------
 *  ...
 *  말이름09  --------------->-----------------------
 *  말이름10  --->-----------------------------------
 *  
 *  ....
 *  
 *  
 *  말이름01  -------------------------------------->
 *  말이름02  -------------------------------------->
 *  말이름03  -------------------------------------->
 *  말이름04  -------------------------------------->
 *  ...
 *  말이름09  -------------------------------------->
 *  말이름10  -------------------------------------->
 *  
 *  경기가 끝나면 등수 순으로 출력한다.
 *  
 */


public class ThreadTest13 {

	public static void main(String[] args) {
		Horse[] horse = new Horse[]{
				new Horse("01번마"), new Horse("02번마"),
				new Horse("03번마"), new Horse("04번마"),
				new Horse("05번마"), new Horse("06번마"),
				new Horse("07번마"), new Horse("08번마"),
				new Horse("09번마"), new Horse("10번마")
		};
		Display disp = new Display(horse);
		for(Horse h : horse){
			h.start();
		}
		disp.start();
		for(Horse h : horse){
			try {
				h.join();
			} catch (InterruptedException e) {}
		}
		try {
			disp.join();
		} catch (InterruptedException e) {}
		Arrays.sort(horse);
		System.out.println("----- 경기 종료 !! -----");
		for(int i = 0; i < horse.length; i++){
			System.out.println(i+1 + "등 : " + horse[i].name);
		}
		System.out.println("--------------------");
	}

}


class Horse extends Thread implements Comparable<Horse>{
	public static int rank = 1;
	public String name;
	private int ranking;
	private int pos;
	

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int state) {
		this.pos = state;
	}

	public Horse(String name) {
		this.name = name;
		this.pos = 0;
	}
	
	public int compareTo (Horse h){
		return new Integer(this.ranking).compareTo(h.ranking);
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 50; i++){
			try {
				Thread.sleep((int)(Math.random()*(500-101+1) +1));
			} catch (InterruptedException e) {}
			pos = i;
		}
		ranking = rank++;
	}
	
}

class Display extends Thread{
	private Horse[] horse;
	
	public Display(Horse[] horse){
		this.horse=horse;
	}
	
	private void displayLane(){
		System.out.println("\n\n\n\n\n\n");
		for(int i = 1; i <= 55; i++){
			System.out.print("=");
		}
		System.out.println();
		for(Horse h : this.horse){
			System.out.print(h.name + " ");
			for(int i = 1; i <= 50; i++){
				if(h.getPos() == i){
					System.out.print("🐎");
				} else {
					System.out.print("-");
				}
				if(h.getPos() == 50 && i == 50){
					System.out.print("\t" + h.getRanking() + "등!!");
				}
			}
			System.out.println();
		}
		for(int i = 1; i <= 55; i++){
			System.out.print("=");
		}
		System.out.println();
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
			displayLane();
			if(Horse.rank==11){
				return;
			}
		}
	}
}





















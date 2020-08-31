package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *  Vector, Hashtable 등의 예전부터 존재하던 Collection 객체들은 내부에 동기화 처리가 되어 있다.
 *  
 *  그런데, 최근에 새로 구성된 Collection들을 동기화 처리가 되어있지 않다.
 *  그래서, 동기화가 필요한 프로그램에서 이런 Collection객체들을 사용하려면
 *  동기화 처리를 한 후에 사용해야 한다. 
 */
public class ThreadTest19 {
	private static Vector<Integer> vec = new Vector<>();

	// 동기화 처리가 되어 있지 않은 List
	private static List<Integer> list = new ArrayList<>();
	
	// 동기화 처리를 한 후의 List
	private static List<Integer> list2 = Collections.synchronizedList(new ArrayList<Integer>()); 
	
	public static void main(String[] args) {
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i <10000; i++){
//					vec.add(i);
					list.add(i);
				}
			}
		};
		
		// -----------------------------------------------
		Thread[] ths = new Thread[]{
				new Thread(r), new Thread(r),new Thread(r),
				new Thread(r),new Thread(r)
		};
		
		for(Thread th : ths){
			th.start();
		}
		for(Thread th : ths){
			try {
				th.join();
			} catch (InterruptedException e) {
			}
		}
		
//		System.out.println("vec의 개수 : " + vec.size());
		System.out.println("vec의 개수 : " + list.size());

	}

}







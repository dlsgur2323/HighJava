package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/*
 *  컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 *  
 *  컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
 *  사용자의 가위 바위 보는 showInputDialog()를 이용해서 입력받는다.
 *  
 *  입력시간은 5초로 제한하고 카운트다운을 진행한다.
 *  5초안에 입력이 없으면 게임을 진것으로 처리한다.
 *  
 *  5초안에 입력이 완료되면 승패를 구해서 출력한다.
 *  
 *  결과 예시)
 *  	-- 결  과 --
 *  	컴퓨터 : 가위
 *  	사용자 : 바위
 *  	결   과 : 당신이 이겼습니다. (졌습니다, 비겼습니다.)
 *  
 * 
 */
public class ThreadTest07 {

	public static void main(String[] args) {
		Thread th1 = new InputThread();
		Thread th2 = new CountDownThread2();
		
		th1.start();
		th2.start();
		try {
			th2.join();
			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		String cpu;
		ArrayList<String> com = new ArrayList<>();
		com.add("가위");
		com.add("바위");
		com.add("보");
		Collections.shuffle(com);
		
		cpu = com.get(0);
		
		System.out.println("-- 결  과 --");
		System.out.println("컴퓨터 : " + cpu);
		System.out.println("사용자 : " + InputThread.str);
		if(InputThread.str.equals(cpu)){
			System.out.println("결과 : 비겼습니다.");
		} else if((InputThread.str.equals("가위") && cpu.equals("바위")) || (InputThread.str.equals("바위") && cpu.equals("보")) || (InputThread.str.equals("보") && cpu.equals("가위"))){
			System.out.println("결과 : 패배했습니다.");
		} else {
			System.out.println("결과 : 승리했습니다.");
		}
		System.exit(0);
		
	}


}

class InputThread extends Thread{
	public static boolean inputCheck;
	public static String str;
	@Override
	public void run() {
		str = JOptionPane.showInputDialog("<가위, 바위, 보> 중에 입력하세요");
		inputCheck = true;
		
	}
}

class CountDownThread2 extends Thread{
	@Override
	public void run() {
		for(int i = 5; i >= 1; i--){
			if(InputThread.inputCheck){
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("제한시간이 지났습니다.");
		System.out.println("-- 패  배 --");
		System.exit(0);
	}
}








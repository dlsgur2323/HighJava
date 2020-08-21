package kr.or.ddit.basic;

import java.util.LinkedList;

public class StackQueueTest {
	/*
	 * Stack ==> LIFO(후입선출)방식의 자료구조
	 * 
	 * Queue ==> FIFO(선입선출)방식의 자료구조
	 * 
	 * Stack과 Queue는 LinkedList를 이용하여 사용할 수 있다.
	 */
	public static void main(String[] args) {
		/*
		 * stack의 명령
		 * 1. 자료 입력 : push(추가할 데이터);
		 * 2. 자료 출력 : pop() ==> 자료를 꺼내온 후에 꺼내온 자료를 Stack에서 지운다.
		 * 			  peek() ==> 삭제 없이 자료를 꺼내온다.
		 */
		
		LinkedList<String> stack = new LinkedList<>();
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");

		System.out.println("현재 stack값 : " + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 값 : " + data);
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("현재 stack값 : " + stack);
		
		String temp = stack.peek();
		System.out.println("peek로 꺼내온 값 : " + temp);
		System.out.println("현재 stack값 : " + stack);
		
		stack.push("성춘향");
		System.out.println("추가한 후 stack값 : " + stack);
		
		System.out.println("꺼재온 값 : " + stack.pop());
		System.out.println("현재 stack값 : " + stack);
		System.out.println("------------------------------------------------------\n");
		
		/*
		 * Queue의 명령
		 * 1. 자료 입력 : offer(추가할 데이터);
		 * 2. 자료 출력 : poll() ==> 자료를 꺼내오고 꺼내온 자료를 Queue에서 삭제한다.
		 * 			  peek() ==> 삭제없이 자료를 꺼내온다.
		 */
		
		LinkedList<String> queue = new LinkedList<>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("현재 queue 값 : " + queue);
		
		data = queue.poll();
		System.out.println("꺼내온 값 : " + data);
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("현재 queue 값 : " + queue);
		
		queue.offer("성춘향");
		System.out.println("현재 queue 값 : " + queue);
		
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("현재 queue 값 : " + queue);
		
		System.out.println("삭제없이 꺼내오기 : " + queue.peek());
		System.out.println("현재 queue 값 : " + queue);
		
	}

}






























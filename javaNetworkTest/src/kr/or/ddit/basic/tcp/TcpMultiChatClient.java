package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {

	public static void main(String[] args) {
		new TcpMultiChatClient().clientStart();

	}
	
	// 클라이언트가 시작하는 메소드
	private void clientStart(){
		Socket socket = null;
		try {
			String serverIp = "localhost";
			socket = new Socket(serverIp, 7777);
			
			System.out.println("서버에 연결되었습니다.");
			System.out.println();
			
			ClientSender sender = new ClientSender(socket);
			ClientReceiver receiver = new ClientReceiver(socket);
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}// clientStart() 메소드 끝...
	
	// 메시지 전송용 쓰레드
	class ClientSender extends Thread {
		private Socket socket;
		private DataOutputStream dos;
		private DataInputStream dis;
		private String name;
		private Scanner scan;
		
		//생성자
		public ClientSender(Socket socket) {
			this.socket = socket;
			scan = new Scanner(System.in);
			try {
				// 전송용 stream
				dos = new DataOutputStream(socket.getOutputStream());
				// feedback 수신용 stream
				dis = new DataInputStream(socket.getInputStream());
				
				if(dos!=null){
					// 클라이언트 프로그램이 처음 실행되면 자신의 대화명을 입력받아 서버로 전송하고
					// 대화명의 중복 여부를 feedback으로 받아서 확인한다.
					System.out.print("대화명 : ");
					String irum = scan.nextLine();
					
					while(true){
						dos.writeUTF(irum); // 대화명 서버로 전송...
						
						String feedback = dis.readUTF(); // 대화명의 중복여부를 서버로부터 받는다.
						
						if(feedback.equals("이름중복")){ // 대화명이 중복될 때...
							System.out.println(irum + "은 중복된 이름입니다.");
							System.out.println("다른 대화명을 입력하세요...");
							System.out.print("대화명 : ");
							irum = scan.nextLine();
						} else {	// 이름이 중복되지 않을 때...
							name = irum;
							System.out.println("이름 : " + name + "으로 대화방에 입장합니다...");
							break; // 반복문 탈출
						}
					} //while문...
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} // 생성자 끝...
		
		@Override
		public void run() {
			try {
				while(dos!=null){
					// 대화 내용을 입력해서 서버로 전송.
					dos.writeUTF("[" + name + "]" + scan.nextLine());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	} // 메시지 전송용 쓰레드 끝
	
	// 메시지 수신용 쓰레드
	class ClientReceiver extends Thread{
		private Socket socket;
		private DataInputStream dis;
		
		//생성자
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				dis = new DataInputStream(socket.getInputStream()); 
			} catch (Exception e) {
				// TODO: handle exception
			}
		} // 생성자 끝..
		
		@Override
		public void run() {
			try {
				while(dis!=null){
					// 수신한 메시지를 화면에 출력
					System.out.println(dis.readUTF());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
}















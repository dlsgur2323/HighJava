package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TcpMultiChatServer {
	// 접속한 클라이언트 정보를 저장할 Map객체 선언
	//  ==> key값 : 접속한 사람 이름, value값 : 접속한 클라이언트와 연결된 Socket객체
	private Map<String, Socket> clientMap;
	
	// 생성자
	public TcpMultiChatServer() {
		// clientMap을 동기화 처리가 되도록 생성한다.
		clientMap = Collections.synchronizedMap(new HashMap<String, Socket>());
	}
	
	
	public static void main(String[] args) {
		new TcpMultiChatServer().serverStart(); 

	}


	private void serverStart(){
		ServerSocket server = null;
		Socket socket = null;
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			while(true){
				socket = server.accept(); // 클라이언트의 접속을 기다린다.
				// 접속이 완료되면...
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]에서 접속했습니다.");
				
				// 데이터를 받아서 전체에게 전송하는 쓰레드 객체 생성 및 실행
				ServerReceiver serverThread = new ServerReceiver(socket);
				serverThread.start();
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	} // serverStart()메소드 끝...
	
	// clientMap에 저장된 전체 사용자에게 메시지를 전송하는 메소드
	private void sendToAll(String msg){
		// clientMap에 저장된 데이터 개수 만큼 반복
		for(String name : clientMap.keySet()){
			try {
				// 각각의 클라이언트와 연결된 소켓에서 OutputStream객체를 구한다.
				DataOutputStream dos = new DataOutputStream(clientMap.get(name).getOutputStream());
				dos.writeUTF(msg);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}// sendToAll() 메소드 끝...
	
	// Inner Class로 각각의 클라이언트가 보내온 메시지를 클라이언트로 전송하는 Thread를 만든다.
	class ServerReceiver extends Thread {
		private Socket socket;
		private DataOutputStream dos;
		private DataInputStream dis;
		
		// 생성자
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				// 송신용 스트림 객체
				dos = new DataOutputStream(socket.getOutputStream());
				// 수신용 스트림 객체
				dis = new DataInputStream(socket.getInputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}// 생성자 끝
		
		@Override
		public void run() {
			String name = ""; 	// 클라이언트가 맨 처음 보내온 이름 데이터를 저장할 변수 선언
			try {
				
				// 클라이언트가 이름 데이터를 보내오면 이 이름이 중복되는지 여부를 검사해서
				// 그 결과를 클라이언트에게 feedback으로 보내준다.
				// (이름이 중복되면 '이름 중복', 중복되지 않으면 'OK'를 feedback으로 보낸다.)
				while(true){
					name = dis.readUTF(); // 이름 받기
					if(clientMap.containsKey(name)){ // 이름이 중복되면
						dos.writeUTF("이름 중복");
					} else { // 중복되지 않으면
						dos.writeUTF("OK");
						break;
					}
				}// while 문...
				
				// 현재 접속자가 보내온 이름으로 이전에 접속되어있는 다른 클라이언트들에게
				// 대화방 참여 메시지를 보낸다.
				sendToAll("[" + name + "]님이 입장했습니다...");
				
				// 대화명(이름)과 Socket객체를 Map에 추가한다.
				clientMap.put(name, socket);
				
				System.out.println("현재 서버 접속자 수 : " + clientMap.size() + "명");
				
				// 한 클라이언트가 보내온 메시지를 전체 클라이언트에게 보낸다.
				while(dis!=null){
					sendToAll(dis.readUTF());
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				// 이 finally 영역이 실행된다는 것은 클라이언트가 접속을 종료했다는 뜻.
				sendToAll("[" + name + "]님이 대화방을 나갔습니다...");
				clientMap.remove(name);
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]에서 접속을 종료했습니다.");
				System.out.println("현재 서버 접속자 수 : " + clientMap.size() + "명");
			}
		}
		
	}
	
}

















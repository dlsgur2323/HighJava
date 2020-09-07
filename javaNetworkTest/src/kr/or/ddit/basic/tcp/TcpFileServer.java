package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7777);
			
			Socket socket = server.accept();
			System.out.println(" 클라이언트가 접속했습니다.");
			System.out.println(" 수신된 파일을 저장합니다.");
			
			InputStream ins = socket.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(ins);
			
			FileOutputStream fout = new FileOutputStream("d:/d_other/download/호랑이_복사본.jpg");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			int c;
			while((c=bis.read()) != -1){
				bout.write(c);
			}
			bout.flush();
			System.out.println(" 파일이 저장 되었습니다.");
			bis.close();
			bout.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}

	}

}

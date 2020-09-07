package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class TcpFileClient {

	public static void main(String[] args) {
		try {
			Socket socket  = new Socket("localhost", 7777);
			System.out.println(" 서버에 연결되었습니다. ");
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("d:/d_other"));
			
			String fileName = null;
			File file = null;
			int result = fileChooser.showOpenDialog(new JPanel());
			if(result == JFileChooser.APPROVE_OPTION){
				file = fileChooser.getSelectedFile();
				fileName = file.getName();
			} else {
				System.out.println("파일 전송을 취소합니다");
				return;
			}
			
			System.out.println(" 파일을 전송합니다.");
			FileInputStream fin = new FileInputStream(file);
			BufferedInputStream bin = new BufferedInputStream(fin);
			
			OutputStream ous = socket.getOutputStream();
			BufferedOutputStream bout = new BufferedOutputStream(ous); 
			
			int c;
			while((c=bin.read()) != -1){
				bout.write(c);
			}
			bout.flush();
			System.out.println(" 파일이 전송 되었습니다.");
			bin.close();
			bout.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

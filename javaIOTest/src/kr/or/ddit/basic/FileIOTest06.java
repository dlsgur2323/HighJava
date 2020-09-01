package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileIOTest06 {

	public static void main(String[] args) {
				try {
					InputStreamReader isr = new InputStreamReader(System.in);
					
					FileOutputStream fout = new FileOutputStream("d:/d_other/outTest.txt");
					
					// 기본 인코딩 방식으로 저장
//					OutputStreamWriter osw = new OutputStreamWriter(fout);
					
					// 인코딩 방식을 지정해서 저장하기
//					OutputStreamWriter osw = new OutputStreamWriter(fout, "ms949");
					OutputStreamWriter osw = new OutputStreamWriter(fout, "utf-8");
					
					
					System.out.println("파일에 저장할 내용을 입력하세요.");
					System.out.println("입력의 마지막은 Ctrl + z 입니다.");
					
					int c;
					// 콘솔에서 데이터를 입력할 때 입력의 끝은 '컨트롤 + z'
					while( (c=isr.read() ) != -1 ){
						osw.write(c);
					}
					// 스트림 객체 닫기
					osw.close();
					isr.close();
					
				} catch (IOException e) {
					// TODO: handle exception
				}
	}

}

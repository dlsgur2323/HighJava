package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest04 {

	public static void main(String[] args) {
		// 사용자가 입력한 내용을 그대로 파일로 출력하기
		try {
			// System.in ==> 콘솔(표준 입출력 장치) 입력 장치
			// InputStreamReader ==> 입력용 바이트 기반 스트림을 문자기반 스트림으로 변환
			// OutputStreamWriter ==> 출력용 바이트 기반 스트림을 문자 기반 스트림으로 변환
			InputStreamReader isr = new InputStreamReader(System.in);
			
			// 문자기반 파일 출력용 스트림 객체 생성 
			FileWriter fw = new FileWriter("d:/d_other/testChar.txt");
			
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("입력의 마지막은 Ctrl + z 입니다.");
			
			int c;
			// 콘솔에서 데이터를 입력할 때 입력의 끝은 '컨트롤 + z'
			while( (c=isr.read() ) != -1 ){
				System.out.println("스트림 내용 " + c);
				fw.write(c);
			}
			// 스트림 객체 닫기
			fw.close();
			isr.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}

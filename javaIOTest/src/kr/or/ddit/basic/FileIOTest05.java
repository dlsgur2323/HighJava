package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest05 {
	/*
	 *  한글이 저장된 파일 읽어오기
	 *  (한글의 인코딩 방식을 지정해서 읽어온다.)
	 */
	public static void main(String[] args) {
//		File f = new File("d:/d_other/text_ansi.txt");
		File f = new File("d:/d_other/text_utf8.txt");
		try {
			//	보통의 FileReader 객체는 java 파일의 인코딩에 맞춰서 데이터를 읽어온다.
//			FileReader fr = new FileReader(f);
			
			// 입출력할 파일의 인코딩 방식을 지정할 수 있는 스트림 객체는
			// inputStreamReader와 OutputStreamReader
			
			FileInputStream fin = new FileInputStream(f);
			
			// 기본 인코딩 방식
//			InputStreamReader isr = new InputStreamReader(fin);
			
			// 인코딩 방식을 지정해서 읽어오기
			// 인코딩 지정 문자를 설정해서 객체를 생성한다.
			// 인코딩 지정 문자
			// - MS949	 	=> 윈도우의 기본 한글 인코딩 방식 (ANSI 방식)
			// - UTF-8		=> 유니코드의 UTF-8 인코딩 방식
			// - US-ASCII	=> 영문 전용 인코딩 방식
//			InputStreamReader isr = new InputStreamReader(fin, "ms949"); // ansi 방식
			InputStreamReader isr = new InputStreamReader(fin, "utf-8"); // ansi 방식
			
			
			int c;
			while((c=isr.read()) != -1){
				System.out.print((char)c);
			}
			
			isr.close();
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}

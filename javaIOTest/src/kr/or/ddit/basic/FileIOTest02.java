package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 파일 출력용 스트림 객체 생성
			File f = new File("d:/d_other/out.txt");
			FileOutputStream fout = new FileOutputStream(f);
			// 해당 파일이 없으면 새로 만들어줌, 있으면 덮어씀
			
			for(char ch='A'; ch<='Z'; ch++){
				fout.write(ch); // ch변수의 데이터를 파일로 출력한다.
			}
			System.out.println("출력 작업 완료...");
			
			fout.close();	// 스트림 닫기
			
			// ----------------------------------------------
			
			// 저장된 파일 내용을 읽어와 출력하기
			FileInputStream fin = new FileInputStream(f);
			int c;
			System.out.println(f.getName() + "파일에서 읽어온 내용 : ");
			while((c=fin.read()) != -1){
				System.out.print((char)c);
			}
			
			fin.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

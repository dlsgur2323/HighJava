package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	"d:/d_other" 폴더에 있는 "호랑이.jpg" 파일을
	"d:/d_other/연습용" 폴더에 "호랑이_복사본.jpg" 파일로 저장하시오.
*/

public class FileCopy {

	public static void main(String[] args) {
			File f = new File("d:/d_other/호랑이.jpg");
		try {
			FileInputStream fin = new FileInputStream(f);
			BufferedInputStream bin = new BufferedInputStream(fin);
			
			FileOutputStream fout = new FileOutputStream("d:/d_other/연습용/호랑이_복사본.jpg");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			int c;
			
			byte[] temp = new byte[1024]; // 데이터가 저장될 배열 변수
			int len = 0;
			System.out.println("복사 시작...");
			
			//1byte씩 복사
//			while((c=fin.read()) != -1){
//				fout.write(c);
//			}
//			fout.flush();
			
			// 배열을 이용한 복사
			while((len=fin.read(temp)) >0){
				fout.write(temp, 0, len);
			}
			fout.flush();
			
			// 버퍼 스트림을 이용한 복사
			while((c=fin.read(temp)) != -1){
				bout.write(c);
			}
			bout.flush();
			
			System.out.println("복사 완료...");
			bout.close();
			fout.close();
			fin.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

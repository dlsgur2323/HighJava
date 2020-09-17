package kr.or.ddit.basic;

import java.security.NoSuchAlgorithmException;

import kr.or.ddit.util.AES256Util;
import kr.or.ddit.util.CryptoUtil;

public class CryptoTest {

	public static void main(String[] args) throws Exception {
//		String testData = "Hello, world";
		String testData = "안녕하세요, 이 문장은 암호화에 사용될 문장입니다.";
		
		System.out.println("MD5 : " + CryptoUtil.md5(testData));
		System.out.println("SHA-256 : " + CryptoUtil.sha256(testData));
		System.out.println("SHA-512 : " + CryptoUtil.sha512(testData));
		System.out.println("--------------------------------------------");
		// -------------------------------------------------------------
		
		AES256Util aes256 = new AES256Util();

		System.out.println("AES256 암호화하기 전 : " + testData);
		// 암호화 작업
		String str = aes256.encrypt(testData);
		System.out.println("AES256 암호화한 후 : " + str);
		
		// 복호화 작업
		String deStr = aes256.decrypt(str);
		System.out.println("AED256 복호화한 후 : " + deStr);
		
	}

}

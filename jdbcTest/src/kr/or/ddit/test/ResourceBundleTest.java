package kr.or.ddit.test;

import java.util.ResourceBundle;

/*
 *	ResourceBundleTest ==> 파일의 확장자가 properties인 파일을 읽어와
 *	key값과 value값으로 분리해서 정보글 갖고 있는 객체
 *
 *	==> 읽어올 파일의 내용은 'key값=value값' 형태로 저장되어 있어야 한다.
 */
public class ResourceBundleTest {

	public static void main(String[] args) {
		// ResourceBundle객체 생성
		// 			==> 읽어올 파일명을 지정할 때 '파일명'만 지정하고 확장자는 지정하지 않는다.
		//			==> 확장자는 항상 'properties'이기 때문이다.
		ResourceBundle bundle = ResourceBundle.getBundle("dbinfo");
		
		// 읽어온 내용 출력하기
		System.out.println("driver : " + bundle.getString("driver"));
		System.out.println("url : " + bundle.getString("url"));
		System.out.println("user : " + bundle.getString("user"));
		System.out.println("password : " + bundle.getString("password"));

	}

}

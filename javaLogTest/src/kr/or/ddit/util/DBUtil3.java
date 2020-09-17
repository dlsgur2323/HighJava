package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

// 이 클래스는 JDBC드라이버를 로딩하고 DB시스템에 접속하여 Connection객체를 반환하는 역할을 수행하는 클래스이다.

public class DBUtil3 {
	private static Logger logger = Logger.getLogger(DBUtil3.class);
	private static ResourceBundle bundle;
	
	// static 초기화 블럭
	static {
		bundle = ResourceBundle.getBundle("dbinfo"); // ResourceBundle객체 생성
		logger.info("ResourceBundle객체 생성 -dbinfo.properties파일 읽기");
		
		try {
			Class.forName(bundle.getString("driver"));
			logger.info("DB 드라이버 로딩 성공!!!");
		} catch (ClassNotFoundException e) {
			logger.error("DB 드라이버 로딩 실패~~~ ==> " + e.getMessage());
//			e.printStackTrace();
		}
	}
	// DB시스템에 접속한 후 접속 정보를 갖는 Connection객체를 반환하는 메소드
	public static Connection getConnection() {
		try {
			String url = bundle.getString("url");
			String user = bundle.getString("user");
			String password = bundle.getString("password");
			logger.info("DB에 연결하기 ==> Connection객체 생성!!");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			logger.error("DB에 연결 실패~~~ ==> " + e.getMessage());
//			System.out.println("오라클 연결 실패!!");
			return null;
		}
	}
}

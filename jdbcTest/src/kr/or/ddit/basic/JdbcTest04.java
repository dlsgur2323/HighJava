package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "dlsgur";
			String password = "java";
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("계좌번호 정보 추가하기");
			System.out.print("계좌번호 : ");
			String bankNo = scan.next();
			
			System.out.print("은 행 명 : ");
			String bankName = scan.next();
			
			System.out.print("예금주명 : ");
			String bankUser = scan.next();
			
//			// Statement객체를 이용하여 데이터 추가하기
//			String sql = "INSERT INTO BANKINFO (BANK_NO, BANK_NAME, BANK_USER_NAME, BANK_DATE)"
//					+ " VALUES('"+bankNo+ "', '" + bankName + "', '" + bankUser + "', SYSDATE)"; 
//			
//			stmt = conn.createStatement();
////			
//			// 실행할 sql문이 select문일 경우에는 executeQuery() 메소드를 사용하고,
//			// 실행할 sql문이 select문이 아닐 경우에는 executeUpdate() 메소드를 사용한다,
//			// executeUpdate() 메소드의 반환값 ==> 작업에 성공한 레코드 수
//			int cnt = stmt.executeUpdate(sql);
//			System.out.println("반환값 : " + cnt);

			String sql = "insert into bankinfo (bank_no, bank_name, bank_user_name, bank_date)"
					+ " values (?, ?, ?, sysdate)";
			
			pstmt = conn.prepareStatement(sql);
			// SQL문의 물음표 자리에 들어갈 데이터를 세팅
			pstmt.setString(1, bankNo);
			pstmt.setString(2, bankName);
			pstmt.setString(3, bankUser);
			
			// sql문 실행
			int cnt = pstmt.executeUpdate();
			
			System.out.println("반환값 : " + cnt);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) try {stmt.close();} catch (Exception e2) {}
			if(pstmt != null) try {pstmt.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
		}
 
	}

}

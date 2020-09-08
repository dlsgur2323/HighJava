package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 *  Lprod 테이블에 새로운 데이터 추가하기
 *  
 *  lprod_gu와 lprod_nm은 직접 입력받아서 처리하고,
 *  lprod_id는 현재의 lprod_id중 제일 큰 값보다 1 크게 한다.
 *  그리고, 입력받은 lprod_gu가 이미 등록되어 있으면 다시 입력받는다.
 *  
 */
public class JdbcTest05 {
	Scanner scan = new Scanner(System.in);
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		new JdbcTest05().insert();

	}

	private void insert(){
		
			String lprod_gu = lprodcheck();
				
			System.out.print("lprod_nm 입력 : ");
			String lprod_nm = scan.next();
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "dlsgur";
				String password = "java";
				conn = DriverManager.getConnection(url, user, password);
				
				String sql = "INSERT INTO LPROD (LPROD_ID, LPROD_GU, LPROD_NM)"
						+ " VALUES ( (SELECT MAX(LPROD_ID) FROM LPROD)+1, UPPER(?), ?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, lprod_gu);
				ps.setString(2, lprod_nm);
				int cnt = ps.executeUpdate();
				if(cnt > 0){
					System.out.println("데이터 입력 성공");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	private String lprodcheck(){
		
		String gu = "";
		try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "dlsgur";
		String password = "java";
		conn = DriverManager.getConnection(url, user, password);
		
		
		while(true){
			System.out.print("lprod_gu 입력 : ");
			gu = scan.next();
			
			String sql = "SELECT COUNT(*) FROM LPROD WHERE LPROD_GU = UPPER(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, gu);
			rs = ps.executeQuery();
		
			while(rs.next()){
				if(rs.getInt(1) == 0){
					return gu;
				} else {
					System.out.println("중복입니다. 다시 입력하세요");
					break;
				}
			}
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return gu;
	}
	
	
	
}













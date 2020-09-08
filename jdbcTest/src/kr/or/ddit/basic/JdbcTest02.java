package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

// 문제1) 사용자로부터 Lprod_id 값을 입력받아 입력한 값보다 lprod_id가 큰 자료들을 출력하시오

// 문제2) lprod_id값을 2개 입력 받아서 두 값 중 작은값부터 큰값 사이의 자료들을 출력하시오.
public class JdbcTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력 1~9");
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int input = Integer.parseInt(sc.nextLine());
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "dlsgur";
			String password = "java";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM LPROD WHERE LPROD_ID > "+ input;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			
			for(int i=1; i<=md.getColumnCount(); i++){
				System.out.print(md.getColumnName(i) + "\t");
			}
			System.out.println();
			while(rs.next()){
				for(int i=1; i <= md.getColumnCount(); i++){
					System.out.print(rs.getObject(md.getColumnName(i)) + "\t\t");
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch (SQLException e2) {}
			if(st!=null) try { st.close(); } catch (SQLException e2) {}
			if(conn!=null) try { conn.close(); } catch (SQLException e2) {}
		}
		
		System.out.println("숫자1 입력 1~9");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("숫자2 입력 1~9");
		int num2 = Integer.parseInt(sc.nextLine());
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "dlsgur";
			String password = "java";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM LPROD WHERE LPROD_ID BETWEEN " +Math.min(num1, num2)+" AND " + Math.max(num1, num2);
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			
			for(int i=1; i<=md.getColumnCount(); i++){
				System.out.print(md.getColumnName(i) + "\t");
			}
			System.out.println();
			while(rs.next()){
				for(int i=1; i <= md.getColumnCount(); i++){
					System.out.print(rs.getObject(md.getColumnName(i)) + "\t\t");
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch (SQLException e2) {}
			if(st!=null) try { st.close(); } catch (SQLException e2) {}
			if(conn!=null) try { conn.close(); } catch (SQLException e2) {}
		}
	}

}

package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil3;

/*
 * 	회원을 관리하는 프로그램을 작성하시오.
 * 	(오라클 DB의 MYMEMBER테이블 이용)
 * 	아래 메뉴의 기능을 모두 구현하시오. (CRUD 구현하기 연습)
 * 	메뉴예시)
 * 		  -- 작업 선택 --
 * 		1. 자료 추가
 * 		2. 자료 삭제
 * 		3. 자료 수정
 * 		4. 전체 자료 출력
 * 		0. 작업 끝
 * 		----------------
 * 		원하는 작업 선택 >>
 * 
 * 	
 */

public class JdbcTest06 {
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		new JdbcTest06().start();
	}
		
	private void start() {
		while(true){
			System.out.println("\n\n\n");
			System.out.println("-- 작업 선택 --");
			System.out.println("1. 자료 추가");
			System.out.println("2. 자료 삭제");
			System.out.println("3. 자료 수정");
			System.out.println("4. 전체 자료 출력");
			System.out.println("0. 작업 끝");
			System.out.println("------------");
			System.out.print("원하는 작업 선택 >");
			int input = Integer.parseInt(sc.nextLine());
			switch(input){
			case 1 :
				insertData();
				break;
			case 2 :
				deleteData();
				break;
			case 3 :
				updateData();
				break;
			case 4 :
				printData();
				break;
			case 0 :
				System.out.println("작업 종료...");
				System.exit(0);
			}
		}
	}

	private void printData() {
		System.out.println("\t-- 전체 자료 출력 --\n");
		conn = DBUtil3.getConnection();
		try {
			String sql = "SELECT * FROM MYMEMBER";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			for(int i = 1; i <= md.getColumnCount(); i++){
				System.out.print(md.getColumnName(i) + "\t");
			}
			System.out.println();
			while(rs.next()){
				for(int i = 1; i <= md.getColumnCount(); i++){
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		System.out.println("-------------------------------------");
	}

	private void updateData() {
		System.out.println("-- 자료 수정 --");
		String id = "";
		checker:
		while(true){
			System.out.print("수정할 id >");
			id = sc.nextLine();
			
			conn = DBUtil.getConnection();
			try {
				String sql = "SELECT COUNT(*) FROM MYMEMBER WHERE MEM_ID = UPPER(?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				
				while(rs.next()){
					if(rs.getInt(1) > 0){
						break checker;
					} else {
						System.out.println("존재하지 않는 ID 입니다.");
						return;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try {rs.close();} catch (Exception e2) {}
				if(ps != null) try {ps.close();} catch (Exception e2) {}
			}
		}// 전체 while 끝
		System.out.print("이 름 >");
		String name = sc.nextLine();
		System.out.print("PH >");
		String ph = sc.nextLine();
		System.out.print("주 소 >");
		String addr = sc.nextLine();
		try {
			String sql = "UPDATE MYMEMBER SET MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ?"
					+ " WHERE MEM_ID = UPPER(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, ph);
			ps.setString(3, addr);
			ps.setString(4, id);
			int cnt = ps.executeUpdate();
			if(cnt > 0){
				System.out.println("자료 수정 완료..!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null) try {ps.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
		}
	}

	private void deleteData() {
		System.out.println("-- 자료 삭제 --");
		String id = "";
		checker:
		while(true){
			System.out.print("삭제할 id >");
			id = sc.nextLine();
			
			conn = DBUtil.getConnection();
			try {
				String sql = "SELECT COUNT(*) FROM MYMEMBER WHERE MEM_ID = UPPER(?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				
				while(rs.next()){
					if(rs.getInt(1) > 0){
						break checker;
					} else {
						System.out.println("존재하지 않는 ID 입니다.");
						return;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try {rs.close();} catch (Exception e2) {}
				if(ps != null) try {ps.close();} catch (Exception e2) {}
			}
		}// 전체 while 끝
		
		try {
			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = UPPER(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int cnt = ps.executeUpdate();
			if(cnt > 0){
				System.out.println("자료 삭제 완료..!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) try {ps.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
		}
	}

	private void insertData() {
		System.out.println("-- 자료 추가 --");
		String id = "";
		checker:
		while(true){
			System.out.print("id >");
			id = sc.nextLine();
			
			conn = DBUtil.getConnection();
			try {
				String sql = "SELECT COUNT(*) FROM MYMEMBER WHERE MEM_ID = UPPER(?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				
				while(rs.next()){
					if(rs.getInt(1) > 0){
						System.out.println("중복된 ID 입니다. 다시 입력하세요.");
						break;
					} else {
						break checker;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try {rs.close();} catch (Exception e2) {}
				if(ps != null) try {ps.close();} catch (Exception e2) {}
			}
		}// 전체 while 끝
		
		System.out.print("이 름 >");
		String name = sc.nextLine();
		System.out.print("PH >");
		String ph = sc.nextLine();
		System.out.print("주 소 >");
		String addr = sc.nextLine();
		
		try {
			String sql = "INSERT INTO MYMEMBER (MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR)"
					+ "	VALUES (UPPER(?), ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, ph);
			ps.setString(4, addr);
			int cnt = ps.executeUpdate();
			if(cnt > 0){
				System.out.println("자료 추가 완료..!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) try {ps.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
		}
	}

}

package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao{
	private static Logger logger = Logger.getLogger(MemberDaoImpl.class);
	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "INSERT INTO MYMEMBER (MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR)"
					+ "	VALUES (?, ?, ?, ?)";
			logger.info("실행된 SQL문 ==> INSERT INTO MYMEMBER (MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR) VALUES (?, ?, ?, ?)");
			ps = conn.prepareStatement(sql);
			ps.setString(1, memVo.getMem_id());
			ps.setString(2, memVo.getMem_name());
			ps.setString(3, memVo.getMem_tel());
			ps.setString(4, memVo.getMem_addr());
			logger.info("사용된 데이터 ==> [" + memVo.getMem_id() + ", " + memVo.getMem_name() + ", " + memVo.getMem_tel() + ", " + memVo.getMem_addr()+"]");
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null) try {ps.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		Connection conn = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
			logger.info("실행된 SQL문 ==> DELETE FROM MYMEMBER WHERE MEM_ID = ?");
			ps = conn.prepareStatement(sql);
			ps.setString(1, memId);
			logger.info("사용된 데이터 ==> [" + memId + "]");
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null) try {ps.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "UPDATE MYMEMBER SET MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ?"
					+ " WHERE MEM_ID = ?";
			logger.info("실행된 SQL문 ==> UPDATE MYMEMBER SET MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ?");
			ps = conn.prepareStatement(sql);
			ps.setString(1, memVo.getMem_name());
			ps.setString(2, memVo.getMem_tel());
			ps.setString(3, memVo.getMem_addr());
			ps.setString(4, memVo.getMem_id());
			logger.info("사용된 데이터 ==> [" + memVo.getMem_id() + ", " + memVo.getMem_name() + ", " + memVo.getMem_tel() + ", " + memVo.getMem_addr()+"]");
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps != null) try {ps.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MemberVO> memList = null;
		try {
			conn = DBUtil3.getConnection();
			String sql = "SELECT * FROM MYMEMBER";
			logger.info("실행된 SQL문 ==> SELECT * FROM MYMEMBER");
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			memList = new ArrayList<>();
			while(rs.next()){
				MemberVO memVo = new MemberVO();
				memVo.setMem_id(rs.getString("MEM_ID"));
				memVo.setMem_name(rs.getString("MEM_NAME"));
				memVo.setMem_tel(rs.getString("MEM_TEL"));
				memVo.setMem_addr(rs.getString("MEM_ADDR"));
				memList.add(memVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(ps != null) try {ps.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
		}
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "SELECT COUNT(*) FROM MYMEMBER WHERE MEM_ID = ?";
			logger.info("실행된 SQL문 ==> SELECT COUNT(*) FROM MYMEMBER WHERE MEM_ID = ?");
			ps = conn.prepareStatement(sql);
			ps.setString(1, memId);
			logger.info("사용된 데이터 ==> [" + memId + "]");
			rs = ps.executeQuery();
			while(rs.next()){
				cnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch (Exception e2) {}
			if(ps != null) try {ps.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
		}
		return cnt;
	}

	@Override
	public int updateMember2(Map<String, String> param) {
		Connection conn = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "UPDATE MYMEMBER SET " + param.get("field") + " = ? WHERE MEM_ID = ?";
			logger.info("실행된 SQL문 ==> UPDATE MYMEMBER SET " + param.get("field") + " = ? WHERE MEM_ID = ?");
			ps = conn.prepareStatement(sql);
			ps.setString(1, param.get("data"));
			ps.setString(2, param.get("id"));
			logger.info("사용된 데이터 ==> [" + param.get("data") + ", " + param.get("id") + ", " + param.get("field") +"]");
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			if(ps != null) try {ps.close();} catch (Exception e2) {}
			if(conn != null) try {conn.close();} catch (Exception e2) {}
		}
		return cnt;
	}

}

package kr.or.ddit.mvc.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
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

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.AES256Util;

public class MemberDaoImpl implements IMemberDao{
	private static MemberDaoImpl dao;
	private SqlMapClient smc;
	private MemberDaoImpl(){
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			// 1-2. 환경 설정파일 읽어오기
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			// 1-3. 위에서 읽어온 Reader객체를 이용하여 실제 환경설정을 완성한 후 
			//		sql문을 호출해서 실행할 수 있는 객체를 생성한다.
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close(); // 스트림 닫기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDaoImpl getInstance(){
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		
		int cnt = 0;
		try {
			Object obj = smc.insert("mymember.insertMember", memVo);
			if(obj==null) cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		
		int cnt = 0;
		try {
			AES256Util aes256 = new AES256Util();
			String memid = aes256.encrypt(memId);
			cnt = smc.delete("mymember.deleteMember", memid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		
		int cnt = 0;
		try {
			cnt = smc.update("mymember.updateMember", memVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> memList = null;
		try {
			memList = smc.queryForList("mymember.getAllMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		int cnt = 0;
		try {
			AES256Util aes256 = new AES256Util();
			String memid = aes256.encrypt(memId);
			cnt = (int)smc.queryForObject("mymember.getMemberCount", memid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember2(Map<String, String> param) {
		int cnt = 0;
		try {
			cnt = smc.update("mymember.updateMember2", param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}

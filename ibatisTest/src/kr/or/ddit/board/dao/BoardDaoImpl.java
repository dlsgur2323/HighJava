package kr.or.ddit.board.dao;

import java.io.BufferedReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.board.vo.BoardVo;

public class BoardDaoImpl implements IBoardDao{
	
	private static BoardDaoImpl boardDao;
	private SqlMapClient smc;
	
	private BoardDaoImpl(){
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			// 1-2. 환경 설정파일 읽어오기
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			// 1-3. 위에서 읽어온 Reader객체를 이용하여 실제 환경설정을 완성한 후 
			//		sql문을 호출해서 실행할 수 있는 객체를 생성한다.
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close(); // 스트림 닫기
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static BoardDaoImpl getInstance(){
		if(boardDao==null) boardDao = new BoardDaoImpl();
		return boardDao;
	}
	
	
	
	@Override
	public int insertBoard(BoardVo boardVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("jdbc_board.insertBoard", boardVo);
			if(obj==null) cnt=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int cnt = 0;
		try {
			cnt = smc.delete("jdbc_board.deleteBoard", boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		int cnt = 0;
		try {
			cnt = smc.update("jdbc_board.updateBoard", boardVo);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public List<BoardVo> getAllBoard() {
		List<BoardVo> boardList = null;
		try {
			boardList = smc.queryForList("jdbc_board.getAllBoard");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return boardList;
	}
	
	@Override
	public List<BoardVo> getAllTitle(String title) {
		List<BoardVo> boardList = null;
		title = "%"+title+"%";
		try {
			boardList = smc.queryForList("jdbc_board.getAllTitle", title);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return boardList;
	}

	@Override
	public BoardVo getOneBoard(int boardNo) {
		BoardVo boardVo = null;
		try {
			boardVo = (BoardVo)smc.queryForObject("jdbc_board.getOneBoard",boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return boardVo;
	}

	@Override
	public int getBoardCount(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCnt(int boardNo) {
		try {
			int cnt = smc.update("jdbc_board.updateCnt", boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	
	public static String clobToString(Clob clob) throws Exception {
		StringBuffer s = new StringBuffer();
		BufferedReader br = new BufferedReader(clob.getCharacterStream());
		String ts = "";
		while((ts = br.readLine()) != null) {
			s.append(ts + "\n");
		}
		br.close();
		return s.toString();
	}


}

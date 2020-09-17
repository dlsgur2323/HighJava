package kr.or.ddit.mvc2.jdbc_board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc2.jdbc_board.vo.BoardVo;

public interface IBoardDao {
	public int insertBoard(BoardVo boardVo);
	
	public int deleteBoard(int boardNo);
	
	public int updateBoard(Map<String, String> boardMap, int boardNo);
	
	public List<BoardVo> getAllBoard();
	
	public BoardVo getOneBoard(int boardNo);
	
	public int getBoardCount(int boardNo);
	
	public List<BoardVo> getAllTitle(String title);
	
	public void updateCnt(int boardNo);
	
	
	
}

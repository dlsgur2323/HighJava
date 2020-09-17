package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVo;

public interface IBoardService {
	
	public int insertBoard(BoardVo boardVo);
	
	public int deleteBoard(int boardNo);
	
	public int updateBoard(BoardVo boardVo);
	
	public List<BoardVo> getAllBoard();
	
	public BoardVo getOneBoard(int boardNo);
	
	public int getBoardCount(int boardNo);
	
	public List<BoardVo> getAllTitle(String title);
	
	public void updateCnt(int boardNo);
}

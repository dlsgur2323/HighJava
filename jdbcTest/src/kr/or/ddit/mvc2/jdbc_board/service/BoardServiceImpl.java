package kr.or.ddit.mvc2.jdbc_board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc2.jdbc_board.dao.BoardDaoImpl;
import kr.or.ddit.mvc2.jdbc_board.dao.IBoardDao;
import kr.or.ddit.mvc2.jdbc_board.vo.BoardVo;

public class BoardServiceImpl implements IBoardService{
	
	private static BoardServiceImpl boardService;
	
	public static BoardServiceImpl getInstance(){
		if(boardService==null) boardService = new BoardServiceImpl();
		return boardService;
	}
	
	private IBoardDao dao;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	@Override
	public int insertBoard(BoardVo boardVo) {
		return dao.insertBoard(boardVo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return dao.deleteBoard(boardNo);
	}

	@Override
	public int updateBoard(Map<String, String> boardMap, int boardNo) {
		return dao.updateBoard(boardMap, boardNo);
	}

	@Override
	public List<BoardVo> getAllBoard() {
		return dao.getAllBoard();
	}

	@Override
	public BoardVo getOneBoard(int boardNo) {
		return dao.getOneBoard(boardNo);
	}

	@Override
	public int getBoardCount(int boardNo) {
		return dao.getBoardCount(boardNo);
	}

	@Override
	public void updateCnt(int boardNo) {
		dao.updateCnt(boardNo);
	}

	@Override
	public List<BoardVo> getAllTitle(String title) {
		return dao.getAllTitle(title);
	}

}

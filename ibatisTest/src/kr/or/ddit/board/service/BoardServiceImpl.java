package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVo;

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
	public int updateBoard(BoardVo boardVo) {
		return dao.updateBoard(boardVo);
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

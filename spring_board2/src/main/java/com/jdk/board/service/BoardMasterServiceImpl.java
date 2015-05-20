package com.jdk.board.service;

import java.util.List;

import com.jdk.board.dao.BoardMasterDao;
import com.jdk.vo.BoardVO;


public class BoardMasterServiceImpl implements BoardMasterService{
	private BoardMasterDao boardMasterDao;
	
	public void setBoardMasterDao(BoardMasterDao boardMasterDao) {
		this.boardMasterDao = boardMasterDao;
	}

	@Override
	public List boardSelect(BoardVO boardvo) throws Exception {
		return boardMasterDao.boardSelect(boardvo);
	}

	@Override
	public int boardSelectCount(BoardVO boardvo) throws Exception {
		return boardMasterDao.boardSelectCount(boardvo);
	}
	
	@Override
	public void boardViewCount(BoardVO boardvo) throws Exception {
		boardMasterDao.boardViewCount(boardvo);
	}

	@Override
	public BoardVO boardView(BoardVO baordvo) throws Exception {
		return boardMasterDao.boardView(baordvo);
	}

	@Override
	public void boardDelete(BoardVO boardvo) throws Exception {
		boardMasterDao.boardDelete(boardvo);
	}

	@Override
	public void boardUpdate(BoardVO boardvo) throws Exception {
		boardMasterDao.boardUpdate(boardvo);
	}

	@Override
	public void boardInsert(BoardVO boardvo) throws Exception {
		boardMasterDao.boardInsert(boardvo);
	}

}

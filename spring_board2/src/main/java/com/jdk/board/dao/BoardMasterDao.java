package com.jdk.board.dao;

import java.util.List;

import com.jdk.vo.BoardVO;

public interface BoardMasterDao {

	//게시판리스트
	public List boardSelect(BoardVO boardvo) throws Exception;
	
	//게시판리스트
	public int boardSelectCount(BoardVO boardvo) throws Exception;
		
	//게시판 조회수 증가
	public void boardViewCount(BoardVO boardvo) throws Exception;
	
	//게시판 뷰
	public BoardVO boardView(BoardVO baordvo) throws Exception;
	
	//게시글 삭제
	public void boardDelete(BoardVO boardvo) throws Exception;
	
	//게시글 수정
	public void boardUpdate(BoardVO boardvo) throws Exception;
	
	//게시글 작성
	public void boardInsert(BoardVO boardvo) throws Exception;
}

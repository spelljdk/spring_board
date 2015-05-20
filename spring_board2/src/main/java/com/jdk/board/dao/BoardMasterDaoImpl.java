package com.jdk.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jdk.vo.BoardVO;

public class BoardMasterDaoImpl implements BoardMasterDao{
	private String sqlPath = "sql.MapperMaster.Board";
	private SqlSession sqlsession;
	
	
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}

	@Override
	public List boardSelect(BoardVO boardvo) throws Exception {
		return sqlsession.selectList(sqlPath+".boardSelect", boardvo);
	}
	
	@Override
	public int boardSelectCount(BoardVO boardvo) throws Exception {
		return sqlsession.selectOne(sqlPath+".boardSelectCount", boardvo);
	}

	@Override
	public void boardViewCount(BoardVO boardvo) throws Exception {
		sqlsession.update(sqlPath+".boardViewCount", boardvo);
		
	}

	@Override
	public BoardVO boardView(BoardVO baordvo) throws Exception {
		return (BoardVO) sqlsession.selectOne(sqlPath+".boardView", baordvo);
	}

	@Override
	public void boardDelete(BoardVO boardvo) throws Exception {
		sqlsession.update(sqlPath+".boardDelete", boardvo);
		
	}

	@Override
	public void boardUpdate(BoardVO boardvo) throws Exception {
		sqlsession.update(sqlPath+".boardUpdate", boardvo);
		
	}

	@Override
	public void boardInsert(BoardVO boardvo) throws Exception {
		sqlsession.insert(sqlPath+".boardInsert", boardvo);
	}
}

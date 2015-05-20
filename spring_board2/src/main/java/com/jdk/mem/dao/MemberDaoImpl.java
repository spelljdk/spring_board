package com.jdk.mem.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.jdk.vo.MemberVO;

@Service("memberDao")
public class MemberDaoImpl implements MemberDao{
	private SqlSession sqlsession;
	private String sqlPath = "sql.MapperMaster.Member";
	
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	/*회원검색*/
	@Override
	public MemberVO memberSelect(MemberVO membervo) throws SQLException {
		return sqlsession.selectOne(sqlPath+".memberSelect",membervo);
	}

	/*회원찾기*/
	@Override
	public MemberVO memberIDFind(MemberVO membervo) throws Exception {
		return sqlsession.selectOne(sqlPath+".memberSelect",membervo);
	}

	/*회원가입*/
	@Override
	public void memberInsert(MemberVO membervo) throws Exception {
		sqlsession.selectOne(sqlPath+".memberInsert",membervo);
	}
	
	/*회원존재여부*/
	@Override
	public int memberCount(MemberVO membervo) throws Exception {
		return sqlsession.selectOne(sqlPath+".memberExist",membervo);
	}

}

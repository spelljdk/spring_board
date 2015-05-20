package com.jdk.mem.dao;

import java.sql.SQLException;

import com.jdk.vo.MemberVO;

public interface MemberDao {
	/*회원검색*/
	public MemberVO memberSelect(MemberVO membervo) throws SQLException;
	
	/*회원찾기*/
	public MemberVO memberIDFind(MemberVO membervo) throws Exception;
	
	/*회원가입*/
	public void memberInsert(MemberVO membervo) throws Exception;
	
	/*회원존재여부*/
	public int memberCount(MemberVO membervo) throws Exception;
}

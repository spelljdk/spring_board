package com.jdk.mem.service;

import java.sql.SQLException;

import com.jdk.vo.MemberVO;

public interface MemberService {
	/*회원검색*/
	public MemberVO memberSelect(MemberVO membervo) throws SQLException;
	
	/*회원찾기*/
	public MemberVO memberFind(MemberVO membervo) throws Exception;
	
	/*회원가입*/
	public void memberInsert(MemberVO membervo) throws Exception;
	
	/*회원존재여부*/
	public int memberCount(MemberVO membervo) throws Exception;
}

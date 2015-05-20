package com.jdk.mem.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdk.mem.dao.MemberDao;
import com.jdk.mem.dao.MemberDaoImpl;
import com.jdk.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl  implements MemberService{
	@Autowired
	public MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	/*�α���*/
	public MemberVO memberSelect(MemberVO membervo) throws SQLException{
		return memberDao.memberSelect(membervo);
	}
	
	/*ȸ������*/
	public void memberInsert(MemberVO membervo) throws Exception{
		memberDao.memberInsert(membervo);
	}
	
	/*ȸ��ã��*/
	public MemberVO memberFind(MemberVO membervo) throws Exception{
		return memberDao.memberIDFind(membervo);
	}
	
	/*회원존재여부*/
	@Override
	public int memberCount(MemberVO membervo) throws Exception {
		return memberDao.memberCount(membervo);
	}
}

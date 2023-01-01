package com.mission3.service;

import java.util.List;

import com.mission3.dao.MemberDaoH2Impl;
import com.mission3.dao.MemberDaoListImpl;
import com.mission3.dao.MemberInterface;
import com.mission3.domain.MemberVO;

public class MemberService {
	private MemberInterface memberDao;
	
	public MemberService() {
		memberDao = new MemberDaoH2Impl();
//		memberDao = new MemberDaoListImpl();
//		memberDao = new MemberDaoFileImpl();
	}

	public MemberVO postMember(int id, String pass, String name) {
		System.out.println("MemberService - postMember()");
		return memberDao.postMember(id,pass,name);
	}
	
	public List<MemberVO> getMembers() {
		System.out.println("MemberService - getMembers()");
		return memberDao.getMembers();
	}

	public MemberVO getMember(int id) {
		System.out.printf("MemberService - getMember(%s)\n", id);
		return memberDao.getMember(id);
	}

	public MemberVO putMember(int id, String pass, String name) {
		System.out.println("MemberService - putMember()");
		return memberDao.putMember(id,pass,name);
	}

	public MemberVO deleteMember(int id) {
		System.out.println("MemberService - deleteMember()");
		return memberDao.deleteMember(id);
	}
	



}

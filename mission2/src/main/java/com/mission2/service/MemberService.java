package com.mission2.service;

import java.util.List;

import com.mission2.dao.MemberDao;
import com.mission2.domain.MemberVO;

public class MemberService {

	MemberDao memberDao; 
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	public MemberVO postMember(MemberVO memberVO) {
		System.out.println("MemberService - postMember()");
		return memberDao.postMember(memberVO);
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
		return memberDao.putMembers(id,pass,name);
	}

	public MemberVO deleteMember(int id) {
		System.out.println("MemberService - deleteMember()");
		return memberDao.deleteMember(id);
	}

}

package com.mission3.dao;

import java.util.List;

import com.mission3.domain.MemberVO;

public interface MemberInterface {

	MemberVO postMember(int id, String pass, String name);

	 List<MemberVO> getMembers();

	MemberVO getMember(int id);

	MemberVO putMember(int id, String pass, String name);

	MemberVO deleteMember(int id);



}

package edu.mission4.dao.member;

import java.util.List;

import edu.mission4.domain.MemberVO;


public interface MemberInterface {
	MemberVO postMember(int id, String pass, String name);

	 List<MemberVO> getMembers();

	MemberVO getMember(int id);

	MemberVO putMember(int id, String pass, String name);

	MemberVO deleteMember(int id);
}

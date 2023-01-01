package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



import edu.pnu.domain.MemberVO;

//@RestController
public class MemberController {

	@GetMapping("/getMembers")
	public List<MemberVO> getMembers() {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		for (int i = 1; i <= 10; i++) {
			MemberVO member = new MemberVO();
			member.setId(i);
			member.setPass(null);
			member.setName("테스터");
			member.setRegidate(new Date());
			memberList.add(member);
		}
		return memberList;
	}

	public MemberVO getMember(@PathVariable Integer id) {
		return null;
	}

	public MemberVO addMember(MemberVO memberVO) {
		return memberVO;

	}

	public MemberVO updateMembers(MemberVO memberVO) {
		return memberVO;

	}

	public MemberVO removeMember(@PathVariable Integer id) {
		return null;

	}

}

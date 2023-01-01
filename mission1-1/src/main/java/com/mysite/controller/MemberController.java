package com.mysite.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.domain.MemberVO;

@RestController
public class MemberController {

	List<MemberVO> memberList;

	public MemberController() {
		memberList = new ArrayList<MemberVO>();
//		List<MemberVO> memberList = new ArrayList<MemberVO>();
//		이런 식으로 하면 호출할때마다 생성
		for (int i = 1; i < 10; i++) {
			MemberVO member = new MemberVO();
			member.setId(i);
			member.setName("Person" + i);
			member.setPass("pass" + i);
			member.setRegidate(new Date());
			memberList.add(member);
		}
	}

	// CRUD -- POST GET PUT DELETE
//	@GetMapping({ "", "/" }) // 문자열들어가야함
//	public String home() {
//		return "홈입니다.";
//	}

	@GetMapping("/member")
	public List<MemberVO> Getmembers() { // 모든 멤버 정보를 JSON 형태로 브라우저에 출력
		return memberList;
	}

	@GetMapping("/member/{id}")
	public MemberVO Getmember(@PathVariable Integer id) {
		for (MemberVO m : memberList) {
			if (m.getId() == id) { // 아이디가 {Id} 인 member를 찾아서 브라우저에 출력
				return m;
			}
		}
		return null;
	}

//	추가하고자 하는 member 정보를 전달, 추가된 객체를 출력
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		memberVO = new MemberVO();
		memberVO.setRegidate(new Date());
		memberVO.setId(memberList.size());
		memberVO.setName("man" + memberList.size() );
		memberVO.setPass("stop" + memberList.size() );
		memberList.add(memberVO);
		return memberVO;
	}

//	수정 대상 객체 정보를 전달, 수정된 객체를 출력
	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO memberVO) {
	
		for (MemberVO m : memberList) {
			if (memberVO.getId() == m.getId()) {
				m.setId(memberVO.getId());
				m.setName(memberVO.getName());
				m.setPass(memberVO.getPass());
				return m;
			}
		}
		return null;
	}


//	아이디가 {Id} 인 member를 찾아서 삭제, 브라우저에는 삭제된 객체를 출력
	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable Integer id) {
		for (MemberVO m : memberList) {
			if (m.getId() == id) { 
				memberList.remove(m);
				return m;
			}
		}
		return null;

	}

//	@GetMapping("/getMember")
//	public MemberVO getMember() {
//		MemberVO member = new MemberVO();
//		member.setId(1);
//		member.setName("Person");
//		member.setPass("pass");
//		member.setRegidate(new Date());
//		return member;
//
//	}
//
//	@GetMapping("/getMemberList")
//	public List<MemberVO> getMemberList() {
//		List<MemberVO> memberList = new ArrayList<MemberVO>();
//		for (int i = 1; i < 10; i++) {
//			MemberVO member = new MemberVO();
//			member.setId(i);
//			member.setName("Person" + i);
//			member.setPass("pass" + i);
//			member.setRegidate(new Date());
//			memberList.add(member);
//		}
//		return memberList;
//	}
//
//	@GetMapping("/getMemberList/{id}")
//	public MemberVO getMemberList(@PathVariable Integer id) {
//		List<MemberVO> memberList = new ArrayList<MemberVO>();
//		MemberVO member = new MemberVO();
//		member.setId(1);
//		member.setName("Person" + 1);
//		member.setPass("pass" + 1);
//		member.setRegidate(new Date());
//		memberList.add(member);
//		for (int i = 2; i <= 10; i++) {
//			member.setId(i);
//			member.setName("Person" + i);
//			member.setPass("pass" + i);
//			member.setRegidate(new Date());
//			memberList.add(member);
//		}
//		int x =  id;
//		return  memberList.get(x - 1);
//	}
}

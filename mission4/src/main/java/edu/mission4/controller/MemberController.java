package edu.mission4.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	private MemberService memberService;

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	public MemberController() {
		log.info("MemberController() 생성자가 호출됨.");
		memberService = new MemberService();
	},,

//Create
	@PostMapping("/member/{id}/{pass}/{name}")
	public MemberVO postMember(@PathVariable int id, @PathVariable String pass, @PathVariable String name) {
		return memberService.postMember(id, pass, name);
	}
//Read

	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		System.out.println("MemberController - getMembers()");
		return memberService.getMembers();
	}

	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable int id) {
		System.out.printf("MemberController - getMember(%s)\n", id);
		return memberService.getMember(id);
	}

//Update
	@PutMapping("/member/{id}/{pass}/{name}")
	public MemberVO putMember(@PathVariable int id, @PathVariable String pass, @PathVariable String name) {
		System.out.println("MemberController - getMembers()");
		return memberService.putMember(id, pass, name);
	}

//Delete
	@DeleteMapping("/member/{id}")
	public MemberVO deleteMemberVO(@PathVariable int id) {
		System.out.println("MemberController - deleteMembers()");
		return memberService.deleteMember(id);
	}
}

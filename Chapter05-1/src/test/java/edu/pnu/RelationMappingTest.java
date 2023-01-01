package edu.pnu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class RelationMappingTest {
	@Autowired
	private BoardRepository boardRepo;

	@Autowired
	private MemberRepository memberRepo;

//	@Test
	public void testManyToOneInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setPassword("member111");
		member1.setName("둘리");
		member1.setRole("User");
		memberRepo.save(member1);

		Member member2 = new Member();
		member2.setId("member2");
		member2.setPassword("member222");
		member2.setName("도우너");
		member2.setRole("Admin");
		memberRepo.save(member2);

		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member1);
			board.setTitle("둘리가 등록한 게시글 " + i);
			board.setContent("둘리가 등록한 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
		memberRepo.save(member1);

		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member2);
			board.setTitle("도우너가 등록한 게시글 " + i);
			board.setContent("도우너가 등록한 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
		memberRepo.save(member2);
	}

//	단방향
//	@Test
	public void testFindById() {
		Board board = boardRepo.findById(1L).get();
//		id가(seq type:Long) 1
		
		System.out.println("검색 결과");
		System.out.println("---> " + board.toString());
		
//		Board [seq=1, title=둘리가 등록한 게시글 1, writer=null, content=둘리가 등록한 게시글 내용 1, 
//		createDate=2022-12-02 11:27:22.322, cnt=0, member=Member [id=member1, password=member111, name=둘리, role=User]]
		
		Member member = memberRepo.findById("member2").get();
		System.out.println("---> " + member.toString());
//		 Member [id=member2, password=member222, name=도우너, role=Admin]
		
		board.setMember(member);
//		board member를 위에서 찾은 멤버로 바꿈
		
		boardRepo.save(board);
//		board 저장
		
	}
//	양방향
	@Test
	public void testTwoWayMapping() {
		Member member = memberRepo.findById("member1").get();
		
		System.out.println("===============================");
		System.out.println(member.getName() + "가(이) 저장한 게시글 목록");
		System.out.println("===============================");
		
		List<Board> board = (List<Board>) boardRepo.findAllByWriter(member.getName()).get();
		for (Board x: board) {
			
			System.out.println(x.toString());
		}
	}
	

}

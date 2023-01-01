package edu.pnu;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import edu.pnu.domain.Board;
import edu.pnu.domain.QBoard;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	@Autowired
	EntityManager em;

//	@Test
//	title에 "1"이 포함되는 데이터 출력
//	public void testFindByTitle1() {
//		List<Board> boardList = boardRepo.findByTitleContaining("1");
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//
//	}

//	@Test
//	title에 "1"이 포함되면서 cnt가 50보다 큰 데이터 출력
//	public void testFindByTitle2() {
//		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1",50);
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//
//	}
//

//	@Test
//	cnt가 10~50 사이인 데이터 출력
////	public void testFindByTitle3() {
//		List<Board> boardList = boardRepo.findByCntBetween(10,50);
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//
//	}

//	cnt가 10~50 사이인 데이터를 seq 오름차순으로 출력
//	@Test
	public void testFindByTitle3() {
		Pageable paging = PageRequest.of(1, 5); // 페이징
		List<Board> boardList = boardRepo.findByCntBetweenOrderBySeqAsc(10, 50, paging);
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}

	}

//	title 10 포함 or content 2포함 데이터 seq 내림차순
//	@Test
	public void testFindByTitle4() {
//		Pageable paging = PageRequest.of(1, 5); //페이징
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc(10,2,paging);
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc(10, 2);
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}

	}

//	@Query어노테이션
//	@Test
//	public void testQueryAnnotationTest1() {
//
//		List<Board> boardList = boardRepo.queryAnnotationTest1("1");
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//
//	}

//	@Test
//	public void testQueryAnnotationTest2() {
//
//		List<Object[]> boardList = boardRepo.queryAnnotationTest2("1");
//		System.out.println("검색 결과");
//		for (Object[] row : boardList) {
//			System.out.println("---> " + Arrays.toString(row));
//		}
//
//	}

//	@Test
//	public void testQueryAnnotationTest3() {
//
//		List<Object[]> boardList = boardRepo.queryAnnotationTest3("1");
//		System.out.println("검색 결과");
//		for (Object[] row : boardList) {
//			System.out.println("---> " + Arrays.toString(row));
//		}
//
//	}

//	@Test
//	public void testQueryAnnotationTest4() {
//		Pageable paging = PageRequest.of(0, 3); //페이징
//		List<Board> boardList = boardRepo.queryAnnotationTest4(paging);
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//
//	}

//	동적쿼리 p292
//	@Test
	public void testDynamicQuery() {
		String searchCondition = "CONTENT";
		String searchKeyword = "1";

		BooleanBuilder builder = new BooleanBuilder();

		QBoard qboard = QBoard.board;

		if (searchCondition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		} else if (searchCondition.equals("CONTENT")) {
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}

		Pageable paging = PageRequest.of(0, 5);

		Page<Board> boardList = boardRepo.findAll(builder, paging);

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}

	//교수님코드  체인
	@Test
	public void testDynamicQuery1() {
		
		JPAQueryFactory query = new JPAQueryFactory(em);
		QBoard b = QBoard.board;

		List<Board> list = query.selectFrom(b).where(b.cnt.lt(50)).orderBy(b.seq.asc()).fetch();
		
		for (Board bb : list) {
			System.out.println("---->" + bb);
		}

	}

}
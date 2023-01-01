package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>,QuerydslPredicateExecutor<Board> {

//	List<Board> findBoardByTitle(String string);

//	List<Board> findByCnt(int Cnt);

//	List<Board> findByTitleContaining(String string);
//  교수님 문제 1 title에 string 포함
	
//	List<Board> findByTitleContainingAndCntGreaterThan(String string, int i);
//	교수님 문제 2 title에 string 포함되면서 cnt가 i보다 큰 데이터 출력
	
	List<Board> findByCntBetween(int i, int j);
//	cnt가 10~50 사이인 데이터 출력

	List<Board> findByCntBetweenOrderBySeqAsc(int i, int j, Pageable paging);
//	교수님 문제 3 cnt가 10~50 사이인 데이터를 seq 오름차순으로 출력
	
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(int i, int j, Pageable paging);

	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(int i, int j);
//	교수님 문제 4 title 10 포함 or content 2포함 데이터 seq 내림차순
	
	
	//p275 [1]위치기반파라미터사용 title 에 searchkeyword 포함 데이터 seq 내림차순
//	@Query("select b from Board b where b.title like %?1% order by b.seq desc")
//	List<Board> queryAnnotationTest1(String searchkeyword);
	
	//p277 [2]이름 기반 파라미터사용
//	@Query("select b from Board b where b.title like %:searchkeyword% order by b.seq desc")
//	List<Board> queryAnnotationTest1(@Param("searchkeyword") String searchkeyword);

	//p278 [3]특정 변수만 조회하기
//	@Query("select b.seq, b.title, b.writer, b.createDate from Board b where b.title like %?1% order by b.seq desc")
//	List<Object[]> queryAnnotationTest2(@Param("searchkeyword") String searchkeyword);
	
	//p280 1.3.3 네이티브 쿼리 사용하기
	
//	@Query(value="select seq, title, writer, create_Date from Board where title like '%'||?1||'%' order by seq desc", nativeQuery = true)
//	List<Object[]> queryAnnotationTest3(String searchkeyword);
	
	@Query("Select b from Board b order by b.seq desc")
	List<Board> queryAnnotationTest4(Pageable paging);
	


}

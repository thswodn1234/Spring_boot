package edu.pnu.persistence;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	@Transactional 
	@Modifying(clearAutomatically = true) // @Query만 있으면 ExecuteQuery로 됨 cnt 조회수 1증가
	@Query(value="UPDATE Board SET Cnt=Cnt+1 WHERE SEQ=?1",nativeQuery=true)
	void updateVisit(Long seq);
}

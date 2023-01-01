package edu.pnu.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;

public interface BoardRepository extends CrudRepository<Board, Long> {
	
	List<Board> findByTitle(String searchKeyword);

	List<Board> findByContentContaining(String searchKeyword);

	List<Board> findByTitleContainingOrContentContaining(String title, String content);

	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);

	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

	List<Board> findByMember_Id(String string);

	Optional<Board> findAllByWriter(String name);



}

package edu.pnu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	public List<Board> getBoardList(Board board){
		return (List<Board>) boardRepo.findAll();
		
	}
	
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}
	
	public Board getBoard(Board board) {
		boardRepo.updateVisit(board.getSeq());
		return boardRepo.findById(board.getSeq()).get();
		
//		Board b = boardRepo.findById(board.getSeq()).get();
//		b.setCnt(b.getCnt() + 1L);
//		boardRepo.save(b);
//		return b;
	}
	
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
		
	}
	
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
		
	}



}

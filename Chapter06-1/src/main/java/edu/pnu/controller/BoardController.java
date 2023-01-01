package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.service.BoardService;

@Controller // Controller 리턴하는 값 자체가 view이름 <------> RestController 리턴하는 값 자체를 리턴
public class BoardController {

//	page 355
	@GetMapping("/hello")
	public void hello(Model model) {
		model.addAttribute("greeting", "Hello 타입리프.^^");
	}

//	page338
	@Autowired
	private BoardService boardService;

	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardList(board);

		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}

	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}

	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}

	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}

	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}

	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}

	/*
	 * page327 // @GetMapping("/test1") // src/main/webapp/ // public String test1()
	 * { // return "test1"; // } // @GetMapping("/test1") // src/main/webapp/ //
	 * public @ResponseBody String test1() { //텍스트 자체로 // return "test1"; // }
	 * // @GetMapping("/test2") // public String test2() { // return
	 * "/WEB-INF/test2"; // } // @GetMapping("/test2") // public String test2() { //
	 * return "test2"; // ===> why? prefix WEB-INF/board/test2.jsp // }
	 * 
	 * 
	 * 
	 * // @RequestMapping("/getBoardList") // String getBoardList(Model model) { //
	 * List<Board> boardList = new ArrayList<Board>(); // // for (int i = 1; i <=
	 * 10; i++) { // Board board = new Board(); // board.setSeq((long) i); //
	 * board.setTitle("게시판 프로그램 테스트"); // board.setWriter("도우너"); //
	 * board.setContent("게시판 프로그램 테스트입니다..."); // board.setCreateDate(new Date());
	 * // board.setCnt(0L); // boardList.add(board); // } //
	 * model.addAttribute("boardList",boardList); // return "getBoardList"; // } //
	 * // @RequestMapping("/getBoardList1") // public ModelAndView getBoardList1() {
	 * // // ModelAndView mv = new ModelAndView(); // // List<Board> boardList = new
	 * ArrayList<Board>(); // // for (int i = 1; i <= 10; i++) { // Board board =
	 * new Board(); // board.setSeq((long) i); // board.setTitle("게시판 프로그램 테스트"); //
	 * board.setWriter("도우너"); // board.setContent("게시판 프로그램 테스트입니다..."); //
	 * board.setCreateDate(new Date()); // board.setCnt(0L); //
	 * boardList.add(board); // } // mv.addObject("boardList",boardList); //
	 * mv.setViewName("getBoardList"); // return mv; // }
	 */
}

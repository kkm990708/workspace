package com.kh.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller
@RequestMapping("board")
@SessionAttributes("selectBoard")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("insert")
	public String insert() {
		return "board/insert";
	}
	
	@PostMapping("insert")
	public String insert(Board insertBoard,
			RedirectAttributes ra) {
		
		int result = service.insert(insertBoard);
		
		ra.addFlashAttribute("message", "삽입 성공");
		
		return "redirect:/";
	}
	
	
	@GetMapping("selectOne")
	public String selectOne(int no, Model model) {
		
		Board selectBoard = service.selectBoard(no);
		
		model.addAttribute("selectBoard", selectBoard);
		
		return "board/selectOne";
	}
	
	
	@PostMapping("deleteBoard")
	public String deleteBoard(int boardNo, String boardPw,
			RedirectAttributes ra,
			Model model) {
		
		int result = service.deleteBoard(boardNo, boardPw);
		
		String message = null;
		String path = null;
		if (result > 0) {
			message = "삭제 성공";
			path = "redirect:/";
		}
		else {
			message = "비밀번호가 일치하지 않습니다";
			path = "redirect:selectOne?no="+boardNo;
		}
		
		ra.addFlashAttribute("message",message);
		
		return path;
	}
	
	
	@PostMapping("moveUpdate")
	public String moveUpdate(int boardNo, String boardPw,
			RedirectAttributes ra,
			Model model) {
		
		Board selectBoard = service.moveBoard(boardNo, boardPw);
		
		String path = null;
		if (selectBoard != null) {
			model.addAttribute("selectBoard", selectBoard);
			path = "board/update";
		}
		else {
			ra.addFlashAttribute("message","비밀번호가 일치하지 않습니다");
			path = "redirect:selectOne?no="+boardNo;
		}
		
		return path;
	}
	
	@PostMapping("updateBoard")
	public String updateBoard(Board updateBoard, Model model, 
			RedirectAttributes ra) {
		
		int result = service.updateBoard(updateBoard);
		
		ra.addFlashAttribute("message", "수정 성공");
		return "redirect:selectOne?no="+updateBoard.getBoardNo();
	}
}

package com.kh.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller
@RequestMapping("board")
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
	public String deleteBoard() {
		
		return "redirect:/";
	}
	
}

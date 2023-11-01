package com.kh.test.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping("success")
	public String success(String boardTitle, Model model) {
		
		List<Board> boarList = service.success(boardTitle);
		
		if (boarList.size() == 0) {
			return "searchFail";
		}
		
		model.addAttribute("boarList",boarList);
		
		return "searchSuccess";
	}
	
}

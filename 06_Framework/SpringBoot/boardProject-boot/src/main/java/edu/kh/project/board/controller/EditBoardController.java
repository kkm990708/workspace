package edu.kh.project.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.board.model.service.EditBoardService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("editBoard")
@SessionAttributes({"loginMember"})
public class EditBoardController {
	
	private final EditBoardService service;

	
	
}

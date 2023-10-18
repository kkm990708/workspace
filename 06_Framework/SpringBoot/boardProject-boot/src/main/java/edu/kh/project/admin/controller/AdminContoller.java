package edu.kh.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.project.admin.service.AdminService;
import edu.kh.project.admin.service.AdminServiceImpl;
import edu.kh.project.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("admin")
public class AdminContoller { 
	
	@Autowired
	private AdminService service;
	

	/** 관리자 메인 페이지
	 * @return "admin/admin-main"
	 */
	@GetMapping("main")
	public String adminMain() {
		// forward : 요청 위임
		// Thymeleaf
		// -prefix : classpath:/templates/
		// -suffix: .html
		return "admin/admin-main";
	}
	
	@GetMapping("selectMember")
	public String selectMember(String inputEmail, Model model) {
		
		Member selectMember = service.selectMember(inputEmail);
		
		if (selectMember != null) { 
			model.addAttribute("searchMember",selectMember);
			return "admin/success"; 
		}
		
		return "admin/fail";  
		
		
		// 이메일이 일치하는 회원이 존재하는 경우
		// model.addAttribute("searchMember", value)
		// return "admin/success"; 
		
		// 이메일이 일치하는 회원이 존재하는 경우
		// return "admin/fail";
	}
	
}

package edu.kh.project.myPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.myPage.model.service.MyPageService;

@Controller
@RequestMapping("myPage")
@SessionAttributes({"loginMember"})
public class MyPageController {

	@Autowired
	private MyPageService service;
	
	// 마이페이지 화면 전환(forward)
	@GetMapping("info")
	public String info() {

		return "myPage/myPage-info";
	} 
	
	@GetMapping("profile")
	public String profile() {
		return "myPage/myPage-profile";
	} 
	
	@GetMapping("changePw")
	public String changePw() {
		return "myPage/myPage-changePw";
	}
	
	@GetMapping("secession")
	public String secession() {
		return "myPage/myPage-secession";
	}
	
	
}

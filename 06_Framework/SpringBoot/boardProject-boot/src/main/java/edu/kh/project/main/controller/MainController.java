package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.project.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // 현 재 클래스에서 로그 출력시 작성하는 어노테이션
public class MainController {
	
	// 로그 출력 방법
	// log.debug("문자열")
	@RequestMapping("/") // GET/POST 가리지 않고 "/" 요청오면 매팽)
	public String mainPage(Model model) {
		
		// Model : 데이터 전달용 객체(기본 scope : request)
		model.addAttribute("testName","홍길동");
		model.addAttribute("testAge",25);
		
		Member testMember = new Member();
		testMember.setMemberNo(99999);
		testMember.setMemberEmail("testMember@kh.or.kr");
		testMember.setMemberNickname("김테스트");
		
		model.addAttribute("testMember",testMember);
		
		// text, utext 비교
		model.addAttribute("address","<h1>서울시 강남구<h1>");
		
		log.debug("로그 찍기");
		log.debug("메인페이지 요청");
		
		/* Thymeleaf 템플릿 엔진 사용시 접두사 접미사 */
		// 접두사 : classpath:/templates
		// 접미사 : .html
		
		// classpath == src/main/resources 폴더
		return "common/main";
		
	}
}

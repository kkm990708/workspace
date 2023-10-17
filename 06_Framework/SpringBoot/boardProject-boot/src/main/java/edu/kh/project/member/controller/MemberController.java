package edu.kh.project.member.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;


/* Spring boot Controller에서 요청 주소 작성 시
 * 제일 앞에 "/" 제외하고 작성   */

@Slf4j	// 로그
@Controller // Controller 역할(요청/응답 제어) + Bean등록
@RequestMapping("member")
@SessionAttributes({"loginMember"}) // 세션 올리기
public class MemberController {
	
	// MemberService 의존성 주입 
	@Autowired
	private MemberService service;
	
	
	
	/** 로그인
	 * @param inputMember : 아이디 비밀번호 파라미터
	 * @param model : 데이터 전달 객체
	 * @param ra : 리다이렉트 시 request scope 로 데이터 전달
	 * @return
	 */
	@PostMapping("login") // 로그인 요청
	public String login(Member inputMember, Model model, RedirectAttributes ra) {
		
		// 로그인 서비스 호출 
		Member loginMember = service.login(inputMember);
		
		// 로그인 성공
		if(loginMember != null) {
			
			// 쿠키 코드 작성 예정
		}
		
		// 로그인 실패
		if(loginMember == null) {
			ra.addAttribute("message", "아이디 또는 비빌번호가 일치하지 않습니다");
		}
		
		model.addAttribute("loginMember",loginMember);
		
		//메인 페이지 리 다이렉트
		return "redirect:/";
	}
	
	
	@GetMapping("logout")
	public String logout(SessionStatus status) {
		
		status.setComplete(); 	// @SessionAttrubutes 세션 만료
		
		return "redirect:/";
	}
	
	
	/** 로그인 전용 페이지 forward
	 * @return
	 */
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	
	@GetMapping("signup")
	public String signup() {
		return "member/signup";
	}
	
	
	/** 회원가입
	 * @param inputMember : 파라미터가 저장된 커맨드 객체
	 * @return
	 */
	@PostMapping("signup")
	public String signup(@ModelAttribute Member inputMember,
			String[] memberAddress, RedirectAttributes ra) {
		
		
		// 회원 가입 서비스 호출
		int result = service.signup(inputMember, memberAddress);
		
		// 회원가입 성공시 
		if(result > 0) {
			ra.addFlashAttribute("message","회원 가입 성공");
			return "redirect:/";
		}
	
		
		// 회원 가입 실패
		
		ra.addFlashAttribute("message","회원 가입 실패!");
		return "redirect:signup";
	}
	
	
	
	
}

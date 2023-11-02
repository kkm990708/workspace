package edu.kh.project.myPage.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.service.MyPageService;
import jakarta.mail.Session;

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
	
	
	// ==================================================================
	
	/** 회원 정보 수정
	 * @param updateMember : 수정된 회원 정보가 담긴 커맨드 객체
	 * @param memberAddress : 주소 값이 담긴 배열
	 * @parma loginMember : 현재 로그인한 회원의 정보가 담긴 객체(session)
	 * @param ra : 리다이렉트 시 request scope로 데이터 전달
	 * @return
	 */
	@PostMapping("info")
	public String info(Member updateMember, String[] memberAddress,
			@SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra) {
		
		// 1. loginMember에서 회원 번호만 얻어와 updateMember에 세팅
		updateMember.setMemberNo(loginMember.getMemberNo());
		
		// 2. 회원 정보 서비스 호출 후 결과 반환 받기
		int result = service.info(updateMember, memberAddress);
		
		// 3. 서비스 처리 결과에 따라 응답 제어
		
		// [성공]
		// - message = "회원 정보가 수정되었습니다"
		// - session에 세팅된 이전 회원 정보를
		//	 수정된 회원 정보로 다시 세팅
		
		// [실패]
		// - message = "회원 정보 수정 실패:
		String message = null;
		if (result > 0) {
			message = "회원 정보가 수정되었습니다";
			loginMember.setMemberNickname(updateMember.getMemberNickname() );
			loginMember.setMemberTel(updateMember.getMemberTel() );
			loginMember.setMemberAddress(updateMember.getMemberAddress() );
			
		}
		
		else {
			message = "회원 정보 수정 실패";
		}
		
		ra.addFlashAttribute("message", message);
		return "redirect:info";
	}
	
	
	/** 비밀번호 변경
	 * @param currentPw : 현재 비밀번호 (@RequestParam 생략)
	 * @param newPw : 새 비밀번호 (@RequestParam 생략)
	 * @param loginMember : 로그인한 회원 (session)
	 * @param ra : 리다이렉트 시 데이터 전달
	 * @return
	 */
	@PostMapping("changePw")
	
	
	public String changePw(
			String currentPw,
			String newPw,
			@SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra) {
		
		int result = service.changePw(currentPw, newPw, loginMember.getMemberNo());
		
		String path = null;
		String message = null;
		if (result > 0) {
			message = "비밀번호 변경 성공";
			path = "redirect:info";
		}
		else {
			message = "비밀번호 변경 실패";
			path = "redirect:changePw";
		}
		
		ra.addFlashAttribute("message", message);
		return path;
	}
	
	
	@PostMapping("secession")
	public String secession(
			String memberPw,
			@SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra,
			SessionStatus status) {
		int result = service.secession(memberPw, loginMember);
		
		String path = null;
		String message = null;
		if (result > 0) {
			message = "탈퇴 되었습니다";
			path = "redirect:/";
			status.setComplete(); 	// @SessionAttrubutes 세션 만료
		}
		else {
			message = "비밀번호가 틀렷습니다";
			path = "redirect:secession";
		}
		
		ra.addFlashAttribute("message", message); 
		
		return path;
	}
	
	
	//---------------------------------------
	
	// MultipartFile : multipart/form/data 형식으로 제출된 파라미터 중
	// file 타입 데이터만 추출해 저장하는 Spring 제공 객체
	// - 실제 파일
	// - 파일 이름
	// - 파일 크기
	// - 업로드된 파일을 지정된 경로에 저장하는 메서드
	
	/** 프로필 이미지 수정
	 * @param profileImg : 실제 업로드된 프로필 이미지 (파일선택 여부 관련없이 무조건 객체 생성)
	 * @param loginMember 
	 * @param ra
	 * @return 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PostMapping("profile")
	public String profile(
			@RequestParam("profileImg") MultipartFile profileImg,
			@SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra) throws IllegalStateException, IOException {
		
		// 프로필 이미지 수정 서비스 호출 후 결과 반환
		int result = service.profile(profileImg,loginMember);
								// 실제 이미지 파일, 세션에 저장된 회원 정보 
		
		// 서비스 결과에 따라 응답 제어
		String message = null;
		
		if( result > 0 ) {
			message = "프로필 이미지가 변경 되었습니다";
		} else {
			message = "프로필 변경 실패";
			
		}
		
		ra.addFlashAttribute("message", message);
		
		return "redirect:profile";
	}
	
	
	
	
	
}

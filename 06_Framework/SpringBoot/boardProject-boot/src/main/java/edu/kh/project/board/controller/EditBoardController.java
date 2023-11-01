package edu.kh.project.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.service.EditBoardService;
import edu.kh.project.member.model.dto.Member;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("editBoard")
@SessionAttributes({"loginMember"})
public class EditBoardController {
	
	private final EditBoardService service;

	
	/** 게시글 삭제
	 * @param boardCode : 게시판 구분 코드
	 * @param boardNo : 게시글 번호(PK)
	 * @param loginMember : 세션에 저장된 로그인된 회원의 정보(로그인X면 null)
	 * @param ra
	 * @return
	 */
	@GetMapping("{boardCode:[0-9]+}/{boardNo}:[0-9]+/delete")
	public String deleteBoard(
			@PathVariable("boardCode") int boardCode,
			@PathVariable("boardNo") int boardNo,
			@SessionAttribute(value="loginMember", required = false) Member loginMember,
			RedirectAttributes ra) {
		
		// 로그인 상태가 아닌 경우 삭제 진행 X
		if(loginMember == null	) {
			ra.addFlashAttribute("message" , "로그인 후 이용해 주세요");
			return "redirect:/member/login";
		}
		
		// Map을 이용해서 boardCode, boardNo, memberNo 담기
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("boardCode", boardCode);
		paramMap.put("boardNo", boardNo);
		paramMap.put("memberNo", loginMember.getMemberNo() );
		
		// 서비스 호출 후 결과 반환
		int result = service.deleteBoard(paramMap);
		
		return null;
	}
	
}







package edu.kh.project.admin.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.project.admin.service.AjaxSerivce;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.service.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("ajax") // 상위 공통 주소
public class AjaxContoller {

	@Autowired
	private AjaxSerivce	serivce;
	
	/** 회원 번호가 일치하는 회원 이메일 조회
	 * @param memberNo : 입력된 회원번호
	 * @return : 
	 */
	@ResponseBody
	@GetMapping("selectMemberNo")
	public String selectMemberNO(int memberNo) {
		
		String email = serivce.selectMemberNo(memberNo);
		
		// 동기식(기존 방식)으로 응답 할 때
		// 1) Model 객체에 데이터 세팅
		// 2) 지정된 html로 forward
		// 3) 갱신된 화면에 데이터 룰력
		
		//---------------------------------------------
		
		// 비동기 방식으로 등답하는 방법
		// - 비동기 통신으로 페이지 갱신(화면 새로 만들기) 이 목적 X
		// - 단순히 요청에 맞는 데이터만 주고 받는 것이 목적 O
		
		// 조회 결과 email을 요청한 곳으로 반환
		return email;
		
		// { 문제 발생	}
		// - email을 반환 하려는데
		// Controller에서 반환된값은 ViewResolver에 의해
		// 자동으로 /templates/ 반환값.html로
		// forward를 수행하는 문제 발생
		
		// [해결 방법]
		// Controller의 메서드 반환값이 아닌
		// forward를 위한 경로가 아닌
		// 비동기 요청한곳으로 돌아가야하는 값 자체적인 
		// 어노테이션 @ResponseBody를 메서도 위에 추가
	
	}
	
	/** 이메일로 전화번호 조회
	 * @param inputEmail
	 * @return memberTel
	 */
	@GetMapping("selectEmail")
	@ResponseBody // forward 아니고 값 자체 반환 할꺼야(비동기)
	public String selectEmail(String inputEmail) {
		return serivce.selectEmail(inputEmail);
	}
	
	
	
	@GetMapping(value="selectMember", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Member selectMember(int no) {
		
		// Java 객체는 JS에서 사용 불가능
		// Java 객체 -> JS 객체 변환 작업 필요
		// 1) Java 객체를 JSON으로 변환 
		//	  * JSON : JS 객체 모양 문자열 (String)
		//	   -> HttpMessageConverter 가 변환
		
		// 2) JSON(문자열) 형태의 데이터를 JS로 전달(응답)
		//	  + JSON이니까 JS 객체로 변환해서 사용해 라는 구문을 첨부
		//	  -> @XXXMapping() 구문에 
		//		 produces="application/json; charset=UTF-8" 추가
		
		// 3) JS에서 자동으로 JS 객체로 변환되어 사용 가능
		// 	
		return serivce.selectMember(no);
	}
	
	
	/** 일부 일치하는 이메일 모두 조회
	 * @param keyword
	 * @return emailList
	 */
	@GetMapping(value="selectEmailList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<String> selectEmailList(String keyword){
		return serivce.selectEmailList(keyword);
	}
	
	
	@GetMapping(value="selectAll" , produces = "application/json; charset=UTF-8")
	@ResponseBody // 비동기 통신 응답(forward/redirect X, 데이터 자제)
	public List<Member> selectAll(){
		
		// List (Java 객체)
		// -> HttpMessageConverter 가 JSON(문자열)으로 변환
		//	  (+ produces 속성을 이용해 응답 받는 JS에서 자동으로 JS객체로 변환하도록함
		// -> 객체
		
		return serivce.selectAll();
	}
	
	
	
	// @RequestBody{ 요정 body }
	// - 요청 body에 담긴 내용을 얻어와 매개변수에 대입
	// - HttpMessageConber가
	//   이 과정에서 데이터 타입을 Java에 알맞게 변환
	// number -> int/double
	// string -> String
	// JSON -> DTO, List, Map
	/**
	 * @return
	 */
	@PostMapping("insertMember")
	@ResponseBody // 반환값이 그대로 들어감
	public int insertMember(@RequestBody Member member) {
		
		log.debug(member.toString());
		
		return serivce.insertMember(member);
	}
	
	/** 회원 탈퇴여부 변경
	 * @param paramMap : flag, targetNo가 담겨있는 map
	 * @return
	 */
	@PutMapping("updateFlag")
	@ResponseBody
	public int updateFlag(@RequestBody Map<String, Object> paramMap) {
		
		return serivce.updateFlag(paramMap);
	}
	
	
}

package edu.kh.project.myPage.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.mapper.MyPageMapper;

@Transactional
@Service
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MyPageMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	public int info(Member updateMember, String[] memberAddress) {
		
		// 주소 가공
		
		// 주소가 입력되지 않은 경우
		if(updateMember.getMemberAddress().equals(",,")) {
			updateMember.setMemberAddress(null);
		}
		
		// 주소를입력한 경우
		// 배열 -> 문자열로 합쳐서 inputMember에 추가
		else {
			String address = String.join("^^^", memberAddress);
			updateMember.setMemberAddress(address);
		}
		
		// mapper 호출 후 결과 반환
		return mapper.info(updateMember);
	}
	
	
	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
		
		String encPw = mapper.selectMemberPw(memberNo);
		
		if (!bcrypt.matches(currentPw, encPw)) {
			return 0;
		}
		
		// 3. 같으면 새 비밀번호 변경
		// 마이바티스 코드의 파라미터는 1개만 가능
		// -> 지금 newPw, memberNo 두개가 필요
		
		Map<String, Object>insertMember = new HashMap<>(); 
		insertMember.put("memberNo", memberNo);
		insertMember.put("memberPw", bcrypt.encode(newPw));
		
		return mapper.changePw(insertMember);
	}
	
	
	
	@Override
	public int secession(String memberPw, Member loginMember) {
		
		// 로그인한 회원의 암호화된 비밀번호 조회
		String encPw = mapper.selectMemberPw(loginMember.getMemberNo());
		
		if (!bcrypt.matches(memberPw, encPw)) {
			return 0;
		}
		
		//회원 탈퇴
		return mapper.secession(loginMember);
	}
	
	
}

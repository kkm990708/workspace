package edu.kh.project.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;


@Transactional
@Slf4j
@Service // 비
public class MemberServiceImpl implements MemberService{

	// 암호화 객체 의존성 주입(DI)
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	// @DB관련 역할 수행 객체 의존성 주입
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public Member login(Member inputMember) {
				
		// 1. 이메일이 일치하는 탈퇴하지 않은 회원 정보를 조회(pw 포함)
		Member loginMember = mapper.login(inputMember);
		// 2. 조회 결과가 없을 경우 return null;
		log.debug("1");
		log.debug(" " + loginMember);
		
		if(loginMember == null) 
			return null;
		
		
		// 3. 입력 받은 비밀번호(평문)와 
		// 조회한 비밀번호(암호문)가 같지 않으면  return null;
		if(!bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw() ) ) {
			return null;
		}
		
		log.debug("2");
		log.debug(" " + loginMember);
		// 4. 비밀번호가 일치하면 비밀번호 제거 후 return
		loginMember.setMemberPw(null);
		return loginMember;
	}
}
